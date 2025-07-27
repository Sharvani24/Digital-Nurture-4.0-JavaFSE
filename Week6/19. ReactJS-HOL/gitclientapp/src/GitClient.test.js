import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios');

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    const dummyResponse = {
      data: [
        { name: 'reactapp' },
        { name: 'springbootapi' },
        { name: 'portfolio-site' }
      ]
    };

    axios.get.mockResolvedValue(dummyResponse);

    const gitClient = new GitClient();
    const repos = await gitClient.getRepositories('techiesyed');

    expect(repos).toEqual(['reactapp', 'springbootapi', 'portfolio-site']);
  });
});
