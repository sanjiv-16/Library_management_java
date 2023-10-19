import java.util.*;
public class Book {
    private String bookTitle;
    private String ISBN;
    private Author author;
    private Publisher publisher;
    private int noOfPages;
    private int quantity;
    public Book(String bookTitle, String ISBN, Author author, Publisher publisher, int noOfPages,int quantity) {
        this.bookTitle = bookTitle;
        this.ISBN = ISBN;
        this.author = author;
        this.publisher = publisher;
        this.noOfPages = noOfPages;
        this.quantity=quantity;
    }
    public Book(Book book){
        this.bookTitle=book.bookTitle;
        this.ISBN=book.ISBN;
        this.author=book.author;
        this.publisher=book.publisher;
        this.noOfPages=book.noOfPages;
        this.quantity=1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return noOfPages == book.noOfPages &&
                bookTitle.equals(book.bookTitle) &&
                ISBN.equals(book.ISBN) &&
                author.equals(book.author) &&
                publisher.equals(book.publisher);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookTitle='" + bookTitle + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", author=" + author +
                ", Quantity = "+quantity +
                '}';
    }
    public static boolean deleteBook(String ISBN,Library library){
        for(Book book:library.listOfBooks){
            if(book.ISBN==ISBN){
                library.listOfBooks.remove(book);
                return true;
            }
        }
        return false;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public int getQuantity() {
        return quantity;
    }
}
