import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ILinkedList {
    public void add(int index,Object element);
    public void add(Object element);
    public Object get(int index);
    public void set(int index,Object element);
    public void clear();
    public boolean isEmpty();
    public void remove(int index);
    public int size();
    public ILinkedList sublist(int fromIndex,int toIndex);
    public boolean contains(Object o);
}

class Node{
    Object data;
    Node next;
    Node previous;

    Node(Object d){
        data = d;
    }
}
public class DoubleLinkedList implements ILinkedList {

    static Node head = null;
    static Node tail = null;
    static Node curr;
    static Node prev;
    static int length;
    static String[] arr;

    //# 1 #//

    public void add(int index,Object element) {
        if(index<0 || index>=length)
            System.out.print("Error");
        else if(head==null && index!=0)
            System.out.print("Error");
        else {
            Node newNode = new Node(element);
            if(index == 0) {
                newNode.next = head;
                head.previous = newNode;
                head = newNode;
                head.previous = null;
                System.out.print("[");
                printlist(head);
            }
            else {
                curr = head;
                for(int i = 0; i < index ; i++) {
                    prev = curr;
                    curr = curr.next;
                }
                newNode.next = curr;
                newNode.previous = prev;
                prev.next = newNode;
                curr.previous = newNode;
                System.out.print("[");
                printlist(head);
            }
        }
    }

    //# 2 #//

    public void add(Object element) {
        Node newNode = new Node(element);
        if(head == null) {
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    //# 3 #//

    public Object get(int index) {
        curr = head;
        if(index < 0 || index >= length || head == null){
            System.out.print("Error");
            return 0;
        }
        //// TAKE CARE HEEEERRRREEEE
        else if(index == 0) {
            System.out.print(head.data);
            return head.data;
        }
        else{
            for(int i = 0; i < index; i++)
                curr = curr.next;
            System.out.print(curr.data);
        }
        return curr.data;
    }
    
    //# 4 #//
    
    public void set(int index,Object element) {
        Node newNode = new Node(element);
        //    curr = head;
        if(head == null && index != 0) {
            System.out.println("Error");
        }
        else if(index < 0 || index >= length){
            System.out.print("Error");
        }
        else if(head == null && index == 0) {
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
            System.out.print("[");
            printlist(head);
        }
        else{
            curr = head;
            for(int i = 0; i < index; i++) {
                curr = curr.next;
            }
            curr.data = element;
            System.out.print("[");
            printlist(head);
        }
    }

    //# 5 #//
    
    public void clear() {
        head = null;
    }

    //# 6 #//
    
    public boolean isEmpty() {
        if(head == null) {
            System.out.print("True");
            return true;
        }
        else {
            System.out.print("False");
            return false;
        }
    }

    //# 7 #//
    
    public void remove(int index) {
        if(index < 0 || index >= length || head == null) {
            System.out.print("Error");
        }
        else {
            if(index==0) {
                head = head.next;
                head.previous = null;
                System.out.print("[");
                printlist(head);
            }
            else {
                curr = prev = head;
                for(int i = 0; i < index - 1; i++)
                {     prev = prev.next;
                }
                for(int j = 0; j < index ; j++)
                {      curr = curr.next;
                }
                prev.next = curr.next;
                curr.previous = prev;
                System.out.print("[");
                printlist(head);
            }
        }
    }

    //# 8 #//
    
    public int size() {
        if(head == null) {
            System.out.print("0");
            return 0;
        }
        else {
            System.out.print(length);
            return length;
        }
    }

    //# 9 #//

    public ILinkedList sublist(int fromIndex,int toIndex) {
        DoubleLinkedList object = new DoubleLinkedList();
        if(fromIndex < 0 || fromIndex >= length || toIndex < 0 || toIndex >= length || fromIndex > toIndex || head == null){
            System.out.print("Error");
        }
        else{
            prev = head;

            int i;
            for( i = 0; i < fromIndex; i++) {
                prev = prev.next;
            }
            System.out.print("[");
            for(int k = i; k <= toIndex; k++) {
                object.add(prev.data);
                System.out.print(prev.data);
                if(k!=toIndex)
                    System.out.print(", ");
                prev = prev.next;
            }
            System.out.print("]");
        }
        return object;
    }

    //# 10 #//

    public boolean contains(Object o) {
        curr = head;
        int k = 1;
        while(curr.data != o && k < length) {
            curr = curr.next;
            k++;
        }
        if(curr.data == o) {
            System.out.print("True");
            return true;
        }
        System.out.print("False");
        return false;
    }

    public static void printlist(Node node) {
        if(node==null)
            System.out.print("]");
        else {
            System.out.print(node.data);
            if(node.next!=null) {System.out.print(", ");}
            printlist(node.next);
        }
    }//end of the method
    public static void main(String[] args) {
        Scanner MyInput = new Scanner(System.in);
        String list = MyInput.nextLine().replaceAll("\\[|\\]", "");
        arr = list.split(", ");
        length = arr.length;
        DoubleLinkedList obj = new DoubleLinkedList();
        if(arr.length == 1 && arr[0].isEmpty())
            head = null;
        else {
            for(String i: arr) {
                obj.add(Integer.parseInt(i));
            }
        }
        String op = MyInput.nextLine();
        switch (op) {
            case "addToIndex":
                int index = MyInput.nextInt();
                String Ivalue = MyInput.nextLine();
                Ivalue = MyInput.nextLine();
                obj.add(index,Integer.parseInt(Ivalue));
                break;
            case "add":
                String value = MyInput.nextLine();
                obj.add(Integer.parseInt(value));
                System.out.print("[");
                printlist(head);
                break;
            case "get":
                int ind = MyInput.nextInt();
                obj.get(ind);
                break;
            case "set":
                int inde = MyInput.nextInt();
                String val = MyInput.nextLine();
                val = MyInput.nextLine();
                obj.set(inde, val);
                break;
            case "clear":
                obj.clear();
                System.out.print("[");
                printlist(head);
                break;
            case "isEmpty":
                obj.isEmpty();
                break;
            case "remove":
                int in = MyInput.nextInt();
                obj.remove(in);
                break;
            case "size":
                obj.size();
                break;
            case "sublist":
                int from = MyInput.nextInt();
                int to = MyInput.nextInt();
                obj.sublist(from, to);
                break;
            case "contains":
                String i = MyInput.nextLine();
                obj.contains(Integer.parseInt(i));
                break;
        }
    }//end of main
}//end of class