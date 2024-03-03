package Controller;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс отвечающий за обработку запросов пользователя
 */
public class ControllerClass {
    private iGetModel model; // Поле переданной модели
    private iGetView view; // Поле переданного вида
    private List<Student> bufferStudentList = new ArrayList<Student>(); // Список студентов
    public static boolean language = false; // флаг языка

    /**
     * Конструктор класса со всеми параметрами
     * @param model передаваемая модель
     * @param view передаваемый вид
     */
    public ControllerClass(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Метод/флаг проверки наличия студентов в передаваемом списке
     * @param students список студентов
     * @return булевое значение проверки
     */
    private boolean testData(List<Student> students) {
        if (students.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод запуска обработки и вывода списка студентов
     */
    public void update() {
        // MVC
        // view.printAllStudent(model.getStudents());

        // MVP
        bufferStudentList = model.getAllStudents();
        if (testData(bufferStudentList)) {
            view.printAllStudents(bufferStudentList);
        } else {
            if (language){
                System.out.println("Список студентов пуст!");
            }else {
                System.out.println("The list of students is empty!");
            }
        }

    }

    /**
     * Метод запуска обратоки запросов/команд пользователя над списком студентов
     */
    public void run() {

        Command com = Command.NONE;
        boolean getNewIteration = true; // флаг для выхода из запроса команд
        while (getNewIteration) {
            if (language){
                String command = view.prompt("Enter the command: ");
                com = Command.valueOf(command.toUpperCase());
            }else {
                String command = view.prompt("Введите команду: ");
                com = Command.valueOf(command.toUpperCase());
            }
            switch (com) {
                case EXIT: //выход из ввода команд
                    getNewIteration = false;
                    if (language){
                        System.out.println("Выход из программы!");
                    }else {
                        System.out.println("Exit the program!");
                    }

                    break;
                case LIST: // вывод списка студентов
                    view.printAllStudents(model.getAllStudents());
                    break;
                case DELETE: // удаление записи/студента из списка
                    Scanner in = new Scanner(System.in);
                    if (language){
                        System.out.println("Введите ID удаляемого студента: ");
                    }else {
                        System.out.println("Enter the ID of the student you are deleting:");
                    }

                    int id = in.nextInt();
                    model.delStudent(id);
                    break;
            }
        }
    }
}
