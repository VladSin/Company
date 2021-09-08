package org.example.vladsin.company.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "website")
    private String website;

    @Column(name = "location")
    private String location;

    @Column(name = "budget")
    private Long budget;

    @OneToMany(mappedBy = "Department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Department> departments;
}
