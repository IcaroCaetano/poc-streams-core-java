# Java Streams Playground - Spring Boot + Java 21

This project is a **proof of concept (POC)** built using **Spring Boot** and **Java 21** to explore and demonstrate the capabilities of the **Java Stream API** and Java **functional interfaces** in a RESTful service.

---

## 📚 Topics Covered

### ✅ Java Stream API Basics
- **Stream creation** from collections (e.g. `List<String>`)
- **Intermediate operations**:
  - `map()` – Transform elements

📌 Example:
  
 ```java
  List<String> upper = names.stream()
    .map(String::toUpperCase)
    .toList();	
 ```
  
  - `filter()` – Filter elements based on conditions
  
  📌 Example:
  
 ```java
  List<String> startsWithA = names.stream()
    .filter(name -> name.startsWith("A"))
    .toList(); 
 ```
  
- **Terminal operations**:

Used to produce a result or side-effect. These operations trigger the execution of the stream pipeline.

  - `collect()` – Gather elements into a collection
  
  📌 Example:
  
```java
  List<String> collected = names.stream()
    .filter(n -> n.length() > 3)
    .collect(Collectors.toList());
 ```
  
  - `reduce()` – Aggregate elements
  
  📌 Example:
  
```java
  int totalLength = names.stream()
    .map(String::length)
    .reduce(0, Integer::sum);
```

### ✅ Functional Interfaces

- `Predicate<T>` – Filter elements by condition
A Predicate takes a single argument and returns true or false. Commonly used in .filter().

📌 Example:

```java
Predicate<String> startsWithL = s -> s.startsWith("L");
List<String> names = List.of("Liam", "Oliver", "Emma", "Lucas");
names.stream().filter(startsWithL).forEach(System.out::println);
// Output: Liam, Lucas

```

- `Supplier<T>` – Lazily generate values (e.g. UUID)
A Supplier returns a value without any input. Often used to generate new values.

📌 Example:

```java
Supplier<String> uuidSupplier = () -> UUID.randomUUID().toString();
System.out.println(uuidSupplier.get());
// Output: something like "c2a83d90-6b4e-4b9e-93a0-65bd229df53d"

```

- `Consumer<T>` – Apply an action to each element
A Consumer accepts a single input and performs an operation, without returning anything.

📌 Example:

```java
Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());
List<String> names = List.of("james", "john");
names.forEach(printUpper);
// Output: JAMES, JOHN

```

- `UnaryOperator<T>` – Modify a single input (e.g. double a number)
A UnaryOperator modifies a value and returns the result of the same type.

📌 Example:

```java
UnaryOperator<Integer> doubleIt = x -> x * 2;
System.out.println(doubleIt.apply(5)); 
// Output: 10

```

- `BinaryOperator<T>` – Combine two inputs (e.g. sum list)
A BinaryOperator combines two values of the same type into one.

📌 Example:

```java
BinaryOperator<Integer> sum = (a, b) -> a + b;
List<Integer> numbers = List.of(1, 2, 3);
int result = numbers.stream().reduce(0, sum);
System.out.println(result);
// Output: 6

```

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
cd poc-streams-core-java

```

- 2. Run the application:

```
./gradlew bootRun
# or with Maven
./mvnw spring-boot:run

```


## 📖 References and Documentation

Here are some helpful references to learn more about Java Streams and their integration with Spring Boot:

1. **Java Stream API Official Documentation (Oracle)**  
The official documentation for Java Streams in **Java 21**.  
[Java Streams - Oracle Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/stream/package-summary.html)

2. **Java Streams Tutorial - Oracle**  
A step-by-step tutorial to get started with Java Streams in Java 21.  
[Java Streams Tutorial - Oracle](https://docs.oracle.com/en/java/javase/21/tutorial/collections/streams/index.html)

3. **Java Streams Guide - Baeldung**  
A detailed guide and examples for using Java Streams with various operations.  
[Java Streams Guide - Baeldung](https://www.baeldung.com/java-8-streams)

4. **springdoc-openapi Documentation**  
Documentation for **springdoc-openapi**, which helps generate Swagger UI for Spring applications.  
[springdoc-openapi Documentation](https://springdoc.org/)

5. **Java Streams - Stack Overflow**  
A community-driven Q&A site with solutions and examples for common Java Streams issues.  
[Java Streams - Stack Overflow](https://stackoverflow.com/questions/tagged/java-stream)

6. **Java Streams Examples - GitHub**  
Explore GitHub repositories with example projects and code related to Java Streams.  
[Java Streams Examples - GitHub](https://github.com/search?q=java+streams&type=repositories)

7. **Java 8 Stream API Documentation (Oracle)**  
Documentation for Java 8 Streams, which serves as the foundation for later versions like Java 21.  
[Java 8 Stream API Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)

---

Feel free to explore the provided resources and deepen your understanding of Java Streams in this Spring Boot project!


