**Boostore API**
========================================================================

This project aims to simulate a digital bookstore, in which the following functionalities are challenged: list the various categories of books, search for a book, delete and update.

**Some of the resources used**
- Git 
- Maven 
- Spring Boot 
- MySQL
- REST 
- JPA (Hibernate) 
- Spring Data 

EXAMPLES OF EXECUTION

List all categories and their respective GET books: http://localhost:8080/category/1

```json
{
    "id": 3,
    "name": "Terror",
    "description": "Livros de Terror",
    "books": [
        {
            "id": 6,
            "title": "Frankenstein",
            "authorName": "Mary Shelley",
            "text": "Lorem Ipsum"
        },
        {
            "id": 7,
            "title": "Drácula",
            "authorName": "Bram Stoker",
            "text": "Lorem Ipsum"
        },
        {
            "id": 8,
            "title": "O Chamado de Cthulhu",
            "authorName": "H. P. Lovecraft",
            "text": "Lorem Ipsum"
        }
    ]
}
```
List all categories GET: http://localhost:8080/category

```json
[
    {
        "id": 1,
        "name": "Informática",
        "description": "Livros de TI"
    },
    {
        "id": 2,
        "name": "ficção cientifica",
        "description": "Livros de ficção cientifica"
    },
    {
        "id": 3,
        "name": "Terror",
        "description": "Livros de Terror"
    }
]
```
Create a new category POST: http://localhost:8080/category

```json
{
    "name": "New Category",
    "description" : "This is description"
}
```
Updates an existing book PUT: http://localhost:8080/category/1

```json
{
   "id": 1,
   "name": "New name",
   "description": "Livros de TI"
}
```
List a specific book GET: localhost:8080/book/1

```json
{
    "id": 1,
    "title": "Clean Code",
    "authorName": "Robert Martins",
    "text": "Lorem Ipsum"
}
```
Create book for a certain category POST: localhost:8080/book?category=1

```json
{
    "title": "New Book",
    "authorName" : "Enter name with author Name",
    "text": "this is text to Book"
}
```
Lists books of a specific GET category: localhost:8080/book?category=1

```json
[
    {
        "title": "Big Data: Como extrair volume, variedade, velocidade e valor da avalanche de informação cotidiana",
        "authorName": "Kenneth Cukier e Viktor Mayer-schonberer"
    },
    {
        "title": "Engenharia de Software: Uma Abordagem Profissional",
        "authorName": "Roger Pressman"
    },
    {
        "title": "Linux a Bíblia: O Mais Abrangente e Definitivo Guia Sobre Linux",
        "authorName": "Christopher Negus"
    },
    {
        "title": "New Book",
        "authorName": "Enter name with author Name"
    }
]
```
Updates an existing book POST: localhost:8080/book?category=1

```json
{
    "id": 9,
    "title": "Engenharia de Software: Uma Abordagem Profissional",
    "authorName": "New Author Name",
    "text": "Lorem Ipsum"
}
```
