import React, { useState, useEffect } from "react";
import axios from 'axios';
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

  // Filter notifications by userId
  const filteredNotifications = notifications.filter((notification) =>
    notification.userId.toString().includes(searchTerm) // Only search by User ID
  );

  const handleBack = () => {
    navigate(-1); // Go back to the previous page
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/notifications/${id}`);
      setNotifications(notifications.filter((notification) => notification.id !== id));
    } catch (error) {
      console.error("Error deleting notification:", error);
    }
  };

  // Define table columns
  const columns = [
    { header: "User ID", key: "userId" },
    { header: "Username", key: "username" },
    { header: "Message", key: "message" },
  ];

  return (
    <div className="notification-page-container">
      <Header title="Notifications" total={notifications.length} />
      <SearchBar placeholder="Search by User ID..." onSearch={handleSearch} />
      <BackButton onClick={handleBack} />

      {/* Table component to display notifications */}
      <Table
        data={filteredNotifications}
        columns={columns}
        onDelete={handleDelete} // Only pass onDelete handler
      />
    </div>
  );
};

export default Notification;