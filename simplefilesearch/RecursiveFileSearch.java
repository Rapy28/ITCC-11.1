import java.io.*;
import java.util.*;

// Class representing a file or folder
class FileNode {
    String name;
    boolean isDirectory;
    List<FileNode> children;
    FileNode(String name, boolean isDirectory) {
        this.name = name;
        this.isDirectory = isDirectory;
        this.children = new ArrayList<>();
    }
    void addChild(FileNode child) {
        if (this.isDirectory) {
            this.children.add(child);
    }
    }
    }

public class RecursiveFileSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the file extension to search for (e.g., .txt, .java) or type 'exit' to quit: ");
            String extension = scanner.nextLine();
            
            if (extension.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program...");
                break;
            }
            
            // Mock file system with more files and folders
            FileNode root = new FileNode("root", true);
            FileNode folder1 = new FileNode("folder1", true);
            FileNode file1 = new FileNode("file1.txt", false);
            FileNode file2 = new FileNode("filesearch.java", false);
            FileNode file3 = new FileNode("splash.bmp", true);
            FileNode file4 = new FileNode("chrome.exe", false);
            FileNode file5 = new FileNode("windows.iso", true);
            FileNode file6 = new FileNode("rotgames.exe", false);
            FileNode file7 = new FileNode("4kwallpaper.jpg", false);
            FileNode file8 = new FileNode("liceo.mp4", false);
            FileNode file9 = new FileNode("xu.mov", true);
            FileNode file10 = new FileNode("nodes.mp4", true);

            folder1.addChild(file1);
            root.addChild(folder1);
            root.addChild(file2);
            root.addChild(file3);
            root.addChild(file4);
            root.addChild(file5);
            root.addChild(file6);
            root.addChild(file7);
            root.addChild(file8);
            root.addChild(file9);
            root.addChild(file10);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("search_results.txt"))) {
                searchFiles(root, extension, writer);
                System.out.println("Search completed. Results saved in search_results.txt");
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
            }
        scanner.close();
    }
    public static void searchFiles(FileNode node, String extension, BufferedWriter writer) throws IOException {
        if (!node.isDirectory && node.name.endsWith(extension)) {
            System.out.println("File found: " + node.name);
            writer.write("File found: " + node.name + "\n");
        }
        for (FileNode child : node.children) {
            searchFiles(child, extension, writer);
        }
    }
}
