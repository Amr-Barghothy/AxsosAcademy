import {createSlice} from '@reduxjs/toolkit'

export const userSlice = createSlice({
    name: 'users',
    initialState: {
        firstName: {
            value: '',
            error: null,
        },
        lastName: {
            value: '',
            error: null
        },
        email: {
            value: '',
            error: null
        }
    },
    reducers: {
        setFirstName: (state, action) => {
            state.firstName.value = action.payload
        },
        setFirstNameError: (state, action) => {
            state.firstName.error = action.payload
        },
        setLastName: (state, action) => {
            state.lastName.value = action.payload
        },
        setLastNameError: (state, action) => {
            state.lastName.error = action.payload
        },
        setEmail: (state, action) => {
            state.email.value = action.payload
        },
        setEmailError: (state, action) => {
            state.email.error = action.payload
        },
    }
})

export const {
    setFirstName,
    setFirstNameError,
    setLastName,
    setLastNameError,
    setEmail,
    setEmailError
} = userSlice.actions;

export default userSlice.reducer;