import java.util.*;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    private static void printDelim() {
        System.out.println("\nВыберите действие:\n" +
                "1. Вывести список задач\n" +
                "2. Добавить задачу\n" +
                "3. Удалить задачу\n" +
                "0. Выход");
    }

    private static void taskList(List<String> notebook) {
        if (notebook.isEmpty()) {
            System.out.println("Список пуст, необходимо добавить задачу");
        } else {
            for (int i = 0; i < notebook.size(); i++)
                System.out.println((i + 1) + ". " + notebook.get(i));
        }
    }

    private static void addTask(List<String> notebook) {
        String addTask = scanner.nextLine();
        notebook.add(addTask);
    }

    private static void deleteTask(List<String> notebook) {
        if (notebook.isEmpty()) {
            System.out.println("Список пуст, необходимо добавить задачу");
        } else {
            String deleteTask = scanner.nextLine();
            int numberTask = Integer.parseInt(deleteTask) - 1;
            notebook.remove(numberTask);
        }
    }

    public static void main(String[] args) {
        List<String> notebook = new ArrayList<>();
        printDelim();
        try {
            while (true) {
                String input = scanner.nextLine();
                int operation = Integer.parseInt(input);
                if (operation == 0) {
                    break;
                }
                switch (operation) {
                    case 1:
                        System.out.println("Список задач:");
                        taskList(notebook);
                        printDelim();
                        break;
                    case 2:
                        System.out.println("Введите задачу для планирования:");
                        addTask(notebook);
                        printDelim();
                        break;
                    case 3:
                        System.out.println("Введите номер задачи для удаления:");
                        deleteTask(notebook);
                        printDelim();
                        break;
                    default:
                        System.out.println("Такой операции нет");
                        printDelim();
                }
            }
        } catch (RuntimeException exception) {
            System.out.println("Введенные данные не корректны");
        }
        System.out.println("Программа завершена!");
    }
}