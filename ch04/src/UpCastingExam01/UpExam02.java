package src.UpCastingExam01;
import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private int publicationYear;

    // 생성자
    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // 업캐스팅 되면서 기본적으로 이게 실행됨
    // 업캐스팅을 함으로써 부모클래스의 메소드를 오버라이딩해서 사골 우려먹듯 사용한다.
    // 그렇기에 자식클래스는 별도의 메소드 정의 없이 부모 메소드 만으로 실행이 가능하다.
    // 이는 코드 중복을 줄이고(로직의 재사용) 유지보수성이 향상? 된다.
    public void printDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + publicationYear);
    }
}

class Novel extends Book {
    private String genre;

    public Novel(String title, String author, int publicationYear, String genre) {
        super(title, author, publicationYear);
        this.genre = genre;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Genre: " + genre);
    }
}

class Textbook extends Book {
    private String subject;

    public Textbook(String title, String author, int publicationYear, String subject) {
        super(title, author, publicationYear);
        this.subject = subject;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Subject: " + subject);
    }
}

class Magazine extends Book {
    private int issueNumber;

    public Magazine(String title, String author, int publicationYear, int issueNumber) {
        super(title, author, publicationYear);
        this.issueNumber = issueNumber;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Issue: " + issueNumber);
    }
}

// 다형성으로 인해 여기서 자동으로 업캐스팅 진행됨
// Why? 메소드 인자로 캐스팅한 인자를 받아서 그럼
class Bookshelf {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void printAllDetails() {
        for (Book book : books) {
            book.printDetails();
            System.out.println("---------------");
        }
    }
}

// 메인 클래스
public class UpExam02 {
    public static void main(String[] args) {
        Bookshelf shelf = new Bookshelf();

        // Novel 클래스가 Book 타입(클래스)으로 업캐스팅 후 오버라이딩 발생 (genre 필드 추가 사용)
        shelf.addBook(new Novel("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Tragedy"));

        // Textbook 클래스가 Book 타입(클래스)으로 업캐스팅 후 오버라이딩 발생 (subject 필드 추가 사용)
        shelf.addBook(new Textbook("Introduction to Algorithms", "Thomas H. Cormen", 2009, "Computer Science"));

        // Magazine 클래스가 Book 타입(클래스)으로 업캐스팅 후 오버라이딩 발생 (issueNumber 필드 추가 사용)
        shelf.addBook(new Magazine("National Geographic", "Multiple Authors", 2020, 500));
        shelf.printAllDetails();
    }
}