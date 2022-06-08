import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class task6Test {

    @Test
    void convert_to_unicode() {
        task6 obj = new task6();
        int result = obj.convert_to_unicode();
        assertEquals(61, result);
    }
}