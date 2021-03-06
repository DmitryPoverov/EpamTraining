package by.epam.designPattern.patternEpamLesson;

public class Lexeme implements Component {

    private String value;
    private LexemeType type;

    private Lexeme(String value, LexemeType type) {
        this.value = value;
        this.type = type;
    }

    public static Lexeme word(String value) {
        return new Lexeme(value, LexemeType.WORD);
    }

    public static Lexeme expression(String value) {
        return new Lexeme(value, LexemeType.EXPRESSION);
    }
}
