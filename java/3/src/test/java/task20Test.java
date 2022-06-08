import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class task20Test {

    @Test
    void type_analiser1() {
        task20 obj = new task20();
        String result = obj.type_analiser1();
        assertEquals("String", result);
    }
}