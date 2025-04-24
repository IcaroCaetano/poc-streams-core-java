# Java Streams Playground - Spring Boot + Java 21

This project is a **proof of concept (POC)** built using **Spring Boot** and **Java 21** to explore and demonstrate the capabilities of the **Java Stream API** and common **functional interfaces**.

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
- `Predicate<T>` – Used to filter elements based on a condition.
- `Supplier<T>` – Used to lazily generate or supply values (e.g. UUID).
- `Consumer<T>` – Used to perform an action on each element.
- `UnaryOperator<T>` – Represents a function that takes one argument and returns a result of the same type (e.g. doubling a number).
- `BinaryOperator<T>` – Represents a function that combines two values into one (e.g. summing a list).

### ✅ RESTful Endpoints
Each functionality is exposed through a dedicated REST endpoint, allowing you to test each concept independently.

## 🛠️ Technologies Used

- **Java 21**
- **Spring Boot 3.x**
- **Maven or Gradle**
- **Spring Web**

## 🚀 How to Run

1. Clone this repository:
   ```
   git clone https://github.com/your-username/java-streams-playground.git
   cd java-streams-playground
```
   
## Run the application:
```
./gradlew bootRun
# or with Maven
./mvnw spring-boot:run
```
   