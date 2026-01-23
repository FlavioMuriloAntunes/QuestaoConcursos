import { useParams } from "react-router-dom";

export default function Questoes() {
  const { materia } = useParams();

  const questoesFake = [
    {
      id: 1,
      pergunta: "O que é React?",
      alternativas: ["Framework", "Biblioteca", "Linguagem", "Banco de dados"],
      correta: 1
    },
    {
      id: 2,
      pergunta: "O que é uma API?",
      alternativas: [
        "Interface de programação",
        "Banco de dados",
        "Servidor web",
        "Framework frontend"
      ],
      correta: 0
    }
  ];

  return (
    <div style={styles.container}>
      <h2>Questões de {materia}</h2>

      {questoesFake.map((q) => (
        <div key={q.id} style={styles.card}>
          <p><strong>{q.pergunta}</strong></p>

          {q.alternativas.map((alt, index) => (
            <div key={index}>
              <input type="radio" name={`q-${q.id}`} />
              <label> {alt}</label>
            </div>
          ))}
        </div>
      ))}
    </div>
  );
}

const styles = {
  container: {
    padding: "40px"
  },
  card: {
    backgroundColor: "#f1f5f9",
    padding: "20px",
    marginBottom: "20px",
    borderRadius: "8px"
  }
};
