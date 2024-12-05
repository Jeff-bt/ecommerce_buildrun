package dev.jeff.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tb_billing_address")
public class BillingAddressEntity {

    @Id
    @Column(name = "billing_address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billingAddressId;

    @Column(name = "address")
    private String address;

    @Column(name = "number")
    private String number;

    @Column(name = "complement")
    private String complement;

    // construtor vazio e getter & setters
}