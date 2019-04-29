package a2;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Scanner;


public class PizzaOrder implements Pizza{
    // Initialize variables needed to submit order
    private String pizzaType;
    private List<String> pizzaTypes = new ArrayList<String>();
    private List<String> pizzaToppings = new ArrayList<String>();
    private String orderType;
    private List<String> drinks;
    private double price;
    private String pizzaSize;
    private int orderNumber;
    private String uberEatsJSON;
    private String foodoraCSV;

    // Setters
    public void setPizzaTypes(List<String> pizzaTypes) {
        this.pizzaTypes = pizzaTypes;
    }
    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }
    public void setPizzaToppings(List<String> pizzaToppings) {
        this.pizzaToppings = pizzaToppings;
    }
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
    public void setDrinks(List<String> drinks) {
        this.drinks = drinks;
    }
    public void setPizzaSize(String pizzaSize) { this.pizzaSize = pizzaSize; }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    // Getters
    public int getOrderNumber() {
        return orderNumber;
    }
    public List<String> getPizzaTypes() { return pizzaTypes; }
    public String getPizzaType() {
        return pizzaType;
    }
    public String getOrderType() {
        return orderType;
    }
    public List<String> getPizzaToppings() {
        return pizzaToppings;
    }
    public List<String> getDrinks() {
        return drinks;
    }
    public String getPizzaSize() { return pizzaSize; }

    // Total cost of the order = Price of the pizza + Delivery Price
    double totalPrice;
    double pizzaPrice;
    double drinkPrice;
    double deliveryPrice;
    double toppingPrice;

    // Function to determine the price of the pizza
//    Pizza Type : pepperoni, margherita, vegetarian, Neapolitan
    public double computePizzaPrice() {

        if (getPizzaType().equals("Pepperoni") || getPizzaType().equals("Vegetarian")) {
            pizzaPrice = 12.99;
            if (getPizzaSize().equals("M") || getPizzaSize().equals("m")) {
                pizzaPrice += 1.99;
            }
            else if (getPizzaSize().equals("L") || getPizzaSize().equals("L")) {
                pizzaPrice += 4.99;
            }
        }
        else if (getPizzaType().equals("Margherita")) {
            pizzaPrice = 19.99;
            if (getPizzaSize().equals("M") || getPizzaSize().equals("m")) {
                pizzaPrice += 1.99;
            }
            else if (getPizzaSize().equals("L") || getPizzaSize().equals("L")) {
                pizzaPrice += 4.99;
            }
        }
        else if (getPizzaType().equals("Neapolitan")) {
            pizzaPrice = 15.99;
            if (getPizzaSize().equals("M") || getPizzaSize().equals("m")) {
                pizzaPrice += 1.99;
            }
            else if (getPizzaSize().equals("L") || getPizzaSize().equals("L")) {
                pizzaPrice += 4.99;
            }
        }

        return pizzaPrice;
    }

    public double computeToppingPrice() {
        if (getPizzaToppings().size() > 2) {
            toppingPrice = getPizzaToppings().size() * 1.99;
        } else {
            toppingPrice = 0;
        }
        return toppingPrice;
    }


