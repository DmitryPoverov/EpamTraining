package by.epam.xml.xmlSax.enums;

public enum VoucherXmlTagsEnum {
    VOUCHERS("vouchers"),
    VOUCHER("voucher"),
    COUNTRY("country"),
    HOTEL_CHARACTERISTICS("hotelCharacteristics"),
    NUMBER_OF_DAYS("numberOfStars"),
    ROOM_TYPE("roomType"),
    COST("cost");

    private String value;

    VoucherXmlTagsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
