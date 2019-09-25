import java.util.Scanner;
public class Book {
    static int const_id = 0;
    Scanner in = new Scanner(System.in);
    public static void fill(Stack stack){
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++){
            System.out.println("Введите имя автора: ");
            String aut = in.nextLine();
            System.out.println("Введите Название книги: ");
            String nm = in.nextLine();
            System.out.println("Введите год издания: ");
            int ag = in.nextInt();
            in.nextLine();
            stack.push(aut, nm, ag, ++const_id);
        }
    }
    public static void fill(Stack stack, int n){
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; i++){
            System.out.println("Введите имя автора: ");
            String aut = in.nextLine();
            System.out.println("Введите Название книги: ");
            String nm = in.nextLine();
            System.out.println("Введите год издания: ");
            int ag = in.nextInt();
            in.nextLine();
            stack.push(aut, nm, ag, ++const_id);
        }
    }

    public static void fillRand(Stack stack) {
        for (int i = 1; i <= 5; i++){
            stack.push(String.valueOf(i),String.valueOf(i),i,++const_id);
        }
    }
    public static void fillRand(Stack stack, int N) {
        for (int i = 1; i <= N; i++){
            stack.push(String.valueOf(i),String.valueOf(i),i,++const_id);
        }
    }
    public static void delAllAuthors(Stack stack){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя автора: ");
        String aut = in.nextLine();
          stack.delA(aut);
    }
    public static void addNewLink(Stack stack){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите позицию вставки: ");
        int pos = in.nextInt();
        in.nextLine();
        System.out.println("Введите имя автора: ");
        String aut = in.nextLine();
        System.out.println("Введите Название книги: ");
        String nm = in.nextLine();
        System.out.println("Введите год издания: ");
        int ag = in.nextInt();
        in.nextLine();
        stack.addIn(pos,aut,nm,ag,++const_id);
    }
    public static void menu(){
        System.out.println("1. Заполнить стэк 5 авторами");
        System.out.println("2. Заполнить стэк N авторами");
        System.out.println("3. Заполнить стэк значениями от 1 до 5");
        System.out.println("4. Заполнить стэк значениями от 1 до N");
        System.out.println("5. Удалить из стэка все узлы с указанным автором");
        System.out.println("6. Добавить в стэк новый узел с заданной позиции");
        System.out.println("7. Вывести стэк");
        System.out.println("8. Очистить стэк");
        System.out.println("9. Выйти");
    }
    public static void main(String[] args){
        LinkedStack stack = new LinkedStack();
        Scanner in = new Scanner(System.in);
        int N;
        int a;
        do{
            menu();
            a = in.nextInt();
            in.nextLine();
            switch (a){
                case 1:
                    fill(stack);
                    break;
                case 2:
                    System.out.print("Введите количество элементов: ");
                    N = in.nextInt();
                    in.nextLine();
                    fill(stack, N);
                    System.out.println("\n Done!");
                    break;
                case 3:
                    fillRand(stack);
                    System.out.println("Done!");
                    break;
                case 4:
                    System.out.print("Введите количество элементов: ");
                    N = in.nextInt();
                    in.nextLine();
                    fillRand(stack, N);
                    System.out.println("\n Done!");
                    break;
                case 5:
                    delAllAuthors(stack);
                    System.out.println("Done!");
                    break;
                case 6:
                    addNewLink(stack);
                    System.out.println("Done!");
                    break;
                case 7:
                    System.out.println("Stack :");
                    stack.peek();
                    break;
                case 8:
                    stack.clear();
                    break;
            }
        } while (a!=9);
    }
}
