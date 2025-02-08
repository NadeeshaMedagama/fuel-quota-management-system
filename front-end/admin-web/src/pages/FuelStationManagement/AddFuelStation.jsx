import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./AddFuelStation.css";

const AddFuelStation = () => {
  const [formData, setFormData] = useState({
    stationName: "",
    licenseNumber: "",
    email: "",
  });

  const navigate = useNavigate();

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8080/api/v1/fuelStation",
        formData,
        {
          headers: { "Content-Type": "application/json" },
        }
      );
      console.log("Fuel station added:", response.data);
      navigate("/fuel-stations");
    } catch (error) {
      console.error("Error adding fuel station:", error);
    }
  };

  return (
    <div className="form-container">
      <h2>Add Fuel Station</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="stationName">Name:</label>
          <input
            type="text"
            id="stationName"
            name="stationName"
            value={formData.stationName}
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="licenseNumber">License Number:</label>
          <input
            type="text"
            id="licenseNumber"
            name="licenseNumber"
            value={formData.licenseNumber}
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleInputChange}
            required
          />
        </div>
        <button type="submit" className="addfuel">Add Fuel Station</button>
      </form>
    </div>
  );
};

export default AddFuelStation;