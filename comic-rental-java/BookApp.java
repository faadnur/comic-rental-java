import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class BookApp {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        int loop = 1;

        System.out.println("\nWelcome");

        while (loop == 1) {
            System.out.println("Do you want to search for a book or process rentals?");
            System.out.println("1 - Search for a book");
            System.out.println("2 - Process rentals");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Enter comic title to search:");
                String comicName = sc.nextLine();

                try (BufferedReader br = new BufferedReader(new FileReader("comic.txt"))) {
                    String line;
                    boolean found = false;
                    while ((line = br.readLine()) != null) {
                        StringTokenizer tokenizer = new StringTokenizer(line, ";");
                        int bookCount = Integer.parseInt(tokenizer.nextToken());
                        String[] titles = tokenizer.nextToken().split(",");
                        String category = tokenizer.nextToken();

                        for (String title : titles) {
                            if (title.equalsIgnoreCase(comicName)) {
                                System.out.println("Book available");
                                found = true;
                                break;
                            }
                        }
                    }
                    if (!found) System.out.println("Book not available");
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (choice == 2) {
                try {
                    PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("member.txt")));
                    PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter("nonmember.txt")));

                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Member(M)/Non-member(N): ");
                    char member = sc.nextLine().charAt(0);
                    System.out.print("How many comics are you renting: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    Book[] comics = new Book[quantity];
                    for (int j = 0; j < quantity; j++) {
                        System.out.println("Title " + (j + 1) + ": ");
                        String title = sc.nextLine();
                        System.out.println("Category: ");
                        String category = sc.nextLine();
                        comics[j] = new Book(title, category);
                    }
                    System.out.print("Rental days: ");
                    int day = sc.nextInt();
                    sc.nextLine();

                    BookRental rental;
                    if (member == 'M') {
                        rental = new Member(comics, name, 0.0, member, day, quantity);
                        System.out.print(rental.toString());
                        out1.println("Name: " + rental.getName());
                        out1.println("Total Fee: RM " + df.format(rental.calcTotalFee()));
                        out1.close();
                    } else {
                        rental = new NonMember(comics, name, 0.0, member, day, quantity);
                        System.out.print(rental.toString());
                        out2.println("Name: " + rental.getName());
                        out2.println("Total Fee: RM " + df.format(rental.calcTotalFee()));
                        out2.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            System.out.print("\nDo you want to continue? Insert 1 for yes, otherwise for no: ");
            loop = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("\t Bye~Bye~");
    }
}
