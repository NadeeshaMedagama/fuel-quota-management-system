import React from 'react';
import './Terms.css'; // Import the CSS file

const TermsAndConditions = ({ isOpen, onClose }) => {
  if (!isOpen) return null;

  const handleOverlayClick = (e) => {
    if (e.target === e.currentTarget) {
      onClose();
    }
  };

  return (
    <div 
      className="fixed inset-0 z-50 flex items-center justify-center bg-black bg-opacity-50"
      onClick={handleOverlayClick}
    >
      <div className="relative w-full max-w-3xl p-8 mx-auto bg-white border-t-4 border-green-500 shadow-xl rounded-xl">
        {/* Close button */}
        <button
          onClick={onClose}
          className="absolute top-4 right-4 text-gray-500 hover:text-gray-800"
        >
          ✕
        </button>

        {/* Popup Header */}
        <h1 className="mb-6 text-4xl font-extrabold text-center text-green-700">
          Terms and Conditions
        </h1>
        <p className="mb-8 text-sm text-center text-green-500">
          Last Updated: January 2025
        </p>

        {/* Scrollable Content */}
        <div
          className="overflow-y-auto max-h-[70vh] px-4"
          style={{ scrollbarWidth: "thin", scrollbarColor: "#10B981 #F3F4F6" }}
        >
          {/* Welcome Section */}
          <section className="mb-8">
            <h2 className="mb-4 text-2xl font-semibold text-green-800">
              Welcome to FuelPulse
            </h2>
            <p className="text-lg leading-relaxed text-gray-700">
              Thank you for choosing FuelPulse. By using our platform, you agree to these terms and conditions. Please read them carefully to understand your rights and responsibilities.
            </p>
          </section>

          {/* User Responsibilities Section */}
          <section className="mb-8">
            <h2 className="mb-4 text-2xl font-semibold text-green-800">
              User Responsibilities
            </h2>
            <p className="text-lg leading-relaxed text-gray-700">
              As a user, you are responsible for ensuring the accuracy of the information you provide and complying with all applicable laws and regulations while using our platform. Misuse of the platform may result in account suspension or termination.
            </p>
          </section>

          {/* Privacy and Data Security Section */}
          <section className="mb-8">
            <h2 className="mb-4 text-2xl font-semibold text-green-800">
              Privacy and Data Security
            </h2>
            <p className="text-lg leading-relaxed text-gray-700">
              Your privacy is important to us. We collect and use your data in accordance with our Privacy Policy to improve your experience on our platform. We implement advanced security measures to safeguard your information.
            </p>
          </section>

          {/* Payment Policies Section */}
          <section className="mb-8">
            <h2 className="mb-4 text-2xl font-semibold text-green-800">
              Payment Policies
            </h2>
            <p className="text-lg leading-relaxed text-gray-700">
              All transactions made through FuelPulse are subject to our payment terms. Refunds will only be processed under specific circumstances, as detailed in our Refund Policy.
            </p>
          </section>

          {/* Disclaimer of Liability Section */}
          <section className="mb-8">
            <h2 className="mb-4 text-2xl font-semibold text-green-800">
              Disclaimer of Liability
            </h2>
            <p className="text-lg leading-relaxed text-gray-700">
              FuelPulse is provided "as is" without warranties of any kind. While we strive for accuracy, we are not responsible for errors, omissions, or disruptions in service. Use the platform at your own risk.
            </p>
          </section>

          {/* Updates to Terms Section */}
          <section className="mb-8">
            <h2 className="mb-4 text-2xl font-semibold text-green-800">
              Updates to Terms
            </h2>
            <p className="text-lg leading-relaxed text-gray-700">
              We reserve the right to modify these terms at any time. Changes will be communicated through our platform or via email. Continued use of the platform constitutes acceptance of the updated terms.
            </p>
          </section>

          {/* Governing Law Section */}
          <section className="mb-8">
            <h2 className="mb-4 text-2xl font-semibold text-green-800">
              Governing Law
            </h2>
            <p className="text-lg leading-relaxed text-gray-700">
              These terms are governed by the laws of Sri Lanka. Any disputes arising from the use of our platform will be subject to the jurisdiction of Sri Lankan courts.
            </p>
          </section>

          {/* Contact Us Section */}
          <section className="mb-8">
            <h2 className="mb-4 text-2xl font-semibold text-green-800">
              Contact Us
            </h2>
            <p className="text-lg leading-relaxed text-gray-700">
              If you have any questions, please contact us at{' '}
              <a
                href="mailto:support@fuelpulse.com"
                className="text-green-600 transition duration-200 hover:text-green-800"
              >
                support@fuelpulse.com
              </a>
              . We are here to help.
            </p>
          </section>
        </div>
        <div className="mt-4 text-center">
          <button
            onClick={onClose}
            className="px-8 py-2 text-lg font-semibold text-white bg-gradient-to-r from-green-500 to-teal-500 rounded-lg shadow-md hover:from-teal-500 hover:to-green-500 focus:ring-4 focus:ring-green-400"
          >
            Close
          </button>
        </div>
      </div>
    </div>
  );
};

export default TermsAndConditions;
