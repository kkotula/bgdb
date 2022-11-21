package io.armory.bgdb;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customer")
    private List<Address> addresses;

    public void addAddress(Address address) {
        if (this.addresses == null) {
            this.addresses = new ArrayList<>(1);
        }
        this.addresses.add(address);
    }
}
