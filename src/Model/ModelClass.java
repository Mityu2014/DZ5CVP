package Model;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;


import java.util.List;

import static Controller.ControllerClass.language; // флаг языка

/**
 * Класс для модели обработки команд списка студентов (list)
 */
public class ModelClass implements iGetModel {
    private List<Student> students; // список студентов

    /**
     * Конструктор класса с параметрами
     * @param students список студентов
     */
    public ModelClass(List<Student> students) {
        this.students = students;
    }

    /**
     * Метод возвращающий весь список студентов
     * @return список студентов
     */
    public List<Student> getAllStudents() {
        return students;
    }

    /**
     * Метод для удаления студента из списка через ID
     * @param id студента для удаления
     */
    @Override
    public void delStudent(Integer id) {
        boolean b = students.removeIf(student -> student.getId() == id); //проверка налисие записи/студента в списке (по ID)
                                                                        // и удаление записи/сдудента из списка
        if (!b){
            if (language){
                System.out.println("С таким ID студента нет");
            }else {
                System.out.println("There is no student with this ID");
            }
        }
    }
}
