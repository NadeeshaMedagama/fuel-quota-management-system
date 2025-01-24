import { jsPDF } from "jspdf";

// Utility function to fetch report data from the Spring Boot backend
export const fetchReportData = async (fuelType, period) => {
  try {
    // Making an API call to fetch report data
    const response = await fetch(`/api/fuel-report?fuelType=${fuelType}&period=${period}`);
    
    if (!response.ok) {
      throw new Error("Failed to fetch report data");
    }

    // Parse the JSON response
    const data = await response.json();

    return {
      fuelType,
      period,
      data: data || [], // Default to an empty array if `data` is undefined
    };
  } catch (error) {
    console.error("Error fetching report data:", error);

    // Return a structure with empty data in case of failure
    return {
      fuelType,
      period,
      data: [],
    };
  }
};

