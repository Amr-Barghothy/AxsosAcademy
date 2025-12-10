import {useState} from 'react'
import Button from "./Components/button.jsx";
import './App.css'

function App() {
    const [page, setPage] = useState(1);
    let arr = [1, 2, 3, 4, 5];
    let arr2 = [1, 2, 3, 4, 5, 6];
    let arr3 = [1, 2, 3, 4, 5, 7];
    return (
        <>
            <div className={"flex place-content-center"}>
                <Button number={1} page={page} setPage={setPage} arr={arr}/>
                <Button number={2} page={page} setPage={setPage} arr={arr2}/>
                <Button number={3} page={page} setPage={setPage} arr={arr3}/>
            </div>
        </>
    );
}

export default App;
