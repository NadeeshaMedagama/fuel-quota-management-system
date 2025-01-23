import React, { useState } from 'react';
import './QRCodeScanner.css';
import { useNavigate } from 'react-router-dom';
import { QrReader } from 'react-qr-code-scanner';
 // Updated import

const QRCodeScannerPage = () => {
  const [qrData, setQrData] = useState(null);
  const navigate = useNavigate();

  const handleScan = (data) => {
    if (data) {
      setQrData(data);
      console.log('QR Code Data: ', data);
    }
  };

  const handleError = (err) => {
    console.error('QR Error: ', err);
  };

  return (
    <div className="scanner-container">
      <h2 className="scanner-title">Scan QR Code</h2>
      <p className="scanner-message">
        Point your camera at a QR code to scan and get the data.
      </p>

      {/* Updated QR Code Scanner Component */}
      <QrReader
        delay={300}
        style={{ width: '100%' }}
        onError={handleError}
        onScan={handleScan}
      />

      {qrData && (
        <div className="scanner-result">
          <h3>QR Code Scanned Successfully!</h3>
          <p><strong>Data:</strong> {qrData}</p>
        </div>
      )}
    </div>
  );
};

export default QRCodeScannerPage;

