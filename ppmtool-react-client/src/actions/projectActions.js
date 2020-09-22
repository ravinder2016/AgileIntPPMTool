import axios from 'axios';
import { GET_ERRORS } from './types';

export const createProject = (project, history) => async (dispatch) => {
  try {
    const res = axios.post(
      'http://localhost:8080//api/project/create',
      project
    );
    history.push('/dashboard');
  } catch (err) {
    console.log('error message');
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data,
    });
  }
};
