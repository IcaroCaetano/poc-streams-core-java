# Java Streams Playground - Spring Boot + Java 21

This project is a **proof of concept (POC)** built using **Spring Boot** and **Java 21** to explore and demonstrate the capabilities of the **Java Stream API** and Java **functional interfaces** in a RESTful service.

---

## 📚 Topics Covered

### ✅ Java Stream API Basics
- **Stream creation** from collections (e.g. `List<String>`)
- **Intermediate operations**:
  - `map()` – Transform elements
  - `filter()` – Filter elements based on conditions
- **Terminal operations**:
  - `collect()` – Gather elements into a collection
  - `reduce()` – Aggregate elements

### ✅ Functional Interfaces
- `Predicate<T>` – Filter elements by condition
- `Supplier<T>` – Lazily generate values (e.g. UUID)
- `Consumer<T>` – Apply an action to each element
- `UnaryOperator<T>` – Modify a single input (e.g. double a number)
- `BinaryOperator<T>` – Combine two inputs (e.g. sum list)

---

## 🔗 RESTful Endpoints

Each concept is exposed via a dedicated REST endpoint. Here's a summary:

| Method | Endpoint            | Description                           |
|--------|---------------------|---------------------------------------|
| GET    | `/streams/map`      | Convert names to uppercase            |
| GET    | `/streams/filter`   | Filter names by starting letter       |
| GET    | `/streams/predicate`| Filter names by minimum length        |
| GET    | `/streams/supplier` | Generate a UUID                       |
| GET    | `/streams/consumer` | Prepend a prefix to names             |
| GET    | `/streams/unary`    | Double a number                       |
| POST   | `/streams/binary`   | Sum a list of integers                |

---

## 📖 API Documentation (Swagger)

After starting the application, Swagger UI is available at:


It provides:

- Complete description of each endpoint
- Example requests and responses
- Parameters with descriptions and expected formats

---

## 💡 Example Requests


### GET: Convert names to uppercase
curl http://localhost:8080/streams/map

### GET: Filter names starting with S
curl http://localhost:8080/streams/filter?letter=S

### GET: Filter names by length > 5
curl http://localhost:8080/streams/predicate?length=5

### GET: Generate UUID
curl http://localhost:8080/streams/supplier

### GET: Transform names with consumer
curl http://localhost:8080/streams/consumer

### GET: Double number
curl http://localhost:8080/streams/unary?value=10

### POST: Sum list of numbers
curl -X POST http://localhost:8080/streams/binary -H "Content-Type: application/json" -d "[2, 3, 5]"

## 🛠️ Technologies Used

- Java 21

- Spring Boot 3.x

- Spring Web

- springdoc-openapi (Swagger 3)

- Gradle (or Maven)

## 🚀 Getting Started

- 1. Clone the project:

```
git clone https://github.com/IcaroCaetano/poc-streams-core-java.git
cd java-streams-playground

```

- 2. Run the application:

```
./gradlew bootRun
# or with Maven
./mvnw spring-boot:run

```


