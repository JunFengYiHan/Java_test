package book;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-22
 * Time: 21:39
 */
public class BookList {
    private Book[] book = new Book[10];
    private int usedSize = 0;

    public BookList() {
        //默认放入四大名著
        book[0] = new Book("三国演义","罗贯中",56,"小说");
        book[1] = new Book("水浒传","施耐庵",56,"小说");
        book[2] = new Book("西游记","吴承恩",56,"小说");
        book[3] = new Book("红楼梦","曹雪芹",56,"小说");
        this.usedSize = 4;
    }
    //得到pos下标的书籍
    public Book getBook(int pos) {
        return this.book[pos];
    }
    //设置pos下标的书籍
    public void setBook(int pos,Book book) {
        this.book[pos] = book;
    }
    //得到存放的书的本数
    public int getUseSize() {
        return usedSize;
    }
    //设置存放书的本数
    public void setUseSize(int useSize) {
        this.usedSize = useSize;
    }
}
