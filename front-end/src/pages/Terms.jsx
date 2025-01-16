import React from 'react';

const TermsAndConditions = () => {
  return (
    <div style={styles.termsContainer}>
      <header style={styles.termsHeader}>
        <h1>Terms and Conditions</h1>
      </header>

      <section style={styles.termsContent}>
        <h2>Introduction</h2>
        <p>Welcome to our website! By using our services, you agree to comply with and be bound by the following terms and conditions. Please read them carefully.</p>

        <h2>1. Use of Services</h2>
        <p>Our services are provided to you for personal and non-commercial use. You agree not to use our services for any illegal or unauthorized purposes.</p>

        <h2>2. User Account</h2>
        <p>To use certain features of the website, you may need to create a user account. You are responsible for maintaining the confidentiality of your account information.</p>

        <h2>3. Content Ownership</h2>
        <p>All content on this website, including text, images, and videos, is owned by us or our licensors. You may not reproduce, distribute, or use this content without permission.</p>

        <h2>4. Limitation of Liability</h2>
        <p>We are not responsible for any damages or losses that result from using our website or services. Our liability is limited to the maximum extent permitted by law.</p>

        <h2>5. Changes to Terms</h2>
        <p>We reserve the right to update or modify these terms at any time. Any changes will be posted on this page with the updated date.</p>

        <h2>6. Governing Law</h2>
        <p>These terms are governed by the laws of the jurisdiction where our company is located. Any disputes will be resolved in the courts of that jurisdiction.</p>

        <h2>Your Rights</h2>
        <p>If you have any questions about our terms and conditions or wish to exercise your rights, please contact us at [contact@yourdomain.com].</p>

        <p>Last updated: January 16, 2025</p>
      </section>

      <footer style={styles.termsFooter}>
        <p>&copy; 2025 YourCompany. All rights reserved.</p>
      </footer>
    </div>
  );
};

const styles = {
  termsContainer: {
    fontFamily: 'Arial, sans-serif',
    margin: 0,
    padding: 0,
    display: 'flex',
    flexDirection: 'column',
    minHeight: '100vh',
  },
  termsHeader: {
    backgroundColor: '#00274d',
    color: '#fff',
    padding: '20px 50px',
    textAlign: 'center',
  },
  termsContent: {
    padding: '20px',
    backgroundColor: '#f8f9fa',
    color: '#333',
    flex: 1,
    lineHeight: '1.6',
  },
  termsFooter: {
    backgroundColor: '#00274d',
    color: '#fff',
    textAlign: 'center',
    padding: '20px',
  },
};

export default TermsAndConditions;


