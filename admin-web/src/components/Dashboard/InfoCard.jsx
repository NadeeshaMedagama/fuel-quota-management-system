import React from "react";
import { Card } from "react-bootstrap";
import "./InfoCard.css";

const InfoCard = ({ title, count }) => {
  return (
    <Card className="info-card text-center">
      <Card.Body>
        <Card.Title className="info-title">{title}</Card.Title>
        <Card.Text className="info-count">{count}</Card.Text>
      </Card.Body>
    </Card>
  );
};

export default InfoCard;
