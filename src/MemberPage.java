import java.util.*;
public class MemberPage {
    public static boolean memberLogin(Library library){
        System.out.println("Enter your name : ");
        String username=Resources.input.next();
        System.out.println("Enter your password : ");
        String userPassword=Resources.input.next();
        for(Member member:library.listOfMenbers){
            if(member.getMemberName().equals(username) && member.getMemberPassword().equals(userPassword)) {
                MemberPage.memberMenuHandler(library,member);
                return true;
            }
        }
        return false;
    }

    public static boolean memberRegistration(Library library){
        System.out.println("Enter your name : ");
        String username=Resources.input.next();
        System.out.println("Enter your password : ");
        String userPassword=Resources.input.next();
        System.out.println("Enter your email : ");
        String userEmail=Resources.input.next();
        Member member=new Member(username,userPassword,userEmail);
        if(!library.listOfMenbers.contains(member)){
            library.listOfMenbers.add(member);
            MemberPage.memberMenuHandler(library,member);
            return true;
        }
        return false;
    }

    private static boolean addBook(Library library,Member member){
        System.out.println("Enter book ISBN");
        String bookISBN=Resources.input.next();
        System.out.println("Enter book name");
        String bookName=Resources.input.next();
        for(Book book:library.listOfBooks){
            if(book.getBookTitle().equals(bookName) && book.getISBN().equals(bookISBN)){
                book.setQuantity(book.getQuantity()-1);
                Book memberBook=new Book(book);
                if(member.cartBooks.contains(memberBook)){
                    member.cartBooks.get(member.cartBooks.indexOf(memberBook)).setQuantity( member.cartBooks.get(member.cartBooks.indexOf(memberBook)).getQuantity()+1);
                }
                else {
                    member.cartBooks.add(memberBook);
                }
                System.out.println(book.getBookTitle()+" book added to cart");
                return true;
            }
        }
        return false;
    }

    private static boolean submitBook(Library library,Member member){
        System.out.println("Enter ISBN to submit : ");
        String submitISBN=Resources.input.next();
        System.out.println("Enter book name");
        String submitName=Resources.input.next();
        for(Book bbook:member.borrowedBooks){
            if(bbook.getBookTitle().equals(submitName) && bbook.getISBN().equals(submitISBN )&& bbook.getQuantity()>0) {
                for(Book book:library.listOfBooks){
                    if(book.equals(bbook)){
                        book.setQuantity(book.getQuantity()+1);
                        Book memberBook=new Book(book);
                        if(member.borrowedBooks.contains(memberBook)){
                            member.borrowedBooks.get(member.borrowedBooks.indexOf(memberBook)).setQuantity( member.borrowedBooks.get(member.borrowedBooks.indexOf(memberBook)).getQuantity()-1);
                        }
                        else {
                            member.borrowedBooks.add(memberBook);
                        }
                        System.out.println(memberBook.getBookTitle()+" Book submitted");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void memberMenuHandler(Library library,Member member){
        boolean memberFlag=true;
        while(memberFlag){
            System.out.println("1.Add book to cart");
            System.out.println("2.Display cart");
            System.out.println("3.Submit books");
            System.out.println("4.Borrow books");
            System.out.println("5.Display all borrowed books");
            System.out.println("6.Display all books in library");
            System.out.println("7.Exit");
            int memberChoice=Resources.input.nextInt();
            switch(memberChoice){
                case 1:{
                    if(!addBook(library,member)){
                        System.out.println("book not found");
                    }
                    break;
                }
                case 2:{
                    System.out.println("\n----------------------------------------------------\n");
                    for(Book book:member.cartBooks){
                        System.out.println(book);
                    }
                    System.out.println("\n----------------------------------------------------\n");
                    break;
                }
                case 3:{
                    if(!submitBook(library,member)){
                        System.out.println("Sorry invalid ISBN that you Borrowed");
                    }
                    break;
                }
                case 4:{
                    for(Book book:member.cartBooks){
                        if(member.borrowedBooks.contains(book)){
                            member.borrowedBooks.get(member.borrowedBooks.indexOf(book)).setQuantity( member.borrowedBooks.get(member.borrowedBooks.indexOf(book)).getQuantity()+1);
                        }
                        else {
                            member.borrowedBooks.add(book);
                        }
                    }
                    member.cartBooks.clear();

                }
                case 5:{
                    System.out.println("\n----------------------------------------------------\n");
                    System.out.println("Total Borrowed Books are : ");
                    for(Book book:member.borrowedBooks){
                        if(book.getQuantity()==0){
                            member.borrowedBooks.remove(book);
                        }
                        System.out.println(book);
                    }
                    System.out.println("\n----------------------------------------------------\n");
                    break;
                }
                case 6:{
                    System.out.println("\n----------------------------------------------------\n");
                    for(Book book:library.listOfBooks){
                        System.out.println(book);
                    }
                    System.out.println("\n----------------------------------------------------\n");
                    break;
                }
                case 7:{
                    for(Book book:member.cartBooks){
                        for(Book lbook:library.listOfBooks){
                            if(book.equals(lbook)){
                                lbook.setQuantity(lbook.getQuantity()+book.getQuantity());
                            }
                        }
                    }
                    member.cartBooks.clear();
                    memberFlag=false;
                    break;
                }
            }
        }
    }


}
