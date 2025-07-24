import React from 'react';
import { Link } from 'react-router-dom';

const TrainerList = ({ data }) => {
  return (
    <div>
      <h3>Trainers List</h3>
      <ul>
        {data.map((trainer) => (
          <li key={trainer.id}>
            <Link to={`/trainer/${trainer.id}`}>{trainer.name}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TrainerList;
