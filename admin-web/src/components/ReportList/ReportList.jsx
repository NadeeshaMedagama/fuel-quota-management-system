import React from 'react';
import { saveAs } from 'file-saver';
import { generatePDF,  } from '../components/utils/reportUtils';
import './ReportList.css';

function ReportList({ reports }) {
  const handleDownload = (report, format) => {
    if (format === 'pdf') {
      const pdfBlob = generatePDF(report);
      saveAs(pdfBlob, `${report.fuelType}_${report.period}.pdf`);
    } 
  };

  return (
    <div>
    
      {reports.map((report, index) => (
        <div key={index}>
          <p>{`Fuel Type: ${report.fuelType}, Period: ${report.period}`}</p>
          <button onClick={() => handleDownload(report, 'pdf')}>Download as PDF</button>
          
        </div>
      ))}
    </div>
  );
}

export default ReportList;
