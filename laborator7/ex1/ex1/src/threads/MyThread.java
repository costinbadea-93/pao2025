package threads;

public class MyThread extends Thread {

    private Task task;

    public MyThread(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
       task.executeTask();
    }
}
