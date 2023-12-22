package book_pocket.entity;

public class Book {
    private String isbn;
    private String name;
    private int price;
    private String author;
    private String desc;
    private String category;
    private String datePublish;

    public Book(String isbn, String name, int price, String author, String desc, String category, String datePublish) {
        this.isbn = isbn;
        this.name = name;
        this.price = price;
        this.author = author;
        this.desc = desc;
        this.category = category;
        this.datePublish = datePublish;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    // TODO: 필드 변수를 직접적으로 불러와 사용하지 말고, Getter를 사용해서 리턴하기
    @Override
    public String toString() {
        return isbn + " | " + name + " | " + price + " | " + author + " | " + desc + " | " + category + " | " + datePublish + " |";
    }
}