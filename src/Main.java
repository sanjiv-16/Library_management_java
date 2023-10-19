import java.util.*;
public class Main {

    public static void main(String[] args) {


        Librarian librarian1=new Librarian("sanjiv","sanj16","sanj@gmail.com");
        Library library1=new Library("Payilagam","avinashi road,coimbatore",librarian1);
        Book book1=new Book("Harrypotter","12345",new Author("John","john@","Drama Writter"),new Publisher("Goodsun","coimbatore",123654),102,10);
        Book book2=new Book("GoodWings","12346",new Author("Peter","peter@","Drama Writter"),new Publisher("Goodsun","coimbatore",123654),15,10);
        library1.listOfBooks.add(book1);
        library1.listOfBooks.add(book2);
        Member member1=new Member("Raju","raju@","1234");
        library1.listOfMenbers.add(member1);


        boolean mainFlag=true;
        while(mainFlag) {
            System.out.println("1.Admin login");
            System.out.println("2.Member login");
            System.out.println("3.Exit");
            System.out.print("Enter your choice : ");
            int loginChoice = Resources.input.nextInt();
            switch (loginChoice) {
                case 1: {
                    if (AdminPage.adminVerification(library1)) {
                        AdminPage.menuHandler(library1);
                    }
                    break;
                }
                case 2: {
                    System.out.println("Are you a new member (y/n): ");
                    char userchar=Resources.input.next().charAt(0);
                    if(userchar=='n'){
                        MemberPage.memberLogin(library1);

                    }
                    else{
                        MemberPage.memberRegistration(library1);
                    }
                    break;

                }
                case 3: {
                    System.out.println("ThankYou");
                    mainFlag=false;
                    break;
                }
            }
        }
    }
}
class Resources{
    public static Scanner input=new Scanner(System.in);
}