//Toppings : olives, tomatoes, mushrooms, jalapenos, chicken, beef, pepperoni
//    Drinks : Coke, Diet Coke, Coke Zero, Pepsi, Diet Pepsi, Dr. Pepper, Water, Juice
    public double computeDrinkPrice() {
        if (getDrinks().size() == 0) {
            drinkPrice = 0;
        } else {
            for (int i = 0; i < getDrinks().size(); i++) {
                if (getDrinks().get(i).equals("Coke")) {
                    drinkPrice += 1.99;
                }
                else if (getDrinks().get(i).equals("Diet Coke")) {
                    drinkPrice += 2.49;
                }
                else if (getDrinks().get(i).equals("Coke Zero")) {
                    drinkPrice += 2.49;
                }
                else if (getDrinks().get(i).equals("Pepsi")) {
                    drinkPrice += 1.99;
                }
                else if (getDrinks().get(i).equals("Diet Pepsi")) {
                    drinkPrice += 2.49;
                }
                else if (getDrinks().get(i).equals("Dr. Pepper")) {
                    drinkPrice += 1.99;
                }
                else if (getDrinks().get(i).equals("Water")) {
                    drinkPrice += 2.49;
                }
                else if (getDrinks().get(i).equals("Juice")) {
                    drinkPrice += 3.49;
                }
            }
        }

        return drinkPrice;
    }

    public double computeDeliveryPrice() {
        if (getOrderType().equals("Pick Up")) {
            deliveryPrice = 0;
        }
        else if (getOrderType().equals("Delivery")) {
            deliveryPrice = 6.99;
        }
        else if (getOrderType().equals("Uber Eats")) {
            deliveryPrice = 4.99;
        }
        else if (getOrderType().equals("Foodora")) {
            deliveryPrice = 4.99;
        }
        return deliveryPrice;
    }

    public double computeTotalPrice() {
        totalPrice = pizzaPrice + drinkPrice + deliveryPrice + toppingPrice;

        return totalPrice;
    }


    public void addDrink(String Drink) {
        if (Drink.equals("Coke")) {
            this.drinks.add("Coke");
        }
        else if (Drink.equals("Diet Coke")) {
            this.drinks.add("Diet Coke");
        }
        else if (Drink.equals("Coke Zero")) {
            this.drinks.add("Coke Zero");
        }
        else if (Drink.equals("Pepsi")) {
            this.drinks.add("Pepsi");
        }
        else if (Drink.equals("Diet Pepsi")) {
            this.drinks.add("Diet Pepsi");
        }
        else if (Drink.equals("Dr. Pepper")) {
            this.drinks.add("Dr. Pepper");
        }
        else if (Drink.equals("Water")) {
            this.drinks.add("Water");
        }
        else if (Drink.equals("Juice")) {
            this.drinks.add("Juice");
        }
        else if (Drink.equals("")) {
            this.drinks.add("");
        }
        else {
            System.out.println("Error: Invalid Drink was entered! Please check the menu!");
        }
    }

    public void addTopping(String Topping) {
        if (Topping.equals("P")) {
            this.pizzaToppings.add("Pepperoni");
        }
        else if (Topping.equals("O")) {
            this.pizzaToppings.add("Olives");
        }
        else if (Topping.equals("T")) {
            this.pizzaToppings.add("Tomatoes");
        }
        else if (Topping.equals("M")) {
            this.pizzaToppings.add("Mushrooms");
        }
        else if (Topping.equals("J")) {
            this.pizzaToppings.add("Jalapenos");
        }
        else if (Topping.equals("C")) {
            this.pizzaToppings.add("Chicken");
        }
        else if (Topping.equals("B")) {
            this.pizzaToppings.add("Beef");
        } else {
            System.out.println("Error: Invalid Topping was entered! Please check the menu!");
        }
    }

    public void checkPizzaType(String pizzaType, PizzaOrder pizza) {
        if (pizzaType.equals("P")) {
            pizza.setPizzaType("Pepperoni");
            System.out.println("You have selected Pepporoni! ");
        }
        else if (pizzaType.equals("M")) {
            pizza.setPizzaType("Margherita");
            System.out.println("You have selected Margherita! ");
        }
        else if (pizzaType.equals("V")) {
            pizza.setPizzaType("Vegetarian");
            System.out.println("You have selected Vegetarian!");
        }
        else if (pizzaType.equals("N")) {
            pizza.setPizzaType("Neapolitan");
            System.out.println("You have selected Neapolitan! ");
        } else {
            System.out.println("Error: Invalid Pizza Type was entered! Please check the menu!");
        }

    }

    public void assignOrderNumber(PizzaOrder pizzaOrder) {
        Random rand = new Random();
        int orderNumber = rand.nextInt(500);
        pizzaOrder.setOrderNumber(orderNumber);
    }

    public void askDeliveryOptions(PizzaOrder pizzaOrder, Scanner scanner) {

        System.out.println("Would you like to order in, or make a delivery order?: ");
        System.out.println("Your Options : Pick Up, Uber Eats, Foodora, Delivery");


        // Set order type
        pizzaOrder.setOrderType(scanner.nextLine());

        System.out.println("Your delivery charge is: " +  pizzaOrder.computeDeliveryPrice());


        if (pizzaOrder.getOrderType().equals("Pick Up")) {
            System.out.println("No extra charges for pick up!");

        }
        else if (pizzaOrder.getOrderType().equals("Uber Eats")) {
            System.out.println("Enter your Address: ");
            String address = scanner.nextLine();
            System.out.println("Enter your Order Details: ");
            String orderDetails = scanner.nextLine();
            System.out.println("Order Number: " + pizzaOrder.getOrderNumber());

            pizzaOrder.uberEatsJSON = "{ 'address' : " + address + ", 'orderDetails' : " + orderDetails +   ", 'orderNumber' : " + pizzaOrder.getOrderNumber();
        }
        else if (pizzaOrder.getOrderType().equals("Foodora")) {
            System.out.println("Enter your Address: ");
            String address = scanner.nextLine();
            System.out.println("Enter your Order Details: ");
            String orderDetails = scanner.nextLine();
            System.out.println("Order Number: " + pizzaOrder.getOrderNumber());

            pizzaOrder.foodoraCSV = address + ", " + orderDetails + ", " + pizzaOrder.getOrderNumber();
        }
        else if (pizzaOrder.getOrderType().equals("Delivery")) {
            System.out.println("Charge of 5.99 for delivery ");

        } else {
            System.out.println("You have entered an invalid order option! ");
            askDeliveryOptions(pizzaOrder, scanner);
        }

    }

    public void orderPizza(PizzaOrder pizzaOrder, Scanner scanner) {
        // Assign order Number, will be later displayed on the receipt
        pizzaOrder.assignOrderNumber(pizzaOrder);

        System.out.println("Select the type of your pizzaOrder! ");
        System.out.println("Your options are Pepperoni, Margherita, Vegetarian, Neapolitan");
        System.out.println("Type in the first letter of the type. e.g.) P for Pepperoni ");

        // Set the type of the pizzaOrder
        String pizzaOrderType = scanner.nextLine();
        pizzaOrder.checkPizzaType(pizzaOrderType, pizzaOrder);

        System.out.println("Choose the size of Your Pizza!");
        System.out.println("Options: Small, Medium, Large ");
        System.out.println("Type in first letter. i.e.) S for Small ");

        String pizzaSize = scanner.nextLine();
        pizzaOrder.setPizzaSize(pizzaSize);

        System.out.println("Select your toppings! ");
        System.out.println("Olives, Tomatoes, Mushrooms, Jalapenos, Chicken, Beef, Pepperoni");
        System.out.println("Type in the first letter of the type. e.g.) P for Pepperoni ");

        // Set the toppings
        String Topping = scanner.nextLine();
        List<String> Toppings = new ArrayList<String>();
        pizzaOrder.setPizzaToppings(Toppings);
        pizzaOrder.addTopping(Topping);

        String response = "";
        while (!(response.equals("n") || response.equals("N"))) {
            System.out.println("Do you want more toppings? (y/n)");
            response = scanner.nextLine();
            if (response.equals("y") || response.equals("Y")) {
                System.out.println("Toppings : Olives, Tomatoes, Mushrooms, Jalapenos, Chicken, Beef, Pepperoni");
                System.out.println("Type in the first letter of the type. e.g.) P for Pepperoni ");
                Topping = scanner.nextLine();
                pizzaOrder.addTopping(Topping);
            } else {
                break;
            }
        }

        System.out.println("Aren't you thirsty? Pick a drink! ");
        System.out.println("Coke, Diet Coke, Coke Zero, Pepsi, Diet Pepsi, Dr. Pepper, Water, Juice");
        System.out.println("Press Enter if you want to skip ");

        List<String> Drinks = new ArrayList<String>();
        String Drink = scanner.nextLine();
        pizzaOrder.setDrinks(Drinks);
        pizzaOrder.addDrink(Drink);

        response = "";
        while (!(response.equals("n") || response.equals("N"))) {
            System.out.println("Do you want more drinks? (y/n)");
            response = scanner.nextLine();
            if (response.equals("y") || response.equals("Y")) {
                System.out.println("Coke, Diet Coke, Coke Zero, Pepsi, Diet Pepsi, Dr. Pepper, Water, Juice");
                System.out.println("Press Enter if you want to skip ");
                Drink = scanner.nextLine();
                pizzaOrder.addDrink(Drink);
            } else {
                break;
            }
        }
    }

    public void askMoreChanges(PizzaOrder pizzaOrder, Scanner scanner) {
        System.out.println("Do you want to make other changes? ");
        String changesResponse = scanner.nextLine();
        if (changesResponse.equals("y") || changesResponse.equals("Y")) {
            pizzaOrder.updateOrder(pizzaOrder, scanner);
        }
    }

    public void updateOrder(PizzaOrder pizzaOrder, Scanner scanner) {
        System.out.println("Would you like to make any changes to the order? (y/n) ");
        String updateResponse = scanner.nextLine();
        if (updateResponse.equals("y") || updateResponse.equals("Y")) {
            System.out.println("Change 1) Pizza Type 2) Drinks");
            System.out.println("Type in the number. i.e.) 1 for Pizza Type");
            System.out.println("Press Enter if you want to skip ");

            updateResponse = scanner.nextLine();
            if (updateResponse.equals("1")) {
                System.out.println("Which pizza would you want to change it to? ");
                System.out.println("Your current pizza is: " + pizzaOrder.getPizzaType());
                // Set the type of the pizzaOrder

                String pizzaType = scanner.nextLine();
                pizzaOrder.checkPizzaType(pizzaType, pizzaOrder);
                pizzaOrder.setPizzaType(pizzaType);
                pizzaOrder.askMoreChanges(pizzaOrder, scanner);

            }
            else if (updateResponse.equals("2")) {
                System.out.println("Add or Remove drinks : Press A for add, R for remove ");
                updateResponse = scanner.nextLine();
                if (updateResponse.equals("A")) {
                    System.out.println("Which drink would you want like to add? ");
                    System.out.println("Your current drinks are: " + pizzaOrder.getDrinks());
                    System.out.println("Options: Coke, Diet Coke, Coke Zero, Pepsi, Diet Pepsi, Dr. Pepper, Water, Juice");

                    String drink = scanner.nextLine();
                    pizzaOrder.addDrink(drink);
                    pizzaOrder.askMoreChanges(pizzaOrder, scanner);
                }
                else if (updateResponse.equals("R")) {
                    System.out.println("Which drink would you want like to remove? ");
                    System.out.println("Your current drinks are: " + pizzaOrder.getDrinks());
                    String drink = scanner.nextLine();
                    pizzaOrder.deleteDrink(drink);
                    pizzaOrder.askMoreChanges(pizzaOrder, scanner);
                }
            }
        }

    }

    public void displayReceipt(PizzaOrder pizzaOrder) {
        System.out.println("Your Order Number is:  " + pizzaOrder.getOrderNumber());
        System.out.println("Your Pizza Type is:  " + pizzaOrder.getPizzaType());
        System.out.println("Your Pizza Size is:  " + pizzaOrder.getPizzaSize());
        System.out.println("Your Toppings are:  " + pizzaOrder.getPizzaToppings());
        System.out.println("Your Drinks are: " + pizzaOrder.getDrinks());


        System.out.printf("Total Pizza Price is:  %.2f \n", pizzaOrder.computePizzaPrice());
        System.out.printf("Total Topping price is:  %.2f \n", pizzaOrder.computeToppingPrice());
        System.out.printf("Total Drink Price is:  %.2f \n", pizzaOrder.computeDrinkPrice());

        System.out.printf("Delivery Price:  %.2f \n", pizzaOrder.computeDeliveryPrice());
        System.out.printf("Total Price is:  %.2f \n", pizzaOrder.computeTotalPrice());
    }

    // Ask Cancel Order
    public void askCancelOrder(Scanner scanner) {
        System.out.println("At any time, if you would want to cancel your order, please press 'Q'");
        String response = scanner.nextLine();

        if (response.equals("q") || response.equals("Q")) {
            System.out.println("Are you sure you want to cancel your order? (y/n)");
            response = scanner.nextLine();
            if (response.equals("y") || response.equals("Y")) {
                System.out.println("Bye! Have a nice day!");
                scanner.close();
            }
        }
    }


    public void addPizza(PizzaOrder pizzaStore, Scanner scanner) {

        System.out.println("Add New Type of Pizza to your Menu ");
        // Add Pizza type
        System.out.println("Type the name of the pizza: ");


        String pizzaName = scanner.nextLine();
        ArrayList<String> originalPizzaTypes = new ArrayList<String>();
        originalPizzaTypes.add("Pepperoni");
        originalPizzaTypes.add("Margherita");
        originalPizzaTypes.add("Vegetarian");
        originalPizzaTypes.add("Neapolitan");
        pizzaStore.setPizzaTypes(originalPizzaTypes);

        originalPizzaTypes.add(pizzaName);

        pizzaStore.setPizzaTypes(originalPizzaTypes);
        String response = scanner.nextLine();
        while (!(response.equals("n") || response.equals("N"))) {
            System.out.println("Do you want more Pizza Menu? (y/n)");
            response = scanner.nextLine();
            if (response.equals("y") || response.equals("Y")) {
                System.out.println("Add New Type of Pizza to your Menu ");
                // Add Pizza type
                System.out.println("Type the name of the pizza: ");
                pizzaName = scanner.nextLine();
                originalPizzaTypes.add(pizzaName);
                pizzaStore.setPizzaTypes(originalPizzaTypes);
            } else {
                break;
            }
        }
        System.out.println("Updated Pizza Type is:  " + originalPizzaTypes);

    }

    public void optionResponse(PizzaOrder pizzaOrder, String optionResponse, Scanner scanner) {

        if (optionResponse.equals("1")) {
            // Initialize new pizza
            // Order Pizza
            pizzaOrder.orderPizza(pizzaOrder, scanner);
            // Update order
            pizzaOrder.updateOrder(pizzaOrder, scanner);
            // Ask delivery option
            pizzaOrder.askDeliveryOptions(pizzaOrder, scanner);
            // Cancel order of display receipt
            System.out.println("Would you want to cancel your order? (y/n)");
            String cancelResponse = scanner.nextLine();
            if (cancelResponse.equals("y") || cancelResponse.equals("Y")) {
                System.out.println("Good Bye! Hope you reach us next time!");
            } else {
                // Display Receipt
                pizzaOrder.displayReceipt(pizzaOrder);
            }
        } else if (optionResponse.equals("2")){
            pizzaOrder.displayMenu(pizzaOrder);
            System.out.println("Would you want to order?");
            optionResponse = scanner.nextLine();
            if (optionResponse.equals("y") || optionResponse.equals("Y")) {
                optionResponse(pizzaOrder, "1", scanner);
            }
        }
    }

    public void displayMenu(PizzaOrder pizzaOrder) {
        System.out.println("============= FULL MENU ============== ");
        System.out.println("Pizza Types :  Pepperoni, Margherita, Vegetarian, Neapolitan");
        System.out.println("Pizza Size : S, M, L");
        System.out.println("Toppings: Olives, Tomatoes, Mushrooms, Jalapenos, Chicken, Beef, Pepperoni");
        System.out.println("Drinks: Coke, Diet Coke, Coke Zero, Pepsi, Diet Pepsi, Dr. Pepper, Water, Juice");
    }

    public void deleteDrink(String drink) {
        this.drinks.remove(drink);
    };



    public static void main(String[] args) {

    }




}