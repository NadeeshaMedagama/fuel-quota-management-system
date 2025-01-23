import React from 'react';
import { useNavigate } from 'react-router-dom';
import './RegistrationSuccessfullPage.css';

const RegistrationSuccessfull = () => {
  const navigate = useNavigate(); // Hook for navigation

  const startQRScanner = () => {
    // Navigate to the QR Scanner page
    navigate('/qrcode-scanner');
  };

  return (
    <div className="success-container">
      <div className="message-container">
        <h2 className="success-title">Vehicle Registration Successful!</h2>
        <p className="success-message">
          Your vehicle has been successfully registered. You can now use the QR code scanner for quick access to your vehicle details.
        </p>
        {/* QR Code Scanner Button */}
        <button className="qr-button" onClick={startQRScanner}>
          Scan QR Code
        </button>
      </div>
    </div>
  );
};

export default RegistrationSuccessfull;


