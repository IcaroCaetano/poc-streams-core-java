package com.myprojecticaro.poc_streams_core_java.appllication.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * Service responsible for demonstrating Java Stream API and functional interfaces.
 * <p>
 * Covered topics:
 * <ul>
 *     <li>Streams with Lists</li>
 *     <li>Streams with Arrays</li>
 *     <li>Map and Filter operations</li>
 *     <li>Predicate, Supplier, Consumer</li>
 *     <li>UnaryOperator and BinaryOperator</li>
 * </ul>
 */
@Service
public class StreamService {

    /**
     * A sample list of names used for stream operations.
     */
    private final List<String> names = List.of("Emma", "William", "James", "Sophia", "Lucas", "Scarlett", "Elizabeth", "John");

    /**
     * Converts all names in the list to uppercase using {@code map()}.
     *
     * @return a new list with all names converted to uppercase.
     */
    public List<String> mapToUpper() {
        return names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    /**
     * Filters the list of names by a starting letter using {@code filter()}.
     *
     * @param letter the initial letter to filter names.
     * @return a list of names starting with the given letter.
     */
    public List<String> filterByStartingLetter(String letter) {
        return names.stream()
                .filter(name -> name.startsWith(letter))
                .collect(Collectors.toList());
    }

    /**
     * Filters names based on a {@link Predicate} that checks the length of each name.
     *
     * @param size minimum length to include names.
     * @return a list of names whose length is greater than the specified size.
     */
    public List<String> filterByPredicateLengthGreaterThan(int size) {
        Predicate<String> predicate = name -> name.length() > size;
        return names.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    /**
     * Generates a UUID using a {@link Supplier}.
     *
     * @return a randomly generated UUID in string format.
     */
    public String generateUUID() {
        Supplier<UUID> uuidSupplier = UUID::randomUUID;
        return uuidSupplier.get().toString();
    }

    /**
     * Uses a {@link Consumer} to add formatted names into a list.
     *
     * @return a list of formatted strings using the "Name: " prefix.
     */
    public List<String> consumeNames() {
        List<String> result = new ArrayList<>();
        Consumer<String> consumer = name -> result.add("Name: " + name);
        names.forEach(consumer);
        return result;
    }

    /**
     * Applies a {@link UnaryOperator} to double the input value.
     *
     * @param x the value to double.
     * @return the doubled value.
     */
    public int applyUnaryOperator(int value) {
        UnaryOperator<Integer> doubleIt = n -> n * 2;
        return doubleIt.apply(value);
    }

    /**
     * Uses a {@link BinaryOperator} with {@code reduce()} to sum all integers in a list.
     *
     * @param numbers list of integers to sum.
     * @return the total sum.
     */
    public int applyBinaryOperator(List<Integer> numbers) {
        BinaryOperator<Integer> sum = Integer::sum;
        return numbers.stream().reduce(0, sum);
    }
}
