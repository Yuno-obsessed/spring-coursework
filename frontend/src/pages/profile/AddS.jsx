import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
import {Button, Grid, Stack, TextField} from "@mui/material";
import React, {useEffect, useState} from "react";
import {useLocation, useNavigate} from "react-router-dom";
import HttpService from "../../services/HttpService";
import {useSnackbar} from "notistack";
import AuthService from "../../services/AuthService";

function AddS(props) {

    const [formValues, setFormValues] = useState({
        petId: '',
        userId: AuthService.getCurrentUser()?.id,
        difficulty: '',
        date: '',
        description: '',
    });

    const [activeId, setActiveId] = useState(null);
    const userId = AuthService.getCurrentUser()?.id;
    const [pets, setPet] = React.useState([])
    React.useEffect(() => {
        HttpService.getWithAuth("/pets/users/" + userId)
            .then((response) => {
                setPet(response.data);
            })
    }, [])

    const navigate = useNavigate()
    const location = useLocation();
    const { enqueueSnackbar } = useSnackbar();
    const surgeries = location.state;

   // const filteredPets = pets.filter((pet) => {  // if you wanna filter
     //   return !surgeries.some((surgery) => surgery.petId === pet.id);
   // });

  //  const finalPets = filteredPets.length > 0 ? filteredPets : pets;


    const handleId = (petId) => {
        setActiveId(petId)

    }
    const handleInputChange = (e, inputType) => {
        const {value}  = e.target;
        setFormValues((prevFormValues) => ({
            ...prevFormValues,
            [inputType]: value,
             petId: activeId
        }));
    };
   const handleSubmit = (event) => {
       HttpService.postWithAuth("/surgery", formValues)
           .then((response) => {
               enqueueSnackbar("surgery created successfully", { variant: "success" });
               navigate("/profile");
           })
           .catch((error) => {
               if (error.response?.data?.errors) {
                   error.response?.data?.errors.map((e) =>
                       enqueueSnackbar(e.field + " " + e.message, { variant: "error" })
                   );
               } else if (error.response?.data?.message) {
                   enqueueSnackbar(error.response?.data?.message, { variant: "error" });
               } else {
                   enqueueSnackbar(error.message, { variant: "error" });
               }
           });
   }
    return(
        <div className="single">
            <Sidebar />
            <div className="singleContainer">
                <Navbar />
                <div className="bottom">
                    <h1 className="title">Add New</h1>
                    <Grid
                        container
                        alignItems="left"
                        justify="center"
                        direction="column"
                        spacing={2}
                    >
                        <Grid item>
                            <h3 className='PetsId'>Pets id</h3>
                            <div className="petsIDs">
                            {
                                pets.map((pet) => (
                                    <p
                                        key={pet.id}
                                        onClick={(e) => {
                                            handleInputChange(e, "petId")
                                            handleId(pet.id)
                                        }}
                                        style={{ opacity: activeId === pet.id ? 0.6 : 1 }}
                                        className="petsID"
                                    >
                                        {pet.id}
                                    </p>
                                ))
                            }
                            </div>
                        </Grid>
                        <Grid item>
                            <TextField
                                sx={{ width: 240 }}
                                required
                                id="Difficulty"
                                name="difficulty"
                                label="Difficulty"
                                type="number"
                                onChange={(e) => handleInputChange(e, "difficulty")}
                            />
                        </Grid>
                        <Grid item>
                            <TextField
                                sx={{ width: 640}}
                                required
                                id="description"
                                name="description"
                                label="Description"
                                type="text"
                                onChange={(e) => handleInputChange(e, "description")}
                            />
                        </Grid>
                        <Grid item>
                            <input className='dataPicker'
                                   onChange={(e) => handleInputChange(e, "date")}
                                   type="date"/>
                        </Grid>
                    </Grid>
                    <Stack spacing={2} sx={{ py: 3, paddingRight: 0 }} direction="row">
                        <Button
                            onClick={() => navigate("/profile")}
                            sx={{ minWidth: 112 }}
                            variant="outlined"
                        >
                            Cancel
                        </Button>
                        <Button sx={{ minWidth: 112 }}
                                type="submit"
                                onClick={(e) => handleSubmit(e)}
                                variant="contained">
                            Save
                        </Button>
                    </Stack>
                </div>
            </div>
        </div>
    )

}

export default AddS;