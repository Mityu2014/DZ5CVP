/**
Интерфейс для создания моделей
 */
package Controller.Interfaces;

import Model.Domain.Student;

import java.util.List;

public interface iGetModel {
    /**
     * Метод возвращающий весь список студентов
     */
    public List<Student> getAllStudents();

    /**
     * Метод для удаления студента из списка через ID
     * @param id студента для удаления
     */
    public void delStudent(Integer id);
}
