import React from 'react';

const OfficeList = () => {
  const offices = [
    { id: 1, name: "Downtown Office", rent: 55000, address: "123 Main St" },
    { id: 2, name: "Uptown Office", rent: 65000, address: "456 Elm St" },
    { id: 3, name: "Suburban Office", rent: 48000, address: "789 Oak Ave" },
  ];

  return (
    <div>
      {offices.map((office) => (
        <div key={office.id} style={{ border: '1px solid #ccc', marginBottom: '10px', padding: '10px' }}>
          <h2>{office.name}</h2>
          <p>Address: {office.address}</p>
          <p style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
            Rent: ₹{office.rent}
          </p>
        </div>
      ))}
    </div>
  );
};

export default OfficeList;
