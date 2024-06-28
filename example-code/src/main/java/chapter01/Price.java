package chapter01;

public abstract class Price {
    abstract int getPriceCode();

    // switch case 문을 상속 -> 각각 클래스를 구현해서 풀어냄
    abstract double getCharge(int daysRented);

    int getRenterPoints(int daysRented) {
        return 1;
    }
}

class ChildrensPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 2;

        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}

class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}

class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 2;

        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}
