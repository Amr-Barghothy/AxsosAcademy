import { createSlice } from "@reduxjs/toolkit";

export const authorSlice = createSlice({
    name: "author",
    initialState: {
        authors: [],
    },
    reducers: {
        addAuthor: (state, action) => {
            state.authors.push(action.payload);
        },
        setAuthors: (state, action) => {
            state.authors = action.payload;
        },
        removeAuthor: (state, action) => {
            state.authors = state.authors.filter(
                (author) => author._id !== action.payload
            );
        },
        updateAuthor: (state, action) => {
            const updated = action.payload;
            const index = state.authors.findIndex(
                (a) => a._id === updated._id
            );
            if (index !== -1) {
                state.authors[index] = updated;
            }
        },

    },
});

export const { addAuthor, setAuthors ,updateAuthor} = authorSlice.actions;
export default authorSlice.reducer;
