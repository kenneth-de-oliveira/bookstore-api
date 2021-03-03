**API de livraria**
========================================================================
Foi desenvolvido uma REST api, no intuito de fixar conceitos como orientação a objetos, encapsulamento, rest api entre outros assuntos abordados no curso do professor Valdir Cezar. O sistema 
cadastra uma categoria para diversos livros, atualiza e lista livros por categoria, como também deleta um livro existente. Foram implementados alguns dos recursos disponíveis
abaixo.

**Alguns dos recursos utilizados**

- Git 
- Maven 
- Spring Boot 
- MySQL
- REST 
- JPA (Hibernate) 
- Spring Data 

EXEMPLOS DE EXECUÇÃO

Listar todas as categoria e seus respectivos livros GET: http://localhost:8080/category/1

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

Listar todas as categorias GET: http://localhost:8080/category

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

Cria uma nova categoria POST: http://localhost:8080/category

```json
{
    "name": "New Category",
    "description" : "This is description"
}
```

Lista um livro específico GET: localhost:8080/book/1

```json
{
    "id": 1,
    "title": "Clean Code",
    "authorName": "Robert Martins",
    "text": "Lorem Ipsum"
}
```

Criar livro para uma determinada categoria POST: localhost:8080/book?category=1

```json
{
    "title": "New Book",
    "authorName" : "Enter name with author Name",
    "text": "this is text to Book"
}
```

Lista livros de uma determinada categoria GET: localhost:8080/book?category=1

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

Atualiza um livro existente POST: localhost:8080/book?category=1

```json
{
    "id": 9,
    "title": "Engenharia de Software: Uma Abordagem Profissional",
    "authorName": "New Author Name",
    "text": "Lorem Ipsum"
}
```


Atualiza um livro existente PUT: http://localhost:8080/category/1

```json
{
   "id": 1,
   "name": "New name",
   "description": "Livros de TI"
}
```
