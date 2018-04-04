package dovhaniuk;

import dovhaniuk.monitoring.*;

import java.util.Arrays;
import java.util.List;

public class CommandLineProcessor {
    public static void processCommand(String inputCommand, List<String> arguments, User user) {
        if (!COMMANDS_LIST.contains(inputCommand)) {
            System.out.println("No such command!");
        }

        if (RoleManager.canPerformAction(inputCommand, user.role)) {
            switch (inputCommand) {
                case "create_team":
                    Database.teams.add(new Team(arguments.get(0)));
                    System.out.println("Team " + arguments.get(0) + " created!");
                    System.out.println();
                    System.out.println("All teams:");
                    System.out.println(Database.teams.toString());
                    break;
                case "show_all_teams":
                    System.out.println("All teams:");
                    System.out.println(Database.teams.toString());
                    break;
                case "add_worker":
                    Database.workers.add(new Worker(arguments.get(0)));
                    System.out.println("Worker " + arguments.get(0) + " created!");
                    System.out.println();
                    System.out.println("All workers:");
                    System.out.println(Database.workers.toString());
                    break;
                case "add_worker_to_team":
                    Worker workerWithNoTeam = Database.getWorker(arguments.get(0));
                    if (workerWithNoTeam == null) {
                        System.out.println("No such worker!");
                        return;
                    }
                    Team teamToAddWorker = Database.getTeam(arguments.get(1));
                    if (teamToAddWorker == null) {
                        System.out.println("No such team!");
                        return;
                    }
                    teamToAddWorker.workers.add(workerWithNoTeam);
                    System.out.println("Worker " + workerWithNoTeam.name + " was added to the team " + teamToAddWorker.name);
                    System.out.println();
                    System.out.println("All teams:");
                    System.out.println(Database.teams.toString());
                case "show_all_workers":
                    System.out.println("All workers:");
                    System.out.println(Database.workers.toString());
                    break;
                case "create_task":
                    Database.tasks.add(new Task(arguments.get(0)));
                    System.out.println("Task " + arguments.get(0) + " created!");
                    System.out.println();
                    System.out.println("All tasks:");
                    System.out.println(Database.tasks.toString());
                    break;
                case "assign_task":
                    Task task = Database.getTask(arguments.get(0));
                    if (task == null) {
                        System.out.println("Task doesn't exist!");
                        return;
                    }
                    Worker worker = Database.getWorker(arguments.get(1));
                    if (worker == null) {
                        System.out.println("No such worker!");
                        return;
                    }
                    System.out.println("Task " + task.name + " assigned to worker " + worker.name);
                    System.out.println();
                    System.out.println("All tasks:");
                    System.out.println(Database.tasks.toString());
                case "set_task_status":
                    Task workingTask = Database.getTask(arguments.get(0));
                    if (workingTask == null) {
                        System.out.println("Task doesn't exist!");
                        return;
                    }
                    workingTask.status = arguments.get(1);
                    System.out.println("Task " + workingTask.name + " now has status "+ arguments.get(0));
                    System.out.println();
                    System.out.println("All tasks:");
                    System.out.println(Database.tasks.toString());
                    break;
                case "show_all_tasks":
                    System.out.println("All tasks: ");
                    System.out.println(Database.tasks.toString());
                    break;
                case "exit":
                    System.exit(0);
                    break;
            }
        } else {
            System.out.println("You don't have enough privileges");
        }

    }

    public static final List<String> COMMANDS_LIST = Arrays.asList(
            "create_team",
            "show_all_teams",
            "add_worker",
            "add_worker_to_team",
            "show_all_workers",
            "create_task",
            "assign_task",
            "set_task_status",
            "show_all_tasks",
            "exit"
    );

    public static final List<String> HUMAN_FRIENDLY_COMMANDS_LIST = Arrays.asList(
            "create_team 'team_name'",
            "show_all_teams",
            "add_worker 'worker_name'",
            "add_worker_to_team 'worker_name' 'team_name'",
            "show_all_workers",
            "create_task 'task_name'",
            "assign_task 'task_name' 'worker_name'",
            "set_task_status 'task_name' 'status'",
            "show_all_tasks",
            "exit"
    );

    public static String getAllCommands() {
        String result = "";
        for (int i = 0; i < HUMAN_FRIENDLY_COMMANDS_LIST.size(); i++) {
            result += HUMAN_FRIENDLY_COMMANDS_LIST.get(i) + "; ";
        }
        return result;
    }
}
