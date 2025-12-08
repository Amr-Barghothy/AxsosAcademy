import './App.css'
import InputField from "./Components/InputField.jsx";
import {useEffect, useState} from "react";

function App() {
    const [firstName, setFirstName] = useState("");
    const [firstErrorName, setFirstErrorName] = useState(false)
    const [lastName, setLastName] = useState("");
    const [lastNameError, setLastNameError] = useState(false)
    const [email, setEmail] = useState("");
    const [emailError, setEmailError] = useState(false)
    const [password, setPassword] = useState("");
    const [passwordError, setPasswordError] = useState(false)
    const [confirmPassword, setConfirmPassword] = useState("");
    const [confPassError, setConfPassError] = useState(false)
    const [confPassMatchError, setConfPassMatchError] = useState(false)

    useEffect(() => {
        console.log("im here")
        setFirstErrorName(firstName.length < 2 && firstName.length !== 0)
        setLastNameError(lastName.length < 2 && lastName.length !== 0)
        setEmailError(email.length < 5 && email.length !== 0)
        setPasswordError(password.length < 8 && password.length !== 0)
        setConfPassError(confirmPassword.length < 8 && confirmPassword.length !== 0)
        setConfPassMatchError(password !== confirmPassword)
    }, [firstName, lastName, email, password, confirmPassword]);
    return (
        <>
            <div className={"flex flex-col items-center"}>
                <InputField label="First Name" type={"text"} set={setFirstName}/>
                {firstErrorName && <p>First Name should be at least 2 characters</p>}
                <InputField label="Last Name" type={"text"} set={setLastName}/>
                {lastNameError && <p>Last Name Should be at least 2 characters</p>}
                <InputField label="Email" type={"email"} set={setEmail}/>
                {emailError && <p>Email should be at least 5 characters</p>}
                <InputField label="Password" type={"password"} set={setPassword}/>
                {passwordError && <p>Password Should be at least 8 characters</p>}
                <InputField label="Confirm Password" type={"password"} set={setConfirmPassword}/>
                {confPassError && <p>Confirm Password Should be at least 8 characters</p>}
                {confPassMatchError && <p>Confirm Password and Password doesn't match</p>}
            </div>
            <div className={"mx-auto"}>

            </div>
        </>
    )
}

export default App
