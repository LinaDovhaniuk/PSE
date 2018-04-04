package dovhaniuk.monitoring;

import java.util.Random;

public class Worker {
    public String name;
    public int id;

    public Worker(String name) {
        this.name = name;
        this.id = new Random().nextInt(100);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
