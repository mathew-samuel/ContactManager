package Contacts;

public class Contact {
    private String firstName;
    private String lastName;
    private String fullName;
    private String number;
    private String address;

    public Contact(){}

    public Contact(String First,String Number){
        this.firstName = First;
        this.number = Number;
    }

    public Contact(String First,String Last,String Number){
        this.firstName = First;
        this.lastName = Last;
        this.fullName = First+" "+Last;
        this.number = Number;
    }

    public Contact(String First,String Last,String Number,String Address){
        this.firstName = First;
        this.lastName = Last;
        this.fullName = First+" "+Last;
        this.number = Number;
        this.address = Address;
    }
}
