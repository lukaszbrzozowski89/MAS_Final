/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package data;/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */


/**
 * Class using to store data about every address
 * links with Person
 *
 * @author Lukasz
 * @see Person
 */
public class Address extends ObjectPlusPlus {
    protected String city;
    protected String street;
    protected String postalCode;

    public Address(String city, String street, String postalCode) {
        super();
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
