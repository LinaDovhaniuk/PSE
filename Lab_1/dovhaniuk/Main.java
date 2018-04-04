package dovhaniuk;

import dovhaniuk.monitoring.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {

            br = new BufferedReader(new InputStreamReader(System.in));

            User currentUser = new User("user");
            System.out.println("Please enter role: admin, user");
            String userRole = br.readLine();

            if (userRole.equals("admin")) {
                currentUser.role = "admin";
            } else if (userRole.equals("user")) {
                currentUser.role = "user";
            } else {
                System.out.println("You've entered wrong role. Program will now exit.");
                System.exit(0);
            }

            while (true) {
                System.out.println();
                System.out.println("Please enter command. Available commands:");
                System.out.println(CommandLineProcessor.getAllCommands());

                String input = br.readLine();
                String[] params = input.split(" ");
                List<String> arguments = new ArrayList<>();

                if (params.length > 1) {
                    arguments.add(params[1]);
                }

                if (params.length > 2) {
                    arguments.add(params[2]);
                }

                CommandLineProcessor.processCommand(params[0], arguments, currentUser);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
