import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Header from "../../components/Header/Header"; // Ensure this component exists
import SearchBar from "../../components/SearchBar/SearchBar"; // Ensure this component exists
import BackButton from "../../components/Button/BackIcon"; // Ensure this component exists
import Table from "../../components/Table/Table"; // Import Table component

const NotificationPage = () => {
  const [notifications, setNotifications] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const navigate = useNavigate();

  // Fetch notifications from the backend
  useEffect(() => {
    const fetchNotifications = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/notifications");
        setNotifications(response.data);
      } catch (error) {
        console.error("Error fetching notifications:", error);
      }
    };

    fetchNotifications();
  }, []);

  const handleSearch = (term) => {
    setSearchTerm(term.toLowerCase());
  };


};

export default NotificationPage;