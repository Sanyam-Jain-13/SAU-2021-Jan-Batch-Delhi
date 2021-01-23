import React from 'react';
import Todoinput from "./Todoinput";
import "./todo.css";
import Todolist from "./Todolist";


class Todo extends React.Component{

    state = {
        todo : "",
        todos : [{todo : "Task1", marked : false}, {todo : "Task2", marked : true}],
        title : "My Tasks",
        filter : "all"
    };

    handleChanges = (event)=>{
        console.log(event.target.value);

        //use this.setState should set the state
        this.setState({todo : event.target.value}); 
    };
    addTask = () =>
    {
        const {todo,todos} = this.state;

        const newTodos = [...todos];

        if(todo !== "")
        {   
            newTodos.push({todo : todo,marked : false});
            this.setState({todos : newTodos,todo : ""});
        }
    };

    markTaskAsCompleted = (event,index) =>
    {
        const {todos} = this.state;
        const newTodos = [...todos];

        newTodos[index]={
            ...newTodos[index],
            marked : !newTodos[index].marked,
        };

        this.setState({todos : newTodos});
    }

    deleteTask = (event,index) =>
    {
        const {todos} = this.state;

        const tempArr = [...todos];

        if(index !==  -1)
        {
            tempArr.splice(index,1);
            this.setState({todos:tempArr});
        }

        else 
        {
            alert("No Item Present");
            return;
        }
    }

    duplicateTask = (event,index) =>
    {
        const {todos} = this.state;
        const newTodos = [...todos];

        if(index !== -1)
        {
            newTodos.push({todo : todos[index].todo,marked : false});
            this.setState({todos : newTodos});
        }

        else
        {
            alert("Duplicate task unsuccessful!");
            return;
        }


    }

    filterTasks = (filterTask) =>
    {
        this.setState({filter : filterTask});
    }
    render()
    {   
        const hstyle = 
        {
            fontFamily : "roboto",
            fontWeight : "bold"
        }

        const btnStyle = 
        {
            boxShadow : "2px 2px 5px grey",
            background : "silver"
        }

        return(
            <div className = "TodoContain">
            
                <h1 class="col-md-3 mx-auto text-center " style = {hstyle}>Todo-Task <i class="fa fa-th-list" aria-hidden="true"></i></h1>
                <div class="d-flex flex-row justify-content-around my-4"> 
                    <button class="btn col-md-3" style = {btnStyle} onClick = {() => this.filterTasks("completed")}>Completed</button>
                    <button class="btn col-md-3" style = {btnStyle} onClick = {() => this.filterTasks("all")}>Show All</button>
                    <button class="btn col-md-3" style = {btnStyle} onClick = {() => this.filterTasks("pending")}>Pending</button>
                    
                </div>
                
                <hr></hr>
            
                <Todoinput
                    placeholder = "Enter Task"
                    value = {this.state.todo}
                    onchange = {this.handleChanges}    
                />

                <div class="">
                    <button class = "btn btn-sm bg-success my-3 bg-danger font-weight-bold col-md-4 offset-4" onClick = {this.addTask}>Add Task</button>
                </div>

                <Todolist 
                title = "My title" 
                todos = {this.state.todos}
                markTaskAsCommpleted = {this.markTaskAsCompleted}
                deleteTask = {this.deleteTask}
                duplicateTask = {this.duplicateTask}
                filter = {this.state.filter}
                /> 
            </div>
        );
    }
}

export default Todo;