package org.oss.LibraryManagementSystem.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "\"user\"", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "full_name")
    @NotNull(message = "code không thể là null")
    private String fullName;

    @Column(name = "gender")
    @NotNull(message = "name không thể là null")
    private String gender;

    @Column(name = "password")
    @NotNull(message = "password không thể là null")
    private String password;

    @Column(name = "email")
    @NotNull(message = "email không thể là null")
    private String email;

    @Column(name = "date_of_birth")
    @NotNull(message = "date_of_birth không thể là null")
    private Timestamp dateOfBirth;

    @Column(name = "contact_number")
    @NotNull(message = "contact_number không thể là null")
    private String contactNumber;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public User(String fullName, String gender, String password, String email, Timestamp dateOfBirth, String contactNumber, boolean enabled, Set<Role> roles) {
        this.fullName = fullName;
        this.gender = gender;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.enabled = enabled;
        this.roles = roles;
    }

}
