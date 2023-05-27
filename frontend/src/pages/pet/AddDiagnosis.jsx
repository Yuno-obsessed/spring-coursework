import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
import {Button, Grid, Stack, TextField} from "@mui/material";
import React from "react";
import {useLocation, useNavigate} from "react-router-dom";
import HttpService from "../../services/HttpService";
import {useSnackbar} from "notistack";

function AddDiagnosis() {
    const { enqueueSnackbar } = useSnackbar();
    const navigate = useNavigate();

    const { state } = useLocation();

    const [formValues, setFormValues] = React.useState({
        "petId": state.id,
        "description": '',
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
        HttpService.postWithAuth("/diagnosis", formValues)
            .then((response) => {
                enqueueSnackbar("diagnos created successfully", { variant: "success" });
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
                        <h1 className='title-bottom'>Add diagnosis for {state.name}</h1>
                        <div className='inputsAdd'>
                            <Grid className='grids'
                                  container
                                  alignItems="left"
                                  justify="center"
                                  direction="column">
                                <Grid item>
                                    <input
                                        onChange={(e) => handleInputChange(e, 'date')}
                                        autoFocus={true}
                                        className='dataPicker'
                                        type="date"/>
                                </Grid>
                                <Grid item>
                                    <TextField
                                        onChange={(e) => handleInputChange(e, 'description')}
                                        className='field'
                                        sx={{ width: 322}}
                                        required
                                        id="name"
                                        name="Description"
                                        label="Description"
                                        type='text'
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
export default AddDiagnosis