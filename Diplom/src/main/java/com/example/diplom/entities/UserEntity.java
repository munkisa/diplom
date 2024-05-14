package com.example.diplom.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private int pass_series;
    private int pass_id;
    private String email;
    private String password;

}
