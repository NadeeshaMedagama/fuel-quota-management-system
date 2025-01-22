import React from "react";
import "./Form.css";

const EditForm = ({ onSubmit, formData, handleInputChange }) => {
  return (
    <form className="form" onSubmit={onSubmit}>
      <h3>Edit Item</h3>
      <div className="form-group">
        <label htmlFor="name">Name:</label>
        <input
          type="text"
          id="name"
          name="name"
          value={formData.name || ""}
          onChange={handleInputChange}
          required
        />
      </div>
      <div className="form-group">
        <label htmlFor="description">Description:</label>
        <textarea
          id="description"
          name="description"
          value={formData.description || ""}
          onChange={handleInputChange}
          required
        />
      </div>
      <button type="submit">Edit</button>
    </form>
  );
};

export default EditForm;
