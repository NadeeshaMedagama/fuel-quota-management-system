// FuelConsumptionChart.jsx
import React, { useEffect, useState } from "react";
import { Pie } from "react-chartjs-2";
import { Chart as ChartJS } from "chart.js";
import { ArcElement, Tooltip, Legend } from "chart.js";
import "bootstrap/dist/css/bootstrap.min.css";

ChartJS.register(ArcElement, Tooltip, Legend);

const FuelConsumptionChart = () => {
  const [data, setData] = useState(null); // State for chart data
  const [loading, setLoading] = useState(true); // State for loading
  const [error, setError] = useState(null); // State for errors

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/api/chart-data");
        if (!response.ok) {
          throw new Error("Failed to fetch chart data");
        }
        const result = await response.json(); 

        setData({
          labels: result.labels, // Assumes API returns { labels: [], data: [] }
          datasets: [
            {
              data: result.data,
              backgroundColor: ["#040480", "#2d65ff", "#51b9ff"],
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
          font: { size: 10 },
        },
      },
      tooltip: {
        bodyFont: { size: 10 },
      },
    },
  };

  if (loading) return <div className="text-center">Loading...</div>;
  if (error) return <div className="text-center text-danger">Error: {error}</div>;

  return (
    <div className="container d-flex justify-content-center align-items-center vh-100">
      <div className="col-12 col-sm-8 col-md-6 col-lg-4">
        <div className="card shadow-sm">
          <div className="card-body">
            
            <div className="chart-container" style={{ position: "relative", height: "300px" }}>
              <Pie data={data} options={options} />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default FuelConsumptionChart;
