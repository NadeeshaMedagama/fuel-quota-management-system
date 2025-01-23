import React from 'react';
import './Terms.css'; // Import the CSS file

const TermsAndConditions = () => {
  return (
    <div className="terms-container">
      <header className="terms-header">
        <h1 className="main-heading">Terms and Conditions</h1>
      </header>

      <section className="terms-content">
        <h2 className="section-heading">Introduction</h2>
        <p className="paragraph">
          Welcome to our website! By using our services, you agree to comply with and be bound by the following terms and conditions. Please read them carefully.
        </p>

        <h2 className="section-heading">1. Use of Services</h2>
        <p className="paragraph">
          Our services are provided to you for personal and non-commercial use. You agree not to use our services for any illegal or unauthorized purposes.
        </p>

        <h2 className="section-heading">2. User Account</h2>
        <p className="paragraph">
          To use certain features of the website, you may need to create a user account. You are responsible for maintaining the confidentiality of your account information.
        </p>

        <h2 className="section-heading">3. Content Ownership</h2>
        <p className="paragraph">
          All content on this website, including text, images, and videos, is owned by us or our licensors. You may not reproduce, distribute, or use this content without permission.
        </p>

        <h2 className="section-heading">4. Limitation of Liability</h2>
        <p className="paragraph">
          We are not responsible for any damages or losses that result from using our website or services. Our liability is limited to the maximum extent permitted by law.
        </p>

        <h2 className="section-heading">5. Changes to Terms</h2>
        <p className="paragraph">
          We reserve the right to update or modify these terms at any time. Any changes will be posted on this page with the updated date.
        </p>

        <h2 className="section-heading">6. Governing Law</h2>
        <p className="paragraph">
          These terms are governed by the laws of the jurisdiction where our company is located. Any disputes will be resolved in the courts of that jurisdiction.
        </p>

        <h2 className="section-heading">Your Rights</h2>
        <p className="paragraph">
          If you have any questions about our terms and conditions or wish to exercise your rights, please contact us at [contact@yourdomain.com].
        </p>

        <p className="last-updated">Last updated: January 16, 2025</p>
      </section>

      <footer className="terms-footer">
        <p>&copy; 2025 YourCompany. All rights reserved.</p>
      </footer>
    </div>
  );
};

export default TermsAndConditions;



