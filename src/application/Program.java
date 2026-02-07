package application;

import java.time.LocalDateTime;

import entities.Evento;
import entities.Local;
import entities.Organizador;
import entities.Participante;
import enums.ModalidadeEvento;
import enums.StatusEvento;
import enums.TipoEvento;
import enums.TiposIngresso;

public class Program {

    public static void main(String[] args) {

        // Criando objetos necessários
        Organizador org = new Organizador("Carlos Almeida", "carlos@eventos.com");
        Local local = new Local("Centro de Convenções", "São Paulo", 500);

        Evento evento = new Evento(
                1, // ID por enquanto manual
                "Tech Conference",
                LocalDateTime.of(2025, 12, 10, 18, 0),
                LocalDateTime.of(2025, 12, 10, 14, 0),
                local,
                org,
                TipoEvento.CORPORATIVO,
                ModalidadeEvento.PRESENCIAL,
                StatusEvento.EM_ANDAMENTO,
                TiposIngresso.VIP
        );

        // Criando participantes
        Participante p1 = new Participante("João Silva", "joao@email.com");
        Participante p2 = new Participante("Maria Souza", "maria@email.com");

        // Adicionando participantes
        evento.adicionarParticipante(p1);
        evento.adicionarParticipante(p2);

        // Listando participantes
        evento.listaParitcipantes();

        // Removendo um participante
        evento.removerParticipante(p1);

        // Listando novamente
        evento.listaParitcipantes();

        // Exibindo informações gerais
        System.out.println(evento);
    }
}
