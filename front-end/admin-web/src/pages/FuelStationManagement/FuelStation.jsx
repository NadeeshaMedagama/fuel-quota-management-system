import React, { useState, useEffect, useCallback } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Table from "../../components/Table/Table";
import SearchBar from "../../components/SearchBar/SearchBar";
import Header from "../../components/Header/Header";
import AddButton from "../../components/Button/AddButton";
import EditButton from "../../components/Button/EditButton";
import DeleteButton from "../../components/Button/DeleteButton";
const FuelStation = () => {
  const [fuelStations, setFuelStations] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const navigate = useNavigate();

  const fetchFuelStations = useCallback(async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/api/v1/fuelStation",
        {
          headers: { Accept: "application/json" },
        }
      );

      console.log("API Response:", response.data);

      if (Array.isArray(response.data)) {
        setFuelStations(
          response.data.map((station) => ({
            fuelStationId: station.fuelStationId || "N/A",
            stationName: station.fuelStationName || "N/A",
            licenseNumber: station.fuelStationRegisterId || "N/A",
            email: station.fuelStationEmail || "N/A",
          }))
        );
      } else {
        console.error("Unexpected API response format:", response.data);
        setFuelStations([]);
      }
    } catch (error) {
      console.error("Error fetching fuel stations:", error);
    }
  }, []);

  useEffect(() => {
    fetchFuelStations();
  }, [fetchFuelStations]);

  const handleSearch = (term) => {
    setSearchTerm(term.trim().toLowerCase());
  };

  const handleAdd = () => {
    navigate("/add-fuel-station");
  };

  const handleEdit = (id) => {
    navigate(`/edit-fuel-station/${id}`);
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/v1/fuelStation/${id}`);
      setFuelStations((prevStations) =>
        prevStations.filter((station) => station.fuelStationId !== id)
      );
    } catch (error) {
      console.error("Error deleting fuel station:", error);
    }
  };

  const filteredStations = fuelStations.filter((station) =>
    station.stationName.toLowerCase().includes(searchTerm)
  );

  const columns = [
    { header: "ID", key: "fuelStationId" },
    { header: "Name", key: "stationName" },
    { header: "License Number", key: "licenseNumber" },
    { header: "Email", key: "email" },
    {
      header: "Actions",
      key: "actions",
      render: (row) => (
        <>
          <EditButton onClick={() => handleEdit(row.fuelStationId)} />
          <DeleteButton onClick={() => handleDelete(row.fuelStationId)} />
        </>
      ),
    },
  ];

  return (
    <div>
      <Header title="Fuel Station Management" total={fuelStations.length} />
      <SearchBar placeholder="Search fuel stations..." onSearch={handleSearch} />
      <AddButton onClick={handleAdd} /> {/* Add button above the table */}
      <Table data={filteredStations} columns={columns} />
    </div>
  );
};

export default FuelStation;
