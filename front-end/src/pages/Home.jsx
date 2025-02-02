import React from "react";
import "../Styles/home.css";
import LoginButton from "../Styles/components/LoginButton";
import RegisterButton from "../Styles/components/RegisterButton";
import Footer from "../Styles/components/Footer";
import { Link } from "react-router-dom"; // import Link for routing

function Home() {
  return (
    <div className="home-container">
      <header className="home-header">
        <img src="/logo.png" alt="FuelPulse Logo" className="logo" />
      {/* Add Fuel Station Button */}
      <Link to="/FuelStationLogin" className="fuelstation-button">
          <button className="fuelstation-btn">Fuel Station</button>
        </Link>
      </header>

      <main className="home-main">
        <h1>What is FuelPulse?</h1>
        <p>Managing Fuel, Simplifying Lives: Your Digital Fuel Management Solution</p>
        <RegisterButton />
        <LoginButton />
       
      
     

      </main>

      <section className="home-description">
        <div className="info-card">
          <h2>FuelPulse</h2>
          <p>FuelPulse is an innovative platform designed to streamline fuel management processes.</p>
        </div>
      </section>

      <Footer />
    </div>
  );
}

export default Home;



