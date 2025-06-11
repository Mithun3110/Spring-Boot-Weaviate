# Spring Boot + Weaviate Integration

This project is a simple Spring Boot backend that lets you:

- Add an object to a Weaviate vector database via `POST /api/weaviate/add`
- Retrieve the object via `GET /api/weaviate/{id}`

It uses Weaviate's REST API and acts as a lightweight gateway around Weaviate.

---

##  Conceptual Overview

- Spring Boot acts as a REST API server on port `8081`
- Weaviate (running in Docker) is the vector database on port `8080`
- The app accepts a JSON object, sends it to Weaviate, and can retrieve it

---

## Architecture Flow

```
[Postman] → [Spring Boot Controller] → [WeaviateService] → [Weaviate REST API]
```

---

## Technology Stack

| Component | Purpose |
|----------|---------|
| Spring Boot | Web server + REST API |
| RestTemplate | HTTP client to talk to Weaviate |
| Jackson | JSON serialization |
| Docker | Runs Weaviate locally |
| Lombok | Reduces boilerplate |
| Postman | For API testing |
| Weaviate | Vector database |

---

## Code-Level Breakdown

### `pom.xml`

Defines dependencies:
- Spring Web
- Lombok
- Jackson Databind
- Spring Boot Devtools

---

##  Testing with Postman

### POST `/api/weaviate/add`

```json
{
  "className": "Article",
  "properties": {
    "title": "Hello",
    "content": "World"
  }
}
```

### GET `/api/weaviate/{uuid}`

Returns the object from Weaviate.

---

## Summary

| Layer | Description |
|-------|-------------|
| Controller | API endpoints |
| Service | Communicates with Weaviate |
| Model | Request structure |
| Docker | Runs Weaviate |
| Postman | Testing tool |

---
