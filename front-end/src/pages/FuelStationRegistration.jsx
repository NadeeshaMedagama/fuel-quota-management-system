import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "../Styles/FuelStationRegistration.css";

const FuelStationRegistration = () => {
  const [stationName, setStationName] = useState("");
  const [location, setLocation] = useState("");
  const [ownerName, setOwnerName] = useState("");
  const [contactNumber, setContactNumber] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  const navigate = useNavigate();
  const registerFuelStation = async (event) => {
    event.preventDefault();
    setError("");
    setLoading(true);

    try {
      const response = await axios.post("http://localhost:8080/api/v1/fuelStation/register", {
        stationName,
        location,
        ownerName,
        contactNumber,
        password,
      });

      if (response.data.message === "Registration Successful") {
        navigate("/fuel-station-success");
      } else {
        setError(response.data.message || "Registration failed.");
      }
    } catch (error) {
      setError("An error occurred. Please try again.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="fuel-station-registration-container">
      <div className="fuel-station-form-container">
        <h2 className="fuel-station-form-title">Fuel Station Registration</h2>
        <form onSubmit={registerFuelStation} className="fuel-station-registration-form">
          <div className="fuel-station-input-group">
            <label>Station Name</label>
            <input type="text" value={stationName} onChange={(e) => setStationName(e.target.value)} required />
          </div>
          <div className="fuel-station-input-group">
            <label>Location</label>
            <input type="text" value={location} onChange={(e) => setLocation(e.target.value)} required />
          </div>
          <div className="fuel-station-input-group">
            <label>Owner Name</label>
            <input type="text" value={ownerName} onChange={(e) => setOwnerName(e.target.value)} required />
          </div>
          <div className="fuel-station-input-group">
            <label>Contact Number</label>
            <input type="text" value={contactNumber} onChange={(e) => setContactNumber(e.target.value)} required />
          </div>
          <div className="fuel-station-input-group">
            <label>Password</label>
            <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
          </div>
          {error && <div className="fuel-station-error-message">{error}</div>}
          <button type="submit" className="fuel-station-submit-button" disabled={loading}>
            {loading ? "Registering..." : "Register"}
          </button>
        </form>
      </div>
    </div>
  );
};

export default FuelStationRegistration;
