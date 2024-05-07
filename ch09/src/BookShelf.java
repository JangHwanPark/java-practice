import java.util.ArrayList;
import java.util.Iterator;

// Iterable 인터페이스를 구현하고 있음
public class BookShelf implements Iterable<Book> {
    private ArrayList<Book> books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new ArrayList<>(maxsize);
    }

    // Book 타입 books 의 인덱스 반환
    public Book getBookAt(int index) {
        return books.get(index);
    }

    // 추가
    public void appendBook(Book book) {
        this.books.add(last, book);
        last++;
    }

    public int getLength() {
        return last;
    }

    // Book 타입의 이터레이터를 생성하고 자기자신을 전달
    // this = 의 bookShelf
    @Override
    public Iterator<Book> iterator() {
        BookShelfIterator bookShelfIterator = new BookShelfIterator(this);
        System.out.println(bookShelfIterator);
        return bookShelfIterator;
    }
}