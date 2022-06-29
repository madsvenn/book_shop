package Entity;

public class Book {

    Integer bookId;
    Integer categoryId;//类别
    String categoryName;//类别名称
    String bookName;
    String author;
    String publisher;

    int price;
    int salePrice;
    int amount;

    public Book() {
    }

    public Book(Integer categoryId, String bookName, String author, String publisher, int price, int salePrice) {
        this.categoryId = categoryId;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.salePrice = salePrice;
    }

    public Book(Integer bookId, Integer categoryId, String categoryName, String bookName, String author, String publisher, int price, int salePrice, int amount) {
        this.bookId = bookId;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.salePrice = salePrice;
        this.amount = amount;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", salePrice=" + salePrice +
                ", amount=" + amount +
                '}';
    }
}
