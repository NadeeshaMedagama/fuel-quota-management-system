import React from "react";
import { Card } from "react-bootstrap";
import "./InfoCard.css";

const InfoCard = ({ title, count }) => {
  return (
    <Card className="info-card">
      <Card.Title className="info-title">{title}</Card.Title>
      <Card.Text className="info-count">{count}</Card.Text>
    </Card>
  );
};

export default InfoCard;
