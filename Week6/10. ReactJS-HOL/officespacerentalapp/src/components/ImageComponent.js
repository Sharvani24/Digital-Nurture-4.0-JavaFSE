import React from 'react';

const ImageComponent = () => {
  return (
    <div>
      <img
        src={`${process.env.PUBLIC_URL}/office.jpg`}
        alt="Office Space"
        style={{ width: '400px', height: 'auto' }}
      />
    </div>
  );
};

export default ImageComponent;
