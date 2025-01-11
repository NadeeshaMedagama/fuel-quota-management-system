import React from "react";
import { Card } from "react-bootstrap";
import useWindowSize from "../../Admin_Pages/Resizer"; // Import the useWindowSize hook
import "./InfoCard.css";

const InfoCard = ({ title, count }) => {
  const { width } = useWindowSize();
  const isMobile = width <= 768; // Determine if the screen is mobile
 
 
  
    return (
    <Card className={`info-card ${isMobile ? "mobile-info-card" : "web-info-card"}`}>
    
        <Card.Title className="info-title">{title}</Card.Title>
        <Card.Text className="info-count">{count}</Card.Text>
      
    </Card>
  );
};

export default InfoCard;
