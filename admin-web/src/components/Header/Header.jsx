import React from "react";
import { Button } from "react-bootstrap"; 
import "./Header.css";
import BackIcon from "../Button/BackIcon"; 

const Header = ({ title }) => {
  return (
    <div className="header d-flex align-items-center justify-content-between p-4">
      <div className="header-left d-flex align-items-center">
        <BackIcon />
      </div>
      <h1 className="header-title mb-0 text-center flex-grow-1">{title}</h1>
    </div>
  );
};

export default Header;
