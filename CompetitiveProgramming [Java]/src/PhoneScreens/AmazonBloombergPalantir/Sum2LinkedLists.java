package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-18
 */
public class Sum2LinkedLists {

    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(3);

        Node second = new Node(5);
        second.next = new Node(3);
        second.next.next = new Node(9);

        System.out.println(sumTwoLinkedListsReversed(first, second));
    }

    //If numbers are in correct order
    //1 -> 2 -> 3 = 123
    public static Node sumTwoLinkedLists(Node first, Node second) {

        //Convert to number
        int firstNum = 0;
        while (first != null) {
            firstNum = firstNum * 10 + first.data;
            first = first.next;
        }

        int secNum = 0;
        while (second != null) {
            secNum = secNum * 10 + second.data;
            second = second.next;
        }

        //Add numbers
        int resNum = firstNum + secNum;

        //Convert to list
        String res = String.valueOf(resNum);
        int currVal = Integer.parseInt(String.valueOf(res.charAt(0)));
        Node head = new Node(currVal);
        Node curr = head;

        for (int i = 1; i < res.length(); i++) {
            currVal = Integer.parseInt(String.valueOf(res.charAt(i)));
            curr.next = new Node(currVal);
            curr = curr.next;
        }

        return head;
    }

    //If numbers are reversed
    //1 -> 2 -> 3 = 321
    public static Node sumTwoLinkedListsReversed(Node first, Node second) {

        Node result = null;
        Node prev = null;
        Node curr;
        int carry = 0;
        int sum;

        while (first != null || second != null) {

            sum = carry + (first != null ? first.data : 0) +
                    (second != null ? second.data : 0);

            carry = sum >= 10 ? 1 : 0;

            //Check if sum > 10
            sum = sum % 10;

            curr = new Node(sum);

            //Check if list is empty
            if (result == null) result = curr;
            else {
                prev.next = curr;
            }

            prev = curr;

            if (first != null) first = first.next;
            if (second != null) second = second.next;
        }

        if (carry > 0) {
            prev.next = new Node(carry);
        }

        return result;
    }

    static class Node {
        int data;
        Node next;

        Node() {
        }

        Node(int data) {
            this.data = data;
        }

    }
}