package com.example.a3.Employees;





import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "emp")
@Builder
//@JsonIgnoreProperties({"image"})
@Table(uniqueConstraints = { @UniqueConstraint(name = "fullName",columnNames = { "first_name", "last_name" }) })
public class Emp {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @NotNull
    @NotBlank
    @Column(name="first_name")
    private String firstName;

    @NotNull
    @NotBlank
    @Column(name="last_name")
    private String lastName;

    @NotNull
    @Column(name="salary")
    private Long salary;

    @NotNull
    @Email
    @NotBlank
    @Column(name="email",unique = true)
    private String email;

    @NotNull
    @Past
    @Column(name="birth_date")
    private LocalDate birthDate;

//    @Column(name = "image")
//    @Lob
//    @JsonIgnore
//    private byte[] image;

    @OneToOne(mappedBy = "emp",cascade = CascadeType.ALL)
    private UserData1 userData1;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Manager manager;
}
