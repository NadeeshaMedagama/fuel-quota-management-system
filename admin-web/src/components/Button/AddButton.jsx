import React from "react";
import "./Button.css";

const AddButton = ({ onClick }) => {
  return (
    <button className="add" onClick={onClick}>
      Add
    </button>
  );
};

export default AddButton;
