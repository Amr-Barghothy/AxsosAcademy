import React from 'react';

const InputField = ({label, type, onTextChange, data, setError}) => {
    function handleOnChange(e) {
        const value = e.target.value;

        onTextChange(value);

        if (value.length < 5 && value !== "") {
            setError(`The ${label} should be at least 5 characters long.`);
        } else {
            setError(null);
        }
    }


    return (
        <div className={"flex flex-col items-center mb-5 w-50/100 mx-auto gap-y-4"}>
            <label htmlFor={label} className={"self-start"}>{label}</label>
            <input type={type} value={data.value} name={label} id={label}
                   className={"p-3 rounded-md border-gray-300 w-full"}
                   onChange={(e) => handleOnChange(e)}/>
        </div>
    );
};

export default InputField;