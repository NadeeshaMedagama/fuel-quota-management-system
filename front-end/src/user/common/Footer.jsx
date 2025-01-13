

import React from "react";
import "./Footer.css"; // Link to the CSS file


const Footer = () => {
  return (
    <footer className="footer">
      <div className="footer-content">
        <div className="footer-left">
        <img src="/logo.png" alt="FuelPulse Logo" className="footer-logo" />
         
          <p className="footer-description">
            FuelPulse is an innovative platform designed to manage fuel
            distribution efficiently, ensuring fair allocation during fuel
            crises. Simplify your fuel management today!
          </p>
        </div>
        <div className="footer-center">
          <img
            src="/qr-pic.jpg"
            alt="QR Code"
            className="footer-qr-code"
          />
        </div>
        <div className="footer-right">
          <h3 className="quick-links-title">Quick Links</h3>
          <ul className="quick-links">
            <li><a href="#home">Home</a></li>
            <li><a href="#vehicle">Vehicle</a></li>
            <li><a href="#fuel-station">Fuel Station</a></li>
            <li><a href="#distributor">Distributor</a></li>
           
          </ul>
        </div>
      </div>
      <div className="footer-bottom">
        <p>
          © 2024 FuelPulse. All rights reserved. 
          <a href="#privacy-policy"> Privacy Policy </a> | 
          <a href="#terms-conditions"> Terms & Conditions </a>
        </p>
      </div>
    </footer>
  );
};



export default Footer;
