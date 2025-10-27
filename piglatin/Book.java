package piglatin;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Book {
    private String title;
    private ArrayList<String> text = new ArrayList<String>();

    Book() {
        // Empty book - no code needed here.
    }

    // Helper to debug code
    // Prints out a range of lines from a book
    public void printlines(int start, int length) {
        System.out.println("Lines " + start + " to " + (start + length) + " of book: " + title);
        for (int i = start; i < start + length; i++) {
            if (i < text.size()) {
                System.out.println(i + ": " + text.get(i));
            } else {
                System.out.println(i + ": line not in book.");
            }
        }
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getLine(int lineNumber) {
        return text.get(lineNumber);
    }

    int getLineCount() {
        return text.size();
    }

    void appendLine(String line) {
        text.add(line);
    }

    public void readFromString(String title, String string) {
        // load a book from an input string.
        this.title = title;

        // use: text.add(line) to add a line to the book.

        Scanner sc=new Scanner(string);
        while(sc.hasNextLine())
        {
            String line=sc.nextLine();
            text.add(line);

        }


sc.close();



    }

    public void readFromUrl(String title, String url) {
        // load a book from a URL.
        // https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
        this.title = title;

        try {
            URL bookUrl = URI.create(url).toURL();
            // Scanner can open a file on a URL like this:
            // Scanner(bookUrl.openStream())
            // use: text.add(line) to add a line to the book.
            Scanner sc=new Scanner(bookUrl.openStream());
            while(sc.hasNextLine())
            {
                String line=sc.nextLine();
                text.add(line);
            }
            sc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    void writeToFile(String name) {
        // TODO: Add code here to write the contents of the book to a file.
        Path filePath = Paths.get("output.txt");
        try {
            // Overwrites the file if it exists, creates it if not
            for (String line:text)
            {
                
                Files.writeString(filePath, "\n"+line, StandardOpenOption.APPEND);
                
            }
            // To append:
            // Files.writeString(filePath, "\nAppended text.", StandardOpenOption.APPEND);
            
            System.out.println("Successfully wrote to the file using Files.writeString().");
        } catch (IOException e) {
            System.err.println("DANG check book.java line 109" + e.getMessage());
        }

        // Must write to file using provided name.
    }
}
