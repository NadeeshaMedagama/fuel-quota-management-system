import React from "react";
import { Navbar, Nav } from "react-bootstrap";
import { Link } from "react-router-dom"; // Import Link from react-router-dom
import logo from "../../assets/logo.png"; // Import your logo image
import "./Sidebar.css";

const Sider = () => {
  return (
    
    <Navbar className="sider-container web-sider" expand="lg" variant="dark">
      {/* Logo Section */}
      
      <div className="logo-container">
        <img src={logo} alt="Logo" className="sidebar-logo" />
      </div>

      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <div className="nav_block">
          <Nav className="flex-column sider-menu">
            <Nav.Item>
              <Link to="/vehicles" className="nav-link">
                Manage Vehicles
              </Link>
            </Nav.Item>
            <Nav.Item>
              <Link to="/fuel-stations" className="nav-link">
                Manage Fuel Station
              </Link>
            </Nav.Item>
           
            <Nav.Item>
              <Link to="/distribution-tracking" className="nav-link">
                Distribution
              </Link>
            </Nav.Item>
            <Nav.Item>
              <Link to="/fuel-quota" className="nav-link">
                Quota Management
              </Link>
            </Nav.Item>
            <Nav.Item>
              <Link to="/reports" className="nav-link">
                Generate Reports
              </Link>
            </Nav.Item>
          </Nav>
        </div>
      </Navbar.Collapse>
    </Navbar>
    
  );
};

export default Sider;
