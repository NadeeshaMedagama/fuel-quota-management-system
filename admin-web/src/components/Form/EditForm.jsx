import React from "react";
import { Button, Form } from "react-bootstrap"; // Import Bootstrap components
import "./Form.css";

const EditForm = ({ onSubmit, formData, handleInputChange }) => {
  return (
    <Form className="form" onSubmit={onSubmit}>
      <h3>Edit Item</h3>
      
      <Form.Group className="mb-3" controlId="name">
        <Form.Label>Name:</Form.Label>
        <Form.Control
          type="text"
          name="name"
          value={formData.name || ""}
          onChange={handleInputChange}
          required
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="description">
        <Form.Label>Description:</Form.Label>
        <Form.Control
          as="textarea"
          name="description"
          value={formData.description || ""}
          onChange={handleInputChange}
          required
        />
      </Form.Group>

      <Button variant="primary" type="submit" block>
        Edit
      </Button>
    </Form>
  );
};

export default EditForm;
