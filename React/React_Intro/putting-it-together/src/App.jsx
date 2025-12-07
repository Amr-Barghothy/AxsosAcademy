import './App.css'
import PersonCard from "./Components/PersonCard.jsx";

function App() {

    return (
        <>
            <PersonCard name = "Amr" age={22} color={"Brown"}/>
            <PersonCard name = "Khaled" age={22} color={"Black"}/>
            <PersonCard name = "Anas" age={19} color={"Black"}/>
            <PersonCard name = "Amr Foqaha" age={25} color={"Black"}/>
        </>
    )
}

export default App
