package by.epam.xml.xmlSax;

import by.epam.xml.xmlSax.entities.Voucher;

public class Runner {
    public static void main(String[] args) {
        Voucher voucher = new Voucher("USA", 10, 1000);
        Voucher.HotelCharacteristics characteristics = voucher.new HotelCharacteristics(5, "Double");
        voucher.setCharacteristics(characteristics);
        System.out.println(voucher);
    }
}
