# MS-USER - MicroServiço de Cadastro de Usuários 👤

## Visão Geral
Este projeto implementa um sistema de cadastro de usuários como um microserviço independente. Ele valida as entradas dos usuários, armazena os dados e publica eventos para outros serviços consumirem.

---

## Tecnologias Utilizadas 🛠

- **Java 21**: Recursos modernos da linguagem Java.
- **Spring Boot**: Desenvolvimento rápido de aplicações.
- **PostgreSQL**:  Banco de dados relacional confiável.
- **Bean Validation**:  Garante a validade das entradas.
- **Spring RabbitMQ**:  Publicação de mensagens para comunicação orientada a eventos.

---

## Visão Geral da Arquitetura 📊

### Responsabilidades

1. Aceitar solicitações de cadastro de usuários via endpoints REST.
2. Validar as entradas usando **Bean Validation**.
3. Persistir os dados no **PostgreSQL**.
4. Publicar uma mensagem no RabbitMQ após o cadastro bem-sucedido para envio de um email de boas vindas.

---

## Como Executar o Projeto ⚡

1. **Configurar o Ambiente**:
   - Certifique-se de que o **Java 21** está instalado.
   - Instale o **PostgreSQL** e configure as credenciais no `application.properties`.
   - Configure o **RabbitMQ** e certifique-se de que o broker está em execução.

2. **Build e Execução**:
   - Clone o repositório.
   - Construa o serviço usando Maven: `mvn clean install`.
   - Execute o serviço: `java -jar target/user-service.jar`.

3. **Testar o Serviço**:
   - Use ferramentas como Postman para enviar requisições ao endpoint `/users`.

---

## Exemplo de Endpoint 📡

### POST `/users`
Registra um novo usuário.

**Corpo da Requisição**:
```json
{
  "nome": "John Doe",
  "email": "john.doe@example.com"
}
```

**Resposta**:
```json
{
  "id":"UUID - GERADO"
  "nome": "John Doe",
  "email": "john.doe@example.com"
}
```

---

## Melhorias Futuras 🔄
- Adicionar autenticação e autorização.
- Aprimorar validações com restrições personalizadas.
- Implementação de endpoints de listagem, atualização e exclusão lógica
- Implementação de dados para recepcionar mais informações do usuário como endereço, cpf e etc.

---

## Contribuindo 🌟
Sinta-se à vontade para abrir issues e enviar pull requests. Contribuições são bem-vindas!

---

## Licença 📢
Este projeto está licenciado sob a Licença MIT. Veja `LICENSE` para mais detalhes.

---


