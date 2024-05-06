Swagger: http://localhost:8080/swagger-ui/index.html

1. POST: new user - http://localhost:8080/api/users/create
 {
    "email": "john.doe@example.com",
    "firstName": "John",
    "lastName": "Doe",
    "birthDate": "2020-01-01",
    "address": "123 Main St",
    "phoneNumber": "123-456-7890"
}

2. PUT: update user - http://localhost:8080/api/users/update/

    {
    "email": "tom.doe@gmail.com",
    "firstName": "Tom",
    "lastName": "Doe",
    "birthDate": "2020-01-01",
    "address": "123 Main St",
    "phoneNumber": "123-456-7890"
}

4. GET all users http://localhost:8080/api/users/list-all
