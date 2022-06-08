import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class task44Test {

    @Test
    void fileList() {
        task44 obj = new task44();
        int result = obj.fileList();
        assertEquals(2, result);
    }
}