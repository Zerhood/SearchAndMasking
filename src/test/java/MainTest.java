import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Скрываем секретную информацию!")
public class MainTest {

    @Test
    @DisplayName("Текст = Вот тут не секретная информация, а тут <секрет>")
    void maskingOneString() {
        String expected = "Вот тут не секретная информация, а тут ***";
        String actual = Main.searchAndReplace("Вот тут не секретная информация, а тут <секрет>", "***");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Текст = Вот тут не секретная информация, а тут <куча кучная секретов>")
    void maskingMoreString() {
        String expected = "Вот тут не секретная информация, а тут ***";
        String actual = Main.searchAndReplace("Вот тут не секретная информация, а тут <куча кучная секретов>", "***");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Текст = Вот тут не секретная информация")
    void noMaskingString() {
        String expected = "Вот тут не секретная информация";
        String actual = Main.searchAndReplace("Вот тут не секретная информация", "***");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Текст = ")
    void noStrings() {
        String expected = "";
        String actual = Main.searchAndReplace("", "***");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Текст = первое правило <бойцовского> клуба: никому не рассказывать о <бойцовском> клубе.")
    void doubleMaskingString() {
        String expected = "первое правило *** клуба: никому не рассказывать о *** клубе.";
        String actual = Main.searchAndReplace("первое правило <бойцовского> клуба: никому не рассказывать о <бойцовском> клубе.", "***");
        assertEquals(expected, actual);
    }
}