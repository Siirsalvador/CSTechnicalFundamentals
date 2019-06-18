package PhoneScreens.Microsoft;

import com.sun.istack.internal.NotNull;

import java.util.LinkedList;

public class CandyCrush {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.add(10);
//        linkedList.add(20);
//        linkedList.add(30);
//        linkedList.add(30);
//        linkedList.add(20);
//        linkedList.add(5);

        CandyCrush crusher = new CandyCrush();
//        System.out.println(crusher.crushCandy(linkedList));

//        linkedList = new LinkedList<>();
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//        linkedList.add(3);
//        linkedList.add(4);
//        linkedList.add(4);
//        linkedList.add(2);
//        linkedList.add(2);
//        linkedList.add(3);
//        linkedList.add(5);
//        System.out.println(crusher.crushCandy(linkedList));

        linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(3);
        System.out.println(crusher.crushCandy(linkedList));

//        ListNode listNode1 = new ListNode(10);
//        ListNode listNode2 = new ListNode(20);
//        ListNode listNode3 = new ListNode(30);
//        ListNode listNode4 = new ListNode(30);
//        ListNode listNode5 = new ListNode(20);
//        ListNode listNode6 = new ListNode(5);

//        listNode1.setNext(listNode2);
//        listNode2.setNext(listNode3);
//        listNode3.setNext(listNode4);
//        listNode4.setNext(listNode5);
//        listNode5.setNext(listNode6);

//        CandyCrush crusher2 = new CandyCrush();
//        System.out.println(crusher2.crushCandy(listNode1));



    }


    private LinkedList<Integer> crushCandy(@NotNull LinkedList<Integer> linkedList) {
        return crushTheDamnCandy(linkedList);
    }

    private LinkedList<Integer> crushTheDamnCandy(@NotNull LinkedList<Integer> linkedList) {

        boolean crushed = false;

        int compareFrom = 0;
        int compareTo = 0;

        for (int i = 1; i < linkedList.size(); i++) {

            Integer currentValue = linkedList.get(i);

            if (linkedList.get(compareFrom).equals(currentValue)) {
                compareTo = i;
                crushed = true;

                if (i == linkedList.size() - 1) {
                    while (compareTo >= compareFrom) {
                        linkedList.remove(compareTo);
                        compareTo--;
                    }
                }

            } else {

                if (compareTo == 0) {
                    compareFrom = i;
                    continue;
                }

                while (compareTo >= compareFrom) {
                    linkedList.remove(compareTo);
                    compareTo--;
                }

                break;
            }
        }

        return crushed ? crushTheDamnCandy(linkedList) : linkedList;
    }

}

class ListNode extends LinkedList {

    private int value;
    private ListNode next;

    ListNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}

