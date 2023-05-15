import axios from 'axios';
// export function retrieveHelloWorldBean() {
//     return axios.get('http://localhost:8080/hello-world-bean')
// }

const apiClinet = axios.create(
    {
        baseURL:'http://localhost:8080' 
    }
)
// export const retrieveAllTodosForUsername = () => axios.get('http://localhost:8080/hello-world-bean') 

export const retrieveAllTodosForUsernameApi 
    = (username) => apiClinet.get(`/users/${username}/todos`)

export const deleteTodoApi 
    = (username, id) => apiClinet.delete(`/users/${username}/todos/${id}`)
export const retrieveTodoApi 
    = (username, id) => apiClinet.get(`/users/${username}/todos/${id}`)
export const updateTodoApi 
    = (username, id, todo) => apiClinet.put(`/users/${username}/todos/${id}`, todo)
export const createTodoApi
    = (username, todo) => apiClinet.post(`/users/${username}/todos`, todo)