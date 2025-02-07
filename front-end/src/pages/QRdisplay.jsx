import React, { useRef } from "react";
import { useLocation } from "react-router-dom";
import { QRCodeCanvas } from "qrcode.react";

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
    <div
      style={{
        textAlign: "center",
        padding: "20px",
        fontFamily: "Arial, sans-serif",
        backgroundColor: "#f9f9f9",
        minHeight: "100vh",
      }}
    >
      <h1
        style={{
          fontSize: "2.9rem",
          color: "#002855",
          marginBottom: "20px",
        }}
      >
        QR Code for Vehicle
      </h1>
      {vehicleDetails ? (
        <div
          style={{
            display: "inline-block",
            padding: "20px",
            border: "1px solid #ddd",
            borderRadius: "10px",
            backgroundColor: "#fff",
            boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1)",
          }}
        >
          <p style={{ fontSize: "1rem", margin: "10px 0" }}>
            <strong>Vehicle ID:</strong> {vehicleDetails.id}
          </p>
          <p style={{ fontSize: "1rem", margin: "10px 0" }}>
            <strong>Owner Name:</strong> {vehicleDetails.ownerName}
          </p>
          <div
            ref={qrRef}
            style={{
              margin: "20px auto",
              padding: "10px",
              display: "inline-block",
              backgroundColor: "#f1f1f1",
              borderRadius: "8px",
            }}
          >
            <QRCodeCanvas value={JSON.stringify(vehicleDetails)} size={200} />
          </div>
          <button
            onClick={downloadQRCode}
            style={{
              marginTop: "20px",
              padding: "10px 20px",
              fontSize: "1rem",
              backgroundColor: "#002855",
              color: "#fff",
              border: "none",
              borderRadius: "5px",
              cursor: "pointer",
              transition: "background-color 0.3s ease",
            }}
            onMouseOver={(e) => (e.target.style.backgroundColor = "#004080")}
            onMouseOut={(e) => (e.target.style.backgroundColor = "#002855")}
          >
            Download QR Code
          </button>
        </div>
      ) : (
        <p style={{ fontSize: "2rem", color: "#555" }}>No vehicle details found</p>
      )}
    </div>
  );
};

export default QRDisplay;


