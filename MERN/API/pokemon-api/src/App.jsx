import './App.css'
import {useEffect, useState} from "react";

function App() {
    const [pok, setPok] = useState([])
    const [clicked, setClicked] = useState(false)

        useEffect( () => {
         fetch("https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0").then((res) => res.json()).then((res=> {
             const data = [...res.results]
             console.log(data)
             setPok(data)
         }))
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
                            <li className={'list-disc text-2xl list-inside'} key={index}>{item.name}</li>
                        ))
                    )}
                </ul>
            </div>
        </>
    )
}

export default App
