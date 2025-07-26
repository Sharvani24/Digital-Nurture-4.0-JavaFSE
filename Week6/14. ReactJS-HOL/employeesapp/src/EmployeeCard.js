import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

const EmployeeCard = ({ employee }) => {
  const theme = useContext(ThemeContext); // Access context

  return (
    <div className={`card ${theme}`}>
      <h3>{employee.name}</h3>
      <p>Department: {employee.dept}</p>
      <button className={theme}>View Profile</button>
    </div>
  );
};

export default EmployeeCard;
