import './App.css'
import 'virtual:uno.css'
import {Route, Routes, useNavigate} from "react-router-dom";
import Info from "./Components/Info.jsx";
import {useState} from "react";

function App() {
    const [cat, setCat] = useState("people")
    const [id, setId] = useState("")
    const navigate = useNavigate();

    function handelSubmit() {
        navigate(`/${cat}/${id}`);
    }

    return (
        <>
            <div className={"flex items-center justify-center space-x-2xl"}>
                <label className={"text-xl font-bold"}>
                    Search for:
                    <select name="cat" id="cat" className={"ml-5 text-xl p-2 rounded-lg"}
                            onChange={(e) => setCat(e.target.value)}>
                        <option value="people">people</option>
                        <option value="planets">planets</option>
                        <option value="starships">starships</option>
                    </select>
                </label>
                <label className={"text-xl font-bold"}>
                    ID:
                    <input type="text" name="id" id="id" className={"ml-5 text-xl rounded-lg"}
                           onChange={(e) => setId(e.target.value)}/>
                </label>

                <button className={"p-5 bg-blue-6"} onClick={handelSubmit}>Search</button>
            </div>
            <Routes>
                <Route path="/:cat/:id" element={<Info/>}/>
            </Routes>
        </>
    )
}

export default App
