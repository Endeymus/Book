import java.util.Scanner;
public class Book {
    private static int const_id = 0;
    private static void fill(Stack stack){
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++){
            System.out.println("Введите имя автора: ");
            String aut = in.nextLine();
            System.out.println("Введите область данных, где область данных состоит из: ");
            stack.fildShow();
            int fil = in.nextInt();
            in.nextLine();
            System.out.println("Введите Название книги: ");
            String nm = in.nextLine();
            System.out.println("Введите год издания: ");
            int ag = in.nextInt();
            in.nextLine();
            stack.addBack(aut, fil, nm, ag, ++const_id);
        }
    } //Заполнить списко 5-ю элементами
    private static void fill(Stack stack, int n){ //Заполнить список N-элементами
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; i++){
            System.out.println("Введите имя автора: ");
            String aut = in.nextLine();
            System.out.println("Введите область данных, где область данных состоит из: ");
            stack.fildShow();
            int fil = in.nextInt();
            System.out.println("Введите Название книги: ");
            String nm = in.nextLine();
            System.out.println("Введите год издания: ");
            int ag = in.nextInt();
            in.nextLine();
            stack.addBack(aut, fil, nm, ag, ++const_id); //Добавляем введенные данные в конец списка
        }
    }
    private static void fillRand(Stack stack) {
        for (int i = 1; i <= 5; i++){
            String[] aut ={"", "Брюс Эккель", "Николас Спаркс", "Айн Рэнд", "Лев Николаевич", "Михаил Шолохов"};
            String[] nm ={"", "Введение в Java", "Спеши любить", "Атлант расправил плечи", "Война и мир", "Тихий Дон"};
            int[] id_f ={0,1,3,3,3,3};
            int[] ag = {0,1998,1999,1957,1869,1940,0};
            stack.addBack(aut[i], id_f[i], nm[i],ag[i],++const_id);
        }
    }
    private static void delAllAuthors(Stack stack){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя автора: ");
        String aut = in.nextLine();
        int j = stack.find_aut(aut);
        for (int i = 0; i < j; i++) {
            stack.del(aut);
        }
    }
    private static void delAllAge(Stack stack){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите дату издания: ");
        int n = in.nextInt();
        in.nextLine();
        System.out.println(stack.find_over(n));
        int j = stack.find_over(n);
        for (int i = 0; i < j; i++) {
            stack.del(n);
        }
    }
    private static void delAllAuthorsAge(Stack stack){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя автора: ");
        String aut = in.nextLine();
        System.out.println("Введите дату издания: ");
        int n = in.nextInt();
        int j = stack.find_overaut(aut, n);
        for ( int i = 0 ; i < j; i++) {
            in.nextLine();
        }
        stack.del(aut, n);
    }
    private static void addNewLink(Stack stack){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id, после которого хотите вставить элемент: ");
        int pos = in.nextInt();
        in.nextLine();
        System.out.println("Введите имя автора: ");
        String aut = in.nextLine();
        System.out.println("Введите область данных, где область данных состоит из: ");
        stack.fildShow();
        int fil = in.nextInt();
        System.out.println("Введите Название книги: ");
        String nm = in.nextLine();
        System.out.println("Введите год издания: ");
        int ag = in.nextInt();
        in.nextLine();
        stack.addIn(pos, fil, aut,nm,ag,++const_id);
    }
    private static void menu_two(){
        System.out.println("1. Удалить из списка все узлы с указанным автором");
        System.out.println("2. Удалить из списка все узлы которые изданы позже указанного года");
        System.out.println("3. Удалить из списка все узлы с указанным автором и которые изданы позже указанного года");
        System.out.println("4. Вернуться назад");
    }
    private static void menu_one(){
        System.out.println("1. Заполнить список 5 авторами");
        System.out.println("2. Заполнить список N авторами");
        System.out.println("3. Заполнить список 5 дефолтными значениями");
        System.out.println("4. Вернуться назад");
    }
    private static void menu(){
        System.out.println("1. Заполнить список");
        System.out.println("2. Удаление элементов списка");
        System.out.println("3. Добавить в стэк новый узел с заданной позиции");
        System.out.println("4. Вывести стэк");
        System.out.println("5. Сформировать новый список из значений списков по областям знаний, включив название области только один раз");
        System.out.println("6. Очистить стэк");
        System.out.println("7. Выйти");

    }
    public static void main(String[] args){
        LinkedStack stack = new LinkedStack();
        Scanner in = new Scanner(System.in);
        int N, id;
        int a = 0, a_one = 0, a_two = 0;
        do{
            menu();
                if (in.hasNextInt()) {
                    a = in.nextInt();
                } else {
                    in.next();
                    System.out.println("Type a number, not a text");
                    continue;
                }
            switch (a){
                case 1:
                    do{
                        menu_one();
                        if (in.hasNextInt()){
                            a_one = in.nextInt();
                        } else {
                            in.next();
                            System.out.println("Type a number, not a text");
                            continue;
                        }
                        switch (a_one){
                            case 1:
                                fill(stack);
                                System.out.println("\n Done!");
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
                                System.out.println("Back!");
                                break;
                        }
                    } while (a_one != 4);
                    break;
                case 2:
                    do{
                        menu_two();
                        if (in.hasNextInt()){
                            a_two = in.nextInt();
                        } else {
                            in.next();
                            System.out.println("Type a number, not a text");
                            continue;
                        }
                        switch (a_two){
                            case 1:
                                delAllAuthors(stack);
                                System.out.println("Done!");
                                break;
                            case 2:
                                delAllAge(stack);
                                System.out.println("Done!");
                                break;
                            case 3:
                                delAllAuthorsAge(stack);
                                System.out.println("Done!");
                                break;
                            case 4:
                                System.out.println("Back!");
                                break;
                        }
                    } while (a_two != 4);
                    break;
                case 3:
                    addNewLink(stack);
                    System.out.println("Done!");
                    break;
                case 4:
                    System.out.println("Stack :");
                    stack.show();
                    break;
                case 5:
                    stack.newStack(stack);
                    System.out.println("Введите номер области, введите 0, если хотите вывести отсортированный по областям: ");
                    id = in.nextInt();
                    in.nextLine();
                    stack.out(id);
                    break;
                case 6:
                    stack.clear();
                    System.out.println("Done!");
                    break;
                case 7:
                    System.out.println("BYE!");
                    break;
                default:
                    System.out.println("Incorrect input");
                    break;
            }
        } while (a!=7);
    }
}
