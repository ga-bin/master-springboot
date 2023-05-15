import { deleteTodoApi, retrieveAllTodosForUsernameApi } from "./api/TodoApiService";
import { useEffect, useState } from "react";
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";

export default function ListTodosComponent() {
    const today = new Date();
    const targetDate = new Date(today.getFullYear() + 12, today.getMonth(), today.getDate());
    const [todos, setTodos] = useState([]); 
    const [message, setMessage] = useState(null);
    const authContext = useAuth(); 
    const username = authContext.username;
    const navigate = useNavigate();

    function refreshTodos() {
      retrieveAllTodosForUsernameApi(username)
        .then(response => setTodos(response.data))
        .catch(error => console.log(error));

    }
                         
    useEffect(
        () => { refreshTodos()
    }, []);

    function deleteTodo(id) {
       console.log(id);
       deleteTodoApi(username ,id) 
        .then((response) => {
            setMessage(`Delete of todo with ${id} successful`)
            refreshTodos();
        })
        .catch(error => console.log(error))
    }

    function updateTodo(id) {
        navigate(`/todo/${id}`);
    }

    function addNewTodo() {
        navigate(`/todo/-1`)
    }
    const todoList =  todos.map(
                        todo => (
                            <tr key={todo.id}>
                                <td>{todo.description}</td>
                                <td>{todo.done.toString()}</td>
                                <td>{todo.targetDate.toString()}</td>
                                <td><button className="btn btn-warning" onClick={ () => deleteTodo(todo.id)}>Delete</button></td>
                                <td><button className="btn btn-success" onClick={ () => updateTodo(todo.id)}>Update</button></td>
                            </tr>
                        )
                    );

    return (
        <div className="container">
            <h1>Things You Want To Do!</h1>
            { message && <div className="alert alert-warning">{ message }</div> }
            <div>
                <table className='table'>
                    <thead>
                        <tr>
                            <th>description</th>
                            <th>done</th>
                            <th>targetDate</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        { todoList }
                    </tbody>
                </table>
            </div>
            <div className="btn btn-primary m-5" onClick={ addNewTodo }>Add New Todo</div>
        </div>
    )
}