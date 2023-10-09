package Model;

public class PersonInfo {
    private String photo;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String birthDate;

    private PersonInfo(String photo, String name, String email, String address, String phoneNumber, String birthDate) {
        this.photo = photo;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public static PersonInfo of(String photo, String name, String email, String address, String phoneNumber, String birthDate) {
        return new PersonInfo(photo, name, email, address, phoneNumber, birthDate);
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
