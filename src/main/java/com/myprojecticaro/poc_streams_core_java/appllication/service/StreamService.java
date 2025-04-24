package com.myprojecticaro.poc_streams_core_java.appllication.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * Service responsible for demonstrating the use of Java Stream API
 * and functional interfaces such as Predicate, Supplier, Consumer,
 * UnaryOperator, and BinaryOperator.
 *
 * <p>This class is used as part of a proof of concept (POC) to study Java 21 Streams.</p>
 */
@Service
public class StreamService {

    /**
     * A sample list of names used for stream operations.
     */
    private final List<String> nomes = List.of("Ana", "Bruno", "Carlos", "Amanda", "Eduardo");

    /**
     * Converts all names in the list to uppercase using the {@code map} operation.
     *
     * @return a new list containing the names in uppercase.
     */
    public List<String> mapToUpper() {
        return nomes.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    /**
     * Filters names in the list that start with the given letter.
     *
     * @param letra the initial letter to filter names by.
     * @return a list of names starting with the specified letter.
     */
    public List<String> filterByStartingLetter(String letra) {
        return nomes.stream()
                .filter(nome -> nome.startsWith(letra))
                .collect(Collectors.toList());
    }

    /**
     * Filters names using a {@link Predicate} that checks if the name length is greater than a given value.
     *
     * @param tamanho the minimum name length to be included in the list.
     * @return a list of names whose length is greater than the specified value.
     */
    public List<String> filterByPredicateLengthGreaterThan(int tamanho) {
        Predicate<String> predicate = nome -> nome.length() > tamanho;
        return nomes.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    /**
     * Generates a random UUID using a {@link Supplier}.
     *
     * @return a {@link String} representing the generated UUID.
     */
    public String generateUUID() {
        Supplier<UUID> uuidSupplier = UUID::randomUUID;
        return uuidSupplier.get().toString();
    }

    /**
     * Applies a {@link Consumer} to format and collect names into a new list.
     *
     * @return a list of names formatted with the prefix "Name: ".
     */
    public List<String> consumeNames() {
        List<String> result = new ArrayList<>();
        Consumer<String> consumer = nome -> result.add("Name: " + nome);
        nomes.forEach(consumer);
        return result;
    }

    /**
     * Applies a {@link UnaryOperator} to double the given integer value.
     *
     * @param x the value to be doubled.
     * @return the result of multiplying the input by 2.
     */
    public int applyUnaryOperator(int x) {
        UnaryOperator<Integer> doubleIt = n -> n * 2;
        return doubleIt.apply(x);
    }

    /**
     * Applies a {@link BinaryOperator} to sum a list of integers.
     *
     * @param numeros the list of integers to sum.
     * @return the total sum of the list.
     */
    public int applyBinaryOperator(List<Integer> numeros) {
        BinaryOperator<Integer> sum = Integer::sum;
        return numeros.stream().reduce(0, sum);
    }
}
