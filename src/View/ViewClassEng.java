package View;

import Controller.Interfaces.iGetView;
import Model.Domain.Student;

import java.util.List;
import java.util.Scanner;

/**
 * Класс представления на английском языке
 */
public class ViewClassEng implements iGetView {
    /**
     * Метод вывода списка студентов в терминал
     * @param students список студентов
     */
    public void printAllStudents(List<Student> students)
    {
        System.out.println("--------------------List of students-------------------");
        for(Student s: students)
        {
            System.out.println(s);
        }
        System.out.println("-------------------------------------------------------");
    }
    /**
     * Метод запроса ввода команды
     * @param msg Информацинное сообщение пользователю
     * @return введенную команду для вподнения
     */
    public String prompt(String msg)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }
}
