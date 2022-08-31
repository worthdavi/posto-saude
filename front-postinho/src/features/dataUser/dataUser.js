import { createSlice } from '@reduxjs/toolkit';

const initialState = {
    data: [],
}

export const userData = createSlice({
    name: 'modal',
    initialState,

    reducers: {
        changeDataUser: (state, action) => {
            state.data = action.payload;
        }
    }
});

export  const { changeDataUser } = userData.actions;
export default userData.reducer;

