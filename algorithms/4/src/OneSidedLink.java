public class OneSidedLink {
    public int iData;
    public double dData;
    public OneSidedLink next;

    public OneSidedLink(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }

    public void printLink() {
        System.out.print(" {" + iData + ", " + dData + "}");
    }
}

class OneSidedLinkedList {
    OneSidedLink first;

    public OneSidedLinkedList() {
        first = null;
    }

    public void push(int iD, double dD) {
        OneSidedLink newLink = new OneSidedLink(iD, dD);
        newLink.next = first;
        first = newLink;
    }

    public OneSidedLinkedList delAndSwap(int key) {
        OneSidedLink current = first;
        OneSidedLink previous = first;
        while (current.iData != key) {
            if (current.next == null) {
                System.out.println("Такого елемента немає!");
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
            System.out.println("Видалення пройшло успішно!");
            if (first == null || first.next == null) {
                System.out.println("Не можливо провести заміну елементів!");
                return  null;
            }
            OneSidedLink swap = new OneSidedLink(first.iData,first.dData);
            OneSidedLink swap2 = new OneSidedLink(first.next.iData,first.next.dData);
            first.iData = swap2.iData;
            first.dData = swap2.dData;
            first.next.iData = swap.iData;
            first.next.dData = swap.dData;
        } else {
            previous.next = current.next;
            System.out.println("Видалення пройшло успішно !");
            OneSidedLink next1 = previous.next;
            if (next1 == null) {
                System.out.println("Не можливо провести заміну елементів !");
                return  null;
            }
            OneSidedLink next2 = next1.next;
            if (next2 == null) {
                System.out.println("Не можливо провести заміну елементів !");
                return  null;
            }
            OneSidedLink swap  = new OneSidedLink(next1.iData,next1.dData);
            OneSidedLink swap2 = new OneSidedLink(next2.iData,next2.dData);
            next1.iData = swap2.iData;
            next1.dData = swap2.dData;
            next2.iData = swap.iData;
            next2.dData = swap.dData;
        }
        System.out.println("Заміна пройшла успішно !");
        return null;
    }

    public void delMinAndNeighbours(){
        OneSidedLink current = first;
        OneSidedLink min = first;
        OneSidedLink previous1 = first;
        OneSidedLink previous2 = first;
        while (current.next != null){
            if (current.dData > current.next.dData) {
                min = current.next;
                previous1 = current;
                if (current.next.next != null && current.next.dData > current.next.next.dData) {
                    min = current.next.next;
                    previous1 = current.next;
                    previous2 = current;
                }
            }
            current = current.next;
        }
        if (min == first){
            System.out.println("Повноцінне виконання завдання неможливе!\n" +
                    "Мінімальний елемент знаходиться на першій позиції");
        } else if (previous1 == first && first.next.next != null){
            first = first.next.next.next;
            System.out.println("Видалення пройшло успішно!");
        } else if (min.next == null){
            System.out.println("Повноцінне виконання завдання неможливе!\n" +
                    "Мінімальний елемент знаходиться на останній позиції");
        } else if (min.next.next == null){
            previous2.next.next = null;
            System.out.println("Видалення пройшло успішно!");
        } else {
            previous2.next = min.next.next;
            System.out.println("Видалення пройшло успішно!");
        }

    }

    public void printList() {
        OneSidedLink current = first;
        System.out.print("List (first --> last): ");

        while(current != null) {
            current.printLink();
            current = current.next;
        }
        System.out.println();
    }
}
