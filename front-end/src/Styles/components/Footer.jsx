import React from "react";
import { Link } from "react-router-dom"; // Import Link for navigation
import "../../Styles/footer.css";

function Footer() {
  return (
    <footer className="footer-container">
      <div className="footer-content">
        <div className="footer-logo">
          <img src="/logo.png" alt="FuelPulse Logo" />
          <p>
            FuelPulse is an innovative platform designed to manage fuel distribution efficiently, ensuring fair allocation during fuel crises. Simplify your fuel management today!
          </p>
        </div>
        <div className="footer-contact">
          <h3>Contact Us</h3>
          <p><strong>FuelPulse Headquarters</strong></p>
          <p>123 Main Street, Colombo, Sri Lanka</p>
          <p>Phone: +94 112 345 678</p>
          <p>Email: support@fuelpulse.com</p>
        </div>
      </div>
      <div className="footer-bottom">
        <p>
          © 2024 FuelPulse. All rights reserved.{" "}
          <Link to="/PrivacyPolicy">Privacy Policy</Link> |{" "}
          <Link to="/TermsAndConditions">Terms & Conditions</Link>
        </p>
      </div>
    </footer>
  );
}

export default Footer;


