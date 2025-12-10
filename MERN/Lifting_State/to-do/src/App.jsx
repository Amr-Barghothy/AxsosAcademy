import './App.css'
import {useState} from "react";
import CheckList from "./components/CheckList.jsx";

function App() {
    const [tasks, setTasks] = useState([])
    const [currTask, setCurrTask] = useState("")
    return (
        <>
            <div className={"flex flex-col place-content-center w-20/100 mx-auto"}>
                <input onChange={(e) => setCurrTask(e.target.value)} type="text" name="task" id="task" className={"border-2 rounded-xl p-5 bg-gray-300 mb-5"}/>
                <button className={"p-3 bg-blue-500 rounded-xl text-white w-1/2"} onClick={() => {
                    setTasks([...tasks, currTask])
                }}>Add</button>
            </div>

            {tasks && (
                tasks.map((task, index) => (
                    <CheckList key={index} taskName={task} arr={tasks} setTasks={setTasks} index={index} />
                ))
            )}

        </>
    )
}

export default App
