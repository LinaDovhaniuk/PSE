package dovhaniuk.monitoring;

import java.util.Arrays;
import java.util.List;

public class RoleManager {
    public static boolean canPerformAction(String action, String role) {
        if (role.equals("admin")) {
            return ADMIN_ACTIONS.contains(action);
        }
        if (role.equals("user")) {
            return USER_ACTIONS.contains(action);
        }
        return false;
    }

    public static List<String> ADMIN_ACTIONS = Arrays.asList(
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

    public static List<String> USER_ACTIONS = Arrays.asList("create_team",
            "assign_task",
            "set_task_status",
            "show_all_tasks",
            "exit"
    );
}
