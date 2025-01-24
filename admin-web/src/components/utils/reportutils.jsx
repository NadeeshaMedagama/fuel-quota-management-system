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
// Utility function to generate a PDF using jsPDF
export const generatePDF = (report) => {
  const doc = new jsPDF();

  // Add header information
  doc.setFont("helvetica", "bold");
  doc.setFontSize(16);
  doc.text("Fuel Consumption Report", 10, 10);

  // Add report metadata
  doc.setFont("helvetica", "normal");
  doc.setFontSize(12);
  doc.text(`Fuel Type: ${report.fuelType}`, 10, 20);
  doc.text(`Period: ${report.period}`, 10, 30);

  // Add table headers
  const startY = 40;
  const columnSpacing = [10, 60]; // Adjust column spacing as needed
  doc.text("Date", columnSpacing[0], startY);
  doc.text("Consumption (liters)", columnSpacing[1], startY);

  // Add report data rows
  let yOffset = startY + 10; // Initial row offset
  report.data.forEach((entry, index) => {
    doc.text(`${entry.date}`, columnSpacing[0], yOffset);
    doc.text(`${entry.consumption}`, columnSpacing[1], yOffset);
    yOffset += 10;

    // Add a new page if the content overflows
    if (yOffset > 280) {
      doc.addPage();
      yOffset = 10; // Reset yOffset for the new page
    }
  });

  return doc.output("blob"); // Generate the PDF as a Blob
};


// Function to generate the report and handle file download
export const generateAndDownloadReport = async (fuelType, period) => {
    try {
      // Fetch data from the backend
      const report = await fetchReportData(fuelType, period);
  
      // Generate PDF with the fetched data
      const pdfBlob = generatePDF(report);
  
      // Trigger file download in the browser
      const url = URL.createObjectURL(pdfBlob);
      const link = document.createElement("a");
      link.href = url;
      link.download = `fuel-report-${fuelType}-${period}.pdf`;
      link.click();
  
      console.log("Report downloaded successfully.");
    } catch (error) {
      console.error("Error generating or downloading the report:", error);
      throw new Error("Failed to generate the report.");
    }
  };
  
