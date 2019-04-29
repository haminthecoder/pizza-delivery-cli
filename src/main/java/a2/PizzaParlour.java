package a2;

import java.util.Scanner;
import java.util.*;

public class PizzaParlour {
    private final String password = "1234";

    public static void main(String[] args) {
        PizzaParlour pizzaParlour = new PizzaParlour();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to 301 Pizza!: ");
        System.out.println("Are you the owner? (y/n)");

        String response = scanner.nextLine();

        if (response.equals("y") || response.equals("Y")) {
            System.out.println("Enter your password: ");
            response = scanner.nextLine();
            if (response.equals(pizzaParlour.password)) {
                PizzaOrder pizzaStore = new PizzaOrder();
                pizzaStore.addPizza(pizzaStore, scanner);
            }
        } else {

            PizzaOrder pizzaOrder = new PizzaOrder();
            System.out.println("Welcome to 301 Pizza!: ");
            System.out.println("Select one of the options :");
            System.out.println("1) Pizza Order 2) Display Menu ");

            String optionResponse = scanner.nextLine();
            pizzaOrder.optionResponse(pizzaOrder, optionResponse, scanner);



            scanner.close();
        }
    }
}