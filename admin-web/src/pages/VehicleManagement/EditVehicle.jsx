import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";

const EditVehicle = () => {
  const { id } = useParams(); 
  const [formData, setFormData] = useState({ registrationNumber: "", qrCode: "", fuelType: "" });
  const navigate = useNavigate();


  useEffect(() => {
    const fetchVehicle = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/v1/vehicle/${id}`);
        setFormData(response.data);
      } catch (error) {
        console.error("Error fetching vehicle:", error);
      }
    };

    fetchVehicle();
  }, [id]);



  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };


  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.put(`http://localhost:8080/api/v1/vehicle/${id}`, formData, {
        headers: { "Content-Type": "application/json" },
      });
      navigate("/vehicles"); 
    } catch (error) {
      console.error("Error updating vehicle:", error);
    }
  };

  // Handle cancel action
  const handleCancel = () => {
    navigate("/vehicles"); // Redirect back to the vehicle management page
  };

  return (
    <div className="edit-vehicle-form-container">
      <h1 className="form-title">Edit Vehicle</h1>
      <form className="edit-vehicle-form" onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="registrationNumber">Registration Number:</label>
          <input
            type="text"
            id="registrationNumber"
            name="registrationNumber"
            value={formData.registrationNumber}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="qrCode">QR Code:</label>
          <input
            type="text"
            id="qrCode"
            name="qrCode"
            value={formData.qrCode}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="fuelType">Fuel Type:</label>
          <input
            type="text"
            id="fuelType"
            name="fuelType"
            value={formData.fuelType}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-actions">
          <button type="submit" className="submit-btn">
            Update Vehicle
          </button>
          <button type="button" className="cancel-btn" onClick={handleCancel}>
            Cancel
          </button>
        </div>
      </form>
    </div>
  );
};

export default EditVehicle;
