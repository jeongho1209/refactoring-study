package chapter01;

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int arg) {
        _priceCode = arg;
    }

    public String getTitle() {
        return _title;
    }

    public double getFeeEachMovie(int daysRented) {
        double result = 0;
        switch (this._priceCode) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    public int getRenterPoints(int daysRented) {
        // 최신을 이틀 이상 대여하는 경우 추가 포인트 제공
        boolean isNewReleaseMovie = this.getPriceCode() == Movie.NEW_RELEASE;
        boolean isRentedDayAfterDay = daysRented > 1;
        if (isNewReleaseMovie && isRentedDayAfterDay) {
            return 2;
        }

        return 1;
    }
}
