export default function Home() {
  return (
    <div style={styles.container}>
      <h1>Bem-vindo ao QuestCNC</h1>
      <p>Escolha uma matéria no menu para começar.</p>
    </div>
  );
}

const styles = {
  container: {
    padding: "40px"
  }
};
