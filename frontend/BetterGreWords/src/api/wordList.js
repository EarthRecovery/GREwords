import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/wordList';

export const getWordList = async () => {
    try {
      const response = await axios.get(`${API_BASE_URL}/getAll`);
      return response.data;
    } catch (error) {
      throw error.response ? error.response.data : new Error('Server error');
    }
  }