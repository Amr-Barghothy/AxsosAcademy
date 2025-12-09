import './App.css'
import {useEffect, useState} from "react";
import axios from "axios";

function App() {
    const [pok, setPok] = useState([])
    const [clicked, setClicked] = useState(false)
    useEffect(() => {
        axios.get("https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0").then((response) => {
            const names = response.data.results.map(x => x.name)
            setPok(names)
            console.log(names)
        })

    }, [clicked]);
    return (
        <>
            <div className={"flex items-center flex-col text-center"}>
                <button className={"bg-gray-300 p-3 cursor-pointer w-1/4"} onClick={() => setClicked(true)}>Fetch
                    Pokemon
                </button>
                <ul>
                    {clicked && (
                        pok.map((item, index) => (
                            <li className={'list-disc text-2xl list-inside'} key={index}>{item}</li>
                        ))
                    )}
                </ul>
            </div>
        </>
    )
}

export default App
