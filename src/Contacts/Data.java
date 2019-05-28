package Contacts;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    private static String dir = "data";
    private static String filename = "contacts.txt";
    private static Path dataDir = Paths.get(dir);
    private static Path dataFile = Paths.get(dir,filename);

    public static void createDataDirandDataFile(){

        if (Files.notExists(dataDir)) {
            try {
                Files.createDirectories(dataDir);
                System.out.println("Successfully Created Directory \""+dir+"\".");
            }catch (IOException e){
                System.out.println("Could not Create Directory \""+dir+"\".");
            }
        }else{
            System.out.println("Directory \""+dir+"\" already exists");
        }
        if (Files.notExists(dataFile)){
            try {
                Files.createFile(dataFile);
                System.out.println("Successfully Created \""+filename+"\".");
            }catch (IOException e){
                System.out.println("Could not Create \""+filename+"\".");
            }
        }else{
            System.out.println("File \""+filename+"\" already exists");
        }
    }

    public static void ClearData(){
        List<String> ContactList = Arrays.asList();
            try {
            Files.write(dataFile,ContactList);
            System.out.println("Successfully Cleared \""+filename+"\"");
        }catch (IOException e){
            System.out.println("Failed to Clear \""+filename+"\"");
        }
    }

    public static void OverwriteData(String data){
        List<String> ContactList = Arrays.asList(data);
        try {
            Files.write(dataFile,ContactList);
            System.out.println("Successfully wrote to \""+filename+"\"");
        }catch (IOException e){
            System.out.println("Failed to write to \""+filename+"\"");
        }
    }

    public static void appendData(String data){
        try {
            Files.write(
                    dataFile,
                    Arrays.asList(data),
                    StandardOpenOption.APPEND
            );
            System.out.println("Successfully appended \""+data+"\" to \""+filename+"\"");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Failed to append \""+data+"\" to \""+filename+"\"");
        }
    }

    public static void readData(){
        try {
            List<String> contactList = Files.readAllLines(dataFile);
                for (int i = 0; i < contactList.size(); i++) {
                    System.out.println((i + 1) + ": " + contactList.get(i));
                }
                    System.out.println("Successfully read \""+filename+"\"");
        }catch (IOException e){
            System.out.println("Failed to read \""+filename+"\"");
        }

    }

    public static String retrieveData(){
        String dataList = "";
        try {
            List<String> contactList = Files.readAllLines(dataFile);
                for (int i = 0; i < contactList.size(); i++) {
                    dataList += contactList.get(i);
                }
                System.out.println("Successfully returned \""+filename+"\"");
                     return dataList;
        }catch (IOException e){
            System.out.println("Failed to return \""+filename+"\"");
            return dataList;
        }
    }

    public static void searchData(String Search){
        try {
            List<String> lines = Files.readAllLines(dataFile);
            List<String> newList = new ArrayList<>();

                for (String line : lines){
                    if (line.contains(Search)){
                        System.out.println(line);
                    }
                }
            System.out.println("Successfully searched \""+filename+"\" for \""+Search+"\".\n");
        }catch (IOException e){
            System.out.println("Failed to search for \""+Search+"\" in \""+filename+"\".\n");
        }


    }

    public static void searchDataForDel(String Del){
        try {
            List<String> lines = Files.readAllLines(dataFile);
            List<String> newList = new ArrayList<>();

            for (String line : lines){
                if (!line.contains(Del)){
                    newList.add(line);
                }
            }
            Files.write(dataFile,newList);
            System.out.println("Successfully searched \""+filename+"\" for \""+Del+"\".\n");
        }catch (IOException e){
            System.out.println("Failed to search for \""+Del+"\" in \""+filename+"\".\n");
        }


    }

}
