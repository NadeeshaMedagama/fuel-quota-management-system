import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "./FuelStationLogin.css"; 

const FuelStationLogin = () => {
  const [stationId, setStationId] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  const navigate = useNavigate();

  const login = async (event) => {
    event.preventDefault();
    setError("");
    setLoading(true);

    try {
      const response = await axios.post("http://localhost:8080/api/v1/auth/fuelStationAuth", {
        stationId,
        password,
      });

      if (response.data.message === "Login Success") {
        navigate("/fuel-station-registration");
      } else {
        setError(response.data.message || "Invalid credentials.");
      }
    } catch (error) {
      setError("An error occurred. Please try again.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="fuel-station-login-container">
      <div className="fuel-station-form-container">
        <h2 className="fuel-station-form-title">Fuel Station Login</h2>
        <form onSubmit={login} className="fuel-station-login-form">
          <div className="fuel-station-input-group">
            <label>Fuel Station ID</label>
            <input type="text" value={stationId} onChange={(e) => setStationId(e.target.value)} required />
          </div>
          <div className="fuel-station-input-group">
            <label>Password</label>
            <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
          </div>
          {error && <div className="fuel-station-error-message">{error}</div>}
          <button type="submit" className="fuel-station-submit-button" disabled={loading}>
            {loading ? "Logging in..." : "Login"}
          </button>
        </form>
      </div>
    </div>
  );
};

export default FuelStationLogin;
