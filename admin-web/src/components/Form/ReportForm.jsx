import React, { useState } from "react";
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
      <form className="report-form">
        <div className="form-group">
          <label>
            Fuel Type:
            <select
              value={fuelType}
              onChange={(e) => setFuelType(e.target.value)}
            >
              <option value="petrol">Petrol</option>
              <option value="diesel">Diesel</option>
              <option value="gas">Gas</option>
            </select>
          </label>
        </div>
        <div className="form-group">
          <label>
            Report Period:
            <select
              value={reportType}
              onChange={(e) => setReportType(e.target.value)}
            >
              <option value="daily">Daily</option>
              <option value="weekly">Weekly</option>
              <option value="monthly">Monthly</option>
            </select>
          </label>
        </div>
        <button
          type="button"
          className="generate-report-button"
          onClick={handleGenerateClick}
        >
          Generate Report
        </button>
      </form>
    </div>
  );
}

export default ReportForm;
