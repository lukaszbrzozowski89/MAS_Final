import java.time.LocalDate;

public abstract class Person extends ObjectPlusPlus{

    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private Address address;

    public Person(String name, String surname, LocalDate dateOfBirth, Address address) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address=" + address +
                '}';
    }
}
