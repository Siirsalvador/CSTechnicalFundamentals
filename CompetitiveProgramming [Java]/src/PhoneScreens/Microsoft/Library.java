package PhoneScreens.Microsoft;

import java.util.*;

public class Library {

    private Map<String, Author> authorMap;

    private Library() {
        authorMap = new HashMap<>();
    }

    public static void main(String[] args) {


        List<Book> books = new ArrayList<>();
        books.add(new Book("Demo Classic", "Robert", 2));
        books.add(new Book("Artisan", "James", 1));
        books.add(new Book("Sugar Daddy", "Robert", 2));
        books.add(new Book("Milky Way", "Mimikus", 200));
        books.add(new Book("Donkey", "Sagay", 4));

        Library library = new Library();
        library.printPopularAuthors(books);

    }

    private void printPopularAuthors(List<Book> books) {

        for (Book book : books) {
            String author = book.getAuthor();

            Author authorDetails = authorMap.get(author);

            if (authorDetails == null) {
                authorMap.put(author, new Author(author, book.getCheckOuts()));
            } else {
                authorDetails.totalCheckouts += book.getCheckOuts();
                authorMap.put(author, authorDetails);
            }
        }

        List<Author> authors = new ArrayList<>(authorMap.values());
        Collections.sort(authors);

        for (Author author : authors) {
            System.out.println(String.format("%s : %s", author.name, author.totalCheckouts));
        }

    }
}

class Author implements Comparable<Author> {

    String name;
    int totalCheckouts;


    Author(String name, int totalCheckouts) {
        this.name = name;
        this.totalCheckouts = totalCheckouts;
    }

    @Override
    public int compareTo(Author author) {
        int equal = author.totalCheckouts - this.totalCheckouts;
        return equal == 0 ? this.name.compareTo(author.name) : equal;
    }
}

class Book {

    private String name;
    private String author;
    private int checkOuts;

    Book(String name, String author, int checkOuts) {
        this.name = name;
        this.checkOuts = checkOuts;
        this.author = author;
    }

    String getAuthor() {
        return author;
    }

    int getCheckOuts() {
        return checkOuts;
    }

    String getName() {
        return name;
    }
}