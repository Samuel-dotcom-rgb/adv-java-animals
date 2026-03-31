package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * PetCreator class handles user input to create and add animals to the zoo list.
 * Uses decision logic and exception handling to verify correct data types.
 */
public class PetCreator {
    private ArrayList<Talkable> zoo;
    private Scanner scanner;

    public PetCreator(ArrayList<Talkable> zoo) {
        this.zoo = zoo;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prompts the user for the type of animal and gathers necessary information
     * to create and add that animal to the zoo list.
     */
    public void createAndAddAnimal() {
        System.out.println("\nWhat type of animal would you like to create?");
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Teacher");
        System.out.print("Enter your choice (1-3): ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createDog();
                    break;
                case 2:
                    createCat();
                    break;
                case 3:
                    createTeacher();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer.");
        }
    }

    /**
     * Gathers information for creating a Dog and adds it to the zoo list.
     */
    private void createDog() {
        System.out.print("Enter the dog's name: ");
        String name = scanner.nextLine();

        System.out.print("Is the dog friendly? (true/false): ");
        try {
            boolean friendly = Boolean.parseBoolean(scanner.nextLine());
            Dog dog = new Dog(friendly, name);
            zoo.add(dog);
            System.out.println("Dog added successfully!");
        } catch (Exception e) {
            System.out.println("Error: Invalid input for friendly status.");
        }
    }

    /**
     * Gathers information for creating a Cat and adds it to the zoo list.
     */
    private void createCat() {
        System.out.print("Enter the cat's name: ");
        String name = scanner.nextLine();

        System.out.print("How many mice has the cat killed? ");
        try {
            int mousesKilled = Integer.parseInt(scanner.nextLine());
            if (mousesKilled < 0) {
                System.out.println("Error: Number of mice cannot be negative.");
                return;
            }
            Cat cat = new Cat(mousesKilled, name);
            zoo.add(cat);
            System.out.println("Cat added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer for mice killed.");
        }
    }

    /**
     * Gathers information for creating a Teacher and adds it to the zoo list.
     */
    private void createTeacher() {
        System.out.print("Enter the teacher's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the teacher's age: ");
        try {
            int age = Integer.parseInt(scanner.nextLine());
            if (age < 0 || age > 120) {
                System.out.println("Error: Please enter a reasonable age (0-120).");
                return;
            }
            Teacher teacher = new Teacher(age, name);
            zoo.add(teacher);
            System.out.println("Teacher added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer for age.");
        }
    }
}
