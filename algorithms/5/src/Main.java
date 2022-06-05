public class Main {
    public static void main(String[] args) {
        ArrayStack arr_stack = new ArrayStack();
        LinkedListStack list_stack = new LinkedListStack();

        for (int i = 0; i < 10; i++){
            int n = (int)(Math.random()*21);//(Math.random()*((max-min)+1))+min
            arr_stack.push(n);
            list_stack.push(n);
        }

        System.out.println("Array Stack\n" + arr_stack.toString());
        System.out.println("The sum of numbers which are less than 10: " + arr_stack.sumOfNumbers() + "\n");

        System.out.println("Linked List Stack\n" + list_stack.toString());
        System.out.println("The sum of numbers which are less than 10: " + list_stack.sumOfNumbers());

    }
}
