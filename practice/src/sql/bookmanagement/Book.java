package sql.bookmanagement;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-05-17
 * Time: 9:56
 */
//+--------+-------------+------+-----+---------+-------+
//| Field  | Type        | Null | Key | Default | Extra |
//+--------+-------------+------+-----+---------+-------+
//| id     | varchar(20) | NO   | PRI | NULL    |       |
//| name   | varchar(20) | YES  |     | NULL    |       |
//| author | varchar(20) | YES  |     | NULL    |       |
//| price  | int(11)     | YES  |     | NULL    |       |
//| type   | varchar(20) | YES  |     | NULL    |       |
//+--------+-------------+------+-----+---------+-------+
public class Book {
    private int bookId;
    private String name;
    private String author;
    private int price;
    private String type;
    private boolean isBorrow;

    public Book() {

    }

    public Book(int bookId, String name, String author, int price, String type, boolean isBorrow) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
        this.isBorrow = isBorrow;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", isBorrow=" + isBorrow +
                '}';
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBorrow() {
        return isBorrow;
    }

    public void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }
}
