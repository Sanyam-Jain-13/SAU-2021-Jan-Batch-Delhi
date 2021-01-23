import React from 'react';

class TodoInput extends React.Component
{
    render()
    {   
        const {value,onchange,placeholder} = this.props; //attributes of component
        return(
            <input type = "text" class = "form-control col-md-4 text-center small mx-auto"
            placeholder = {placeholder} 
            value = {value} 
            onChange = {onchange}/>
        );
    }
}

export default TodoInput;