import React from 'react';

const PrivacyPolicy = () => {
  return (
    <div style={styles.privacyContainer}>
      <header style={styles.privacyHeader}>
        <h1>Privacy Policy</h1>
      </header>

      <section style={styles.privacyContent}>
        <h2>Introduction</h2>
        <p>Your privacy is important to us. This Privacy Policy explains the personal data we collect, how we use it, and the measures we take to protect it.</p>

        <h2>Information We Collect</h2>
        <p>We collect information to provide better services to all of our users. The types of information we collect include:</p>
        <ul>
          <li>Personal information such as your name, email address, and contact details.</li>
          <li>Usage data such as your browsing activity, device information, and IP address.</li>
        </ul>

        <h2>How We Use Your Information</h2>
        <p>We use the information we collect to:</p>
        <ul>
          <li>Provide, maintain, and improve our services.</li>
          <li>Communicate with you, including sending updates, newsletters, and marketing materials.</li>
          <li>Analyze how users interact with our website to improve user experience.</li>
        </ul>

        <h2>Data Security</h2>
        <p>We take appropriate security measures to protect your personal information. However, no method of transmission over the internet or electronic storage is 100% secure, and we cannot guarantee absolute security.</p>

        <h2>Cookies</h2>
        <p>We use cookies to enhance your experience on our website. Cookies are small files that are stored on your device. You can choose to disable cookies in your browser settings.</p>

        <h2>Third-Party Services</h2>
        <p>We may share your information with trusted third-party services for analytics or marketing purposes. These third parties are required to use your data only for the purposes specified by us.</p>

        <h2>Your Rights</h2>
        <p>You have the right to access, update, or delete your personal data. If you would like to exercise any of these rights, please contact us at [contact@yourdomain.com].</p>

        <h2>Changes to This Policy</h2>
        <p>We may update this Privacy Policy from time to time. Any changes will be posted on this page with an updated date.</p>

        <p>Last updated: January 16, 2025</p>
      </section>

      <footer style={styles.privacyFooter}>
        <p>&copy; 2025 YourCompany. All rights reserved.</p>
      </footer>
    </div>
  );
};

const styles = {
  privacyContainer: {
    fontFamily: 'Arial, sans-serif',
    margin: 0,
    padding: 0,
    display: 'flex',
    flexDirection: 'column',
    minHeight: '100vh',
  },
  privacyHeader: {
    backgroundColor: '#00274d',
    color: '#fff',
    padding: '20px 50px',
    textAlign: 'center',
  },
  privacyContent: {
    padding: '20px',
    backgroundColor: '#f8f9fa',
    color: '#333',
    flex: 1,
    lineHeight: '1.6',
  },
  privacyFooter: {
    backgroundColor: '#00274d',
    color: '#fff',
    textAlign: 'center',
    padding: '20px',
  },
};

export default PrivacyPolicy;
