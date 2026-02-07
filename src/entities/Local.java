package entities;

public class Local {

	private final String nome;
	private final String cidade;
	private final int capacidade;

	public Local(String nome, String cidade, int capacidade) {
		this.nome = nome;
		this.cidade = cidade;
		this.capacidade = capacidade;
		validar();
	}

	public void validar() {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Nome não pode ser vazio");
		}
		if (cidade == null || cidade.isBlank()) {
			throw new IllegalArgumentException("Cidade não pode ser vazio");
		}

		if (capacidade<=0) {
			throw new IllegalArgumentException("Capacidade inválida");
		}

	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public int getCapacidade() {
		return capacidade;
	}

	@Override
	public String toString() {
		return "Local [nome=" + nome + ", cidade=" + cidade + ", capacidade=" + capacidade + "]";
	}
	
	
	

}
