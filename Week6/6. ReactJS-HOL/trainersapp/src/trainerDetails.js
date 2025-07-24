import React from 'react';
import { useParams } from 'react-router-dom';
import trainers from './trainersMock';

const TrainerDetail = () => {
  const { id } = useParams();
  const trainer = trainers.find((t) => t.id === parseInt(id));

  if (!trainer) return <p>Trainer not found.</p>;

  return (
    <div>
      <h3>Trainer Details</h3>
      <p><strong>{trainer.name} ({trainer.technology})</strong></p>
      <p>{trainer.email}</p>
      <p>{trainer.phone}</p>
      <ul>
        {trainer.skills.map((skill, index) => (
          <li key={index}>{skill}</li>
        ))}
      </ul>
    </div>
  );
};

export default TrainerDetail;
