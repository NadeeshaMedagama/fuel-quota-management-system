import React from "react";
import './Privacy.css';

const PrivacyPolicy = () => {
  return (
    <div style={styles.privacyContainer}>
      <header style={styles.privacyHeader}>
        <h1 style={styles.mainHeading}>Privacy Policy</h1>
      </header>

      <section style={styles.privacyContent}>
        <h2 style={styles.sectionHeading}>Privacy Statement</h2>
        <p style={styles.paragraph}>
          FuelPulse is committed to safeguarding your privacy and protecting the personal information you provide while using our website, www.fuelpulse.com. This Privacy Statement explains how we collect, use, and protect your data when you access and interact with our site.
        </p>

        <h2 style={styles.sectionHeading}>Information We Collect</h2>
        <p style={styles.paragraph}>
          We may collect personal information such as your name, contact details, and other data you provide through features like registrations, inquiries, and forms. Additionally, we may automatically collect technical information, such as your IP address, to improve site performance.
        </p>
        <ul style={styles.list}>
          <li>Personal information such as your name, email address, and contact details.</li>
          <li>Usage data such as your browsing activity, device information, and IP address.</li>
        </ul>

        <h2 style={styles.sectionHeading}>Use of Information:</h2>
        <p style={styles.paragraph}>
          Your personal information will be used to deliver the services you request, conduct internal research, send relevant updates, and enhance user experience. We will not share your personal information with third parties without your consent, except where required by law or to protect FuelPulse’s interests.
        </p>
        <ul style={styles.list}>
          <li>Provide, maintain, and improve our services.</li>
          <li>Communicate with you, including sending updates, newsletters, and marketing materials.</li>
          <li>Analyze how users interact with our website to improve user experience.</li>
        </ul>

        <h2 style={styles.sectionHeading}>Data Security</h2>
        <p style={styles.paragraph}>
          We employ reasonable security measures to protect your information. However, due to the nature of internet transmission, we cannot guarantee complete security against unauthorized access.
        </p>

        <h2 style={styles.sectionHeading}>Cookies</h2>
        <p style={styles.paragraph}>
          We use cookies to improve your experience by customizing content and tracking site performance. You can disable cookies through your browser settings, but this may impact the functionality of certain features on the site.
        </p>

        <h2 style={styles.sectionHeading}>Third-Party Services</h2>
        <p style={styles.paragraph}>
          We may share your information with trusted third-party services for analytics or marketing purposes. These third parties are required to use your data only for the purposes specified by us.
        </p>

        <h2 style={styles.sectionHeading}>Your Rights</h2>
        <p style={styles.paragraph}>
          You have the right to access, update, or delete your personal data. If you would like to exercise any of these rights, please contact us at [contact@yourdomain.com].
        </p>

        <h2 style={styles.sectionHeading}>Changes to the Privacy Statement:</h2>
        <p style={styles.paragraph}>
          We may update this Privacy Policy from time to time. Any changes will be posted on this page with an updated date.
        </p>
        <p style={styles.paragraph}>
          For any questions or concerns, please reach out to us at <strong>support@fuelpulse.com</strong>.
        </p>
        <p style={styles.lastUpdated}>Last updated: January 16, 2025</p>
      </section>

      <div className="footer-right">
        <h3 className="contact-title">Contact Us</h3>
        <p><strong>FuelPulse Headquarters</strong></p>
        <p>123 Main Street, Colombo, Sri Lanka</p>
        <p>Phone: +94 112 345 678</p>
        <p>Email: <a href="mailto:support@fuelpulse.com">support@fuelpulse.com</a></p>
      </div>
    </div>
  );
};

export default PrivacyPolicy;

