import React from "react";
import { useNavigate } from "react-router-dom";
import "../styles/FuelStationSuccess.css";

const FuelStationSuccess = () => {
  const navigate = useNavigate();

  return (
    <div className="success-container">
      <div className="message-container">
        <h2 className="success-title">Registration Successful!</h2>
        <p className="success-message">
          Your fuel station has been successfully registered. You can now manage fuel quotas and monitor transactions from the dashboard.
        </p>
        <button className="dashboard-button" onClick={() => navigate("/FuelStationDashboard")}>
          Go to Dashboard
        </button>
      </div>
    </div>
  );
};

export default FuelStationSuccess;