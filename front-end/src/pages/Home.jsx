import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Footer from "../user/common/Footer";

const Home = () => {
  const [fuelInfo, setFuelInfo] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    // Fetch data from Spring Boot backend
    fetch("http://localhost:8080/api/fuelInfo")
      .then((response) => response.json())
      .then((data) => setFuelInfo(data))
      .catch((error) => console.error("Error fetching fuel data:", error));
  }, []);

  const handleRegisterClick = () => {
    navigate("/Register");
  };

  const handleLoginClick = () => {
    navigate("/Login");
  };

  return (
    <div>
      <div className="container">
        <div className="top-left">
          <img src="/logo.png" alt="FuelPulse Logo" className="logo" />
        </div>
        <div className="top-right">
          <button className="register-button" onClick={handleLoginClick}>
            Log In
          </button>
        </div>

        <div className="content">
          <h1 className="title">What is FuelPulse?</h1>
          <p className="subtitle">
            Managing Fuel, Simplifying Lives: Your Digital Fuel Management Solution
          </p>
          <button className="register-button" onClick={handleRegisterClick}>
            REGISTER NOW
          </button>
        </div>

        <div className="about-section">
          <h2>FuelPulse</h2>
          <p>
            FuelPulse is an innovative platform designed to streamline fuel management processes.
          </p>
          <p>{fuelInfo}</p> {/* Display fetched fuel data */}
        </div>
      </div>

      <Footer />
    </div>
  );
};

export default Home;
