import java.util.*;
public class Library
{
    private String libraryName;
    private String libraryAddress;
    private List<Publisher> publishers =new ArrayList<>();
    private List<Author> authors =new ArrayList<>();
    private Librarian admin;

    List<Book> listOfBooks;
    List<Member> listOfMenbers;

    public Librarian getAdmin() {
        return admin;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Library(String libraryName, String libraryAddress, Librarian admin) {
        this.libraryName = libraryName;
        this.libraryAddress = libraryAddress;
        this.listOfBooks = new ArrayList();
        this.listOfMenbers=new ArrayList<>();
        this.admin = admin;
    }


    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public void setAdmin(Librarian admin) {
        this.admin = admin;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }

}
