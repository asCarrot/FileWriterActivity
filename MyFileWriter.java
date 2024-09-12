import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class MyFileWriter {
    public static void main(String[] args) {
        String data = "Hello, World!";
        String fileName1 = "example.txt";
        String fileName2 = "example2.txt";
        String fileName3 = "example3.txt";
        String fileName4 = "example4.txt";
        String fileName5 = "example5.txt";

        // 1. Using FileWriter
        try (FileWriter writer = new FileWriter(fileName1)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Using BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. Using FileOutputStream
        try (FileOutputStream outputStream = new FileOutputStream(fileName3)) {
            outputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4. Using BufferedOutputStream
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName4))) {
            bufferedOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5. Using Files (java.nio.file)
        try {
            Files.write(Paths.get(fileName5), data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String pass = "";
        String secretFile = ".ultraSecretShh.txt";
        try (FileWriter writer = new FileWriter(secretFile)) {
            writer.write(pass);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static String secretFile = ".ultraSecretShh.txt";
    //static String regularFile = "/.superLowkeyFolder/notAsSecret.txt";
    static File regularFile = new File(".superLowkeyFolder/notAsSecret.txt");
    // generateSecretFile(): creates a secret file within FileWriterActivity.
    // This secret file name and password is hard-coded.
    public static void generateSecretFile() {
        try {
            FileWriter writer = new FileWriter(secretFile);
            writer.write("NotGoodPassword!123");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // generateRandomizedSecretFile(): 
    public static void generateRandomizedSecretFile() {

    }

    public static void generateFileWithCustomName(String fileName) {

    }
    public static void generateFileWithCustomPassword(String password, int passwordLength) {

    }
    public static void generateCustomFile(String fileName, String password, int passwordLength) {

    }

    // generateRegularFile(): creates a regular file in a secret folder within FileWriterActivity. This file name and password
    // is also hard-coded.
    public static void generateRegularFile() {
        try {
            FileWriter writer = new FileWriter(regularFile);
            writer.write("NotGoodPasswordAgain!456");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // for the randomized file method; this should create a password with a specified length in the parameter.
    // the minimum length is 14 characters, while the maximum is   
    // only chooses characters from 33-126 (uppercase + lowercase letters, numbers 0-9, and special symbols)
    private String randomizer(int length) {

        if (length < 14 || length > 25) {
            System.out.println("");
        }

        String randomString = "";
        

        return randomString;
    }

}