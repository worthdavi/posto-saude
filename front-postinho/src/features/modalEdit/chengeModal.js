import { createSlice } from '@reduxjs/toolkit';

const initialState = {
    isOpen: false,
}

export const changeModal = createSlice({
    name: 'modal',
    initialState,

    reducers: {
        changeModalRealTime: (state) => {
            state.isOpen = !state.isOpen;
        }
    }
});

export  const { changeModalRealTime } = changeModal.actions;
export default changeModal.reducer;

