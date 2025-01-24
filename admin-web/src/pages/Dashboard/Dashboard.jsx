// Dashboard.jsx
import React, { useEffect, useState } from "react";
import Sider from "../../components/Dashboard/Sidebar"; // Sidebar component
import InfoCard from "../../components/Dashboard/InfoCard"; // InfoCard component
import FuelConsumptionChart from "../../components/Dashboard/FuelConsumptionChart"; // PieChart component
import "./Dashboard.css"; // Dashboard styles
import axios from "axios";

const Dashboard = () => {
  const [dashboardData, setDashboardData] = useState({
    totalVehicles: 0,
    totalDistributors: 0,
    totalFuelStations: 0,
    totalUsers: 0,
  });

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/dashboard-data")
      .then((response) => {
        // Assume the JSON response is in the format:
        // { totalVehicles: 10, totalDistributors: 5, totalFuelStations: 3, totalUsers: 20 }
        setDashboardData(response.data);
      })
      .catch((error) => console.error("Error fetching dashboard data:", error));
  }, []);

  return (
    <div className="dashboard-container">
      <Sider />
      <div className="dashboard-content">
        <h1 className="dashboard-title">Admin Dashboard</h1>
        <div className="info-cards-container">
          <InfoCard title="Total Vehicles" count={dashboardData.totalVehicles} />
          <InfoCard title="Total Distributors" count={dashboardData.totalDistributors} />
          <InfoCard title="Total Fuel Stations" count={dashboardData.totalFuelStations} />
          <InfoCard title="Total Users" count={dashboardData.totalUsers} />
        </div>
        <div className="fuel-consumption-chart-container">
          <h2 className="chart-title">Daily Fuel Sales</h2>
          <FuelConsumptionChart />
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
