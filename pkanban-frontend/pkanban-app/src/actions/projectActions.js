//import errorReducer from "../reducers/errorReducer";
import axios from "axios";
import { GET_ERRORS, GET_PROJECT, GET_PROJECTS } from "./types";

export const createProject = (project, history) => async (dispatch) => {
  try {
    const res = await axios.post("http://localhost:8081/api/projects/", project);
    history.push("/dashboard");
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data
    });
  }
};

export const updateProject = (project, history) => async (dispatch) => {
  try {
    const res = await axios.put("http://localhost:8081/api/projects/", project);
    history.push("/dashboard");
    dispatch({
      type: GET_ERRORS,
      payload: {}
    });
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data
    });
  }
};

export const getProjects = () => async (dispatch) => {
  const res = await axios.get("http://localhost:8081/api/projects/");
  dispatch({
    type: GET_PROJECTS,
    payload: res.data
  });
};

export const getProject = (id, history) => async (dispatch) => {
  try{
    const res = await axios.get(`http://localhost:8081/api/projects/${id}`);
    dispatch({
      type: GET_PROJECT,
      payload: res.data
    });
  } catch (error){
    history.push("/dashboard");
  }
};
