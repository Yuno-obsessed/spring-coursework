import {
  Button,
  Checkbox,
  FormControlLabel,
  Grid,
  Stack,
  TextField,
} from "@mui/material";
import { useSnackbar } from "notistack";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../../components/navbar/Navbar";
import Sidebar from "../../components/sidebar/Sidebar";
import "./profile.scss";
import axios from "../../services/axios";
import './table.css'
import HttpService from "../../services/HttpService";
import AuthService from "../../services/AuthService";
const Profile = () => {
  const { enqueueSnackbar } = useSnackbar();
  const navigate = useNavigate();
  const [user, setUser] = useState([]);
  const [surgeries, setSurgeries] = useState([])
  const [update, setUpdate] = useState(true)
  useEffect(() => {
    const userId = AuthService.getCurrentUser()?.id;
    HttpService.getWithAuth(`/surgery/user/${userId}`)
        .then((response) => {
          setSurgeries(response.data.surgeries);
          setUser(response.data.user);
        })
      .catch((error) => {
        console.error(error)
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
  }, [update]);
  const handleDelete = (id) => {
    HttpService.deleteWithAuth(`/surgery/${id}`)
        .then((res) => {
          setUpdate(!update)
          const updatedArray = surgeries.filter((item) => item.id !== surgeries);
          setSurgeries(updatedArray)
          enqueueSnackbar("surgery is deleted successfully", { variant: "success" });
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
  };

  const handleEdit = () => {
    navigate("/profile/edit", { state: user });
  };
  const handleEditS = (param) => {
    navigate("/profile/edits", { state: param });
  };
  const handleAddNew = (surgeries) => {
    navigate("/profile/addnew", { state: surgeries });
  };
  return (
    <div className="single">
      <Sidebar />
      <div className="singleContainer">
        <Navbar />
        <div className="top">
          <div className="left">
            <div className="editButton"
                 onClick={() => handleEdit()}>
              Edit
            </div>
            <h1 className="title">Profile</h1>
            <div className="item">
              <img
                src={`${process.env.PUBLIC_URL}/profile.png`}
                alt="user"
                className="itemImg"
              />
              <div className="details">
                <h1 className="itemTitle">{user.fullName}</h1>
                <div className="detailItem">
                  <span className="itemKey">Username:</span>
                  <span className="itemValue">{user.username}</span>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div className='infoContent'>
          <div className='info'>
          </div>
        </div>
        <div className='surgeriesInfo'>
          <div className="table-container">
            <button onClick={() => {handleAddNew(surgeries)}} className='buttonAddNew'>Add New</button>
          <table>
            <thead>
            <tr>
              <th>Name</th>
              <th>Description</th>
              <th>Difficulty</th>
              <th>Date</th>
              <th>Edit</th>
            </tr>
            </thead>
            <tbody>
            {surgeries.map((s, index) => (
                <tr key={index}>
                  <td>{s.name}</td>
                  <td>{s.description}</td>
                  <td>{s.difficulty}</td>
                  <td>{s.date}</td>
                  <td className='gap'>
                    <button className='button' onClick={() => handleDelete(s.id)}>Delete</button>
                    <button className='button' onClick={() => handleEditS(s)}>Edit</button>
                  </td>
                </tr>
            ))}
            </tbody>
          </table>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Profile;
