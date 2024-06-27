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

    public double getFeeForEachMovie() {
        double result = 0;
        switch (this._movie.getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (this.getDaysRented() > 2) {
                    result += (this.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += this.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (this.getDaysRented() > 3) {
                    result += (this.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return result;
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
