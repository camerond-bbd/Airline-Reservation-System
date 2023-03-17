package co.za.bbd.ars.helpers;

public class Validator {
    public static boolean isNotNull(int value) {
        return value < 0;
    }

    public static boolean greaterThan(double greaterValue, double value) {
        return greaterValue > value;
    }
}
