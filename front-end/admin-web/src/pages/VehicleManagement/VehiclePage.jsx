import React, { useEffect, useState } from "react";
import axios from "axios";
import Table from "../../components/Table/Table"; 
import Header from "../../components/Header/Header"; 
import SearchBar from "../../components/SearchBar/SearchBar"; 
import { useNavigate } from "react-router-dom"; 
import EditButton from "../../components/Button/EditButton";
import DeleteButton from "../../components/Button/DeleteButton";

const VehiclePage = () => {
  const [vehicles, setVehicles] = useState([]);
  const [filteredVehicles, setFilteredVehicles] = useState([]); // State for filtered vehicles
  const navigate = useNavigate();

 

  useEffect(() => {
    const fetchVehicles = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/v1/vehicle", {
          headers: { Accept: "application/json" },
        });

        setVehicles(response.data);
        setFilteredVehicles(response.data); // Initialize filteredVehicles
      } catch (error) {
        console.error("Error fetching vehicles:", error);
      }
    };

    fetchVehicles();
  }, []);



  // Handle delete action
  const handleDelete = async (id) => {
    const confirmed = window.confirm("Are you sure you want to delete this vehicle?");
    if (!confirmed) return;

    try {
      await axios.delete(`http://localhost:8080/api/v1/vehicle/${id}`);
      const updatedVehicles = vehicles.filter((vehicle) => vehicle.id !== id);
      setVehicles(updatedVehicles);
      setFilteredVehicles(updatedVehicles); // Update filteredVehicles after deletion
    } catch (error) {
      console.error("Error deleting vehicle:", error);
    }
  };



  // Navigate to edit page
  const handleEdit = (id) => navigate(`/vehicle/${id}`);

  const columns = [
    { header: "ID", key: "vehicleId" },
    { header: "Registration Number", key: "vehicleNumber" },
    { header: "QR Code", key: "qrCode" },
    { header: "VehicleType", key: "vehicleType" },
    {
      header: "Actions",
      key: "actions",
      render: (row) => (
        <>
          <EditButton onClick={() => handleEdit(row.id)} />
          <DeleteButton onClick={() => handleDelete(row.id)} /> </>
      ),
    },
  ];


  // Search functionality
  const handleSearch = (searchTerm) => {
    const lowercasedTerm = searchTerm.toLowerCase();
    const filtered = vehicles.filter(
      (vehicle) =>
        (vehicle.vehicleNumber?.toLowerCase().includes(lowercasedTerm) || "") ||
        (vehicle.vehicleType?.toLowerCase().includes(lowercasedTerm) || "") ||
        (vehicle.qrCode?.toLowerCase().includes(lowercasedTerm) || "")
    );
    setFilteredVehicles(filtered);
  };
  




  return (
    <div>
      <Header title="Vehicle Management" />
      <SearchBar placeholder="Search vehicles..." onSearch={handleSearch} />
      <Table data={filteredVehicles} columns={columns} />
    </div>
  );


  
};

export default VehiclePage;
