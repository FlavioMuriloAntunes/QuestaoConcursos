import { Link } from "react-router-dom";

export default function Navbar() {
  return (
    <nav style={styles.nav}>
      <h2 style={styles.logo}>QuestCNC</h2>

      <div style={styles.links}>
        <Link to="/">Início</Link>
        <Link to="/questoes/matematica">Matemática</Link>
        <Link to="/questoes/portugues">Português</Link>
        <Link to="/questoes/informatica">Informática</Link>
        <Link to="/questoes/direito">Direito</Link>
      </div>
    </nav>
  );
}

const styles = {
  nav: {
    height: "60px",
    backgroundColor: "#1e293b",
    color: "#fff",
    display: "flex",
    alignItems: "center",
    justifyContent: "space-between",
    padding: "0 30px"
  },
  logo: {
    margin: 0
  },
  links: {
    display: "flex",
    gap: "20px"
  }
};
