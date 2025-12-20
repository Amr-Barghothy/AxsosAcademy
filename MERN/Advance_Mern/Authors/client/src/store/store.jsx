import {configureStore} from "@reduxjs/toolkit";
import authorReducer from "./redux/authorSlice.jsx";

export default configureStore( {
    reducer: {
        author: authorReducer,
    }
})