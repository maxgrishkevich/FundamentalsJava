public class LinkedListStack {

    private final LinkedList linkedList = new LinkedList();

    public void push(int data) {
        linkedList.addFirst(data);
    }

    public int pop() {
        return linkedList.removeFirst();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }

    public int sumOfNumbers(){
        return linkedList.sumOfNumbers();
    }
}

class LinkedList {

    private static class Node {
        private final int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }
    }

    private Node first = null;

    public void addFirst(int data) {
        Node newFirst = new Node(data);
        newFirst.next = first;
        first = newFirst;
    }

    public int removeFirst() {
        Node oldFirst = first;
        first = first.next;
        return oldFirst.data;
    }

    @Override
    public String toString() {
        StringBuilder listBuilder = new StringBuilder();
        Node currentNode = first;
        while (currentNode != null) {
            listBuilder.append(currentNode.data).append(" ");
            currentNode = currentNode.next;
        }
        return listBuilder.toString();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int sumOfNumbers(){
        int sum = 0;
        Node currentNode = first;
        while(currentNode != null){
            if(currentNode.data < 10){
                sum += currentNode.data;
            }
            currentNode = currentNode.next;
        }
        return sum;
    }

}