import { BrowserRouter, Routes, Route } from "react-router-dom";

import { Consultation } from "./views/Consultation";
import { EditUser } from "./views/user/Edit";
import { RegisterUser } from "./views/user/RegisterUser";
import { ListUser } from './views/user/List';
import { ListDoctors } from './views/ListDoctors';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="user/register" element={<RegisterUser />} />
        <Route path="user/list" element={<ListUser />} />
        <Route path="/list-medical" element={<ListDoctors />} />
        <Route path="/consultation" element={<Consultation />}>
          <Route path=":consultationId" element={<Consultation />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
