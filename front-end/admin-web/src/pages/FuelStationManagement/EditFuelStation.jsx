import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";

const EditFuelStation = () => {
  const { id } = useParams(); 
  const navigate = useNavigate(); 
  const [formData, setFormData] = useState({
    name: "",
    location: "",
    fuelType: "",
  });

  useEffect(() => {
   
    const fetchFuelStation = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/fuelStations/${id}`, {
          headers: { "Content-Type": "application/json" },
        });

        setFormData(response.data); 
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
      
      await axios.put(`http://localhost:8080/fuelStations/${id}`, formData, {
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

        <button type="submit">Update Fuel Station</button>
      </form>
    </div>
  );
};

export default EditFuelStation;
