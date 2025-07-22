import React, { Component } from 'react';

// Post class (used to create structured post objects)
class Post {
  constructor(id, title, body) {
    this.id = id;
    this.title = title;
    this.body = body;
  }
}

// Posts component
class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  // Fetch data from API and store in state
  loadPosts = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        const postList = data.map(
          item => new Post(item.userId, item.id, item.title, item.body)
        );
        this.setState({ posts: postList });
      })
      .catch(error => {
        console.error('Error fetching posts:', error);
        this.setState({ hasError: true });
      });
  };

  // Load posts after component mounts
  componentDidMount() {
    this.loadPosts();
  }

  // Catch and display errors
  componentDidCatch(error, info) {
    alert('Something went wrong!');
    console.error('Caught error:', error, info);
    this.setState({ hasError: true });
  }

  // Render post titles and content
  render() {
    return (
      <div>
        <h1>Posts</h1>
        {this.state.posts.map(post => (
          <div key={post.id}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
            <hr />
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
