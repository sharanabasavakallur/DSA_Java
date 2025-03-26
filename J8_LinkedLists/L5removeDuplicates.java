package J8_LinkedLists;

/*
leetcode..83..easy
Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
Return the linked list sorted as well.
Input: head = [1,1,2]
Output: [1,2]
Input: head = [1,1,2,3,3]
Output: [1,2,3]
*/

class leetcode83{
    //structure of node
    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value=value;
        }
        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }

    Node head;
    public void insertRear(int data){
        Node newNode=new Node(data);
        if(head==null){//if the list is empty
            head=newNode;
            return;
        }
        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=newNode;
    }

    public void duplicates(){
        if(head==null){//list empty
            System.out.println("list empty..");
            return;
        }
        Node current=head;
        while(current.next!=null){//run till last node
            if(current.value==current.next.value){//check if adjacent nodes have same values
                current.next=current.next.next;//if so skip that node and move to next node after that node
            }
            else{
                current=current.next;//if not check for next node
            }
        }
    }

    // Method to display the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}

public class L5removeDuplicates {
    public static void main(String[] args) {
        leetcode83 lt=new leetcode83();
        lt.insertRear(1);
        lt.insertRear(1);
        lt.insertRear(2);
        lt.insertRear(3);
        lt.insertRear(3);
        lt.insertRear(3);

        lt.display();
        lt.duplicates();
        lt.display();
    }
}
