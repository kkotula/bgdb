package io.armory.bgdb;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "bgdb", name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;
    private String street;
    private String city;
    private String postalCode;
    private String buildingNo;
    private String apartmentNo;

}
