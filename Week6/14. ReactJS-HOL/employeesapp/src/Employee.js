import React from 'react';
import EmployeeCard from './EmployeeCard';

const employees = [
  { id: 1, name: 'Alice', dept: 'Developer' },
  { id: 2, name: 'Bob', dept: 'Designer' },
  { id: 3, name: 'Charlie', dept: 'Tester' }
];

const Employee = () => {
  return (
    <div>
      {employees.map(emp => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
};

export default Employee;
