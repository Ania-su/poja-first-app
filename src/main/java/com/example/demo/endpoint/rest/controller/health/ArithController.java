package com.example.demo.endpoint.rest.controller.health;

import com.example.demo.service.ArithService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ArithController {

    private final ArithService service;

    @GetMapping("/add")
    public ResponseEntity<?> add(@RequestParam(required = false) Double a, @RequestParam(required = false) Double b) {
        try{
            return ResponseEntity.ok(service.add(a, b));
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/subtract")
    public ResponseEntity<?> subtract(@RequestParam(required = false) Double a, @RequestParam(required = false) Double b) {
        try{
            return ResponseEntity.ok(service.sub(a, b));
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/multiply")
    public ResponseEntity<?> multiply(@RequestParam(required = false) Double a, @RequestParam(required = false) Double b) {
        try{
            return ResponseEntity.ok(service.multiply(a, b));
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/divide")
    public ResponseEntity<?> divide(@RequestParam(required = false) Double a, @RequestParam(required = false) Double b) {
        try{
            return ResponseEntity.ok(service.divide(a, b));
        } catch (IllegalArgumentException | ArithmeticException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
