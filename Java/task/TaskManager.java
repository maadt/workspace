import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.time.format.DateTimeParseException;

public class TaskManager {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        List<Task> tasks = new ArrayList<Task>();
        List<Object> sampleTaskData = new ArrayList<Object>();
        sampleTaskData.add("タスク管理課題");
        sampleTaskData.add(LocalDateTime.parse("2023-11-22 23:59", formatter));

        try {
            Task sampleTask = new Task(sampleTaskData);
            tasks.add(sampleTask);

            while (true) {
                System.out.println("1. タスク追加");
                System.out.println("2. タスク一覧表示");
                System.out.println("3. 終了");
                System.out.print("選択してください: ");
                int choice = Integer.parseInt(reader.readLine());

                if (choice == 1) {
                    System.out.print("タスクのタイトルを入力してください: ");
                    String title = reader.readLine();

                    System.out.print("タスクの期限（yyyy-MM-dd HH:mm）を入力してください: ");
                    String dueDateString = reader.readLine();
                    LocalDateTime dueDate = LocalDateTime.parse(dueDateString, formatter);

                    //Q4 タスクの追加処理を呼び出して動作確認
                    addTask(tasks, title, dueDate);
                } else if (choice == 2) {
                    //Q3 タスクの一覧表示処理を呼び出して動作確認
                    displayTasks(tasks);
                } else if (choice == 3) {
                    break;
                } else {
                    System.out.println("無効な選択です。");
                }
            }
        // Q2 catchの()内に数値、入力、日付の例外処理を実装してください。
        } catch (NumberFormatException | IOException | DateTimeParseException e) {
            System.out.println("無効な入力です。");
        // Q2 catchの()内に不正な引数の例外処理を実装してください。
        } catch (IllegalArgumentException e) {
            System.out.println("不正なデータです。");
        } finally {
            System.out.println("プログラムを終了します。");
        }
    }

    // Q4 addTaskメソッドを実装してください
    static void addTask(List<Task> tasks, String title, LocalDateTime dueDate) {
        List<Object> sampleTaskData = new ArrayList<Object>();
        sampleTaskData.add(title);
        sampleTaskData.add(dueDate);
        Task sampleTask = new Task(sampleTaskData);
        tasks.add(sampleTask);
        System.out.println("タスクが追加されました。");
        displayTasks(tasks);
    }

    // Q3 displayTasksメソッドを実装してください
    static void displayTasks(List<Task> tasks) {
        System.out.println("タスク一覧:");

        for (Task taskList : tasks) {//変数定義と同時にTaskクラスのインスタンス生成も行なっている
            System.out.println(taskList.showTask());
        }
    }
}

//Q1 Taskクラスを実装してください
class Task {
    private String title;
    private LocalDateTime dueDate;
    // 処理
    public Task(List<Object> taskData) throws IllegalArgumentException {
        if (taskData.size() != 2) {
            throw new IllegalArgumentException();
        } else if (taskData.size() == 2) {
            for (Object element : taskData) {
                if (element instanceof String) {
                    this.title = (String) element;
                } else if (element instanceof LocalDateTime) {
                    this.dueDate = (LocalDateTime) element;
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String showTask() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "タイトル: " + title + " 期限: " + dueDate.format(formatter);
    }
}
