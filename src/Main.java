import Contacts.Data;

import java.util.Scanner;

public class Main {

    public static String addNew(){
        Scanner scan = new Scanner(System.in);
        String firstName = addFistName();
        String lastName = addLastName();
        System.out.println("Please enter their phone number.\nIn this format [xxx-xxx-xxxx]");
        String phoneNumber = scan.nextLine().trim();




    }

    public static String addFistName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the first name of the contact.");
        return scan.nextLine().trim().toLowerCase();
    }

    public static String addLastName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the last name of the contact.\nIf no last name just press \"RETURN\" to continue.d");
        return scan.nextLine().trim().toLowerCase();
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Contacts Manager");
        System.out.print("Would you like to?\n--------------\nView Contacts.\n------------------\nAdd a new Contact.\n------------------------\nSearch Contacts by Name.\n------------------------\nDelete Existing Contact.\n------------------------\nExit.\n-----\n");
        String userInput = scan.nextLine().trim().toLowerCase();
        if (userInput.contains("v")){
            Data.readData();
        }else if (userInput.contains("add")||userInput.contains("new")){

        }else if (userInput.contains("sea")||userInput.contains("name")){

        }else if (userInput.contains("del")){

        }else if (userInput.contains("exit")){
            System.exit(0);
        }else{

        }
    }

}
