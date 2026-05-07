package com.virtualcard.vcm.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "virtual_cards")
@Data
public class VirtualCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardHolderName;
    private String cardNumber;
    private String expiryDate;
    private Double spendingLimit;
    private Double currentBalance;
    private Boolean isLocked;
    private String cardType; // e.g., VISA, MASTERCARD
}