// src/api/user.js
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/user';

export const registerUser = async (userData) => {
    try {
      const response = await axios.post(`${API_BASE_URL}/createUser/properties`, null, {
        params: {
          name: userData.name,
          password: userData.password,
          email: userData.email
        }
      });
      return response.data;
    } catch (error) {
      throw error.response ? error.response.data : new Error('Server error');
    }
  };
  
