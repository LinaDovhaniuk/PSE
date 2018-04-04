package dovhaniuk.monitoring;

import java.util.ArrayList;
import java.util.List;

public class Team {
    public List<Worker> workers = new ArrayList<>();
    public String name;

    public Team(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "workers=" + workers +
                ", name='" + name + '\'' +
                '}';
    }
}
