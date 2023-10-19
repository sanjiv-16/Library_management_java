public class Librarian extends User {
    private String librarianEmail;

    public String getLibrarianName() {
        return getUsername();
    }

    public String getLibrarianPassword() {
        return getUserPassword();
    }

    public String getLibrarianEmail() {
        return librarianEmail;
    }
    public Librarian(String librarianName, String librarianPassword, String librarianEmail) {
        super(librarianName,librarianPassword);
        this.librarianEmail = librarianEmail;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "librarianName='" + getUsername() + '\'' +
                '}';
    }
}
