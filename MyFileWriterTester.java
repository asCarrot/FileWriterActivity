public class MyFileWriterTester {
    public static void main(String[] args) {
        System.out.println("Testing generateSecretFile()...");
        MyFileWriter.generateSecretFile();
        MyFileWriter.generateRegularFile();
        System.out.println("Should be a success!");
    }
}