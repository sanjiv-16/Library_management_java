import java.util.*;
public class Member extends User{
    private String memberEmail;
    List<Book> cartBooks=new ArrayList<>();
    List<Book> borrowedBooks=new ArrayList<>();

    public Member(String memberName, String memberEmail, String memberPassword) {
        super(memberName,memberPassword);
        this.memberEmail = memberEmail;
    }

    public String getMemberName() {
        return getUsername();
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberName='" + getUsername() + '\t'+'\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }

    public String getMemberPassword() {
        return getUserPassword();
    }

}
