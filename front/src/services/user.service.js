/**
 * We add a HTTP header with 
 * authHeader() when requesting
 * an authorized resource.
 */


import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/test/";

const getPublicContent = () => {
    return axios.get(API_URL + "all");
};

const getUserBoard = () => {
    return axios.get(API_URL + "user", { header: authHeader() });
};

const getAdminBoard = () => {
    return axios.get(API_URL + "admin", {headers:authHeader() });
};

export default {
    getPublicContent,
    getUserBoard,
    getAdminBoard,
};