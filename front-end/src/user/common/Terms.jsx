import React from "react";
import { useNavigate } from "react-router-dom"; // Import useNavigate from react-router-dom
import "./Terms.css"; // Import the CSS file

const TermsAndConditions = () => {
  const navigate = useNavigate(); // Initialize useNavigate hook

  // Function to handle close button click
  const handleClose = () => {
    navigate("/"); // This will navigate to the Home page ("/")
  };

  return (
    <div className="terms-container">
      <h1 className="header">Terms and Conditions</h1>

      {/* Scrollable Content */}
      <div className="content">
        {/* Sections */}
        <section className="section">
          <h2 className="section-title">Welcome to FuelPulse</h2>
          <p className="section-text">
            Thank you for choosing FuelPulse. By using our platform, you agree
            to these terms and conditions. Please read them carefully to
            understand your rights and responsibilities.
          </p>
        </section>
        <section className="section">
          <h2 className="section-title">User Responsibilities</h2>
          <p className="section-text">
            As a user, you are responsible for ensuring the accuracy of the
            information you provide and complying with all applicable laws and
            regulations while using our platform. Misuse of the platform may
            result in account suspension or termination.
          </p>
        </section>
        <section className="section">
          <h2 className="section-title">Privacy and Data Security</h2>
          <p className="section-text">
            Your privacy is important to us. We collect and use your data in
            accordance with our Privacy Policy to improve your experience on
            our platform. We implement advanced security measures to
            safeguard your information.
          </p>
        </section>
      </div>

      {/* Close Button */}
      <button className="close-button" onClick={handleClose}>
        Close
      </button>

      {/* Last Updated Information */}
      <p className="subheader">Last Updated: January 2025</p>
    </div>
  );
};

export default TermsAndConditions;



