package dovhaniuk.monitoring;

import java.util.Random;

public class Task {
    public int id;
    public String name;
    public String status;
    public int workerId;

    public Task(String name) {
        this.id = new Random().nextInt(100);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", workerId=" + workerId +
                '}';
    }
}
