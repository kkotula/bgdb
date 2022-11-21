package io.armory.bgdb;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    UUID save(CustomerDTO dto) {
        var customer = Customer.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .street(dto.getStreet())
                .city(dto.getCity())
                .postalCode(dto.getPostalCode())
                .buildingNo(dto.getBuildingNo())
                .apartmentNo(dto.getApartmentNo())
                .build();
        customerRepository.save(customer);

        return customer.getId();
    }

    CustomerDTO findById(UUID id) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Failed to find a customer with id: " + id));

        return CustomerDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .street(customer.getStreet())
                .city(customer.getCity())
                .postalCode(customer.getPostalCode())
                .buildingNo(customer.getBuildingNo())
                .apartmentNo(customer.getApartmentNo())
                .build();
    }
}
