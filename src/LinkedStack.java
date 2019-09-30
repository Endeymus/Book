import java.lang.ref.PhantomReference;
import java.util.Scanner;

public class LinkedStack implements Stack {
    private Node head;
    private Node first;
    private int size;
    private field newField = new field();
    private ListOfLists links = new ListOfLists();

    LinkedStack(){
        String[] fields = {"", "Техническая литература", "Научная литература", "Художественная литература", "Справочная литература", "Сатира"};

        for (int i = 1; i<=5; i++){
            newField.fadd(i, fields[i]);
        }
        //System.out.println("Size of field : " + newField.getSize_field());
    }

    private static class Node {
        private int id;
        private int id_of_field;
        private String author;
        private String name;
        private int age;
        private Node next;

        Node(String author,int id_of_field, String name, int age, int id){
            this.author = author;
            this.id_of_field = id_of_field;
            this.name = name;
            this.age = age;
            this.id = id;
        }
    }
    public void addFirst(String author, int id_of_field, String name, int age, int id){
        Node NewNode = new Node(author, id_of_field, name, age, id);
        if(first == null){
            first = NewNode;
            head = NewNode;
        }
        else{
            NewNode.next = first;
            first = NewNode;
        }
        size++;
    }
    public void addBack(String author, int id_of_field, String name, int age, int id) {
        Node NewNode = new Node(author, id_of_field, name, age, id);
        if(head == null){
            first = NewNode;
            head = NewNode;
        }
        else{
            head.next = NewNode;
            head = NewNode;
        }
        size++;
    }
    public void del(String val, int overage) {
        Node temp = first;
            if (head == null) {
                System.out.println("Массив пуст.");
                return;
            }
            if (head == first && ( first.author.equals(val) || first.age > overage )) {
                clear();
                return;
            }
            if (first.author.equals(val) || first.age > overage) {
                first = first.next;
                size--;
            }

            while (temp.next != null) {
                if (temp.next.author.equals(val) || temp.next.age > overage) {
                    if (head == temp.next) {
                        head = temp;
                    }
                    temp.next = temp.next.next;
                }
                temp = temp.next;
            }
    }
    public void del(String val) {
        Node temp = first;
            if (head == null) {
                System.out.println("Массив пуст.");
                return;
            }
            if (head == first && first.author.equals(val)) {
                clear();
                return;
            }
            if (first.author.equals(val)) {
                first = first.next;
                size--;
                return;
            }

            while (temp.next != null) {
                if (temp.next.author.equals(val)) {
                    if (head == temp.next) {
                        head = temp;
                    }
                    temp.next = temp.next.next;
                }
                temp = temp.next;
            }
    }
    public void del(int overage) {

            if (head == null) {
                System.out.println("Массив пуст.");
                return;
            }
            if (head == first && (first.age > overage )) {
                clear();
                return;
            }
            if (first.age > overage) {
                first = first.next;
                size--;
                return;
            }
            Node temp = first;
            while (temp.next != null) {
                if (temp.next.age > overage) {
                    if(head == temp.next){
                        head = temp;
                        size--;
                        return;
                    }
                    temp.next = temp.next.next;
                    size--;
                    return;
                    }
                    temp = temp.next;
                }
    }
    public void show(){
        if ( head == null){
            System.out.println("Нечего выводить.");
            return;
        }
        StringBuilder ListString = new StringBuilder();
        Node temp = first;
        while(temp!=null){
            ListString.append("[ ").append(temp.id).append(" ][ ").append(newField.getValue(temp.id_of_field)).append(" ][ " ).append(temp.author).append(" ][ ").append(temp.name).append(" ][ ").append(temp.age).append(" ]");
            temp = temp.next;
            System.out.println(ListString);
            ListString = new StringBuilder();
        }
    }
    @Override
    public void clear() {
        head = null;
        first = null;
        size = 0;
    }
    public void addIn(int pos,int id_of_field, String author, String name, int age, int id){
        Node temp = first;
        Node NewNode;
        if (pos == 0){
            addFirst(author, id_of_field, name, age, id);
            return;
        }
        if(head.id == pos){
            addBack(author, id_of_field, name, age, id);
            return;
        }
        while (temp.id != pos){
            if (temp == head){
                System.out.println("Такого id нет.");
                return;
            }
            temp = temp.next;
        }
        NewNode = new Node(author, id_of_field, name, age, id);
        NewNode.next = temp.next;
        temp.next = NewNode;
    }
    @Override
    public int getSize() {
        return size;
    }
    @Override
    public void newStack(LinkedStack stack) {
        LinkedStack NewStack1 = new LinkedStack();
        links = new ListOfLists();
        Node temp = first;
        if (stack.isEmpty()){
            System.out.println("is empty");
            return; //null;
        }
        int i = 1;
        while (i < newField.getSize_field()){
            while (temp!=null) {
                if (temp.id_of_field == i) {
                    NewStack1.addBack(temp.author, temp.id_of_field, temp.name, temp.age, temp.id);
                }
                temp = temp.next;
            }
            links.linked(i, NewStack1);
            i++;
            temp = first;
            NewStack1 = new LinkedStack();
        }
    }
    public void fildShow(){
        newField.show();
    }
    @Override
    public boolean isEmpty(){
        return (first == null);
    }
    @Override
    public void out(int id) {
        links.out(id);
    }
    public int find_over(int overage){
        int value = 0;
        Node temp = first;
        while (temp != null){
            if( temp.age > overage){
                value ++;
            }
            temp = temp.next;
        }
        return value;
    }
    public int find_aut(String author){
        int value = 0;
        Node temp = first;
        while (temp != null){
            if( temp.author.equals(author)){
                value ++;
            }
            temp = temp.next;
        }
        return value;
    }
    public int find_overaut(String author, int overage){
        int value = 0;
        Node temp = first;
        while (temp != null){
            if( temp.author.equals(author) || temp.age > overage){
                value ++;
            }
            temp = temp.next;
        }
        return value;
    }
}
