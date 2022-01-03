package by.epam.xml.xmlJaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbReader {
    public static void main(String[] args) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(Customer.class);
        File file = new File("src/main/resources/testCustomer.xml");

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Customer customer = (Customer) unmarshaller.unmarshal(file);
        System.out.println(customer);
    }
}
