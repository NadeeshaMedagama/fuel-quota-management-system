import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const AddFuelQuota = () => {
  const [formData, setFormData] = useState({ fuelType: "", vehicleType: "", quota: "" });
  const navigate = useNavigate();

  const handleChange = (e) => setFormData({ ...formData, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:8080/api/v1/fuel", formData);
      navigate("/fuel-quotas");
    } catch (error) {
      console.error("Error adding quota:", error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Fuel Type:
        <input name="fuelType" value={formData.fuelType} onChange={handleChange} required />
      </label>
      <label>
        Vehicle Type:
        <input name="vehicleType" value={formData.vehicleType} onChange={handleChange} required />
      </label>
      <label>
        Quota (Liters/Week):
        <input name="quota" type="number" value={formData.quota} onChange={handleChange} required />
      </label>
      <button type="submit">Add</button>
    </form>
  );
};

export default AddFuelQuota;
