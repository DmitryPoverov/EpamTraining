package by.epam.designPattern.patternEpamLesson;

public class ChainBuilder {

    public Parser build() {
        //TODO add WordParser class
        return new TextParser(new ParagraphParser(null));
    }
}
