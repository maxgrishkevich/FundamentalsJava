public class TestEx4 {
    public static void main(String[] args) {
        Ex4 obj = new Ex4();

        String test1 = "testing java program is very nice work.";
        obj.wordFunction(test1);

        String test2 = "if         we have   many     spaces.";
        obj.wordFunction(test2);

        String test3 = "if you forgot write point";
        obj.wordFunction(test3);

        String test4 = "if we havve numm6ers in w0rrds.";
        obj.wordFunction(test4);
    }
}
