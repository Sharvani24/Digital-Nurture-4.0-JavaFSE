import React, { useEffect, useState } from 'react';
import GitClient from './GitClient';

function App() {
  const [repos, setRepos] = useState([]);
  const gitClient = new GitClient();

  useEffect(() => {
    async function fetchData() {
      const repoNames = await gitClient.getRepositories('techiesyed');
      setRepos(repoNames);
    }
    fetchData();
  }, []);

  return (
    <div style={{ padding: '30px' }}>
      <h2>GitHub Repositories for techiesyed</h2>
      <ul>
        {repos.map((repo, index) => (
          <li key={index}>{repo}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
