package com.databases.tests.app.controller;

import com.databases.tests.app.generator.SchemaValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schema/validation")
@RequiredArgsConstructor
public class SchemaValidationController {

    private final SchemaValidationService schemaValidationService;

    @GetMapping("/allValid")
    public void generateAllValidData() {
        schemaValidationService.allValidData();
    }

    @GetMapping("/halfWrongData")
    public void generateHalfWrongData() {
        schemaValidationService.halfWrongData();
    }

    @GetMapping("/allWrongData")
    public void generateAllWrongData() {
        schemaValidationService.allWrongData();
    }

    @GetMapping("/halfInvalidData")
    public void generateHalfInvalidData() {
        schemaValidationService.halfInvalidData();
    }

    @GetMapping("/allInvalidData")
    public void generateAllInvalidData() {
        schemaValidationService.allInvalidData();
    }
}
