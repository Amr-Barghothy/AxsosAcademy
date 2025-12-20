import React, {useEffect, useState} from 'react';
import Button from "./Button.jsx";
import {useLocation} from "react-router-dom";
import axios from "axios";

const Form = () => {
    const [name, setName] = useState("")
    const [error, setError] = useState("")
    const location = useLocation();
    const [loading, setLoading] = useState(false);
    const id = location.state?.id ?? null ;

    useEffect(() => {
        if (!id) return;

        const fetchData = async () => {
            setLoading(true);
            try {
                const res = await axios.get(
                    `http://localhost:8000/api/author/${id}`
                );
                setName(res.data.name);
            } catch (error) {
                console.error(error);
            } finally {
                setLoading(false);
            }
        };

        fetchData();
    }, [id]);


    function handleError(e) {
        const value = e.target.value;
        if (value.length < 3 && value !== "") {
            setError("The name must be at least 3 characters long");
        } else {
            setError("");
        }
    }

    if (loading) {
        return <h1 className={"w-50/100 mx-auto"}>Loading...</h1>
    }

    return (
        <div className={"w-50/100 mx-auto border-5 flex flex-col gap-2xl"}>
            <label className={"flex flex-col gap-2xl text-xl"}>
                Name:
                <input type="text" value={name} name="name" id="name" className={"text-xl p-1 w-1/4"} onChange={(e) => {
                    setName(e.target.value)
                    handleError(e)
                }}/>
                {error && (
                    <p className={"text-red text-sm"}>{error}</p>
                )}
            </label>
            <div className={"flex space-x-lg"}>
                <Button type={"submit"} text={"Submit"} name={name} id={id}/>
                <Button type={"reset"} text={"Cancel"}/>
            </div>
        </div>
    );
};

export default Form;