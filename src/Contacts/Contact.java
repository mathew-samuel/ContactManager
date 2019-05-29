package Contacts;

import java.util.Scanner;

public class Contact {
    private static void addNew(){
        Scanner scan = new Scanner(System.in);
        String firstName = addFistName();
        String lastName = addLastName();
        String phoneNumber = addPhoneNumber();
        String data_to_add = firstName+"@"+lastName+" "+phoneNumber;
        Data.appendData(data_to_add);
    }

    private static String addFistName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the first name of the contact.");
        return scan.nextLine().trim().toLowerCase();
    }

    private static String addLastName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the last name of the contact.\nIf no last name just press \"RETURN\" to continue.");
        return scan.nextLine().trim().toLowerCase();
    }

    private static String addPhoneNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter their phone number.\nIn this format [123-456-7890]\nOr this format [1234567890]\n");
        String phoneNumber = scan.nextLine().trim();
        if (phoneNumber.length() == 10) {
            return phoneNumber;
        } else if (phoneNumber.length() == 12) {
            phoneNumber = phoneNumber.replace("-", "");
            return phoneNumber;
        } else {
            return addPhoneNumber();
        }
    }

    private static void searchList(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter in the name or number\n you would like to search by.");
        String SearchPhrase = scan.nextLine().trim().toLowerCase();
        Data.searchData(SearchPhrase);

    }

    public static void contactApp(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Would you like to?\n--------------\nView Contacts.\n------------------\nAdd a new Contact.\n------------------------\nSearch Contacts by Name.\n------------------------\nDelete Existing Contact.\n------------------------\nExit.\n-----\n");
        String userInput = scan.nextLine().trim().toLowerCase();
        if (userInput.contains("v")){
            Data.readData();
            contactApp();
        }else if (userInput.contains("add")||userInput.contains("new")){
            addNew();
            contactApp();
        }else if (userInput.contains("sea")||userInput.contains("name")){
            searchList();
            contactApp();
        }else if (userInput.contains("del")){
            delContact();
            contactApp();
        }else if (userInput.contains("exit")){
            System.exit(0);
        }else{
            contactApp();
        }
    }

    private static void delContact(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter in the NAME of the\n Contact you would like to delete");
        String lineToDel = scan.nextLine().trim().toLowerCase();
        System.out.println("Are you sure you want to delete these Contacts?");
        Data.searchData(lineToDel);
        String UserConfirm = scan.nextLine().trim().toLowerCase();
        if (UserConfirm.contains("n")){
            contactApp();
        }else if (UserConfirm.contains("y")){
            Data.searchDataForDel(lineToDel);
        }else{
            delContact();
        }
    }

}
