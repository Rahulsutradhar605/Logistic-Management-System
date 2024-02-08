package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class LoginScreen {
    private static final Map<String, String> users = new HashMap<>();
    private static final Map<String, String> userRoles = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n             //" + "\\\\" + " Hello " + "//" + "\\\\");
            System.out.println("=========================================");
            System.out.println("Welcome to the Logistic Management System");
            System.out.println("=========================================\n\n");
            System.out.println("Please choose an option (Enter 1 OR 2): \n     1. REGISTER \n     2. LOGIN");
            String option = sc.nextLine();

            if (option.equals("1")) {
                registerUser(sc);
            } else if (option.equals("2")) {
                loginUser(sc);
            } else {
                System.out.println("Invalid option. Please choose option '1 or 2' for LOGIN or REGISTER.");
            }
        }
    }

    private static void loginUser(Scanner sc) {
        System.out.println("Login:");
        System.out.println("Enter your role (ADMIN / CUSTOMER / OTHER USER): ");
        String role = sc.nextLine();
        System.out.println("Enter your username:");
        String username = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();

        if (login(role, username, password)) {
            System.out.println("\nLogged in successfully for: " + username + "!");
            displayUserInfo(username, role);
        } else {
            System.out.println("\nLogin failed. Try again.\n");
        }
    }

    private static void displayUserInfo(String username, String role) {
        System.out.println("\nUser Information:");
        System.out.println("Username: " + username);
        System.out.println("Role: " + role);

        // Add more information based on your requirements
        if ("ADMIN".equals(role)) {
            System.out.println("You have ADMIN privileges.");
        } else if ("CUSTOMER".equals(role)) {
            System.out.println("You have CUSTOMER privileges.");
        } else {
            System.out.println("You have privileges for OTHER USER.");
        }
    }

    private static void registerUser(Scanner sc) {
        System.out.println("Registration:");
        System.out.println("Enter your role (ADMIN / CUSTOMER / OTHER USER): ");
        String role = sc.nextLine();
        System.out.println("Username:");
        String username = sc.nextLine();
        System.out.println("Password:");
        String password = sc.nextLine();
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Address:");
        String address = sc.nextLine();
        System.out.println("Email ID:");
        String email = sc.nextLine();
        register(role, username, password, name, address, email);
        System.out.println("\nCongratulations! Registration Done for " + username + "!\n");
    }

    private static boolean login(String role, String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password) && userRoles.get(username).equals(role);
    }

    private static void register(String role, String username, String password, String name, String address, String email) {
        users.put(username, password);
        userRoles.put(username, role);
    }
}

// Login, Order, Product details,