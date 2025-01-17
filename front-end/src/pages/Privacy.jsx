import React from "react";

const PrivacyPolicy = () => {
  return (
    <div style={styles.privacyContainer}>
      <header style={styles.privacyHeader}>
        <h1 style={styles.mainHeading}>Privacy Policy</h1>
      </header>

      <section style={styles.privacyContent}>
        <h2 style={styles.sectionHeading}>Privacy & Policy</h2>
        <p style={styles.paragraph}>
          Your privacy is important to us. This Privacy Policy explains the personal data we collect, how we use it, and the measures we take to protect it.
        </p>

        <h2 style={styles.sectionHeading}>Information We Collect</h2>
        <p style={styles.paragraph}>
          We collect information to provide better services to all of our users. The types of information we collect include:
        </p>
        <ul style={styles.list}>
          <li>Personal information such as your name, email address, and contact details.</li>
          <li>Usage data such as your browsing activity, device information, and IP address.</li>
        </ul>

        <h2 style={styles.sectionHeading}>How We Use Your Information</h2>
        <p style={styles.paragraph}>We use the information we collect to:</p>
        <ul style={styles.list}>
          <li>Provide, maintain, and improve our services.</li>
          <li>Communicate with you, including sending updates, newsletters, and marketing materials.</li>
          <li>Analyze how users interact with our website to improve user experience.</li>
        </ul>

        <h2 style={styles.sectionHeading}>Data Security</h2>
        <p style={styles.paragraph}>
          We take appropriate security measures to protect your personal information. However, no method of transmission over the internet or electronic storage is 100% secure, and we cannot guarantee absolute security.
        </p>

        <h2 style={styles.sectionHeading}>Cookies</h2>
        <p style={styles.paragraph}>
          We use cookies to enhance your experience on our website. Cookies are small files that are stored on your device. You can choose to disable cookies in your browser settings.
        </p>

        <h2 style={styles.sectionHeading}>Third-Party Services</h2>
        <p style={styles.paragraph}>
          We may share your information with trusted third-party services for analytics or marketing purposes. These third parties are required to use your data only for the purposes specified by us.
        </p>

        <h2 style={styles.sectionHeading}>Your Rights</h2>
        <p style={styles.paragraph}>
          You have the right to access, update, or delete your personal data. If you would like to exercise any of these rights, please contact us at [contact@yourdomain.com].
        </p>

        <h2 style={styles.sectionHeading}>Changes to This Policy</h2>
        <p style={styles.paragraph}>
          We may update this Privacy Policy from time to time. Any changes will be posted on this page with an updated date.
        </p>

        <p style={styles.lastUpdated}>Last updated: January 16, 2025</p>
      </section>
    </div>
  );
};




export default PrivacyPolicy;
