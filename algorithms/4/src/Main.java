
public class Main {
    public static void main(String[] args) {

        OneSidedLinkedList OneSidedLinkedList = new OneSidedLinkedList();
        OneSidedLinkedList.push(7, 53); //7
        OneSidedLinkedList.push(6, 17);
        OneSidedLinkedList.push(5, 10);
        OneSidedLinkedList.push(4, 12);
        OneSidedLinkedList.push(3, 18);
        OneSidedLinkedList.push(2, 33);
        OneSidedLinkedList.push(1, 42); //1

        System.out.println("Завдання а:");
        OneSidedLinkedList.printList();
        OneSidedLinkedList.delAndSwap(3);
        OneSidedLinkedList.printList();

        System.out.println("\nЗавдання б:");
        OneSidedLinkedList.printList();
        OneSidedLinkedList.delMinAndNeighbours();
        OneSidedLinkedList.printList();


        TwoSidedLinkedList TwoSidedLinkedList = new TwoSidedLinkedList();
        TwoSidedLinkedList.push(5);
        TwoSidedLinkedList.push(2);
        TwoSidedLinkedList.push(4);
        TwoSidedLinkedList.push(8);
        TwoSidedLinkedList.push(10);

        System.out.println("\nЗавдання в:");
        TwoSidedLinkedList.printList();
        TwoSidedLinkedList.delTwoSidedLinkData(8);
        TwoSidedLinkedList.printList();
    }
}
