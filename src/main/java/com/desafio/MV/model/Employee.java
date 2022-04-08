package com.desafio.MV.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cpf;

    private String name;

    @Column(unique = true)
    private String list;
}
