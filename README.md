# Biblioteca API

API REST de gerenciamento de biblioteca construída com Spring Boot.

## Tecnologias

- Java 21
- Maven
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Validation
- Spring Boot DevTools

## Como executar

### Pré-requisitos

- Java 21 instalado
- Maven (ou usar o wrapper `./mvnw`)

### Execução

```bash
./mvnw spring-boot:run
```

A aplicação iniciará em:

- `http://localhost:8080`

## Endpoints

### Livros (`/api/livros`)

- `GET /api/livros` - lista todos os livros
- `GET /api/livros/{id}` - busca livro por ID
- `GET /api/livros/buscar?titulo=xxx` - busca livros por título
- `POST /api/livros` - cadastra novo livro
- `DELETE /api/livros/{id}` - remove livro por ID

#### Atualizações

- `GET /api/livros/disponiveis` - lista livros disponíveis
- `GET /api/livros/indisponiveis` - lista livros indisponíveis.
- `GET /api/livros/{id}/eprestar` - realiza o empréstimo do livro.
- `GET /api/livros/{id}/devolver` - realiza a devolução do livro.

Exemplo de JSON para `POST /api/livros`:

```json
{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "anoPublicacao": 2008,
  "isbn": "9780132350884",
  "disponivel": true
}
```

### Autores (`/api/autores`)

- `GET /api/autores` - lista todos os autores
- `GET /api/autores/{id}` - busca autor por ID
- `POST /api/autores` - cadastra novo autor
- `DELETE /api/autores/{id}` - remove autor por ID

Exemplo de JSON para `POST /api/autores`:

```json
{
  "nome": "J.R.R. Tolkien",
  "nacionalidade": "Britânico",
  "dataNascimento": "1892-01-03"
}
```

## Dados de exemplo pré-cadastrados

### Livros

1. Dom Casmurro
2. O Senhor dos Anéis
3. 1984

### Autores

1. Machado de Assis
2. George Orwell
