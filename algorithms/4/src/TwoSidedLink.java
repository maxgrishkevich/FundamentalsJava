public class TwoSidedLink {
    int data;
    TwoSidedLink next, prev;

    public void printLink() {
        System.out.print(" {" + data + "}");
    }
}

class TwoSidedLinkedList {
    TwoSidedLink first;

    public TwoSidedLinkedList() {
        first = null;
    }

    public TwoSidedLink delTwoSidedLink(TwoSidedLink del) {
        if (first == null || del == null)
            return null;
        if (first == del)
            first = del.next;
        if (del.next != null)
            del.next.prev = del.prev;
        if (del.prev != null)
            del.prev.next = del.next;
        del = null;
        return first;
    }

    public TwoSidedLinkedList delTwoSidedLinkData(int n) {
        if (first == null)
            return null;
        TwoSidedLink current = first;
        while (current.data != n) {
            if (current.next == null) {
                System.out.println("Такого елемента немає!");
                return null;
            } else {
                current = current.next;
            }
        }
        delTwoSidedLink(current);
        return null;
    }

    public void push(int new_data) {
        TwoSidedLink new_node = new TwoSidedLink();
        new_node.data = new_data;
        new_node.prev = null;
        new_node.next = first;
        if (first != null)
            first.prev = new_node;

        first = new_node;
    }

    public void printList() {
        TwoSidedLink temp = first;
        System.out.print("List (first --> last): ");
        if (temp == null)
            System.out.print("Doubly Linked list empty");
        while (temp != null)
        {
            temp.printLink();
            temp = temp.next;
        }
        System.out.println();
    }
}