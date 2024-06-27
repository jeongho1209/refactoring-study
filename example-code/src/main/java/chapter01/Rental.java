package chapter01;

public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public double getFeeEachMovie() {
        return this._movie.getFeeEachMovie(_daysRented);
    }

    public int getRenterPoint() {
        // 최신을 이틀 이상 대여하는 경우 추가 포인트 제공
        boolean isNewReleaseMovie = this._movie.getPriceCode() == Movie.NEW_RELEASE;
        boolean isRentedDayAfterDay = this.getDaysRented() > 1;
        if (isNewReleaseMovie && isRentedDayAfterDay) {
            return 2;
        }

        return 1;
    }
}
