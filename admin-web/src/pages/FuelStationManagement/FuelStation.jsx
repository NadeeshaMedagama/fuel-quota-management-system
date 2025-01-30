import React, { useState, useEffect } from "react";
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

  useEffect(() => {
    const fetchFuelStations = async () => {
      try {
        const response = await axios.get("http://localhost:8080/fuelStations", {
          headers: { "Accept": "application/json" }, // Expect JSON response
        });


        setFuelStations(response.data);
      } catch (error) {
        console.error("Error fetching fuel stations:", error);
      }
    };

    fetchFuelStations();
  }, []);

  const handleSearch = (term) => {
    setSearchTerm(term.toLowerCase());
  };

  const handleAdd = () => {
    navigate("/add-fuel-station");
  };

  const handleEdit = (id) => {
    navigate(`/edit-fuel-station/${id}`);
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/fuelStations/${id}`);
      setFuelStations(fuelStations.filter((station) => station.id !== id));
    } catch (error) {
      console.error("Error deleting fuel station:", error);
    }
  };

  const filteredStations = fuelStations.filter((station) =>
    station.name.toLowerCase().includes(searchTerm)
  );

  const columns = [
    { header: "ID", key: "id" },
    { header: "Name", key: "name" },
    { header: "Location", key: "location" },
    { header: "Fuel Type", key: "fuelType" },
  ];

  return (
    <div>
      <Header title="Fuel Station Management" total={fuelStations.length} />
      <SearchBar placeholder="Search fuel stations..." onSearch={handleSearch} />
      <AddButton onClick={handleAdd} />
      <Table
        data={filteredStations}
        columns={columns}
        onEdit={handleEdit}
        onDelete={handleDelete}
      />
    </div>
  );
};

export default FuelStation;
