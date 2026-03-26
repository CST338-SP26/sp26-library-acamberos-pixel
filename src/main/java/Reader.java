// athian camberos
// reader java file for project one, part two


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Reader
{
    public static final int CARD_NUMBER_ =0;
    public static final String PHONE_ ="";
    public static final String NAME_ = "";
    public static final int BOOK_START_ =0;
    public static final int BOOK_COUNT_ =0;


    private int card_number_;
   private String phone_ ="";
    private String name_ ="";
    private int book_start_;
    private int book_count_;
    private List<Book> books;

    //The constructor takes three parameters cardNumber (int), name (String), and Phone (String). These are used to set the fields of the same name in the project.
    //
    //Initialize the list of Books to an empty ArrayList.



//    public Book(String isbn, String title, String subject, int pageCount, String author, LocalDate dueDate) {
//        this.isbn = isbn;
//        this.title = title;
//        this.subject = subject;
//        this.pageCount = pageCount;
//        this.author = author;
//        this.dueDate = dueDate;
//    }
    public Reader(int card_number_ , String phone_ , String name_ , int book_start_, int book_count_)
    {
        this.card_number_ = card_number_;
        this.phone_ = phone_;
        this.name_ = name_;
        this.book_start_ = book_start_;
        this.book_count_ = book_count_;
    }



    public void addBook(Book book) {
        books.add(book);
    }
    public void removeBook(Book book)
    {
        books.remove(book);
    }



    public boolean hasBook(Book book) {
        return book != null && books.contains(book);
    }


    // group of getters
    public List<Book> getBooks() {
        return books;
    }

    public int getBook_count_() {
        return book_count_;
    }

    public int getCard_number_() {
        return card_number_;
    }

    public String getPhone_() {
        return phone_;
    }

    public String getName_() {
        return name_;
    }

// group of setters
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setCard_number_(int card_number_) {
        this.card_number_ = card_number_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public void setPhone_(String phone_) {
        this.phone_ = phone_;
    }



    // to string

    @Override
    public String toString() {
        return
                name_  +
                '(' + card_number_ + ')' +
                " has checked out " + '{'  + books +
                '}';
    }





//    // hash code

//    public int hashCode() {
//        return Objects.hash(getISBN(), getTitle(), getSubject(), getPageCount(), getAuthor());
//    }
  @Override
    public int hashCode()
    {
        return Objects.hash(getBook_count_(), getBooks(), getName_(), getPhone_(), getCard_number_());
    }





}
