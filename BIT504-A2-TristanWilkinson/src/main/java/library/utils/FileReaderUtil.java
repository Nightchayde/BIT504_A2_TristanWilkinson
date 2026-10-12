package library.utils;

import library.models.Book;
import library.models.Member;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for reading data files.
 */
public class FileReaderUtil {

    public static List<Book> readBooks(String filePath) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    books.add(new Book(parts[0], parts[1], parts[2], parts[3],
                            parts[4], parts[5], Integer.parseInt(parts[6])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading books file: " + e.getMessage());
        }
        return books;
    }

    public static List<Member> readMembers(String filePath) {
        List<Member> members = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    members.add(new Member(parts[0], parts[1], parts[2],
                            Integer.parseInt(parts[3])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading members file: " + e.getMessage());
        }
        return members;
    }
}
