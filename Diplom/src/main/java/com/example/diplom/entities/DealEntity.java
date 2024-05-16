package com.example.diplom.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="deals")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deal_id;
    private Currency sell_currency;
    private Currency buy_currency;
    private Double price;
    private Integer count;

    public DealEntity(Currency sellCurrency, Currency buyCurrency, Double price, Integer count) {
        this.sell_currency = sellCurrency;
        this.buy_currency = buyCurrency;
        this.price = price;
        this.count = count;
    }
    //private Long fk_id;
}
