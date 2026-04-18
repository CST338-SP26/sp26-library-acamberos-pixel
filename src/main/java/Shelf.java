import Utilities.Code;
import java.util.*;


// sunday april 5th



public class Shelf {
    

// cosntants
public static final int SHELF_NUMBER_ = 0;
public static final int SUBJECT_ = 1;

// Instance Fields/vars

    private int                  shelfNumber;
    private String               subject;
    private HashMap<Book, Integer> books;





    // Constructors needed to handle information

    @Deprecated
    public Shelf() {}


    public Shelf(int shelfNumber, String subject) {
        this.shelfNumber = shelfNumber;
        this.subject = subject;
        this.books = new HashMap<>();
    }



    // get/set

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public HashMap<Book, Integer> getBooks() {
        return books;
    }

    public void setBooks(HashMap<Book, Integer> books)
    {
        this.books = books;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shelf)) return false;
        Shelf other = (Shelf) o;
        return shelfNumber == other.shelfNumber &&
                Objects.equals(subject, other.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shelfNumber, subject);
    }


    @Override
    public String toString() {
        return shelfNumber + " : " + subject;
    }


// get book count

    public int getBookCount(Book book) {
        if (!books.containsKey(book)) {
            return -1;
        }
        return books.get(book);
    }


// make sure to import code class to use this method like in other file

    public Code addBook(Book book) {
        // Book already exists on shelf — just increment the count
        if (books.containsKey(book)) {
            books.put(book, books.get(book) + 1);
            System.out.println(book + " added to shelf " + this);
            return Code.SUCCESS;
        }


        if (book.getSubject().equals(subject)) {
            books.put(book, 1);
            System.out.println(book + " added to shelf " + this);
            return Code.SUCCESS;
        }

        // if the  Subjects don't match for whatever reason
        return Code.SHELF_SUBJECT_MISMATCH_ERROR;
    }

    public Code removeBook(Book book) {

        if (!books.containsKey(book)) {
            System.out.println(book.getTitle() + " is not on shelf " + subject);
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        }

        // Book is in the HashMap but has a count of 0
        if (books.get(book) == 0) {
            System.out.println("No copies of " + book.getTitle() +
                    " remain on shelf " + subject);
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        }

        // Decrement the count
        books.put(book, books.get(book) - 1);
        System.out.println(book.getTitle() + " successfully removed from shelf " + subject);
        return Code.SUCCESS;
    }


    public String listBooks()
    {
        int totalBooks = books.values().stream().mapToInt(Integer::intValue).sum();

        StringBuilder sb = new StringBuilder();

        // Header line — singular "book" vs plural "books"
        if (totalBooks == 1) {
            sb.append("1 book on shelf: ");
        } else {
            sb.append(totalBooks).append(" books on shelf: ");
        }
        sb.append(this).append("\n");

        // One line per book: <book.toString()> <count>
        for (HashMap.Entry<Book, Integer> entry : books.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        return sb.toString();
    }

}
