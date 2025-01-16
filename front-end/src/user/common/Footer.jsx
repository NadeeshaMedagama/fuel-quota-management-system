

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
     
        <div className="footer-right">
          <h3 className="contact-title">Contact Us</h3>
          <p className="contact-details">
            <strong>FuelPulse Headquarters</strong><br />
            123 Main Street, Colombo, Sri Lanka<br />
            Phone: +94 112 345 678<br />
            Email: support@fuelpulse.com
          </p>
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

