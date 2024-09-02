

# Projeto MS-Proposta

Este projeto é uma aplicação Spring Boot que gerencia propostas de crédito e usuários associados. Abaixo estão as informações sobre as dependências utilizadas e o propósito do projeto.

## Dependências

O projeto utiliza as seguintes dependências:

- **Spring Boot**: Framework principal para construção da aplicação.
- **Spring Data JPA**: Para persistência de dados e interação com o banco de dados.
- **Jakarta Persistence**: Para a implementação das entidades JPA.
- **Jakarta Validation**: Para validação dos dados nas entidades.
- **Lombok**: Para simplificar o código das entidades com anotações como `@Getter`, `@Setter`, e `@EqualsAndHashCode`.

## Estrutura do Projeto

### User

#### Representa um usuário do sistema.

- **id**: Identificador único do usuário (auto-gerado).
- **nome**: Nome do usuário.
- **sobrenome**: Sobrenome do usuário.
- **cpf**: CPF do usuário (único).
- **telefone**: Telefone do usuário.
- **renda**: Renda do usuário.


### Proposta

#### Representa uma proposta de crédito.

- **id**: Identificador único da proposta (auto-gerado).
- **solicitado**: Valor solicitado na proposta.
- **meses**: Número de meses para pagamento.
- **validacao**: Booleano que indica se a proposta foi validada.
- **user**: Relacionamento Many-to-One com a entidade `User`.

## Integrantes

-  Luis Gustavo Marques Martins **94577**
-  Gabriel Dario **95946**