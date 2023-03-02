# Register Specialties

This project is a API rest with simple CRUD implementing JAX-RS (with jersey library).

<br>

## Startup

1. Clone the repository.
    * `git clone git@github.com:felipemalli/register-specialties.git`

2. Install dependencies:
    * `mvn install`

3. Run the project:
    * `mvn spring-boot:run`

<br>

## Operations

You can use Postman to access the API in this route:
`http://localhost:8080/{route}`

### Summary

- Create a new professional: `POST /api/professional/add`

- Read all professionals:  `GET /api/professional/all`

- Update a professional: `PUT /api/professional/edit/{id}`

- Delete a professional: `PUT /api/professional/delete/{id}`


### More informations
- **GET path = "/api/professional/all"**: traz todos os registros cadastrados dos profissionais e suas especialidades. Caso não encontre nenhum registro, retorna um `404 Not Found`, com uma mensagem de erro: "*Nenhum registro foi encontrado!*";
- **POST path = "/api/professional/add"**: cadastra um novo registro no banco de dados com retorno `201 Created` e a string "*Inserido*" com id autogerado. Caso seja um `400 Bad Request`, uma mensagem "*Não é permitido inserir novos registros com ID explícito*" é exibida.
- **PUT path = "/api/professional/edit/{id}"**: edita um registro já existente na base de dados e retorna um `200 Ok` e a string "*ID [%d] atualizado*", onde o `%d` representa o ID editado. O ID do cadastro é informado manualmente na URL e, caso ele não exista, um `404 Not Found` com a mensagem "*Não é possível editar, o ID informado não existe*" é retornado;
- **DELETE path = "/api/professional/delete/{id}"**: deleta um registro já existente da base de dados, retorna um `200 Ok` e a string "*ID [%d] removido*", onde o `%d` representa o ID editado. O ID do cadastro é informado manualmente na URL e, caso ele não exista, um `404 Not Found` com a mensagem "*Não é possível deletar, o ID informado não existe*" é retornado;

The application.yml has been configured for the datasource to point to a h2 database and generating a log file in `./logs/speciality-app.log`.

Dependencies: `spring jpa`, `spring jersey`, `h2 database`;
