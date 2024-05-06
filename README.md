Swagger: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

1. **POST**: New User
    - Endpoint: `http://localhost:8080/api/users/create`
    - Request Body:
        ```json
        {
            "email": "john.doe@example.com",
            "firstName": "John",
            "lastName": "Doe",
            "birthDate": "2020-01-01",
            "address": "123 Main St",
            "phoneNumber": "123-456-7890"
        }
        ```

2. **PUT**: Update User
    - Endpoint: `http://localhost:8080/api/users/update/`
    - Request Body:
        ```json
        {
            "email": "tom.doe@gmail.com",
            "firstName": "Tom",
            "lastName": "Doe",
            "birthDate": "2020-01-01",
            "address": "123 Main St",
            "phoneNumber": "123-456-7890"
        }
        ```

3. **GET**: All Users
    - Endpoint: `http://localhost:8080/api/users/list-all`
  
4. **DELETE**: Delete User by ID
    - Endpoint: `http://localhost:8080/api/users/delete/{id}`
