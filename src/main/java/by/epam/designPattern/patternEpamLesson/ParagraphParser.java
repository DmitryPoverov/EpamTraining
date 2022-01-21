package by.epam.designPattern.patternEpamLesson;

public class ParagraphParser extends AbstractParser{

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String text) {
        return null;
    }
}
