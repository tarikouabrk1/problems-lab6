package problem1;

import java.util.ArrayList;
import java.util.Scanner;
public class Shop
{
    public static void main (String[] args)
    {
        ArrayList<Item> cart = new ArrayList();
        Item item;
        String itemName;
        double itemPrice;
        int quantity;
        Scanner scan = new Scanner(System.in);
        String keepShopping = "y";
        do
        {
            System.out.print ("Enter the name of the item: ");
            itemName = scan.nextLine();
            System.out.print ("Enter the unit price: ");
            itemPrice = scan.nextDouble();
            System.out.print ("Enter the quantity: ");
            quantity = scan.nextInt();
            scan.nextLine();
            // *** create a new item and add it to the cart
            cart.add(new Item(itemName, itemPrice, quantity));
            // *** print the contents of the cart object using println
            //before we can just do System.out.println(cart)
            System.out.println("\nCurrent items in your cart:");
            double totalPrice = 0.0;
            for (Item i : cart) {
                System.out.println(i);                       // calls Item.toString() for each item
                totalPrice += i.getPrice() * i.getQuantity();
            }

            // compute the totalPrice of the items that have been added so far
            System.out.printf("Total price: $%.2f%n", totalPrice);
            System.out.print ("Continue shopping (y/n)? ");
            keepShopping = scan.nextLine();
        }
        while (keepShopping.equals("y"));
    }
}
