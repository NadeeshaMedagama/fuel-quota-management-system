import React, { useEffect, useState } from "react";
import { Pie } from "react-chartjs-2";
import { Chart as ChartJS } from "chart.js"; // Import Chart.js

// Register necessary chart types
import { ArcElement, Tooltip, Legend } from "chart.js";
ChartJS.register(ArcElement, Tooltip, Legend);

const MyPieChart = () => {
  const [data, setData] = useState({
    labels: ["Petrol", "Diesel", "Kerosene"],
    datasets: [
      {
        data: [400, 300, 200],
        backgroundColor: ["#040480", "#2d65ff", "#51b9ff"],
        hoverBackgroundColor: ["#FF6384", "#36A2EB", "#FFCE56"],
      },
    ],
  });

  // Chart options to make it responsive and control appearance
  const options = {
    responsive: true,  // Makes the chart responsive
    maintainAspectRatio: false,  // Prevents maintaining aspect ratio
    layout: {
      padding: 10,  // Reduces space around the chart
    },
    plugins: {
      legend: {
        position: "top", // Position the legend on top
        labels: {
          font: {
            size: 10, // Smaller font size for legend labels
          },
        },
      },
      tooltip: {
        bodyFont: {
          size: 10, // Smaller font size for tooltips
        },
      },
    },
  };

  return (
    <div
      style={{
        display: 'flex',
        justifyContent: 'center',  // Horizontally center the chart
        alignItems: 'center',      // Vertically center the chart
        height: '100vh', 
        alignItems:'top'  ,        // Ensure the container takes up full viewport height
      }}
    >
      <div style={{ width: '300px', height: '300px' }}> {/* Set chart size */}
        <Pie data={data} options={options} width={300} height={300} />
      </div>
    </div>
  );
};

export default MyPieChart;
