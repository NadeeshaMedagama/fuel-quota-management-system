import React, { useRef } from "react";
import { useLocation } from "react-router-dom";
//import { QRCodeCanvas } from "qrcode.react";

const QRDisplay = () => {
  const location = useLocation();
  const { vehicleDetails } = location.state || {};
  const qrRef = useRef(null);

  const downloadQRCode = () => {
    const canvas = qrRef.current.querySelector("canvas");
    if (canvas) {
      const url = canvas.toDataURL("image/png");
      const a = document.createElement("a");
      a.href = url;
      a.download = `QR_Code_Vehicle_${vehicleDetails?.id || "default"}.png`;
      document.body.appendChild(a);
      a.click();
      document.body.removeChild(a);
    }
  };

  return (
    <div className="qr-display-container">
      <h1>QR Code for Vehicle</h1>
      {vehicleDetails ? (
        <div>
          <p><strong>Vehicle ID:</strong> {vehicleDetails.id}</p>
          <p><strong>Owner Name:</strong> {vehicleDetails.ownerName}</p>
          <div ref={qrRef}>
            <QRCodeCanvas value={JSON.stringify(vehicleDetails)} size={200} />
          </div>
          <button className="download-btn" onClick={downloadQRCode}>
            Download QR Code
          </button>
        </div>
      ) : (
        <p>No vehicle details found</p>
      )}
    </div>
  );
};

export default QRDisplay;


