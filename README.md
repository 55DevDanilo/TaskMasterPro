# 📅 TaskMaster Pro - Sistema de Gerenciamento de Eventos – Projeto de Estudos

Este projeto implementa um pequeno sistema orientado a objetos para **gerenciar eventos**, **controlar participantes** e aplicar **regras de negócio reais**, utilizando **Java** como linguagem principal.

O foco do projeto foi aprender e aplicar:
- Encapsulamento  
- Enumeração (Status de Evento)  
- Validações de domínio  
- Regras de negócio baseadas em datas  
- Coleções  
- Estruturação de métodos e boas práticas  

---

## 🎯 Objetivo do Projeto
Criar uma classe `Evento` capaz de:
- Adicionar participantes  
- Remover participantes (seguindo regras específicas)  
- Impedir ações dependendo do status do evento  
- Validar datas e impedir ações depois que o evento já começou  
- Manter um estado coerente do objeto  

Além disso, construímos uma classe **main** inicial para simular o uso do sistema.

---

## 🧠 O que foi aprendido neste projeto
### ✔ Regras de negócio aplicadas corretamente
Implementamos condições como:
- ❌ Não permitir remover participante inexistente  
- ❌ Não permitir remover após o início do evento  
- ❌ Não permitir operações se o evento estiver **CANCELADO** ou **CONCLUÍDO**

### ✔ Boas práticas aplicadas
- Uso de `IllegalArgumentException` para manter integridade  
- Validações de entrada  
- Organização dos métodos  
- Clareza na lógica

### ✔ Enumeração
Criamos um `enum StatusEvento` representando o ciclo de vida de um evento:
- PENDENTE  
- EM_ANDAMENTO  
- CONCLUIDO  
- CANCELADO  

### ✔ Validação de datas
Uso de `LocalDateTime.now().isAfter(dataInicio)` para controlar ações com base no tempo real.

---

## 🛠 Tecnologias Utilizadas
- **Java 17+**
- **Collections API**
- **LocalDateTime**
- **Enum**
- **Scanner (em algumas versões do main)**

---

## 🤝 Como o ChatGPT ajudou neste projeto
O ChatGPT atuou como **orientador técnico**, ajudando principalmente em:

### 📌 Correções de lógica
Apontou inconsistências como:
- Mensagens de erro equivocadas  
- Condições invertidas  
- Remoção de participante quando ele não estava na lista  
- Ajuste correto das verificações de status  

### 📌 Explicação de conceitos
Ajudou a entender:
- Por que validar `p == null`  
- Por que validar `contains` antes de remover  
- Diferença entre estados do evento  
- Motivos para exceções  
- Uso correto de enums  

### 📌 Direcionamento sem entregar código
Quando solicitado, a assistência foi apenas conceitual, permitindo que o aprendiz desenvolvesse o código sozinho — prática essencial para evolução.

---
## 📘 Estrutura do Projeto
src/
└── model/
├── Evento.java
├── Participante.java
└── StatusEvento.java
└── application/
└── Main.java


---

## 🚀 Próximos Passos Sugeridos
- Criar classes de serviço (`EventoService`)  
- Persistência simulada com listas ou arquivos  
- Converter para arquitetura MVC  
- Criar testes unitários com JUnit  
- Evoluir para uma API REST usando Spring Boot  

---

## 🧑‍💻 Sobre o Autor
Projeto desenvolvido por **Lima Lima (aprendiz)** como parte de seus estudos em Java e orientação a objetos.

---

## 🤝 Agradecimento Especial
Este projeto foi desenvolvido com apoio do **ChatGPT**, atuando como mentor técnico, auxiliando na lógica, validações e boas práticas, sem substituir o aprendizado prático e sem fornecer código quando isso faria o aluno aprender menos.

