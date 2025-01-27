import React, { useState, useEffect } from "react";
import axios from "axios";
import "./ReportList.css";

const ReportList = ({ fuelType, period }) => {
  const [reports, setReports] = useState([]); // Always initialize as an empty array
  const [error, setError] = useState(null);

  useEffect(() => {
    // Check if valid fuelType and period are provided before making the API call
    if (fuelType && period) {
      const fetchReports = async () => {
        try {
          const response = await axios.get(`http://localhost:8080/api/reports?fuelType=${fuelType}&period=${period}`);
          
          console.log("Response Data:", response.data);

          if (Array.isArray(response.data)) {
            setReports(response.data);
          } else {
            setError("Received data is not in the correct format.");
            setReports([]);
          }
        } catch (err) {
          console.error("Error fetching reports:", err);
          setError("Failed to fetch reports.");
          setReports([]);
        }
      };

      fetchReports();
    }
  }, [fuelType, period]); // This effect runs only when fuelType or period changes

  const handleDownload = (reportId) => {
    axios({
      url: `http://localhost:8080/api/reports/download/${reportId}`,
      method: "GET",
      responseType: "blob", // Important for downloading files
    }).then((response) => {
      const url = window.URL.createObjectURL(new Blob([response.data]));
      const link = document.createElement("a");
      link.href = url;
      link.setAttribute("download", "report.csv");
      document.body.appendChild(link);
      link.click();
    }).catch((err) => {
      setError("Failed to download report.");
    });
  };

  return (
    <div className="report-list-container">
      {error && <div className="error-message">{error}</div>}
      <ul className="report-list">
        {reports.map((report, index) => (
          <li key={index} className="report-item">
            <p><strong>Fuel Type:</strong> {report.fuelType}</p>
            <p><strong>Report Period:</strong> {report.reportPeriod}</p>
            <p><strong>Generated At:</strong> {report.generatedAt}</p>
            <button onClick={() => handleDownload(report.id)}>Download Report</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ReportList;
