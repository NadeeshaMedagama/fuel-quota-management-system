import React from "react";
import "./Header.css";
import BackIcon from "../Button/BackIcon"; // Import the BackIcon component

const Header = ({ title }) => {
  return (
    <div className="header">
      <div className="header-left">
        <BackIcon />
      </div>
      <h1 className="header-title">{title}</h1>
    </div>
  );
};

export default Header;
