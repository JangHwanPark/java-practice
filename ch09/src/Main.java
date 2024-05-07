import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));
        bookShelf.appendBook(new Book("East of Eden"));
        bookShelf.appendBook(new Book("예제로 배우는 씨 프로그래밍"));
        bookShelf.appendBook(new Book("우아한 프런트 개발"));

        //
        Iterator<Book> it = bookShelf.iterator();

        while(it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName());
        }
        System.out.println();

        // for 문 사용
        for (Book book : bookShelf) {
            System.out.println(book.getName());
        }
        System.out.println();
    }
}