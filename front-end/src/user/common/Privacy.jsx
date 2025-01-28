
import "./Privacy.css";

const PrivacyPolicy = () => {

  return (
    <div className="privacy-policy-wrapper">
      {/* Header Section */}
      <header className="policy-header">
        <h1 className="title-heading">Privacy Policy</h1>
      </header>

      {/* Privacy Content Section */}
      <section className="policy-content-section">
        {/* Privacy Statement */}
        <h2 className="content-heading">Privacy Statement</h2>
        <p className="content-paragraph">
          FuelPulse is committed to safeguarding your privacy and protecting thepersonal information you provide while using our website, www.fuelpulse.com.This Privacy Statement explains how we collect, use, and protect your data when you access and interact with our site.
        </p>

        {/* Information We Collect */}
        <h2 className="content-heading">Information We Collect</h2>
        <p className="content-paragraph">
        We may collect information about you in a variety of ways. The information we may collect on the Website includes:

Personal Data Personally identifiable information, such as your name, address, email address, and telephone number that you voluntarily give to us when you register with the Website or when you choose to participate in various activities related to the Website, such as online payments.

Derivative Data Information our servers automatically collect when you access the Website, such as your IP address, your browser type, your operating system, your access times, and the pages you have viewed directly before and after accessing the Website.

Financial Data Financial information, such as data related to your payment method (e.g., valid credit card number, card brand, expiration date) that we may collect when you pay for the license process, and reserve our resorts from the Website
        </p>

        {/* Use of Information */}
        <h2 className="content-heading">Use of Information</h2>
        <p className="content-paragraph">
        Having accurate information about you permits us to provide you with a smooth, efficient, and customized experience. Specifically, we may use information collected about you via the Website to:

Create and manage your account.

Process your transactions.

Email you regarding your account.

Fulfill and manage payments, and other transactions related to the Website.

Increase the efficiency and operation of the Website.

Monitor and analyze usage and trends to improve your experience with the Website.

Notify you of updates to the Website.
        </p>

        {/* Data Security */}
        <h2 className="content-heading">Data Security</h2>
        <p className="content-paragraph">
        We use administrative, technical, and physical security measures to help protect your personal information. While we have taken reasonable steps to secure the personal information you provide to us, please be aware that despite our efforts, no security measures are perfect or impenetrable, and no method of data transmission can be guaranteed against any interception or other types of misuse
        </p>

        {/* Cookies */}
        <h2 className="content-heading">Cookies</h2>
        <p className="content-paragraph">
          We use cookies to improve your experience by customizing content and
          tracking site performance. You can disable cookies through your browser
          settings, but this may impact the functionality of certain features on the site.
        </p>

        {/* Third-Party Services */}
        <h2 className="content-heading">Third-Party Services</h2>
        <p className="content-paragraph">
          We may share your information with trusted third-party services for analytics
          or marketing purposes. These third parties are required to use your data
          only for the purposes specified by us.
        </p>

        {/* Your Rights */}
        <h2 className="content-heading">Your Rights</h2>
        <p className="content-paragraph">
          You have the right to access, update, or delete your personal data. If you
          would like to exercise any of these rights, please contact us at{" "}
          <a href="mailto:support@fuelpulse.com">support@fuelpulse.com</a>.
        </p>

        {/* Changes to the Privacy Statement */}
        <h2 className="content-heading">Changes to the Privacy Statement</h2>
        <p className="content-paragraph">
          We may update this Privacy Policy from time to time. Any changes will be
          posted on this page with an updated date.We may update this Privacy Policy from time to time in order to reflect, for example, changes to our practices or for other operational, legal, or regulatory reasons.
        </p>
        <p className="content-paragraph">
          For any questions or concerns, please reach out to us at{" "}
          <strong>support@fuelpulse.com</strong>.
        </p>
        <p className="last-updated-text">Last updated: January 16, 2025</p>
      </section>
    </div>
  );
};

export default PrivacyPolicy;






