import './App.css'
import InputField from "./Components/InputField.jsx";
import {useDispatch, useSelector} from "react-redux";
import {
    setEmail,
    setEmailError,
    setFirstName,
    setFirstNameError,
    setLastName,
    setLastNameError
} from "./Store/redux/userSlice.jsx";
function App() {
    const user = useSelector((state) => state.user);
    const dispatch = useDispatch();
    return (
        <>
            <InputField label={"First Name"} type={"text"} data={user.firstName}
                        setError={(e) => dispatch(setFirstNameError(e))}
                        onTextChange={(e) => dispatch(setFirstName(e))}/>
            {user.firstName.error !== null && (
                <p className={"text-red text-sm"}>{user.firstName.error}</p>
            )}
            <InputField label={"Last Name"} type={"text"} data={user.lastName}
                        setError={(e) => dispatch(setLastNameError(e))}
                        onTextChange={(e) => dispatch(setLastName(e))}/>
            {user.lastName.error !== null && (
                <p className={"text-red text-sm"}>{user.lastName.error}</p>
            )}
            <InputField label={"Email"} type={"email"} data={user.email} setError={(e)=>dispatch( setEmailError(e))}
                        onTextChange={(e) => dispatch(setEmail(e))}/>
            {user.email.error !== null && (
                <p className={"text-red text-sm"}>{user.email.error}</p>
            )}
            <button className={"bg-blue text-white p-4 rounded-md border-none"}>Submit</button>
        </>
    )
}

export default App
