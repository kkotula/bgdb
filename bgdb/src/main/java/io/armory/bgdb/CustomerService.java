package io.armory.bgdb;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    UUID save(CustomerDTO dto) {
        var customer = new Customer(dto.getFirstName(), dto.getLastName());

        customer.addAddress(
                Address.builder()
                        .customer(customer)
                        .street(dto.getStreet())
                        .city(dto.getCity())
                        .postalCode(dto.getPostalCode())
                        .buildingNo(dto.getBuildingNo())
                        .apartmentNo(dto.getApartmentNo())
                        .build()
        );

        customerRepository.save(customer);

        return customer.getId();
    }

    CustomerDTO findById(UUID id) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Failed to find a customer with id: " + id));

        var address = customer.getAddresses().get(0);

        return CustomerDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .street(address.getStreet())
                .city(address.getCity())
                .postalCode(address.getPostalCode())
                .buildingNo(address.getBuildingNo())
                .apartmentNo(address.getApartmentNo())
                .build();
    }
}
