package dovhaniuk.monitoring;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Task> tasks = new ArrayList<>();
    public static List<Worker> workers = new ArrayList<>();
    public static List<Team> teams = new ArrayList<>();

    public static Task getTask(String name) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).name.equals(name)) {
                return tasks.get(i);
            }
        }
        return null;
    }

    public static Worker getWorker(String name) {
        for (int i = 0; i < workers.size(); i++) {
            if (workers.get(i).name.equals(name)) {
                return workers.get(i);
            }
        }
        return null;
    }

    public static Team getTeam(String name) {
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).name.equals(name)) {
                return teams.get(i);
            }
        }
        return null;
    }
}
