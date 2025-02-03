import React, { useState, useEffect, useCallback } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Table from "../../components/Table/Table";
import SearchBar from "../../components/SearchBar/SearchBar";
import Header from "../../components/Header/Header";
import AddButton from "../../components/Button/AddButton";

const FuelStation = () => {
  const [fuelStations, setFuelStations] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const navigate = useNavigate();

  const fetchFuelStations = useCallback(async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/v1/fuelStation", {
        headers: { Accept: "application/json" },
      });

      console.log("API Response:", response.data);

      if (Array.isArray(response.data)) {
        setFuelStations(
          response.data.map((station) => ({
            fuelStationId: station.fuelStationId || "N/A",
            stationName: station.stationName || "N/A",
            location: station.location || "N/A",
            email: station.email || "N/A",
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
    { header: "Location", key: "location" },
    { header: "Email", key: "email" },
  ];

  return (
    <div>
      <Header title="Fuel Station Management" total={fuelStations.length} />
      <SearchBar placeholder="Search fuel stations..." onSearch={handleSearch} />
      <AddButton onClick={handleAdd} />
      <Table data={filteredStations} columns={columns} onEdit={handleEdit} onDelete={handleDelete} />
    </div>
  );
};

export default FuelStation;
