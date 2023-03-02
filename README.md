# Register Specialties

This project is a API REST with simple CRUD for handling professionals and their specialties.
It was made with Spring and implementing JAX-RS with jersey library.

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

### Endpoints Summary

- Create a new professional: `POST /api/professional/add`

- Read all professionals:  `GET /api/professional/all`

- Update a professional: `PUT /api/professional/edit/{id}`

- Delete a professional: `DELETE /api/professional/delete/{id}`


### More informations
- **GET path = "/api/professional/all"**: brings all registered records of professionals and their specialties. If it does not find any record, it returns a `404 Not Found`, with an error message: "*No record was found!*";
- **POST path = "/api/professional/add"**: registers a new record in the database with return `201 Created` and the string "*Inserido*" with autogenerated id. If it is a `400 Bad Request`, a message "*Not allowed to insert new records with explicit ID*" is displayed.
- **PUT path = "/api/professional/edit/{id}"**: edits an existing record in the database and returns a `200 Ok` and the string "*ID [%id] updated*" , where the `%id` represents the edited ID. The registration ID is entered manually in the URL and, if it does not exist, a `404 Not Found` with the message "*It is not possible to edit, the entered ID does not exist*" is returned;
- **DELETE path = "/api/professional/delete/{id}"**: deletes an existing record from the database, returns a `200 Ok` and the string "*ID [%id] removed*" , where the `%id` represents the edited ID. The registration ID is entered manually in the URL and, if it does not exist, a `404 Not Found` with the message "*It is not possible to delete, the entered ID does not exist*" is returned;

The application.yml has been configured for the datasource to point to a h2 database and generating a log file in `./logs/speciality-app.log`.

Dependencies: `spring jpa`, `spring jersey`, `h2 database`;
