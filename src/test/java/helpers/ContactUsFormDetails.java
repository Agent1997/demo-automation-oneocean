package helpers;

import lombok.Data;

@Data

public class ContactUsFormDetails {
    String title;
    String firstName;
    String lastName;
    String emailAddress;
    String company;
    String jobTitle;
    String country;
    String help;
    Boolean marketing;
    Boolean privacy;
}
