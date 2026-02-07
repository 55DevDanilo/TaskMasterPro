package entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import enums.ModalidadeEvento;
import enums.StatusEvento;
import enums.TipoEvento;
import enums.TiposIngresso;

public class Evento {

	private static int proximoId;
	private int id;
	final private String nome;
	private LocalDateTime dataFim;
	private LocalDateTime dataInicio;
	final private Local local;
	final private Organizador organizador;
	private Set<Participante> participante = new HashSet<>();
	final private TipoEvento tipoEvento;
	final private ModalidadeEvento modalidadeEvento;
	final private StatusEvento statusEvento;
	final private TiposIngresso tipoIngresso;

	public Evento(int id, String nome, LocalDateTime dataFim, LocalDateTime dataInicio, Local local,
			Organizador organizador, TipoEvento tipoEvento, ModalidadeEvento modalidadeEvento,
			StatusEvento statusEvento, TiposIngresso tipoIngresso) {

		this.id = id;
		this.nome = nome;
		this.dataFim = dataFim;
		this.dataInicio = dataInicio;
		this.local = local;
		this.organizador = organizador;
		this.tipoEvento = tipoEvento;
		this.modalidadeEvento = modalidadeEvento;
		this.statusEvento = statusEvento;
		this.tipoIngresso = tipoIngresso;
		validar();
	}

	public static int getProximoId() {
		return proximoId;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public Local getLocal() {
		return local;
	}

	public Organizador getOrganizador() {
		return organizador;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public ModalidadeEvento getModalidadeEvento() {
		return modalidadeEvento;
	}

	public StatusEvento getStatusEvento() {
		return statusEvento;
	}

	public TiposIngresso getTipoIngresso() {
		return tipoIngresso;
	}

	public void adicionarParticipante(Participante p) {
		if (p == null) {
			throw new IllegalArgumentException("Participante não pode ser nulo");
		}

		if (participante.contains(p)) {

			throw new IllegalArgumentException("Participante já inserido");

		}

		if (getStatusEvento() == StatusEvento.CONCLUIDO || getStatusEvento() == StatusEvento.CANCELADO) {
			throw new IllegalArgumentException("Evento finalizado ou cancelado");

		}

		if (LocalDateTime.now().isAfter(dataInicio)) {
			throw new IllegalArgumentException("Não é possível adicionar mais nenhum participante");

		}

		participante.add(p);
	}

	public void removerParticipante(Participante p) {
		if (p == null) {
			throw new IllegalArgumentException("Participante não  ser nulo");
		}

		if (!participante.contains(p)) {

			throw new IllegalArgumentException("Participante não está inserido");

		}

		if (getStatusEvento() == StatusEvento.CONCLUIDO || getStatusEvento() == StatusEvento.CANCELADO) {
			throw new IllegalArgumentException("Evento cancelado ou concluído");

		}

		if (LocalDateTime.now().isAfter(dataInicio)) {
			throw new IllegalArgumentException("Não é possível remover mais nenhum participante");

		}

		participante.remove(p);

	}

	public void listaParitcipantes() {
		int i = 1;
		for (Participante participantes : participante) {
			System.out.println("Participante nº" + i);
			System.out.println(participantes.getNome());
			System.out.println();
			i++;
		}
	}

	// Classe criada para validar atributos no Construtor
	public void validar() {
		final LocalDateTime now = LocalDateTime.now();
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Nome não pode ser vazio");
		}
		if (dataFim == null) {
			throw new IllegalArgumentException("Data fim não pode ser nula");
		}

		if (dataInicio == null) {
			throw new IllegalArgumentException("Data inicio não pode ser nula");
		} else {
			if (dataInicio.isBefore(now)) {
				throw new IllegalArgumentException("Data de inicio não pode ser anterior a data atual");

			} else {
				if (dataInicio.isAfter(dataFim)) {
					throw new IllegalArgumentException("Data de inicio não pode ser posterior a data de fim");

				}
			}
		}

		if (Duration.between(dataInicio, dataFim).isZero()) {
			throw new IllegalArgumentException("A diferença entre início e fim é exatamente de 0 minutos/segundos.");
		}

		if (organizador == null)

		{

			throw new IllegalArgumentException("Organizador não pode ser vazio");
		}
		if (tipoEvento == null) {
			throw new IllegalArgumentException("Tipo de evento não pode ser vazio");

		}

		if (local == null) {
			throw new IllegalArgumentException("Local do evento não pode ser vazio");

		}
		if (tipoIngresso == null) {
			throw new IllegalArgumentException("Tipo de ingresso não pode ser vazio");

		}
		if (modalidadeEvento == null) {
			throw new IllegalArgumentException("Modalidade Evento não pode ser vazio");

		}
		if (statusEvento == null) {
			throw new IllegalArgumentException("Status evento não pode ser vazio");

		}

	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nome=" + nome + ", dataFim=" + dataFim + ", dataInicio=" + dataInicio
				+ ", local=" + local + ", organizador=" + organizador + ", participante=" + participante
				+ ", tipoEvento=" + tipoEvento + ", modalidadeEvento=" + modalidadeEvento + ", statusEvento="
				+ statusEvento + ", tipoIngresso=" + tipoIngresso + "]";
	}
}