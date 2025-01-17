import React from "react";
import "./Home.css";
import { useNavigate } from "react-router-dom";


const Home = () => {
  const navigate = useNavigate(); // Initialize the navigate function

  const handleRegisterClick = () => {
    navigate("/Register"); // Navigate to the Register route
  };
  const handleLoginClick = () => {
    navigate("/Login"); // Navigate to the Register route
  };
  return (
    <div className="container">
      {/* Logo in the top-left corner */}
      <div className="top-left">
        <img src="/logo.png" alt="FuelPulse Logo" className="logo" />
      </div>

      {/* Log In link in the top-right corner */}
      <div className="top-right">
      <button 
          className="register-button" 
          onClick={handleLoginClick} // Add onClick handler
        >
          Log In
          </button>
      </div>

      {/* Main Content */}
      <div className="content">
        <h1 className="title">What is FuelPulse?</h1>
        <p className="subtitle">
          Managing Fuel, Simplifying Lives: Your Digital Fuel Management Solution
        </p>
        <button 
          className="register-button" 
          onClick={handleRegisterClick} // Add onClick handler
        >
          REGISTER NOW
        </button>
      </div>

      {/* About Section */}
      <div className="about-section">
        <h2>FuelPulse</h2>
        <p>
          FuelPulse is an innovative platform designed to streamline fuel management processes.
          Our solution ensures efficient fuel distribution and fair allocation during fuel crises,
          making your fuel management tasks hassle-free.
        </p>
        <p>
          With FuelPulse, you can monitor fuel consumption, track allocations, and ensure that
          every drop of fuel is utilized effectively. Embrace the future of fuel management today!
        </p>
      </div>
    </div>
  );
};

export default Home;