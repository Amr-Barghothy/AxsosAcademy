import React from 'react';
import {useNavigate} from "react-router-dom";
import axios from "axios";
import {useDispatch} from "react-redux";
import {addAuthor, updateAuthor} from "../store/redux/authorSlice.jsx";

const Button = ({type, text, name, id}) => {
    const navigate = useNavigate();
    const dispatch = useDispatch();

    function handleCancel() {
        navigate("/authors")
    }

    async function handleSubmit() {
        if (!id) {
            try {
                const res = await axios.post("http://localhost:8000/api/author", {name: name})
                const data = res.data
                dispatch(addAuthor(data))
            } catch (error) {
                console.log(error)
            }
        } else {
            try {
                const res = await axios.patch(`http://localhost:8000/api/author/${id}`, {name: name})
                const data = res.data
                dispatch(updateAuthor(data))
            } catch (e) {
                console.log(e)
            }
        }
        navigate("/authors")
    }

    return (
        <button type={type} className={"bg-blue-4 text-white border-none p-3 rounded-lg text-xl"}
                onClick={type === "reset" ? handleCancel : handleSubmit}>{text}</button>
    );
};

export default Button;