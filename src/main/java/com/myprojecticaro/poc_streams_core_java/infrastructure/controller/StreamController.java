package com.myprojecticaro.poc_streams_core_java.infrastructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myprojecticaro.poc_streams_core_java.appllication.service.StreamService;

@RestController
@RequestMapping("/streams")
public class StreamController {

    private final StreamService service;

    public StreamController(StreamService service) {
        this.service = service;
    }

    @GetMapping("/map")
    public List<String> mapToUpper() {
        return service.mapToUpper();
    }

    @GetMapping("/filter")
    public List<String> filterByStartingLetter(@RequestParam(defaultValue = "A") String letra) {
        return service.filterByStartingLetter(letra);
    }

    @GetMapping("/predicate")
    public List<String> filterByPredicate(@RequestParam(defaultValue = "5") int length) {
        return service.filterByPredicateLengthGreaterThan(length);
    }

    @GetMapping("/supplier")
    public String generateUUID() {
        return service.generateUUID();
    }

    @GetMapping("/consumer")
    public List<String> consumeNames() {
        return service.consumeNames();
    }

    @GetMapping("/unary")
    public int applyUnaryOperator(@RequestParam(defaultValue = "10") int value) {
        return service.applyUnaryOperator(value);
    }

    @PostMapping("/binary")
    public int applyBinaryOperator(@RequestBody List<Integer> numeros) {
        return service.applyBinaryOperator(numeros);
    }
}
