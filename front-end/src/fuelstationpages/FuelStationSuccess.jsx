import React from "react";
import { useNavigate } from "react-router-dom";
import "./FuelStationSuccess.css";

const FuelStationSuccess = () => {
  const navigate = useNavigate();

  return (
    <div className="fuel-station-success-container">
      <div className="fuel-station-message-container">
        <h2 className="fuel-station-success-title">Registration Successful!</h2>
        <p className="fuel-station-success-message">
          Your fuel station has been successfully registered. You can now manage fuel quotas and monitor transactions from the dashboard.
        </p>
        <button 
          className="fuel-station-dashboard-button" 
          onClick={() => navigate("/")}
        >
          Go to Dashboard
        </button>
      </div>
    </div>
  );
};

export default FuelStationSuccess;
