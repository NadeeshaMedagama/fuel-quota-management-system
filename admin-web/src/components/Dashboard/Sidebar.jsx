import React from "react";
import { Navbar, Nav } from "react-bootstrap";
import useWindowSize from "../../Admin_Pages/Resizer"; // Import the useWindowSize hook
import "./Sider.css";

const Sider = () => {
  const { width } = useWindowSize();
  const isMobile = width <= 768; // Determine if the screen size is mobile

  return (
    <Navbar
      className={`sider-container ${isMobile ? "mobile-sider" : "web-sider"}`}
      expand={isMobile ? false : "lg"} // Expand only for larger screens
    >
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <div class="nav_block">
        <Nav className="flex-column sider-menu">
          <Nav.Link href="#">Manage Vehicles</Nav.Link>
          <Nav.Link href="#">Manage Fuel Station</Nav.Link>
          <Nav.Link href="#">Manage Distributors</Nav.Link>
          <Nav.Link href="#">Manage Users</Nav.Link>
          <Nav.Link href="#">Distribution</Nav.Link>
          <Nav.Link href="#">Quota Management</Nav.Link>
          <Nav.Link href="#">Notification</Nav.Link>
        </Nav>
        </div>
      </Navbar.Collapse>
    </Navbar>
  );
};

export default Sider;
