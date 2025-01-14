import React, { useEffect, useState } from "react";
import { Pie } from "react-chartjs-2";
import { Chart as ChartJS } from "chart.js";
import { ArcElement, Tooltip, Legend } from "chart.js";

ChartJS.register(ArcElement, Tooltip, Legend);

const MyPieChart = () => {
  const [data, setData] = useState(null); // State for chart data
  const [loading, setLoading] = useState(true); // State for loading
  const [error, setError] = useState(null); // State for errors

  useEffect(() => {
    // Fetch data from backend
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/api/chart-data"); // Replace with your backend API URL
        if (!response.ok) {
          throw new Error("Failed to fetch chart data");
        }
        const result = await response.json();

        // Transform the API response to match Chart.js format
        setData({
          labels: result.labels, // Assumes API provides "labels" array
          datasets: [
            {
              data: result.data, // Assumes API provides "data" array
              backgroundColor: ["#040480", "#2d65ff", "#51b9ff"], // Colors
              hoverBackgroundColor: ["#FF6384", "#36A2EB", "#FFCE56"],
            },
          ],
        });
        setLoading(false);
      } catch (error) {
        setError(error.message);
        setLoading(false);
      }
    };

    fetchData();
  }, []);

  const options = {
    responsive: true,
    maintainAspectRatio: false,
    layout: {
      padding: 10,
    },
    plugins: {
      legend: {
        position: "top",
        labels: {
          font: {
            size: 10,
          },
        },
      },
      tooltip: {
        bodyFont: {
          size: 10,
        },
      },
    },
  };

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;

  return (
    <div
      style={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        height: "100vh",
      }}
    >
      <div style={{ width: "300px", height: "300px" }}>
        <Pie data={data} options={options} />
      </div>
    </div>
  );
};

export default MyPieChart;
