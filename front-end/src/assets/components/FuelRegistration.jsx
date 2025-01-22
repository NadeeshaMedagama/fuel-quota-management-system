import React, { useState } from "react";
import axios from "axios";

const FuelStationRegistration = () => {
  const [formData, setFormData] = useState({
    stationName: "",
    licenseNumber: "",
    location: "",
    contactNumber: "",
    email: "",
    lisenceNumber: "",
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8080/api/register",
        formData,
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
      alert(response.data);
    } catch (error) {
      console.error("Error registering fuel station:", error);
      alert("Failed to register fuel station. Please try again.");
    }
  };
  return (
    <div className="container d-flex flex-column align-items-center justify-content-center vh-100">
      <img src="" alt="" />
      <h1 className="mb-4">Fuel Station Registration</h1>

      <form
        onSubmit={handleSubmit}
        className="w-50 bg-light p-4 rounded shadow"
      >
        <div className="mb-3">
          <label htmlFor="stationName" className="form-label">
            Station Name
          </label>
          <input
            type="text"
            id="stationName"
            name="stationName"
            className="form-control"
            value={formData.stationName}
            onChange={handleChange}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="licenseNumber" className="form-label">
            License Number
          </label>
          <input
            type="text"
            id="licenseNumber"
            name="licenseNumber"
            className="form-control"
            value={formData.licenseNumber}
            onChange={handleChange}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="location" className="form-label">
            Location
          </label>
          <input
            type="text"
            id="location"
            name="location"
            className="form-control"
            value={formData.location}
            onChange={handleChange}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="contactNumber" className="form-label">
            Contact Number
          </label>
          <input
            type="text"
            id="contactNumber"
            name="contactNumber"
            className="form-control"
            value={formData.contactNumber}
            onChange={handleChange}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="email" className="form-label">
            Email
          </label>
          <input
            type="email"
            id="email"
            name="email"
            className="form-control"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </div>

        <button type="submit" className="btn btn-primary w-100">
          Register
        </button>
      </form>
    </div>
  );
};

export default FuelStationRegistration;
