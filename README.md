📝 Name Register 

A simple console‑based Java application that lets you manage a list of names.
You start by entering names (empty line stops input), then use an interactive menu to display, add, update, and delete names.
All data is stored in an ArrayList during the session – perfect for learning basic CRUD operations and Java collections.


✨ Features

- Initial name capture – enter multiple names (one per line); finish with an empty line.
- Display register – shows all names with their current index and total count.
- Add new name – append a name to the list.
- Update existing name – search by the current name and replace it with a new one.
- Delete name – remove a specific name from the list.
- Input validation – handles empty inputs and menu selection errors gracefully.
- Duplicate removal method – removeDuplicates() is provided (though not integrated into the menu – you can easily add it).


🛠️ Requirements

- Java Development Kit (JDK) 8 or higher.
- A terminal / command prompt.


🚀 How to Run

1. Save the file as Register.java.
2. Open a terminal in the folder containing the file.
3. Compile the program:
   javac Register.java
4. Run the compiled class:
   java Register


📖 Usage Example

--- Register Program Started ---

Name Set-up

Enter a name: 

Alice

Enter a name: 

Bob

Enter a name: 

Charlie

Enter a name: 

--- [1] List Status: Names Entered ---
1. Alice
2. Bob
3. Charlie

Total names in register: 3.
------------------------------

------ Main Menu ------
=======================
1. Display Register
2. Add New Name
3. Update Name
4. Delete Name
5. Exit

Select an option (1-5): 1

--- [1] List Status: Current Register ---
1. Alice
2. Bob
3. Charlie

Total names in register: 3.
------------------------------


🧩 Code Structure
|           Method	       | Description                                                                       |
|--------------------------|----------------------------------------------------------------------------------:|
|initialCapture()	         | Prompts for names and fills the list until an empty line is entered.              |
|runMenu()	               | Main loop – displays menu and calls appropriate methods based on user choice.     |
|displayList(String)	     | Prints all names with indices and the total count.                                |
|addName()	               | Adds a new name to the list (non‑empty).                                          |
|updateName()	             | Finds a name and replaces it with a new one.                                      |
|deleteName()	             | Removes a name from the list.                                                     |
|displayMenu()	           | Shows the menu options.                                                           |
|removeDuplicates()	       | Utility method that eliminates duplicate names (not integrated into menu).        |


💡 Possible Enhancements

- Integrate removeDuplicates() as a menu option.
- Save the list to a file and load it on startup.
- Sort the names alphabetically.
- Prevent duplicate names at addition time.
- Use Set internally to enforce uniqueness.


📄 License

This project is open source and available under the MIT License.
