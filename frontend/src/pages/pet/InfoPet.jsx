import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
import {Button, FormControl, Grid, InputLabel, MenuItem, Select, Stack, TextField} from "@mui/material";
import {useNavigate} from "react-router-dom";

function InfoPet() {
    const pageTitle = "Info"
    const navigation = useNavigate()
  return(
      <>
          <div className="single">
              <Sidebar />
              <div className="singleContainer">
                  <Navbar />
                  <div className="bottom">
                      <h1 className="title">{pageTitle}</h1>
                    <h1>TTTT</h1>
                  </div>
              </div>
          </div>
      </>
  )
}
export default InfoPet