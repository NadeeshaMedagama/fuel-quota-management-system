import React from "react";
import "./Home.css";

const App = () => {
  return (
    <div className="container">
      <div className="top-right">
        <a href="#" className="login-link">Log In</a>
      </div>
      <div className="content">
        <h1 className="title">What is FuelPulse?</h1>
        <p className="subtitle">
          Managing Fuel, Simplifying Lives: Your Digital Fuel Management Solution
        </p>
        <button className="register-button">REGISTER NOW</button>
      </div>
      <div className="about-section">
        <h2>About FuelPulse</h2>
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

export default App;
