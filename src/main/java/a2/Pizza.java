package a2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface Pizza {
    double computePizzaPrice();
    double computeToppingPrice();
    double computeDrinkPrice();
    double computeDeliveryPrice();
    double computeTotalPrice();
    void addDrink(String Drink);
    void addTopping(String Topping);
    void checkPizzaType(String pizzaType, PizzaOrder pizza);
    void orderPizza(PizzaOrder pizza, Scanner scanner);
    void displayReceipt(PizzaOrder pizza);
    void askCancelOrder(Scanner scanner);

}
