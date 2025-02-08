import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";

const EditFuelStation = () => {
  const { id } = useParams(); 
  const navigate = useNavigate(); 
  const [formData, setFormData] = useState({
    stationName: "",
    licenseNumber: "",
    email: "",
  });

  useEffect(() => {
    const fetchFuelStation = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/v1/fuelStation/${id}`, {
          headers: { "Content-Type": "application/json" },
        });
        setFormData({
          stationName: response.data.fuelStationName || "",
          licenseNumber: response.data.fuelStationRegisterId || "",
          email: response.data.fuelStationEmail || "",
        });
      } catch (error) {
        console.error("Error fetching fuel station data:", error);
      }
    };
    fetchFuelStation();
  }, [id]);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.put(`http://localhost:8080/api/v1/fuelStation/${id}`, formData, {
        headers: { "Content-Type": "application/json" },
      });
      navigate("/fuel-stations");
    } catch (error) {
      console.error("Error updating fuel station:", error);
    }
  };

  return (
    <div className="form-container">
      <h2>Edit Fuel Station</h2>
      <form className="form" onSubmit={handleSubmit}>
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

        <button type="submit">Update Fuel Station</button>
      </form>
    </div>
  );
};

export default EditFuelStation;
