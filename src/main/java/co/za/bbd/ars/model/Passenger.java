package co.za.bbd.ars.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Entity
@Data

public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passengerId", nullable = false)
    //@OneToMany
    //@JoinColumn(name = "FK_passengerId", referencedColumnName = "passengerId")
    private Integer passengerId;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "dateOfBirth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    public Passenger(Integer passengerId, String firstName, String lastName, String email, String phoneNumber, Date dateOfBirth, String nationality) {
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }

    public Passenger() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return passengerId == passenger.passengerId && firstName == passenger.firstName && lastName == passenger.lastName && email == passenger.email && phoneNumber == passenger.phoneNumber && dateOfBirth.equals(passenger.dateOfBirth) && nationality == passenger.nationality;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", email=" + email +
                ", phoneNumber=" + phoneNumber +
                ", dateOfBirth=" + dateOfBirth +
                ", nationality=" + nationality +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, firstName, lastName, email, phoneNumber, dateOfBirth, nationality);
    }
}
