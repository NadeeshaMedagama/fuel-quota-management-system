import React, { useState, useEffect } from "react";
import axios from "axios";
import Table from "../../components/Table/Table";
import SearchBar from "../../components/SearchBar/SearchBar";
import Header from "../../components/Header/Header";
import { useNavigate } from "react-router-dom";



const FuelQuota = () => {
  const [data, setData] = useState([]);
  const [filteredData, setFilteredData] = useState([]);
  const navigate = useNavigate();


  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/fuel-quotas");
        setData(response.data);
        setFilteredData(response.data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };
    fetchData();
  }, []);



  const handleSearch = (term) => {
    const filtered = data.filter(
      (item) =>
        item.fuelType.toLowerCase().includes(term.toLowerCase()) ||
        item.vehicleType.toLowerCase().includes(term.toLowerCase())
    );
    setFilteredData(filtered);
  };




  const handleAdd = () => navigate("/add-fuel-quota");
  const handleEdit = (id) => navigate(`/edit-fuel-quota/${id}`);
  const handleDelete = async (id) => {
    if (window.confirm("Are you sure?")) {
      try {
        await axios.delete(`http://localhost:8080/api/fuel-quotas/${id}`);
        setData(data.filter((item) => item.id !== id));
        setFilteredData(filteredData.filter((item) => item.id !== id));
      } catch (error) {
        console.error("Error deleting item:", error);
      }
    }
  };





  const columns = [
    { header: "Fuel Type", key: "fuelType" },
    { header: "Vehicle Type", key: "vehicleType" },
    { header: "Quota (Liters/Week)", key: "quota" },
    {
      header: "Actions",
      key: "actions",
      render: (row) => (
        <>
          <button onClick={() => handleEdit(row.id)}>Edit</button>
          <button onClick={() => handleDelete(row.id)}>Delete</button>
        </>
      ),
    },
  ];



  return (
    <div className="fuel-quota-container">
      <Header title="Quota Management" />
      <SearchBar placeholder="Search by Fuel/Vehicle Type" onSearch={handleSearch} />
      <button onClick={handleAdd} className="add-button">Add Quota</button>
      <Table data={filteredData} columns={columns} />
    </div>
  );
};



export default FuelQuota;
