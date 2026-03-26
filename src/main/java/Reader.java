// athian camberos
// reader java file for project one, part two


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import Utilities.Code;

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



    public Code addBook(Book book)
    {
        if (books.contains(book))
        {
            return Code.BOOK_ALREADY_CHECKED_OUT_ERROR;
        }

        books.add(book);
        book_count_ = books.size();
        return Code.SUCCESS;
    }
    public Code removeBook(Book book)
    {
        if (!books.contains(book))
        {
            return Code.READER_DOESNT_HAVE_BOOK_ERROR;
        }

        books.remove(book);
        book_count_ = books.size();
        return Code.SUCCESS;
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
                " (#" + card_number_ + ')' +
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return card_number_ == reader.card_number_
                && book_start_ == reader.book_start_
                && book_count_ == reader.book_count_
                && Objects.equals(phone_, reader.phone_)
                && Objects.equals(name_, reader.name_);
    }


}
