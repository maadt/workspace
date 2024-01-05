package exception;

public class Teacher {
    public static void main(String[] args) {

        String issue = "動画作成課題";
        Student student = new Student();
        //Homework homework = student.doHomework(issue);
        Homework homework = null;

        try {
            homework = student.doHomework(issue);
            if (checkHomework(homework)) {
                System.out.println(homework.getContent() + "を採点します。");
        }
        } catch (StudentException e) {
            e.printStackTrace();
        }

        /*
        if (checkHomework(homework)) {
            System.out.println(homework.getContent() + "を採点します。");
        }
        */
    }

    private static boolean checkHomework(Homework homework) {
        if (homework == null || homework.getContent().isEmpty()) {
            return false;
        }
        return true;
    }
}
