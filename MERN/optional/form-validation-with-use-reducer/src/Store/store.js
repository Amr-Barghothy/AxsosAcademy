import {configureStore} from "@reduxjs/toolkit";
import userReducer from "./redux/userSlice.jsx";

export default configureStore( {
    reducer: {
        user: userReducer,
    }
})