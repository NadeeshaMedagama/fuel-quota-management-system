import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Footer from "../user/common/Footer";
import "../Styles/Home.css";

const Home = () => {
  const [fuelInfo, setFuelInfo] = useState(null); // Updated state to handle null more effectively
  const navigate = useNavigate();

  useEffect(() => {
    const fetchFuelInfo = async () => {
      try {
        const response = await fetch("http://localhost:8080/api/fuelInfo");
        if (response.ok) {
          const data = await response.json();
          setFuelInfo(data);
        } else {
          throw new Error("Failed to fetch fuel data");
        }
      } catch (error) {
        console.error("Error fetching fuel data:", error);
      }
    };
    
    fetchFuelInfo();
  }, []); // Empty dependency array ensures this runs once when the component mounts

  const handleRegisterClick = () => {
    navigate("/Register");
  };

  const handleLoginClick = () => {
    navigate("/Login");
  };

  return (
    <div className="home-background">
      <div className="home-container">
        <div className="home-header">
          <div className="home-logo-container">
            <img src="/logo.png" alt="FuelPulse Logo" className="home-logo" />
          </div>
          <div className="home-login-container">
            <button className="home-login-button" onClick={handleLoginClick}>
              Log In
            </button>
          </div>
        </div>

        <div className="home-content">
          <h1 className="home-title">What is FuelPulse?</h1>
          <p className="home-subtitle">
            Managing Fuel, Simplifying Lives: Your Digital Fuel Management Solution
          </p>
          <button className="home-register-button" onClick={handleRegisterClick}>
            REGISTER NOW
          </button>
        </div>

        {/* Optionally display fuelInfo if available */}
        {fuelInfo && (
          <div className="fuel-info">
            <h2>Fuel Information</h2>
            <p>{fuelInfo.details}</p> {/* Customize based on the actual structure of the fetched data */}
          </div>
        )}
      </div>

      <Footer />
    </div>
  );
};

export default Home;

