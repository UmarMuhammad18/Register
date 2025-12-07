import java.util.ArrayList;       //importing the ArrayList class to use dynamic arrays
import java.util.Scanner;        //importing the Scanner class to read user input
import java.util.Set;           //importing the Set interface to use collections that do not allow duplicate elements
import java.util.HashSet;      //importing the HashSet class to implement the Set interface
import java.util.Collections; //importing the Collections class to use utility methods for collections

public class Register {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<String> nameList = new ArrayList<>();
    public static void main(String [] args) {
        System.out.println("--- Register Program Started ---");
        initialCapture();  // 1. Initial Name Capture
        runMenu();     // 2. Main Menu Loop
        System.out.println("--- Program Cancelled. Goodbye! ---");
        scanner.close();
        nameList.clear();  // Clear the list before finishing
    }

    // Core Setup Method
    public static void initialCapture() {
        System.out.println("Name Set-up");
        String input;
        while (true) {
            System.out.println("Enter a name: ");
            input = scanner.nextLine().trim();  // The trim() method removes leading and trailing whitespace(this includes spaces, tabs, and newline characters) from the input string.
            if (input.isEmpty()) {  // Check for an empty string to stop the input process.
                break;
            }
            nameList.add(input);  // Add the inputed name to the nameList ArrayList.
        }
        displayList("Names Entered"); //Display the list of names entered by the user.
    }
    // Main Menu
    public static void runMenu() {  // The runMenu method handles the main interactive menu loop.
        int option = -1;
        while (option != 5) {
            displayMenu();  // Display the menu options to the user.
            if (scanner.hasNextInt()) {  // Check if the next input is an integer.
                option = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (option) {
                    case 1:
                        displayList("Current Register"); // 1: Display the current list of names.
                        break;
                    case 2:
                        addName(); // 2: Add a new name to the list.
                        break;
                    case 3:
                        updateName(); // 3: Update an existing name in the list.
                        break;
                    case 4:
                        deleteName(); // 4: Delete a name from the list.
                        break;
                    case 5:
                        System.out.println("Exiting the program..."); // 5: Exit the program.
                        break;
                    default:
                        System.out.println("Invalid option. Please try again."); // Handle invalid menu options.
                        break;
                }
            }
            else {
                System.out.println("Invalid input. Please enter a number from 1 to 5.");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }
    }

    // Menu
    // Option 1: Display Menu
    public static void displayList(String context) {
        System.out.println("\n--- [1] List Status: " + context + " ---");
        if (nameList.isEmpty()) {
            System.out.println("The register is currently empty.");
        } else {
            for (int i = 0; i < nameList.size(); i++) {
                System.out.println((i + 1) + ". " + nameList.get(i));
            }
        }
        System.out.println("Total names in register: " + nameList.size() + ".");
        System.out.println("------------------------------");
    }
    // Option 2: Add new name
    public static void addName() {
        System.out.println("\n--- [2] Add New Name ---");
        System.out.print("Enter the name to add: ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            nameList.add(newName);
            System.out.println("Name '" + newName + "' added successfully.");
        } else {
            System.out.println("No name entered. Returning to menu.");
        }
    }
    // Option 3: Update existing name
    public static void updateName() {
        System.out.println("\n--- [3] Update Name ---");
        if (nameList.isEmpty()) {
            System.out.println("The register is empty. No names to update.");
            return;
        }
        System.out.print("Enter the **current** name to update: ");
        String currentName = scanner.nextLine().trim();
        if (nameList.contains(currentName)) {
            System.out.print("Enter the **new** name: ");
            String newName = scanner.nextLine().trim();
            int index = nameList.indexOf(currentName);
            nameList.set(index, newName);
            System.out.println("Name updated from '" + currentName + "' to '" + newName + "'.");
        } else {
            System.out.println("Name '" + currentName + "' not found in the register.");
        }
    }
    // Option 4: Delete name
    public static void deleteName() {
        System.out.println("\n--- [4] Delete Name ---");
        if (nameList.isEmpty()) {
            System.out.println("The register is empty. No names to delete.");
            return;
        }
        System.out.print("Enter the name to delete: ");
        String nameToDelete = scanner.nextLine().trim();
        if (nameList.contains(nameToDelete)) {
            nameList.remove(nameToDelete);
            System.out.println("Name '" + nameToDelete + "' deleted successfully.");
        } else {
            System.out.println("Name '" + nameToDelete + "' not found in the register.");
        }
    }
    // Display Menu Options
    public static void displayMenu() {
        System.out.println("=======================");
        System.out.println("\n------ Main Menu ------");
        System.out.println("=======================");
        System.out.println("1. Display Register");
        System.out.println("2. Add New Name");
        System.out.println("3. Update Name");
        System.out.println("4. Delete Name");
        System.out.println("5. Exit");
        System.out.print("Select an option (1-5): ");
    }
    public static void removeDuplicates() {
        int initialSize = nameList.size();
        Set<String> nameSet = new HashSet<>(nameList);
        if (nameSet.size() < initialSize) {
            nameList.clear();
            nameList.addAll(nameSet);
            System.out.println("Duplicates removed. " + (initialSize - nameList.size()) + " duplicate(s) found and removed.");
        } else {
            System.out.println("No duplicates found.");
        }
    }
}
// This program manages a register of names, allowing users to add, update, delete, and display names using an ArrayList. It includes methods for each operation and a menu-driven interface for user interaction.