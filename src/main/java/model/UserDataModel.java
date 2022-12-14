package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Table(name = "user_data")
@Entity(name = "UserData")
@Getter
@Setter
@ToString
public class UserDataModel implements Serializable {

    @Id
    @Column(name = "id")
    public String Id;

    @Column(name = "name")
    public String Name;

    @Column(name = "mother_name")
    public String MotherName;

    @Column(name = "email")
    public String Email;

    @Column(name = "phone_number")
    public int PhoneNumber;

    public UserDataModel(String name, String motherName, String email, int phoneNumber) {

        Id = UUID.randomUUID().toString();
        Name = name;
        Email = email;
        PhoneNumber = phoneNumber;
        MotherName = motherName;

    }

    public UserDataModel() {

        Id = UUID.randomUUID().toString();

    }
}
