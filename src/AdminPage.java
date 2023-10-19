public class AdminPage {
   public static boolean adminVerification(Library library){
       System.out.println("Enter Admin name : ");
       String userName=Resources.input.next();
       System.out.println("Enter Admin password : ");
       String userPassword=Resources.input.next();
       if(library.getAdmin().getLibrarianName().equals(userName) && library.getAdmin().getLibrarianPassword().equals(userPassword))
            return true;
       else
           return false;
   }
   private static boolean createNewBook(Library library){
       System.out.println("Enter book name : ");
       String bookName = Resources.input.next();
       System.out.println("Enter book ISBN : ");
       String bookISBN = Resources.input.next();
       System.out.println("Enter no.of pages : ");
       int pages = Resources.input.nextInt();
       System.out.println("Enter no.of Books : ");
       int quantity = Resources.input.nextInt();
       System.out.println("Enter author name : ");
       String authorName = Resources.input.next();
       System.out.println("Enter author email : ");
       String authorEmail = Resources.input.next();
       System.out.println("Enter author biography : ");
       String authorBiography = Resources.input.next();
       System.out.println("Enter publisher name : ");
       String publisherName = Resources.input.next();
       System.out.println("Enter publisher address : ");
       String publisherAddress = Resources.input.next();
       System.out.println("Enter publisherNumber : ");
       double publisherNumber = Resources.input.nextDouble();
       Author author = new Author(authorName, authorEmail, authorBiography);
       if (!library.getAuthors().contains(author)) {
           library.getAuthors().add(author);
       }
       Publisher publisher = new Publisher(publisherName, publisherAddress, publisherNumber);
       if (!library.getPublishers().contains(publisher)) {
           library.getPublishers().add(publisher);
       }
       Book book = new Book(bookName, bookISBN, author, publisher, pages,quantity);
       if (!library.listOfBooks.contains(book)) {
           library.listOfBooks.add(book);
       }
       return true;
   }

   public static void menuHandler(Library library){
       boolean menuFalg=true;
       while(menuFalg) {
           System.out.println("1.Add book");
           System.out.println("2.Display all Books ");
           System.out.println("3.Delete Book ");
           System.out.println("4.Display all members");
           System.out.println("4.Back");

           int adminChoice = Resources.input.nextInt();
           switch (adminChoice) {
               case 1: {
                   if(createNewBook(library))
                    System.out.println("Book added successfully");
                   break;
               }
               case 2: {
                   System.out.println("Books in Library : "+library.getLibraryName());
                   System.out.println(library.listOfBooks);
                   break;
               }
               case 3:{
                   System.out.print("Enter book ISBN to delete : ");
                   String tempISBN=Resources.input.next();
                   if(Book.deleteBook(tempISBN,library)) {
                       System.out.println(tempISBN+" Deleted successfully");
                   }
                   else{
                       System.out.println("Sorry book not found");
                   }
                   break;
               }
               case 4:{
                   System.out.println("\n----------------------------------------------------\n");
                    for(Member member:library.listOfMenbers){
                        System.out.println(member);
                    }
                   System.out.println("\n----------------------------------------------------\n");
                    break;

               }
               case 5:{
                   menuFalg=false;
                   break;
               }
           }
       }


   }


}
