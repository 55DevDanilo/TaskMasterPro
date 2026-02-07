package entities;

public class Organizador {

	private String nome;
	private String email;
	private String telefone = null;

	public Organizador(String nome, String email) {
		this.nome = nome;
		this.email = email;
		validar();
	}

	public Organizador(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;

		validar();
	}

	public String getNome() {
		return nome;
	}



	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}


	public void validar() {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Nome não pode ser vazio");
		}
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("Email não pode ser vazio");
		}
		if (!email.contains("@")) {
			throw new IllegalArgumentException("Email inválido");
		}

		if (this.telefone != null) {
			if (telefone.isBlank()) {
				throw new IllegalArgumentException("Número de telefone inválido");
			}
		}
	}

	@Override
	public String toString() {
		return "Organizador [nome=" + nome + ", email=" + email + ", telefone=" + telefone + "]";
	}

}
