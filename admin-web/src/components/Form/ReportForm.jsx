import React, { useState } from 'react';
import './ReportForm.css';

function ReportForm({ generateReport }) {
  const [reportType, setReportType] = useState('daily');
  const [fuelType, setFuelType] = useState('petrol');

  const handleGenerateClick = () => {
    generateReport(fuelType, reportType);
  };

  return (
    <div>
      <h2>Select Report Type</h2>
      <form>
        <label>
          Fuel Type:
          <select value={fuelType} onChange={(e) => setFuelType(e.target.value)}>
            <option value="petrol">Petrol</option>
            <option value="diesel">Diesel</option>
            <option value="gas">Gas</option>
          </select>
        </label>
        <label>
          Report Period:
          <select value={reportType} onChange={(e) => setReportType(e.target.value)}>
            <option value="daily">Daily</option>
            <option value="weekly">Weekly</option>
            <option value="monthly">Monthly</option>
          </select>
        </label>
        <button type="button" onClick={handleGenerateClick}>
          Generate Report
        </button>
      </form>
    </div>
  );
}

export default ReportForm;
