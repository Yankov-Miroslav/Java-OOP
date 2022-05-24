package HotelReservation;

public enum Discount {
    VIP(0.2),
    SECOND_VISIT(0.1),
    NONE(0.0);

    private double percentage;

    Discount(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public static Discount fromString(String discountAsString) {
        switch (discountAsString) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("Unknown discount type " + discountAsString);
        }
    }
}
