import React from 'react';

const blogs = [
  {
    id: 1,
    title: 'React Learning',
    author: 'Stephen Biz',
    content: 'Welcome to learning React!'
  },
  {
    id: 2,
    title: 'Installation',
    author: 'Schwezdenier',
    content: 'You can install React from npm.'
  }
];

const BlogDetails = () => {
  return (
    <div className="box">
      <h2>Blog Details</h2>
      {blogs.map(blog => (
        <div key={blog.id}>
          <h4>{blog.title}</h4>
          <strong>{blog.author}</strong>
          <p>{blog.content}</p>
        </div>
      ))}
    </div>
  );
};

export default BlogDetails;
