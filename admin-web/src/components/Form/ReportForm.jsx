import React, { useState } from "react";
import { Button, Form } from "react-bootstrap"; // Import Bootstrap components
import "./ReportForm.css";

function ReportForm({ generateReport }) {
  const [reportType, setReportType] = useState("daily");
  const [fuelType, setFuelType] = useState("petrol");

  const handleGenerateClick = () => {
    generateReport(fuelType, reportType);
  };

  return (
    <div className="report-form-wrapper">
      <h2 className="form-header">Select Report Type</h2>
      <Form className="report-form">
        <Form.Group className="mb-3">
          <Form.Label>Fuel Type:</Form.Label>
          <Form.Control
            as="select"
            value={fuelType}
            onChange={(e) => setFuelType(e.target.value)}
          >
            <option value="petrol">Petrol</option>
            <option value="diesel">Diesel</option>
            <option value="gas">Gas</option>
          </Form.Control>
        </Form.Group>

        <Form.Group className="mb-3">
          <Form.Label>Report Period:</Form.Label>
          <Form.Control
            as="select"
            value={reportType}
            onChange={(e) => setReportType(e.target.value)}
          >
            <option value="daily">Daily</option>
            <option value="weekly">Weekly</option>
            <option value="monthly">Monthly</option>
          </Form.Control>
        </Form.Group>

        <Button
          variant="primary"
          className="generate-report-button"
          onClick={handleGenerateClick}
        >
          Generate Report
        </Button>
      </Form>
    </div>
  );
}

export default ReportForm;
