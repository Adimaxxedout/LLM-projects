import java.io.*;

public class MarkdownViewer {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java MarkdownViewer <markdown_file>");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("^# (.*)", "\n$1\n");
                line = line.replaceAll("^## (.*)", "$1");
                line = line.replaceAll("^### (.*)", "$1");
                line = line.replaceAll("\*\*(.*?)\*\*", "$1");
                line = line.replaceAll("\*(.*?)\*", "$1");
                System.out.println(line);
            }
        }
    }
}