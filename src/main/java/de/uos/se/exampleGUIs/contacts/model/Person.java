package de.uos.se.exampleGUIs.contacts.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Jan-Philipp Schleutker
 */
@SuppressWarnings ("unused")
public class Person
{

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    public Person(String firstName, String lastName, String email, String phone)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    private Person()
    {
    }

    @XmlElement (name = "first_name")
    public String getFirstName()
    {
        return firstName;
    }

    @XmlElement (name = "last_name")
    public String getLastName()
    {
        return lastName;
    }

    @XmlElement (name = "email")
    public String getEmail()
    {
        return email;
    }

    @XmlElement (name = "phone")
    public String getPhone()
    {
        return phone;
    }

    private void setFirstName(String s)
    {
        this.firstName = s;
    }

    private void setLastName(String s)
    {
        this.lastName = s;
    }

    private void setEmail(String s)
    {
        this.email = s;
    }

    private void setPhone(String s)
    {
        this.phone = s;
    }

    @Override
    public String toString()
    {
        return this.lastName + ", " + this.firstName;
    }

}
