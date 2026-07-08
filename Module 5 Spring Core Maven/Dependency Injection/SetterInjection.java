class Book {
    void showBook() {
        System.out.println("Book: Spring in Action");
    }
}

class Library {
    private Book book;
    void setBook(Book book) {
        this.book = book;
    }

    void issueBook() {
        System.out.println("Issuing book...");
        book.showBook();
    }
}
public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.setBook(new Book());
        lib.issueBook();
    }
}