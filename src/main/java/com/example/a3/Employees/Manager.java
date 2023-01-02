package com.example.a3.Employees;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "manager")
@Table(uniqueConstraints = { @UniqueConstraint(name = "fullName",columnNames = { "first_name", "last_name" }) })
public class Manager
{
   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotBlank
    @Column(name="first_name")
    private String firstName;

    @NotNull
    @NotBlank
    @Column(name="last_name")
    private String lastName;
    @NotNull
    @Column(name = "department",unique = true)
    private String department;
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy="manager",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Emp> employess;
}
