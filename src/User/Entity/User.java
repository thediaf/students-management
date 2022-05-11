package User.Entity;

import java.util.Date;

public class User 
{
    private int id = 0;
    private String lastname;
    private String firstname;
    private Date birthDay;
    private String birthLocate;
    private String address;
    private String nationality;

    public void User()
    {
        ++this.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthLocate() {
        return birthLocate;
    }

    public void setBirthLocate(String birthLocate) {
        this.birthLocate = birthLocate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
