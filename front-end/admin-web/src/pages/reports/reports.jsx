import React, { useState } from "react";
import Header from "../../components/Header/Header";
import ReportForm from "../../components/Form/ReportForm";
import ReportList from "../../components/ReportList/ReportList";

const Reports = () => {
  const [fuelType, setFuelType] = useState("");
  const [period, setPeriod] = useState("");
  const [shouldFetchReports, setShouldFetchReports] = useState(false);

  const handleGenerateReport = (selectedFuelType, selectedPeriod) => {
    setFuelType(selectedFuelType);
    setPeriod(selectedPeriod);
    setShouldFetchReports(true); // Trigger fetching reports only when user clicks "Generate Report"
  };

  return (
    <div className="reports-container">
      <Header title="Fuel Consumption Report Generator" />
      <ReportForm generateReport={handleGenerateReport} />
      {shouldFetchReports && <ReportList fuelType={fuelType} period={period} />}
    </div>
  );
};

export default Reports;
