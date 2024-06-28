package chapter01;

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;
    private Price _price;

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR -> {
                _price = new RegularPrice();
            }
            case CHILDREN -> {
                _price = new ChildrensPrice();
            }
            case NEW_RELEASE -> {
                _price = new NewReleasePrice();
            }
            default -> throw new IllegalArgumentException("Illegal Argument");
        }
    }

    public String getTitle() {
        return _title;
    }

    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    public int getRenterPoints(int daysRented) {
        return _price.getRenterPoints(daysRented);
    }
}
