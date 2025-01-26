import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import "../Styles/RegistrationSuccessfullPage.css";
import Footer from '../user/common/Footer';
const RegistrationSuccessfull = () => {
  const [vehicleDetails, setVehicleDetails] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    // Fetch the vehicle details from the backend
    const fetchVehicleDetails = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/v1/vehicle/{id}');
        setVehicleDetails(response.data);
      } catch (error) {
        console.error('Error fetching vehicle details:', error);
      }
    };

    fetchVehicleDetails();
  }, []);

  const startQRScanner = () => {
    // Navigate to the QR Scanner page
    navigate('QRcodeScanner');
  };

  return (
    <div className="success-container">
      <div className="message-container">
        <h2 className="success-title">Vehicle Registration Successful!</h2>
        <p className="success-message">
          Your vehicle has been successfully registered. You can now use the QR code scanner for quick access to your vehicle details.
        </p>

        {/* Display Vehicle Details */}
        {vehicleDetails && (
          <div className="vehicle-details">
            <p><strong>Vehicle ID:</strong> {vehicleDetails.id}</p>
            <p><strong>Owner Name:</strong> {vehicleDetails.ownerName}</p>
          </div>
        )}

        {/* QR Code Scanner Button */}
        <button className="qr-button" onClick={startQRScanner}>
          Scan QR Code
        </button>
      </div>
<Footer />
    </div>
  );
};

export default RegistrationSuccessfull;



