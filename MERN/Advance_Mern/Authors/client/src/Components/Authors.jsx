import React, {useEffect} from 'react';
import {Link} from "react-router-dom";
import axios from "axios";
import {setAuthors} from "../store/redux/authorSlice.jsx";
import {useDispatch, useSelector} from "react-redux";

const Authors = () => {
    const authors = useSelector(state => state.author.authors);
    const dispatch = useDispatch();
    async function handleDelete(id) {
        console.log(id)
        try {
            await axios.delete("http://localhost:8000/api/author/" + id)
            fetchAllAuthors();
        } catch (error) {
            console.log(error)
        }
    }

    const fetchAllAuthors=async () => {
        const res = await axios.get("http://localhost:8000/api/author")
        dispatch(setAuthors(res.data))
        try {
        } catch (error) {
            console.log(error)
        }
    }

    useEffect(() => {
        fetchAllAuthors();
    }, []);
    return (
        <div className={"w-50/100 mx-auto"}>
                <table className={""}>
                    <thead>
                        <tr>
                            <th className={"text-xl"}>Author</th>
                            <th className={"text-xl"}>Action Available</th>
                        </tr>
                    </thead>
                    <tbody>
                        {authors && authors.map((author,idx) => (
                            <tr key={author._id}>
                                <td className={"text-xl"}>{author.name}</td>
                                <td>
                                    <Link state={{id: author._id}} to={"/authors/" + idx}>Edit</Link>
                                </td>
                                <td>
                                    <button onClick={() => handleDelete(author._id)} className={"p-3 text-xl"}>Delete</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
        </div>
    );
};

export default Authors;