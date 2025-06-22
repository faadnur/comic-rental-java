public class Book {
    private String title;
    private String category;

    public Book() {}

    public Book(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public void setBook(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }
}
