package book;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-21
 * Time: 20:25
 */
public class Book {
    private String bookName;//书名
    private String author;//作者
    private int price;//价格
    private String type;//书的类型
    private boolean isBorrowed;//是否被借出

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                (isBorrowed ? ", 已借出 ":", 未借出 ")+
                '}';
    }

    public Book(String bookName, String author, int price, String type) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.type = type;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
