package io.armory.bgdb;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "bgdb", name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String postalCode;
    private String buildingNo;
    private String apartmentNo;
}
