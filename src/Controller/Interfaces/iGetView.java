package Controller.Interfaces;

import Model.Domain.Student;

import java.util.List;

/**
 * Интерфейс создания вида предоставления информации пользователю

 */
public interface iGetView {
    /**
     * Метод вывода списка студентов в терминал
     * @param students список студентов
     */
    public void printAllStudents(List<Student> students);

    /**
     * Метод запроса ввода команды
     * @param msg Информацинное сообщение пользователю
     * @return введенную команду для вподнения
     */
    public String prompt(String msg);
}
