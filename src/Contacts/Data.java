package Contacts;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Data {
    String dir = "data";
    String filename = "contacts.txt";

    Path dataDir = Paths.get(dir);
    Path dataFile = Paths.get(dir,filename);

    public static void createDataDirandDataFile(){
        String dir = "data";
        String filename = "contacts.txt";

        Path dataDir = Paths.get(dir);
        Path dataFile = Paths.get(dir,filename);

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
}
