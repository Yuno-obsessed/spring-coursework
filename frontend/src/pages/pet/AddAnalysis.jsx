import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
import {useSnackbar} from "notistack";
import {useLocation, useNavigate} from "react-router-dom";
import {Button, Grid, Stack, TextField} from "@mui/material";
import React from "react";
import './addanalysis.scss'
import HttpService from "../../services/HttpService";

function AddAnalysis() {
    const { enqueueSnackbar } = useSnackbar();
    const navigate = useNavigate()
    const { state } = useLocation();
    const [formValues, setFormValues] = React.useState({
        "petId": state.id,
        "blood_rate": '',
        "urine_rate": '',
        "date": ''
    })
    const handleInputChange = (e, inputType) => {
        const { value } = e.target;
        setFormValues((prevFormValues) => ({
            ...prevFormValues,
            [inputType]: value,
        }))
    }

    const handleSubmit = (event) => {
        HttpService.postWithAuth("/analysis", formValues)
            .then((response) => {
                enqueueSnackbar("analysis created successfully", { variant: "success" });
                navigate(-1);
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
        <>
            <div className="single">
                <Sidebar />
                <div className="singleContainer">
                    <Navbar />
                    <div className="bottom">
                        <h1 className='title-bottom'>Add analysis for {state.name}</h1>
                        <div className='inputsAdd'>
               <Grid className='grids'
                     container
                     alignItems="left"
                     justify="center"
                     direction="column">
                        <Grid item>
                            <input
                                autoFocus={true}
                                onChange={(e) => handleInputChange(e, "date")}
                                className='dataPicker'
                                   type="date"/>
                        </Grid>
                    <Grid item>
                        <TextField
                            onChange={(e) => handleInputChange(e, "blood_rate")}
                            className='field'
                            sx={{ width: 322}}
                            required
                            id="name"
                            name="Blood Rate"
                            label="Blood Rate"
                            type='text'
                        />
                    </Grid>
                    <Grid item>
                        <TextField
                            onChange={(e) => handleInputChange(e, "urine_rate")}
                            className='field'
                            sx={{ width: 322}}
                            required
                            id="name"
                            name="Urine Rate"
                            label="Urine Rate"
                            type="text"
                        />
                    </Grid>
                   <Stack spacing={2} sx={{ py: 3, paddingRight: 0 }} direction="row">
                       <Button
                           sx={{ minWidth: 112 }}
                           variant="outlined"
                           onClick={() => navigate(-1)}
                       >
                           Cancel
                       </Button>
                       <Button
                           onClick={() => handleSubmit()}
                           sx={{ minWidth: 112 }} type="submit" variant="contained"
                       >
                           Save
                       </Button>
                   </Stack>
               </Grid>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}
export default AddAnalysis
