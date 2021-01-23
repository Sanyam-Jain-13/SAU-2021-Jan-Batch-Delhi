import React from 'react';
import "./Todolist.css";

class list extends React.Component
{
    render()
    {
        //const todos = ['task1','task2','task3','task4']
        const {todos,markTaskAsCommpleted,deleteTask,duplicateTask,filter} = this.props;

        //let showToDos = [...todos];
        //     if (filter === "completed") {showToDos.filter(x=> {return x.marked})};
        let showToDos = [];

        if (filter === "all")
        {
            showToDos = [...todos];
        }

        if(filter === "completed")
        {
            for(let obj of todos)
            {
                if(obj.marked) showToDos.push(obj);
            }
        }

        if(filter === "pending")
        {
            for(let obj of todos)
            {
                if(!obj.marked) showToDos.push(obj);
            }
        }
    
        console.log({filter});

        ///{filter} === "completed" ? todos.filter((x)=> {return x.marked}) : todos;

        console.log(showToDos);

        

        return(
            <ul style = {{listStyle : "square"}} class= "list-group mx-auto col-md-5">
                {showToDos ? showToDos.map(
                    (value,index)=>{
                        return <label>
                        
                        <li class="list-group-item list-group-item-action my-auto" key={index} 
                        style={{boxShadow : "2px 3px 7px silver",backgroundColor:"#f1f1f1"}}>
                    
                            <input class = "checkbox"
                            type="checkbox" 
                            checked = {value.marked}
                            onChange = {(event) => markTaskAsCommpleted(event,index)} />
                                <span class = "font-weight-bold mx-3" style={{fontFamily:"roboto",fontSize:"18px"}}>
                                    <b>{value.todo}</b> :  &nbsp; <i><small>{value.marked ? "It's Done" : "Incomplete"}</small></i>
                                </span>
                                
                            {value.marked ? <i class="fas fa-check-double"></i> : <i class="fas fa-exclamation"></i> }
                            
                            <div class = "float-right my-auto"  >

                                <button class = "btn btn-sm bg-warning mx-2" onClick={(event) => deleteTask(event,index)}>Delete  <i class="fas fa-trash-alt"></i></button>
                                <button class="btn btn-sm bg-info"  onClick={(event) => duplicateTask(event,index)}>Duplicate <i class="fas fa-copy"></i></button>
                            
                            </div>
                            <div class = "clearfix"></div>
                        
                        </li>
                    
                        </label>
                        }
                    ) : null
                }
            </ul>
        );
    }
}


export default  list;