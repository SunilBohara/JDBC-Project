package CrudOperations;

import java.util.Scanner;

public class Mainn {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintingAndSwtiching pas = new PrintingAndSwtiching();
        while (true) {
            pas.justPrinting();
            System.out.print("Choice : ");
            int choice = sc.nextInt();
            pas.multipleChoices(choice);
        }
    }
}
