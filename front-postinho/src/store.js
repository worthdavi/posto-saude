import { configureStore } from '@reduxjs/toolkit';
import changeModalReducer from './features/modalEdit/chengeModal';

export const store = configureStore({
  reducer: {
    modal: changeModalReducer,
  },
})