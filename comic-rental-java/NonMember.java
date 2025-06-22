import java.text.DecimalFormat;

public class NonMember extends BookRental {
    DecimalFormat df = new DecimalFormat("0.00");

    public NonMember(Book[] c, String n, double f, char m, int d, int q) {
        super(c, n, f, m, d, q);
    }

    public NonMember(String n, char m, int d, int q) {
        super(n, m, d, q);
    }

    public double calcTotalFee() {
        double total = 0, totalFee;
        for (int i = 0; i < getComic().length; i++) {
            total += rentalFee(getComic()[i]);
        }
        totalFee = total * getDay();
        return totalFee;
    }

    public String toString() {
        return "\nName: " + getName() + "\nMembership Status: Non Member\nTotal Fee: RM " + df.format(calcTotalFee());
    }
}
