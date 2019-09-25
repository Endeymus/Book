public class LinkedStack implements Stack {
    private Node head;
    private int size;

    private class Node {
        private int id;
        private String author;
        private String name;
        private int age;
        private Node next;


        private Node(Node next, String author, String name, int age, int id){
            this.id = id;
            this.next = next;
            this.author = author;
            this.name = name;
            this.age = age;
        }
    }
    public void push(String author, String name, int age, int id){
        size++;
        head = new Node(head, author, name, age, id);
    }
    public void pop(){
        if(head == null)
        {
            return;
        }
        head.next = head;
        size--;
    }
    public void peek(){
        if ( head == null){
            return;
        }
        StringBuilder ListString = new StringBuilder();
        Node temp = head;
        for( int i = 0; i < size ; i++){
            ListString.append(temp.id).append("|").append(temp.author).append("|").append(temp.name).append("|").append(temp.age).append(" ");
            temp = temp.next;
            System.out.println(ListString);
            ListString = new StringBuilder();
        }
    }

    public Stack delA( String elem){
        Node temp = head;
        LinkedStack NewStack = new LinkedStack();
        int i = 1, j = getSize();
        for (int k = 0; k < getSize(); k++){
            while (i!= j){
                temp = temp.next;
                i++;
            }
            if (!temp.author.equals(elem)) {
                NewStack.push(temp.author, temp.name, temp.age, temp.id);
                j--;
                i = 1;
            }
            temp = head ;
        }
        NewStack.peek();
        return NewStack;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    public void addIn(int pos, String author, String name, int age, int id){
        Node temp = head;
        if(pos < 0){pos = 0;}
        if (pos < size) {
            int i;
            for (i = size; i > pos; i--) {
                temp = temp.next;
            }
            Node NewTemp = new Node(temp, author, name, age, id);
            size++;
            i = size;
            temp = head;
            while (i != pos + 2) {
                temp = temp.next;
                i--;
            }
            temp.next = NewTemp;
        }
        else{
            push(author, name, age, id);
        }

    }

    @Override
    public int getSize() {
        return size;
    }

}
