import React from "react";
import VehicleRegistrationForm from "./VehicleRegistrationForm";
import "./UserDashboard.css"; // Assuming you have a separate stylesheet for UserDashboard

const UserDashboard = () => {
  console.log("Rendering UserDashboard...");

  return (
    <div className="container">
      {/* Logo in the top-left corner */}
      <div className="top-left">
        <img src="/logo.png" alt="FuelPulse Logo" className="logo" />
      </div>

      {/* Main Content */}
      <div className="content">
        <h1 className="title">Welcome to FuelPulse Dashboard</h1>
        <p className="subtitle">
          Managing Fuel, Simplifying Lives: Your Digital Fuel Management Solution
        </p>

        {/* Vehicle Registration Form Section */}
        <div className="vehicle-registration-section">
          <VehicleRegistrationForm />
        </div>
      </div>

    </div>
  );
};

export default UserDashboard;


