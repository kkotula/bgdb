package io.armory.bgdb;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String postalCode;
    private String buildingNo;
    private String apartmentNo;
}
