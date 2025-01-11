import React, { useEffect, useState } from "react";
import Sider from "../Admin_Component/Dashboard/Sider";
import InfoCard from "../Admin_Component/Dashboard/InfoCard";
import { Container, Row, Col } from "react-bootstrap";
import useWindowSize from "./Resizer"; // Import the hook
import axios from "axios";
import "./Dashboard.css";

const Dashboard = () => {
  const { width } = useWindowSize();
  const isMobile = width <= 768;

  const [dashboardData, setDashboardData] = useState({
    totalVehicles: 0,
    totalEmployees: 0,
    totalFuelStations: 0,
    totalUsers: 0,
  });

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/dashboard-data")
      .then((response) => setDashboardData(response.data))
      .catch((error) => console.error("Error fetching dashboard data:", error));
  }, []);

  return (
    <div className={`dashboard-container ${isMobile ? "mobile" : "web"}`}>
      <Sider />
      <div className="dashboard-content">
        <h1 className="dashboard-title">Admin Dashboard</h1>
        <Container>
          <Row className="info-cards-container">
            <Col xs={12} sm={6} md={4} lg={3}>
              <InfoCard title="Total Vehicles" count={dashboardData.totalVehicles} />
            </Col>
            <Col xs={12} sm={6} md={4} lg={3}>
              <InfoCard title="Total Employees" count={dashboardData.totalEmployees} />
            </Col>
            <Col xs={12} sm={6} md={4} lg={3}>
              <InfoCard title="Total Fuel Stations" count={dashboardData.totalFuelStations} />
            </Col>
            <Col xs={12} sm={6} md={4} lg={3}>
              <InfoCard title="Total Users" count={dashboardData.totalUsers} />
            </Col>
          </Row>
        </Container>
      </div>
    </div>
  );
};
// Disable scrolling
document.body.style.overflow = 'hidden';

export default Dashboard;
