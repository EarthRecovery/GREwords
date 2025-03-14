import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/recite';

export const get10RandomWords = async (userWordProgressId) => {
    try {
      const response = await axios.get(`${API_BASE_URL}/get10RandomWords`, {
        params: {
            userWordProgressId: userWordProgressId
        }
      });
      return response;
    } catch (error) {
      throw error.response ? error.response.data : new Error('Server error');
    }
  }