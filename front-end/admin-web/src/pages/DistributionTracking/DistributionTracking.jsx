import React, { useEffect, useState } from "react";
import axios from "axios";
import Header from "../../components/Header/Header";
import SearchBar from "../../components/SearchBar/SearchBar";
import Table from "../../components/Table/Table";

const DistributionTracking = () => {
  const [records, setRecords] = useState([]);
  const [filteredRecords, setFilteredRecords] = useState([]);


  useEffect(() => {
    const fetchDistributionData = async () => {
      try {
        const response = await axios.get("http://localhost:8080/distributions");
        setRecords(response.data);
        setFilteredRecords(response.data); // Initialize filtered records
      } catch (error) {
        console.error("Error fetching distribution data:", error);
      }
    };

    fetchDistributionData();
  }, []);

  // Search functionality
  const handleSearch = (searchTerm) => {
    const lowercasedTerm = searchTerm.toLowerCase();
    const filtered = records.filter((record) =>
      record.vehicleRegisterNumber.toLowerCase().includes(lowercasedTerm)
    );
    setFilteredRecords(filtered);
  };

  // Columns for the table
  const columns = [
    { header: "Vehicle Register Number", key: "vehicleRegisterNumber" },
    { header: "Amount Pumped (L)", key: "amountPumped" },
    { header: "Time", key: "time" },
    { header: "Fuel Station", key: "fuelStation" },
  ];

  return (
    <div>
      <Header title="Distribution Tracking" />
      <SearchBar
        placeholder="Search by Vehicle Register Number"
        onSearch={handleSearch}
      />
      <Table
        data={filteredRecords}
        columns={columns}
      />
    </div>
  );
};

export default DistributionTracking;
