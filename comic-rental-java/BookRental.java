abstract public class BookRental {
    protected Book[] comic;
    private String name;
    private double fee;
    private char member;
    private int day;
    private int quantity;

    public BookRental(Book[] comic, String name, double fee, char member, int day, int quantity){
        this.comic = comic;
        this.name = name;
        this.fee = fee;
        this.member = member;
        this.day = day;
        this.quantity = quantity;
    }

    public BookRental(String name, char member, int day, int quantity){
        this.name = name;
        this.member = member;
        this.day = day;
        this.quantity = quantity;
    }

    public void setBookRental(Book[] comic, String name, double fee, char member, int day, int quantity){
        this.comic = comic;
        this.name = name;
        this.fee = fee;
        this.member = member;
        this.day = day;
        this.quantity = quantity;
    }

    public Book[] getComic() { return comic; }
    public String getName() { return name; }
    public double getFee() { return fee; }
    public char getMember() { return member; }
    public int getDay() { return day; }
    public int getQuantity() { return quantity; }

    public double rentalFee(Book comic) {
        if(comic.getCategory().equalsIgnoreCase("Red"))
            fee = 3.00;
        else if(comic.getCategory().equalsIgnoreCase("Yellow"))
            fee = 4.00;
        else if(comic.getCategory().equalsIgnoreCase("Green"))
            fee = 5.00;
        return fee;
    }

    abstract double calcTotalFee();
}
