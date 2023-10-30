package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Form {

    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String city;
    private String address;
    private String postalCode;
    private String phoneNumber;


}
