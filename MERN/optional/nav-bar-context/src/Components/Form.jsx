import React, {useContext} from 'react';
import MyContext from "../Contexts/MyContext.jsx";

const Form = () => {
    const holder = useContext(MyContext)
    return (
        <div>
            <label className={"flex gap-5 items-center justify-center mt-5 text-2xl"}>
                Your Name:
                <input onChange={(e) => {holder.setName(e.target.value)}} type="text" name="name" id="name" className={"bg-gray-300 rounded-lg p-1"}/>
            </label>
        </div>
    );
};

export default Form;