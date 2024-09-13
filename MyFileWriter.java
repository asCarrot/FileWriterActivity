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

    static String secretFile = "ultraSecretShh";
    static File regularFile = new File(".superLowkeyFolder/notAsSecret.txt");
    // generateSecretFile(): creates a secret file within FileWriterActivity.
    // This secret file name and password is hard-coded.
    public static void generateSecretFile() {
        generateCustomFile(secretFile, "NotGoodPassword!123");
    }

    // generateRandomizedSecretFile(): creates a secret file within FileWriterActivity.
    // This secret file name is hard-coded, but its password is (should be) randomized by a helper method.
    // The randomized password is always set to have the max length (25).
    public static void generateRandomizedSecretFile() {
        generateCustomFile("GigaSecretFile", randomizer(25));
    }

    // generateFileWithCustomName(String): creates a secret file within FileWriterActivity.
    // This secret file name is decided by the parameter, meaning that it's customized. The password is hard-coded.
    // ps: please don't put void into these parameters, since I'm too lazy to add edge-cases right now.
    public static void generateFileWithCustomName(String fileName) {
        generateCustomFile(fileName, "AnotherBadPassword!789");
    }

    // generateFileWithCustomPassword(String): creates a secret file within FileWriterActivity.
    // This secret file name is hard-coded, and its password is decided by the user's input for the parameter (it's customized).
    public static void generateFileWithCustomPassword(String password) {
        generateCustomFile("MegaSecretFile", password);
    }

    // generateCustomFile(): creates a secret file within FileWriterActivity.
    // Both its file name and password are decided by the user's input for the parameter
    public static void generateCustomFile(String fileName, String password) {
        String customSecretFile = ("." + fileName + ".txt");
        try {
            FileWriter writer = new FileWriter(customSecretFile);
            writer.write(password);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    // minimum length: 14 characters || maximum length: 25 characters -> if the target length doesn't meet these requirements,
    //... it will change the length to the closest "valid" number. (Doesn't throw errors when length doesn't meet requirements.)
    // only chooses characters from 33-126 (uppercase + lowercase letters, numbers 0-9, and special symbols)
    private static String randomizer(int length) {
        if (length < 14) {
            System.out.println("Input length is too low, making password with length 14 instead... ");
            length = 14;
        } else if (length > 25) {
            System.out.println("Input length is too low, making password with length 14 instead... ");
            length = 25;
        }
        String randomString = "";
        for (int i = 0; i < length; i++) {
            char randomChar = (char)((int)((Math.random() * 93) + 33));
            randomString += String.valueOf(randomChar);
        }
        return randomString;
    }

    // printFileSize: prints the length of the file's contents.
    public static void printFileSize(String fileName) {
        File file = new File(fileName);
        long fileSize = file.length();
        System.out.println("The length of your file is: " + fileSize);
    }
}