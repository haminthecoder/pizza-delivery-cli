package a2;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class PizzaOrderTest {

    PizzaOrder pizzaOrder = new PizzaOrder();
    @Test
    public void testPizzaTypes() {
        List<String> pizzaTypes = new ArrayList<String>();
        pizzaTypes.add("Pepperoni");
        pizzaOrder.setPizzaTypes(pizzaTypes);
        assertEquals(pizzaOrder.getPizzaTypes(), pizzaTypes);
    }

    @Test
    public void testDrinks() {
        List<String> Drinks = new ArrayList<String>();
        Drinks.add("Coke");
        pizzaOrder.setDrinks(Drinks);
        assertEquals(pizzaOrder.getDrinks(), Drinks);
    }

    @Test
    public void testPizzaToppings() {
        List<String> pizzaToppings = new ArrayList<String>();
        pizzaToppings.add("Pepperoni");
        pizzaOrder.setPizzaToppings(pizzaToppings);
        assertEquals(pizzaOrder.getPizzaToppings(), pizzaToppings);
    }

    @Test
    public void testPizzaType() {
        pizzaOrder.setPizzaType("Pepperoni");
        assertEquals(pizzaOrder.getPizzaType(), "Pepperoni");
    }

    @Test
    public void testOrderType() {
        pizzaOrder.setOrderType("Pick Up");
        assertEquals(pizzaOrder.getOrderType(), "Pick Up");
    }

    @Test
    public void testPizzaSize() {
        pizzaOrder.setPizzaSize("L");
        assertEquals(pizzaOrder.getPizzaSize(), "L");
    }

    @Test
    public void testOrderNumber() {
        pizzaOrder.setOrderNumber(3);
        assertEquals(pizzaOrder.getOrderNumber(), 3);
    }

    @Test
    public void testComputeSmallPizzaPrice() {
        // Test for small pizzas
        pizzaOrder.setPizzaSize("S");
        pizzaOrder.setPizzaType("Pepperoni");
        assertEquals(pizzaOrder.computePizzaPrice(), 12.99);
        pizzaOrder.setPizzaType("Vegetarian");
        assertEquals(pizzaOrder.computePizzaPrice(), 12.99);
        pizzaOrder.setPizzaType("Margherita");
        assertEquals(pizzaOrder.computePizzaPrice(), 19.99);
        pizzaOrder.setPizzaType("Neapolitan");
        assertEquals(pizzaOrder.computePizzaPrice(), 15.99);
    }

    @Test
    public void testComputeMediumPizzaPrice() {
        pizzaOrder.setPizzaSize("M");
        pizzaOrder.setPizzaType("Pepperoni");
        assertEquals(pizzaOrder.computePizzaPrice(), 14.98);
        pizzaOrder.setPizzaType("Vegetarian");
        assertEquals(pizzaOrder.computePizzaPrice(), 14.98);
        pizzaOrder.setPizzaType("Margherita");
        assertEquals(pizzaOrder.computePizzaPrice(), 21.98);
        pizzaOrder.setPizzaType("Neapolitan");
        assertEquals(pizzaOrder.computePizzaPrice(), 17.98);
    }

    @Test
    public void testComputeLargePizzaPrice() {
        pizzaOrder.setPizzaSize("L");
        pizzaOrder.setPizzaType("Pepperoni");
        assertEquals(pizzaOrder.computePizzaPrice(), 17.98);
        pizzaOrder.setPizzaType("Vegetarian");
        assertEquals(pizzaOrder.computePizzaPrice(), 17.98);
        pizzaOrder.setPizzaType("Margherita");
        assertEquals(pizzaOrder.computePizzaPrice(), 24.98);
        pizzaOrder.setPizzaType("Neapolitan");
        assertEquals(pizzaOrder.computePizzaPrice(), 21.98);
    }

    @Test
    public void testComputeToppingPrice() {
        List<String> toppings = new ArrayList<String>();
        toppings.add("Ham");
        pizzaOrder.setPizzaToppings(toppings);
        // One topping
        assertEquals(pizzaOrder.computeToppingPrice(), 0);
        toppings.add("Cheese");
        // Two toppings
        pizzaOrder.setPizzaToppings(toppings);
        assertEquals(pizzaOrder.computeToppingPrice(), 0);

        // Three toppings
        toppings.add("Olives");
        pizzaOrder.setPizzaToppings(toppings);
        assertEquals(pizzaOrder.computeToppingPrice(), 1.99);
    }

    @Test
    public void testComputeDrinkPrice() {
        List<String> drinks = new ArrayList<String>();
        drinks.add("Coke");
        pizzaOrder.setDrinks(drinks);
        // One topping
        assertEquals(pizzaOrder.computeDrinkPrice(), 1.99);
        drinks.add("Pepsi");
        // Two drinks
        pizzaOrder.setDrinks(drinks);
        assertEquals(pizzaOrder.computeDrinkPrice(), 3.98);
        // Three drinks
        drinks.add("Water");
        pizzaOrder.setDrinks(drinks);
        assertEquals(pizzaOrder.computeDrinkPrice(), 5.47);
    }

    @Test
    public void testComputeDeliveryPrice() {
        pizzaOrder.setOrderType("Pick Up");
        assertEquals(pizzaOrder.computeDeliveryPrice(), 0);
        pizzaOrder.setOrderType("Delivery");
        assertEquals(pizzaOrder.computeDeliveryPrice(), 0);
        pizzaOrder.setOrderType("Uber Eats");
        assertEquals(pizzaOrder.computeDeliveryPrice(), 0);
        pizzaOrder.setOrderType("Foodora");
        assertEquals(pizzaOrder.computeDeliveryPrice(), 0);

    }

    @Test
    public void testAddDrinks() {
        List<String> drinks = new ArrayList<String>();
        pizzaOrder.addDrink("Coke");
        pizzaOrder.setDrinks(drinks);
        // One topping
        assertEquals(pizzaOrder.getDrinks().get(0), "Coke");
        pizzaOrder.addDrink("Pepsi");
        // Two drinks
        pizzaOrder.setDrinks(drinks);
        assertEquals(pizzaOrder.getDrinks().get(1), "Pepsi");
        // Three drinks
        pizzaOrder.addDrink("Water");
        pizzaOrder.setDrinks(drinks);
        assertEquals(pizzaOrder.getDrinks().get(2), "Water");
    }

    @Test
    public void testDeleteDrinks() {
        List<String> drinks = new ArrayList<String>();
        pizzaOrder.addDrink("Coke");
        pizzaOrder.addDrink("Pepsi");
        pizzaOrder.setDrinks(drinks);

        pizzaOrder.deleteDrink("Coke");
        assertEquals(pizzaOrder.getDrinks().get(0), "Pepsi");

    }

    @Test
    public void testAddToppings() {
        List<String> toppings = new ArrayList<String>();
        toppings.add("P");
        pizzaOrder.setPizzaToppings(toppings);
        // One topping
        assertEquals(pizzaOrder.getDrinks().get(0), "Pepperoni");
        toppings.add("T");
        // Two toppings
        pizzaOrder.setPizzaToppings(toppings);
        assertEquals(pizzaOrder.getDrinks().get(1), "Tomatoes");
        // Three toppings
        toppings.add("M");
        pizzaOrder.setPizzaToppings(toppings);
        assertEquals(pizzaOrder.getDrinks().get(2), "Mushrooms");
    }

    @Test
    public void testCheckPizzaType() {
        String pizzaType = "P";
        pizzaOrder.checkPizzaType(pizzaType, pizzaOrder);
        assertEquals(pizzaOrder.getPizzaType(), "Pepperoni");

        pizzaType = "M";
        pizzaOrder.checkPizzaType(pizzaType, pizzaOrder);
        assertEquals(pizzaOrder.getPizzaType(), "Margherita");

        pizzaType = "V";
        pizzaOrder.checkPizzaType(pizzaType, pizzaOrder);
        assertEquals(pizzaOrder.getPizzaType(), "Vegetarian");
    }





}
