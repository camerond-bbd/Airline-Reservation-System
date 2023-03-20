package co.za.bbd.ars.dtos;

import co.za.bbd.ars.model.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PassengerData {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    private String nationality;

    public Passenger getPassengerObject() {
        return new Passenger(
                null,
                this.firstName,
                this.lastName,
                this.email,
                this.phoneNumber,
                this.dateOfBirth,
                this.nationality
        );
    }

}
