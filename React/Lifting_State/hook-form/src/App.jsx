import './App.css'
import InputField from "./Components/InputField.jsx";
import {useState} from "react";
import Data from "./Components/Data.jsx";

function App() {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    return (
        <>
            <div className={"flex flex-col items-center"}>
                <InputField label="First Name" type={"text"} set={setFirstName}/>
                <InputField label="Last Name" type={"text"} set={setLastName}/>
                <InputField label="Email" type={"email"} set={setEmail}/>
                <InputField label="Password" type={"password"} set={setPassword}/>
                <InputField label="Confirm Password" type={"password"} set={setConfirmPassword}/>
                <h2>Your Form Data</h2>
                <Data label={"First Name"} get={firstName}/>
                <Data label={"Last Name"} get={lastName}/>
                <Data label={"Email"} get={email}/>
                <Data label={"Password"} get={password}/>
                <Data label={"Confirm Password"} get={confirmPassword}/>
            </div>
            <div className={"mx-auto"}>

            </div>
        </>
    )
}

export default App
