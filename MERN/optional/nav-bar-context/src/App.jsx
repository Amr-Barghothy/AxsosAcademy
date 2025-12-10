import './App.css'
import Form from "./Components/Form.jsx";
import {useState} from "react";
import MyContext from "./Contexts/MyContext.jsx";
import NavBar from "./Components/NavBar.jsx";

function App() {
    const [name, setName] = useState("khaled")
    return (
        <>
            <MyContext.Provider value={{name,setName}} className={"flex flex-col items-center justify-center"}>
                <NavBar/>
                <Form/>
            </MyContext.Provider>
        </>
    )
}

export default App
