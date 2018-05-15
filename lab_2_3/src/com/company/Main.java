package com.company;
import lab3.Queue;
import lab3.Stack;

import static com.company.lab_2.array_print;
import static com.company.lab_2.sort_selection;


public class Main {

    public static void main(String[] args) {

//        first_task();
        second_task();
    }

    public static void first_task(){
        String[] tasks = new String[]{
                "Identify project",
                "Define goals and objectives",
                "Define tasks",
                "Build team",
                "Create a timeline",
                "Get feedback",
                "Adjust plan accordingly",
                "Delegate tasks",
                "Prioritize tasks",
                "Write tommorow`s task today"
        };

        System.out.println("Initial array:\n");
        array_print(tasks);

        System.out.println("\nThe array has been sorted in ascending order:\n");
        sort_selection(tasks, true);
        array_print(tasks);

        System.out.println("\nThe array hac been sorted in descending order:\n");
        sort_selection(tasks, false);
        array_print(tasks);

        System.out.println("\nThe program finished working");
    }

    public static void second_task(){
        stack_demonstration();
        System.out.println("\n\n\n\n\n");
        queue_demonstation();

        // End of program
        System.out.println("\nThe program has finished working.");
    }

    static void stack_demonstration() {
        Stack s = new Stack(5);
        String[] notifications = new String[] {
                "18.04: Task completed (100%) by Thomas",
                "23.03: Task in progress (50%) by Andrew",
                "11.09: Task completed (100%) by Nikolai",
                "10.06: Task in progress (27%) by Mike",
                "12.12: Task in progress (89%) by Georg"
        };

        // notifications sent to Administartor
        for(String n: notifications) {
            System.out.println("Notification sent: " + n);
            s.push(n);
        }

        System.out.println();
        s.output();

        // Administartor checks the notifications:
        for(;s.isEmpty() != true;) {
            System.out.println("Notification received: " + s.pop());
        }
    }

    static void queue_demonstation() {
        Queue q = new Queue(10);
        String[] tasks = new String[] {
                "Identify project",
                "Define goals and objectives",
                "Define tasks",
                "Build team",
                "Create a timeline",
                "Get feedback",
                "Adjust plan accordingly",
                "Delegate tasks",
                "Prioritize tasks",
                "Write tommorow`s task today"
        };

        // Administrator adds all the tasks:
        for(String t: tasks) {
            System.out.println("Added task: " + t);
            q.enqueue(t);
        }

        System.out.println();
        q.output();

        // Developer copes with all the tasks:
        for(;q.isEmpty() != true;) {
            System.out.println("Coped with task: " + q.dequeue());
        }
    }

    }

