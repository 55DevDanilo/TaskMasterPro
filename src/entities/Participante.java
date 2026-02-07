package entities;

import java.util.Objects;
import java.util.regex.Pattern;

public class Participante {

	private final String nome;
	private final String email;

	public Participante(String nome, String email) {
		this.nome = nome;
		this.email = email;
		validar();
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public void validar() {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Nome não pode ser vazio");
		}
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("Email não pode ser vazio");
		}

		if (validaEmail(email) != true) {
			throw new IllegalArgumentException("Email inválido");
		}

	}

	public static boolean validaEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		String emailVerificar = email;
		return Pattern.compile(emailRegex).matcher(emailVerificar).matches();
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participante other = (Participante) obj;
		return Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return "Participante [nome=" + nome + ", email=" + email + "]";
	}

}
