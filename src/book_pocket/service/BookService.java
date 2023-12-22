package book_pocket.service;

import book_pocket.entity.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookService {
    private Map<String, Book> library = new HashMap<>();

    private static BookService instance;
    public static BookService getInstance() {
        if (instance == null) {
            instance = new BookService();
        }
        return instance;
    }

    public BookService() {
        Book book;

        book = new Book("ISBN1234", "쉽게 배우는 JSP 웹 프로그래밍", 27000, "송미영", "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍", "IT전문서", "2018/10/08");
        library.put(book.getIsbn() , book);
        book = new Book("ISBN1235", "안드로이드 프로그래밍", 33000, "우재남", "실습 단계별 명쾌한 멘토링!", "IT전문서", "2022/01/22");
        library.put(book.getIsbn() , book);
        book = new Book("ISBN1236", "스크래치", 22000, "고광일", "컴퓨팅 사고력을 키우는 블록 코딩", "컴퓨터입문", "2019/06/10");
        library.put(book.getIsbn() , book);
    }


    public int BookCount() {
        return library.size();
    }

    public Book getBooks(String bookId) {
        return library.get(bookId);
    }

    public Optional<Book> findById(String bookId) {

        return Optional.of(library.getOrDefault(bookId, null));
    }

    public void addBook(Book book) {
        String bookId = book.getIsbn();

        if (!library.containsKey(bookId)) {
            library.put(book.getIsbn(), book);
        } else {
            System.out.println("이미 존재하는 책입니다.");
        }
    }

    public void removeBook(String bookId) {
        if (library.containsKey(bookId)) {
            library.remove(bookId);
        } else {
            System.out.println("존재하지 않는 책입니다.");
        }
    }
}
