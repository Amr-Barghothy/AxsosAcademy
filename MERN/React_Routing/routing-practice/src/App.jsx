import './App.css'
import 'virtual:uno.css'
import {Routes, Route, Link} from 'react-router-dom'
import Show from "./Components/Show.jsx";
function App() {
    return (
        <>
            <Routes>
                <Route path='/:word' element={<Show />} />
                <Route path='/:word/:color1/:color2' element={<Show />} />
            </Routes>
        </>
    )
}

export default App
