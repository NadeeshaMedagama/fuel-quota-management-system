import React from "react";
import "../styles/TermsAndConditions.css"; // Import the CSS file

const TermsAndConditions = () => {
  return (
    <div className="terms-container">
      {/* Page Header */}
      <header className="terms-header">
        <h1 className="main-heading">Terms and Conditions</h1>
        <p className="last-updated">Last Updated: January 2025</p>
      </header>

      {/* Terms Content */}
      <div className="terms-content">
        <section className="terms-section">
          <h2 className="section-heading">Welcome to FuelPulse</h2>
          <p className="paragraph">
            Thank you for choosing FuelPulse. By using our platform, you agree
            to these terms and conditions. Please read them carefully to
            understand your rights and responsibilities.
          </p>
        </section>
        <section className="terms-section">
          <h2 className="section-heading">User Responsibilities</h2>
          <p className="paragraph">
            As a user, you are responsible for ensuring the accuracy of the
            information you provide and complying with all applicable laws and
            regulations while using our platform. Misuse of the platform may
            result in account suspension or termination.
          </p>
        </section>
        <section className="terms-section">
          <h2 className="section-heading">Privacy and Data Security</h2>
          <p className="paragraph">
            Your privacy is important to us. We collect and use your data in
            accordance with our Privacy Policy to improve your experience on
            our platform. We implement advanced security measures to
            safeguard your information.
          </p>
        </section>
      </div>

      {/* Footer */}
      <footer className="terms-footer">
        <p>
          If you have any questions or concerns regarding these terms, please
          contact us at{" "}
          <a href="mailto:support@fuelpulse.com" className="footer-link">
            support@fuelpulse.com
          </a>
          .
        </p>
      </footer>
    </div>
  );
};

export default TermsAndConditions;
