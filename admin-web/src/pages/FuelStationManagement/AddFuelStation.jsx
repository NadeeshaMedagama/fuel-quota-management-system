import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";  // Update import
import "./AddFuelStation.css";
const AddFuelStation = () => {
  const [formData, setFormData] = useState({
    name: "",
    location: "",
    fuelType: "",
  });

  const navigate = useNavigate();  // Use useNavigate hook instead of useHistory

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    
  };

  return (
    <div className="form-container">
      <h2>Add Fuel Station</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="name">Name:</label>
          <input
            type="text"
            id="name"
            name="name"
            value={formData.name}
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="location">Location:</label>
          <input
            type="text"
            id="location"
            name="location"
            value={formData.location}
            onChange={handleInputChange}
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
            onChange={handleInputChange}
            required
          />
        </div>
        <button type="submit">Add Fuel Station</button>
      </form>
    </div>
  );
};

export default AddFuelStation;
