package io.armory.bgdb;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    CustomerDTO getById(@PathVariable UUID id) {
        return customerService.findById(id);
    }

    @PostMapping
    ResponseEntity<UUID> createCustomer(@RequestBody CustomerDTO dto) {
        return ResponseEntity.status(201).body(customerService.save(dto));
    }

}
