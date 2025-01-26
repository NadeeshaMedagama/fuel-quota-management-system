import React from "react";
import "../styles/Home.css";
import LoginButton from "../Styles/components/LoginButton";
import RegisterButton from "../Styles/components/RegisterButton";
import Footer from "../Styles/components/Footer";

function Home() {
    return (
      <div className="home-container">
        <header className="home-header">
          <img src="/logo.png" alt="FuelPulse Logo" className="logo" />
          <LoginButton />
        </header>
  
        <main className="home-main">
          <h1>What is FuelPulse?</h1>
          <p>Managing Fuel, Simplifying Lives: Your Digital Fuel Management Solution</p>
          <RegisterButton />
        </main>
  
        
  
        <Footer />
      </div>
    );
  }
  

export default Home;

