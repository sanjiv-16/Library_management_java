import java.util.Objects;

public class Author {
    private String authorName;
    private String authorEmail;
    private String biography;

    @Override
    public String toString() {
        return " AuthorName='" + authorName + '\'' +
                '}';
    }

    public Author(String authorName, String authorEmail, String biography) {
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.biography = biography;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorName.equals(author.authorName) &&
                authorEmail.equals(author.authorEmail) &&
                biography.equals(author.biography);
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public String getBiography() {
        return biography;
    }
}
