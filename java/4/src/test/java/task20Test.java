import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class task20Test {

    @Test
    void hash_book_map() {
        task20 obj = new task20();
        int result = obj.hash_book_map();
        assertEquals(5, result);
    }
}