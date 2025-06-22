import java.text.DecimalFormat;

public class Member extends BookRental {
    DecimalFormat df = new DecimalFormat("0.00");

    public Member(Book[] c, String n, double f, char m, int d, int q) {
        super(c, n, f, m, d, q);
    }

    public Member(String n, char m, int d, int q) {
        super(n, m, d, q);
    }

    public double calcTotalFee() {
        double total = 0, totalFee;
        for (int i = 0; i < super.getComic().length; i++) {
            total += super.rentalFee(getComic()[i]);
        }
        totalFee = (total * getDay()) * 0.95;
        return totalFee;
    }

    public String toString() {
        return "\nName: " + getName() + "\nMembership Status: Member\nTotal Fee: RM " + df.format(calcTotalFee());
    }
}
