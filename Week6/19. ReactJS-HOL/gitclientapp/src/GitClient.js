import axios from 'axios';

class GitClient {
  async getRepositories(userName) {
    const response = await axios.get(`https://api.github.com/users/${userName}/repos`);
    return response.data.map(repo => repo.name);
  }
}

export default GitClient;
