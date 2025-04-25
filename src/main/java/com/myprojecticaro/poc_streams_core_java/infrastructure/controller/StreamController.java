package com.myprojecticaro.poc_streams_core_java.infrastructure.controller;

import com.myprojecticaro.poc_streams_core_java.appllication.service.StreamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streams")
public class StreamController {

    private final StreamService service;

    public StreamController(StreamService service) {
        this.service = service;
    }

    @Operation(
        summary = "Map names to uppercase",
        description = "Transforms all names in the internal list to uppercase using Stream's map operation."
    )
    @ApiResponse(
        responseCode = "200",
        description = "List of uppercase names",
        content = @Content(
            mediaType = "application/json",
            examples = @ExampleObject(
                name = "UpperCaseNames",
                summary = "Names transformed",
                value = "[\"EMMA\", \"WILLIAM\", \"JAMES\", \"SOPHIA\", \"LUCAS\"]"
            )
        )
    )
    @GetMapping("/map")
    public List<String> mapToUpper() {
        return service.mapToUpper();
    }

    @Operation(
        summary = "Filter names by starting letter",
        description = "Returns all names that start with the specified letter using the Stream filter method."
    )
    @ApiResponse(
        responseCode = "200",
        description = "Filtered list of names",
        content = @Content(
            mediaType = "application/json",
            examples = @ExampleObject(
                name = "NamesStartingWithS",
                summary = "Names filtered by letter S",
                value = "[\"Sophia\"]"
            )
        )
    )
    @GetMapping("/filter")
    public List<String> filterByStartingLetter(
        @Parameter(
            description = "The starting letter to filter names by",
            example = "S"
        )
        @RequestParam(defaultValue = "A") String letter
    ) {
        return service.filterByStartingLetter(letter);
    }

    @Operation(
        summary = "Filter names by length",
        description = "Filters the list of names using a Predicate that checks whether the name length is greater than a given value."
    )
    @ApiResponse(
        responseCode = "200",
        description = "Filtered list of names by length",
        content = @Content(
            mediaType = "application/json",
            examples = @ExampleObject(
                name = "NamesLongerThan5",
                summary = "Names longer than 5 characters",
                value = "[\"William\", \"Sophia\"]"
            )
        )
    )
    @GetMapping("/predicate")
    public List<String> filterByPredicate(
        @Parameter(
            description = "Minimum length of the name",
            example = "5"
        )
        @RequestParam(defaultValue = "5") int length
    ) {
        return service.filterByPredicateLengthGreaterThan(length);
    }

    @Operation(
        summary = "Generate a UUID",
        description = "Generates a random UUID using Java's Supplier functional interface."
    )
    @ApiResponse(
        responseCode = "200",
        description = "Randomly generated UUID",
        content = @Content(
            mediaType = "text/plain",
            examples = @ExampleObject(
                name = "UUIDExample",
                summary = "Generated UUID",
                value = "550e8400-e29b-41d4-a716-446655440000"
            )
        )
    )
    @GetMapping("/supplier")
    public String generateUUID() {
        return service.generateUUID();
    }

    @Operation(
        summary = "Consume and transform names",
        description = "Applies a Consumer to each name to prepend 'Name: ' to it and collect the result."
    )
    @ApiResponse(
        responseCode = "200",
        description = "List of transformed names",
        content = @Content(
            mediaType = "application/json",
            examples = @ExampleObject(
                name = "ConsumedNames",
                summary = "Formatted names",
                value = "[\"Name: Emma\", \"Name: William\", \"Name: James\", \"Name: Sophia\", \"Name: Lucas\"]"
            )
        )
    )
    @GetMapping("/consumer")
    public List<String> consumeNames() {
        return service.consumeNames();
    }

    @Operation(
        summary = "Double a number using UnaryOperator",
        description = "Uses Java's UnaryOperator to multiply a number by 2."
    )
    @ApiResponse(
        responseCode = "200",
        description = "Doubled value",
        content = @Content(
            mediaType = "application/json",
            examples = @ExampleObject(
                name = "DoubledNumber",
                summary = "UnaryOperator result",
                value = "20"
            )
        )
    )
    @GetMapping("/unary")
    public int applyUnaryOperator(
        @Parameter(
            description = "Value to double",
            example = "10"
        )
        @RequestParam(defaultValue = "10") int value
    ) {
        return service.applyUnaryOperator(value);
    }

    @Operation(
        summary = "Sum list of integers using BinaryOperator",
        description = "Receives a list of integers and returns their sum using Java's BinaryOperator with Stream.reduce()."
    )
    @ApiResponse(
        responseCode = "200",
        description = "Sum of integers",
        content = @Content(
            mediaType = "application/json",
            examples = @ExampleObject(
                name = "SumOfNumbers",
                summary = "Result of sum",
                value = "15"
            )
        )
    )
    @PostMapping("/binary")
    public int applyBinaryOperator(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "List of integers to be summed",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(
                    name = "ListOfNumbers",
                    summary = "List of numbers to sum",
                    value = "[5, 3, 7]"
                )
            )
        )
        @RequestBody List<Integer> numeros
    ) {
        return service.applyBinaryOperator(numeros);
    }
}
