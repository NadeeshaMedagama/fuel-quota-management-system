import React from "react";
import "./Button.css";

const EditButton = ({ onClick }) => {
  return (
    <button className="btn btn-primary" onClick={onClick}>
      Edit
    </button>
  );
};

export default EditButton;
