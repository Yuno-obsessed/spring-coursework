import {
    Button,
    FormControl,
    Grid,
    InputLabel,
    MenuItem,
    Select,
    Stack,
    TextField,
} from "@mui/material";
import { useLocation, useNavigate } from "react-router-dom";
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
import React from "react";
import HttpService from "../../services/HttpService";
import {useSnackbar} from "notistack";
import AuthService from "../../services/AuthService";
function EditS(){
    const { enqueueSnackbar } = useSnackbar();
    const navigate = useNavigate()
    const location = useLocation();
    const surgeries = location.state;
    const [difficulty, setDifficulty] = React.useState(surgeries.difficulty)
    const [description, setDescription] = React.useState(surgeries.description)
    const [date, setDate] = React.useState(surgeries.date.split('.').reverse().join('-'))

    const handleInputChange = (e, inputType) => {
        const { value } = e.target;
        switch (inputType) {
            case 'difficulty':
                setDifficulty(value);
                break;
            case 'date':
                setDate(value.split('.').reverse().join('-'));
                break;
            case 'description':
                setDescription(value);
                break;
            default:
                break;
        }
    };
    function handleSubmit() {
       HttpService.putWithAuth(`/surgery`, {
           "id": surgeries.id,
           "userId": AuthService.getCurrentUser()?.id,
           "petId": surgeries.petId,
           "description": description,
           "difficulty:": difficulty,
           "date": date
       })
           .then((res) => {
               enqueueSnackbar("Surgery updated successfully", { variant: "success" });
               navigate('/profile')
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
                    <h1 className="title">Edit</h1>
                        <Grid
                            container
                            alignItems="left"
                            justify="center"
                            direction="column"
                            spacing={2}
                        >
                            <Grid item>
                                <TextField
                                    sx={{ width: 240 }}
                                    required
                                    autoFocus
                                    id="difficulty"
                                    name="difficulty"
                                    label="difficulty"
                                    type="number"
                                    onChange={(e) => handleInputChange(e, 'difficulty')}
                                    value={difficulty}
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
                                    value={description}
                                    onChange={(e) => handleInputChange(e, 'description')}
                                />
                            </Grid>
                            <Grid item>
                                <input className='dataPicker' onChange={(e) =>handleInputChange(e, 'date')} value={date} type="date"/>
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
                                    onClick={() => handleSubmit()}
                                    type="submit"
                                    variant="contained">
                                Save
                            </Button>
                        </Stack>
                </div>
            </div>
        </div>
    )
}
export default EditS;