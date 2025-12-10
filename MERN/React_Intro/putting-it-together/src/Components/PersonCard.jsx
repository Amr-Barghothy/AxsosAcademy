import React, {useState} from 'react';
const PersonCard = (props) => {
    const [age, setAge] = useState(props.age)

    function changeAge() {
        setAge(age+1)
    }
    return(
        <div>
            <h1>{props.name}</h1>
            <p>Age: {age}</p>
            <p>Hair Color: {props.color}</p>
            <button onClick={changeAge}>Birthday Button for {props.name}</button>
        </div>
    );
}
export default PersonCard;