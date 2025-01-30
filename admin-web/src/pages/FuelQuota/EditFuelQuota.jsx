import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";

const EditFuelQuota = () => {
  const { id } = useParams();
  const [formData, setFormData] = useState({ fuelType: "", vehicleType: "", quota: "" });
  const navigate = useNavigate();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/fuel-quotas/${id}`);
        setFormData(response.data);
      } catch (error) {
        console.error("Error fetching details:", error);
      }
    };
    fetchData();
  }, [id]);

  const handleChange = (e) => setFormData({ ...formData, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.put(`http://localhost:8080/api/fuel-quotas/${id}`, formData);
      navigate("/fuel-quotas");
    } catch (error) {
      console.error("Error updating quota:", error);
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
      <button type="submit">Update</button>
    </form>
  );
};

export default EditFuelQuota;
