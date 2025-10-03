import java.io.*;

public class FileEncryptor {
    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            System.out.println("Usage: java FileEncryptor <encrypt|decrypt> <inputfile> <outputfile> <password>");
            return;
        }
        String mode = args[0];
        String inputFile = args[1];
        String outputFile = args[2];
        String password = args[3];
        byte[] key = password.getBytes();
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {
            int b;
            int i = 0;
            while ((b = fis.read()) != -1) {
                fos.write(b ^ key[i % key.length]);
                i++;
            }
        }
        System.out.println(mode + "ion finished.");
    }
}