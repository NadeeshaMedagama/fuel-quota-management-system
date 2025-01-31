
import React, { useEffect } from "react";  // ✅ Import useEffect
import '../Styles/PrivacyPolicy.css';

const PrivacyPolicy = () => {

    useEffect(() => {
        window.scrollTo(0, 0);
    }, []);

  return (
    <div className="privacy-container">
      <header className="privacy-header">
        <h1 className="main-heading">Privacy Policy</h1>
      </header>

      <section className="privacy-content">
        <h2 className="section-heading">Privacy Statement</h2>
        <p className="paragraph">
          FuelPulse is committed to safeguarding your privacy and protecting the personal information you provide while using our website, www.fuelpulse.com. This Privacy Statement explains how we collect, use, and protect your data when you access and interact with our site.
        </p>

        <h2 className="section-heading">Information We Collect</h2>
        <p className="paragraph">
          We may collect personal information such as your name, contact details, and other data you provide through features like registrations, inquiries, and forms. Additionally, we may automatically collect technical information, such as your IP address, to improve site performance.
        </p>
        <ul className="list">
          <li>Personal information such as your name, email address, and contact details.</li>
          <li>Usage data such as your browsing activity, device information, and IP address.</li>
        </ul>

        <h2 className="section-heading">Use of Information:</h2>
        <p className="paragraph">
          Your personal information will be used to deliver the services you request, conduct internal research, send relevant updates, and enhance user experience. We will not share your personal information with third parties without your consent, except where required by law or to protect FuelPulse’s interests.
        </p>
        <ul className="list">
          <li>Provide, maintain, and improve our services.</li>
          <li>Communicate with you, including sending updates, newsletters, and marketing materials.</li>
          <li>Analyze how users interact with our website to improve user experience.</li>
        </ul>

        <h2 className="section-heading">Data Security</h2>
        <p className="paragraph">
          We employ reasonable security measures to protect your information. However, due to the nature of internet transmission, we cannot guarantee complete security against unauthorized access.
        </p>

        <h2 className="section-heading">Cookies</h2>
        <p className="paragraph">
          We use cookies to improve your experience by customizing content and tracking site performance. You can disable cookies through your browser settings, but this may impact the functionality of certain features on the site.
        </p>

        <h2 className="section-heading">Third-Party Services</h2>
        <p className="paragraph">
          We may share your information with trusted third-party services for analytics or marketing purposes. These third parties are required to use your data only for the purposes specified by us.
        </p>

        <h2 className="section-heading">Your Rights</h2>
        <p className="paragraph">
          You have the right to access, update, or delete your personal data. If you would like to exercise any of these rights, please contact us at <a href="mailto:support@fuelpulse.com">support@fuelpulse.com</a>.
        </p>

        <h2 className="section-heading">Changes to the Privacy Statement</h2>
        <p className="paragraph">
          We may update this Privacy Policy from time to time. Any changes will be posted on this page with an updated date.
        </p>
        <p className="paragraph">
          For any questions or concerns, please reach out to us at <strong>support@fuelpulse.com</strong>.
        </p>
        <p className="last-updated">Last updated: January 16, 2025</p>
      </section>

      <footer className="footer">
        <div className="footer-right">
          <h3 className="contact-title">Contact Us</h3>
          <p><strong>FuelPulse Headquarters</strong></p>
          <p>123 Main Street, Colombo, Sri Lanka</p>
          <p>Phone: +94 112 345 678</p>
          <p>Email: <a href="mailto:support@fuelpulse.com">support@fuelpulse.com</a></p>
        </div>
      </footer>
    </div>
  );
};

export default PrivacyPolicy;
