// src/api/user.js
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/favourite';

export const getFavouriteTable = async () => {
    try {
      const userId = localStorage.getItem('user');
      const response = await axios.get(`${API_BASE_URL}/getAll`, {
        params: {
          userId: userId
        }
      });
      return response;
    } catch (error) {
      throw error.response ? error.response.data : new Error('Server error');
    }
  }