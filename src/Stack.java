public interface Stack {
    void addFirst(String author, int id_of_field, String name, int age, int id);
    void addBack(String author, int id_of_field, String name, int age, int id);
    void show();
     void clear();
     void del(String val, int overage);
     void del(String val);
     void del(int overage);
    void addIn(int pos,int id_od_field, String author, String name, int age, int id);
    int getSize();
    void newStack(LinkedStack stack);
    void fildShow();
    boolean isEmpty();
    int find_over(int value);
    int find_aut(String author);
    int find_overaut(String author, int overage);
    void out(int id);
}