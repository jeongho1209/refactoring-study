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

    public int getRenterPoints() {
        return this._movie.getRenterPoints(_daysRented);
    }
}
