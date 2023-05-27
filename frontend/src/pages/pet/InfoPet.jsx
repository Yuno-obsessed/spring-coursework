import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
import {Button, FormControl, Grid, InputLabel, MenuItem, Select, Stack, TextField} from "@mui/material";
import {useLocation, useNavigate} from "react-router-dom";
import './infopet.css'
import React from "react"
import HttpService from "../../services/HttpService";
import {useSnackbar} from "notistack";

function InfoPet() {
    const pageTitle = "Info"
    const { enqueueSnackbar } = useSnackbar();
    const navigate = useNavigate()
    const { state } = useLocation();
    const [analysis, setAnalysis] = React.useState({
        analysis: {
        },
        diagnosis: {}
    });
    console.log(state.id)
    React.useEffect(() => {
        HttpService.getWithAuth(`/pets/info/${state.id}`)
            .then((res) => {
                setAnalysis({
                    analysis: res.data.analysis,
                    diagnosis: res.data.diagnosis
                });
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
    }, []);

    const handleCopy = (text, variant) => {
        navigator.clipboard.writeText(text).then(() => {
            enqueueSnackbar(`You copied ${variant}`, { variant: "success" })
        });
    };

   const handleAdda = (param) => {
       navigate("/pets/info/addanalysis", { state: param});
   }
    const handleAddd = (param) => {
        navigate("/pets/info/AddDiagnosis", { state: param });
    }

    return(
      <div className="single">
          <Sidebar />
          <div className="singleContainer">
              <Navbar />
              <div className="bottom">
                  <h1 className="title">{pageTitle}</h1>
                  <div className="userInfo">
                      <img
                          src={`${process.env.PUBLIC_URL}/petsImg/pet${state.id}.jpg`}
                          alt="pet"
                      />
                      <div className="detail">
                          <div className="detailItems">
                              <span className="item-detail itembold"><h2>{state.name}</h2></span>
                              <span className="item-detail">Pet ID: {state.id}</span>
                              <span className="item-detail">Pet Type: {state.type.name}</span>
                          </div>
                      </div>
                  </div>
              </div>
              <div className="btnRow">
              <button onClick={() => handleAdda(state)}>Add Analysis</button>
              <button onClick={() => handleAddd(state)}>Add Diagnos</button>
              </div>
              <div className="analysisContent">
                  <div className="blockAnalis">
                      <div className="analis">
                          <h1>Analysis</h1>
                          <table>
                              <thead>
                              <th>Date</th>
                              <th>Blood Rate</th>
                              <th>Urine Rate</th>
                              </thead>
                              <tbody>
                          {Object.entries(analysis.analysis).map(([key, value]) => (
                              <tr
                                  key={key}
                                  className="analysis"
                                  onClick={() => {
                                      const analysisBlock = document.querySelector('.analysis');
                                      handleCopy(`Date: ${value.date}, blood_rate: ${value.blood_rate}, urine_rate:${value.urine_rate}`, 'analysis');
                                  }}
                              >
                                  <td>{value.date}</td>
                                  <td>{value.blood_rate}</td>
                                  <td>{value.urine_rate}</td>
                              </tr>
                          ))}
                          </tbody>
                          </table>
                          <h2>Diagnosis</h2>
                          <table>
                              <thead>
                              <th>Data</th>
                              <th>Description</th>
                              </thead>
                              <tbody>
                          {Object.entries(analysis.diagnosis).map(([key, value]) => (
                              <tr className='analysis diagnosis' key={key}
                                   onClick={() => {
                                       const diagnosisBlock = document.querySelector('.diagnosis');
                                       handleCopy(diagnosisBlock.textContent, "diagnosis");
                                   }}>
                                  <td>{value.date}</td>
                                  <td>{value.description}</td>
                              </tr>
                          ))}
                              </tbody>
                          </table>
                      </div>
                  </div>
              </div>
          </div>
      </div>  )
}
export default InfoPet