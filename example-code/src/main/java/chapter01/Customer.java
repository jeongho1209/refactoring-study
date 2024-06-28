package chapter01;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private final String _name;
    private final Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        Enumeration rentals = this._rentals.elements();
        String result = "chapter01.Rental Record for " + this.getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // 이 대여에 대한 요금 계산 결과 표시
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    each.getFeeEachMovie() + "\n";
        }

        // 풋터(footer) 추가
        result += "Amount owed is " + getTotalAmount(rentals) + "\n";
        result += "You earned " + getTotalRenterPoints(rentals) +
                "frequent renter points";
        return result;
    }

    private int getTotalRenterPoints(Enumeration rentals) {
        int result = 0;
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            result += each.getRenterPoints();
        }

        return result;
    }

    private double getTotalAmount(Enumeration rentals) {
        double result = 0;
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            result += each.getFeeEachMovie();
        }

        return result;
    }
}
