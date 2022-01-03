package by.epam.xml.xmlSax.validator;

import by.epam.xml.xmlSax.handler.VoucherErrorHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class baseValidator {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String filename = "src/main/resources/vouchers.xml";
        String schemaName = "src/main/resources/vouchers.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);

        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filename);
            validator.setErrorHandler(new VoucherErrorHandler());
            validator.validate(source);
            logger.info("The try-block was executed normally");
        } catch (SAXException | IOException e) {
            System.err.println(filename + " is not correct or valid");
            logger.error("\nThe catch-block was executed with error: " + e.getMessage());
        }
    }
}
