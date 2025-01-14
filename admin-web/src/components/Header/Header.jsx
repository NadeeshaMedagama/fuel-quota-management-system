import React from "react";
import "./Header.css";

const Header = ({ title, subtitle, children }) => {
  return (
    <div className="header">
      <h1>{title}</h1>
      {subtitle && <h2>{subtitle}</h2>}
      {children && <div className="header-children">{children}</div>}
    </div>
  );
};

export default Header;
