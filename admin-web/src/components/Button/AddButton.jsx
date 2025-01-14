import React from "react";
import "./Button.css";

const AddButton = ({ onClick }) => {
  return (
    <button className="btn btn-success" onClick={onClick}>
      Add
    </button>
  );
};

export default AddButton;
