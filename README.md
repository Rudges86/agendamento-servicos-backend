# agendamento-servicos-backend
Desenvolvimento de uma api de agendamento de serviços, que possa ser utilizada para qualquer serviço desejado.
📅 Appointment Scheduler API

API REST desenvolvida em Java 17 + Spring Boot para gerenciamento de agendamentos de serviços entre clientes e profissionais, aplicando regras de negócio reais, validações e boas práticas de mercado.

O projeto simula um cenário comum de clínicas, oficinas ou prestadores de serviço, com foco em arquitetura limpa, código organizado e escalabilidade.

🚀 Funcionalidades

Cadastro de clientes, profissionais e serviços

Agendamento de serviços com controle de horários

Validação de conflitos de agenda

Cancelamento de agendamentos com regra de antecedência

Controle de status do agendamento

API documentada com Swagger

Pronto para execução via Docker

🧠 Regras de Negócio

❌ Não permite agendamentos no passado

⏰ Não permite dois agendamentos no mesmo horário para o mesmo profissional

🔒 Apenas profissionais e serviços ativos podem ser utilizados

🚫 Cancelamento permitido somente até 24h antes do horário agendado

🏗️ Arquitetura

Projeto estruturado em camadas, seguindo boas práticas do Spring:

controller
service
repository
domain
dto
exception
config


Separação clara de responsabilidades

Regras de negócio concentradas na camada de serviço

Tratamento global de exceções

Código preparado para evolução (ex: segurança, mensageria)

🧪 Testes

Testes unitários com JUnit 5 e Mockito

Foco nas regras de negócio da camada de serviço

🛠️ Tecnologias Utilizadas

Java 17

Spring Boot

Spring Web

Spring Data JPA

Spring Validation

PostgreSQL

Lombok

Springdoc OpenAPI (Swagger)

Docker & Docker Compose

JUnit 5 / Mockito

📖 Documentação da API

Após subir a aplicação, a documentação estará disponível em:

http://localhost:8080/swagger-ui.html