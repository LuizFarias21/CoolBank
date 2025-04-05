import org.example.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    void printMessageTest() {
        assertEquals("Hello", Main.printMessage("Hello"));
    }
}
