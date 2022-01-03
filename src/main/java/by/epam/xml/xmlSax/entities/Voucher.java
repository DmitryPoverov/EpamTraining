package by.epam.xml.xmlSax.entities;

public class Voucher {
    private String Country;
    private int days;
    private HotelCharacteristics characteristics;
    private int cost;

    public Voucher() {
    }

    public Voucher(String country, int days, int cost) {
        Country = country;
        this.days = days;
        this.cost = cost;
    }

    public String getCountry() {
        return Country;
    }
    public int getDays() {
        return days;
    }
    public HotelCharacteristics getCharacteristics() {
        return characteristics;
    }
    public int getCost() {
        return cost;
    }

    public void setCountry(String country) {
        Country = country;
    }
    public void setDays(int days) {
        this.days = days;
    }
    public void setCharacteristics(HotelCharacteristics characteristics) {
        this.characteristics = characteristics;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "[Voucher\n\tCountry: " + Country + ",\n\tDays: " + days +
                " days,\n\t\tRoom\n" + characteristics + ",\n\tCost: " + cost + "$\n]";
    }

    public class HotelCharacteristics {
        private int numberOfStars;
        private String roomType;

        public HotelCharacteristics(int numberOfStars, String roomType) {
            this.numberOfStars = numberOfStars;
            this.roomType = roomType;
        }

        public int getNumberOfStars() {
            return numberOfStars;
        }
        public String getRoomType() {
            return roomType;
        }

        public void setNumberOfStars(int numberOfStars) {
            this.numberOfStars = numberOfStars;
        }
        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        @Override
        public String toString() {
            return "\t\tNumbers of stars: " + numberOfStars + " stars,\n\t\tRoom type: " + roomType;
        }
    }
}
