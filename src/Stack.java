public interface Stack {
    void push(String author, String name, int age, int id);
    void peek();
     Stack delA( String o);
     void clear();
     void pop();
    void addIn(int pos, String author, String name, int age, int id);
    int getSize();
}