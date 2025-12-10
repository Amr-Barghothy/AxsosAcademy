import './App.css'
import {useState} from "react";
import Box from "./Components/Box.jsx";

function App() {
    const [color, setColor] = useState("")
    const [hw, setHw] = useState(0)
    const [boxes, setBoxes] = useState([]);
    function handleAddColor() {
        setBoxes([...boxes, { color, hw }]);

    }


    return (
        <>
            <div className={"flex space-x-4 justify-center items-center mt-10"}>
                <label className={"text-3xl"}>Color</label>
                <input type="text" name="color" id="color" className={"bg-gray-200 text-3xl p-2 rounded-xl"} onChange={(e) => setColor(e.target.value)} />
                <input type="num" name="color" id="color" className={"bg-gray-200 text-3xl p-2 rounded-xl"} onChange={(e) => setHw(Number(e.target.value))}/>
                <button onClick={handleAddColor} className={"text-3xl border-1 border-gray-400 rounded-xl p-3 cursor-pointer"}>Add</button>
            </div>
            <div className="flex flex-wrap gap-4 justify-center mt-10 ">
                {boxes.map((box,index) => (
                    <Box key={index}  color={box.color} hw={box.hw} />
                ))}
            </div>
        </>
    )
}

export default App
