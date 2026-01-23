import { Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Home from "./pages/Home";
import Questoes from "./pages/Questoes";

export default function App() {
  return (
    <>
      <Navbar />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/questoes/:materia" element={<Questoes />} />
      </Routes>
    </>
  );
}
