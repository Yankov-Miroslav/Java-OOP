package HotelReservation;

public enum Season {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int multiplier;

    Season(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public static Season fromString(String seasonString) {
        switch (seasonString) {
            case "Autumn":
                return AUTUMN;
            case "Spring":
                return SPRING;
            case "Winter":
                return WINTER;
            case "Summer":
                return SUMMER;
            default:
                throw new IllegalArgumentException("Unknown season " + seasonString);
        }
    }
}
