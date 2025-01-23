import React, { useState } from "react";
import "./QRCodeScanner.css";
import { useNavigate } from "react-router-dom";
import { QrReader } from "react-qr-code-scanner"; // Updated import
import axios from "axios"; // Import axios for API calls

const QRCodeScannerPage = () => {
  const [qrData, setQrData] = useState(null);
  const [message, setMessage] = useState(""); // For success/error messages
  const [loading, setLoading] = useState(false); // Loading state

  const navigate = useNavigate();

  const handleScan = async (data) => {
    if (data) {
      setQrData(data);
      console.log("QR Code Data: ", data);

      // Send the scanned data to the Spring Boot backend
      try {
        setLoading(true);
        const response = await axios.post("http://localhost:8080/api/v1/scan", {
          qrCodeData: data, // Payload with scanned QR data
        });

        // Handle the response
        if (response.data.success) {
          setMessage("QR Code processed successfully!");
          // Optionally, navigate to another page or handle the response
          navigate("/home");
        } else {
          setMessage("Failed to process QR Code.");
        }
      } catch (error) {
        console.error("Error processing QR Code: ", error);
        setMessage("An error occurred while processing the QR Code.");
      } finally {
        setLoading(false);
      }
    }
  };

  const handleError = (err) => {
    console.error("QR Error: ", err);
    setMessage("Error accessing the QR scanner. Please try again.");
  };

  return (
    <div className="scanner-container">
      <h2 className="scanner-title">Scan QR Code</h2>
      <p className="scanner-message">
        Point your camera at a QR code to scan and get the data.
      </p>

      {/* QR Code Scanner Component */}
      <QrReader
        delay={300}
        style={{ width: "100%" }}
        onError={handleError}
        onScan={handleScan}
      />

      {/* Display scanned data */}
      {qrData && (
        <div className="scanner-result">
          <h3>QR Code Scanned Successfully!</h3>
          <p>
            <strong>Data:</strong> {qrData}
          </p>
        </div>
      )}

      {/* Display backend response message */}
      {message && <div className="scanner-message">{message}</div>}

      {/* Loading state */}
      {loading && <div className="loading-message">Processing QR Code...</div>}
    </div>
  );
};

export default QRCodeScannerPage;

