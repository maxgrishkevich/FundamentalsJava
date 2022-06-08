import static org.junit.jupiter.api.Assertions.*;

class task5Test {

    @org.junit.jupiter.api.Test
    void crypt_decrypt() {
        task5 obj = new task5();
        String result = obj.crypt_decrypt();
        assertEquals("khoor", result);
    }
}