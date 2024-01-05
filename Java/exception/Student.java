package exception;

public class Student{
    public Homework doHomework(String title) throws StudentException {

        NotePc pc = new NotePc();
        Homework homework = null;

        try {
            homework = pc.createHomework(title);
        } catch (SpecException e) {
            throw new StudentException("容量の増やし方が分かりません。", e);
        }

        /*
        Homework homework = pc.createHomework(title);
        */

        return homework;
    }
}
