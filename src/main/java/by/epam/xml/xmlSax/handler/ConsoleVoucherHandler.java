package by.epam.xml.xmlSax.handler;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class ConsoleVoucherHandler extends DefaultHandler {
    @Override public void startDocument() {
        System.out.println("Parsing started");
    }

    // Blinov's book:
    // String uri - a unique namespace name,
    // String localName - an element's name without prefix specified by the name of xmlns attribute,
    // String qName - full name of element's with the prefix,
    // Attributes attrs - a list of the attributes
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        String tagData = qName + " ";
        for (int i = 0; i < attrs.getLength(); i++) {
            tagData += " " + attrs.getQName(i) + "=" + attrs.getValue(i);
        }
        System.out.print(tagData);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.print(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.print(" " + qName);
    }

    @Override
    public void endDocument() {
        System.out.println("\nParsing ended");
    }
}