import java.util.Random;
import java.util.Properties; 
 
// dice roller java source code
// Also outputs the dice face as ASCII art
public class DiceRollerInJava {
 
    // This has printing information for all numbers
    // For each number,3x3 matrix represents the face
    int[][][] faceConfig = { 
                           { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }, 
                           { { 0, 0, 1 }, { 0, 0, 0 }, { 1, 0, 0 } },
                           { { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 } }, 
                           { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } },
                           { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } }, 
                           { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } },
						   { { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 } },
						   { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } },
						   { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } }
                           };
    
    // ANSI colour codes
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_BLACK = "\u001B[30m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_BLUE = "\u001B[34m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_CYAN = "\u001B[36m";
    static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        DiceRollerInJava dice = new DiceRollerInJava();
        int rollHistory[] = new int[0]; // rollHistory keeps track of ALL rolls the user makes in this session

        String userInput = "";
        while(userInput != "exit")
        {
            // Handle the user input
            System.out.println("\nWhat would you like to do next? "); // ask user
            userInput = System.console().readLine(); // read response
            userInput.toLowerCase(); // change to be readable

            switch(userInput)
            {
                /*
                    To add new function:
                    - add keyword and description to 'help' (above 'exit' description)
                    - add new case for keyword (above 'exit' case)
                    - comment your function so others know what's what
                */
                default:
                    System.out.println("Option not Recognised... type 'help' to see a list of options.");
					
                    break;

                // Show the list of options the user can choose from
                case "help":
                    System.out.println("Here are your options:");
                    System.out.println("\troll: roll the dice.");
					System.out.println("\tcheat: roll the dice to the number you want");
                    System.out.println("\tcolour: change the colour the terminal prints in.");
                    System.out.println("\thistory: show the last 10 rolls.");
                    System.out.println("\texit: leave the program.");
                    break;
				
				
						

					
                //Roll the dice normally
                case "roll": 
					//Select number of dice to be rolled
                    System.out.println("How many dice you want to roll: (input number)");
                    System.out.println("\t1 dice");
                    System.out.println("\t2 dice");
                    System.out.println("\t3 dice");
                    userInput = System.console().readLine();
                    
                    int numDice = Integer.parseInt(userInput);

                    if(numDice > 3)
                    {
                        System.out.println("Maximum of dice allowed is 3!");
                        break;
                    }
                    
                    // Select the type of dice
					String dice6 = "6 Sided dice";
					System.setProperty(dice6,"6");
					
					String dice9 = "9 Sided dice";
					System.setProperty(dice9, "9");

					int type;
					
					System.out.println("Select the type of the dice you want to roll: (input number)");
					System.out.println("\t6 sided dice");
					System.out.println("\t9 sided dice");
					userInput = System.console().readLine(); // read response

                    
					int uInput = Integer.parseInt(userInput);
                    
                    if (uInput != 6 && uInput != 9)
					{
						System.out.println("Please select an appropriate dice");
					break;
					}	
					
					if (uInput == 6 )
					{
						type = Integer.getInteger("6 Sided dice");
						do
						{
                            for(int i=0; i < numDice; i++)
                            {
                            int result = dice.roll(type); // roll the dice and save the result
							dice.draw(result); // show the user what they rolled
							rollHistory = dice.addToHistory(result, rollHistory); // add the roll to history
                            }
							
							System.out.println("Do you want to change the dice? (y/n)");
							userInput = System.console().readLine();
							userInput.toLowerCase(); // change to be readable
						}
						while (!userInput.equals("y"));
					}
					
					
					if (uInput == 9 )
					{
						type = Integer.getInteger("9 Sided dice");
						do
						{
                            for(int i=0; i < numDice; i++)
                            {
							    int result = dice.roll(type); // roll the dice and save the result
							    dice.draw(result); // show the user what they rolled
                                rollHistory = dice.addToHistory(result, rollHistory); // add the roll to history
                            }
							System.out.println("Do you want to change the dice? (y/n)");
							userInput = System.console().readLine();
							userInput.toLowerCase(); // change to be readable
						}
						while (!userInput.equals("y"));
					}
					break;
				

                // Roll a specific number
                case "cheat":
                    int request = 0;
                    System.out.println("What number would you like rolled? (1-9): ");
                    try
                    {   // try to parse string input into an integer
                        request = Integer.parseInt(System.console().readLine()); //get user input
                        if(request >= 1 && request <= 9) //check if valid
                            {
                                dice.draw(request); // show user the dice
                                rollHistory = dice.addToHistory(request, rollHistory); // add roll to history
                                break;
                            }
                        
                    }
                    catch(Exception e){} // user entered text
                    // if program reached here user either entered text or a number out of range
                    System.out.println("Digit not recognised.");
                    break;

                // Change the output colour
                case "colour":         
                    dice.SelectColor();
                    break;

                // Print the roll history
                case "history":
                        System.out.println("You've rolled " + rollHistory.length + " times!"); // prints roll count
                        System.out.println("Here al the results of those..."); 
                        for(int i = 0; i < rollHistory.length; i++) // print each value in rollHistory
                        {
                            System.out.println(i+1 + ") " + rollHistory[i]);
                        }
                        break;

                // give the user a nice message before they leave
                case "exit":
                        System.out.println("Going so soon? Bye!");
                        return;


            }
        }
    }
 
    // Draw the dice face using ascii characters
    private void draw(int value) {
        int[][] displayVal = faceConfig[value - 1];
        System.out.println("-----");
 
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if (displayVal[i][j] == 1) {
                    System.out.print("o");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println("-----");
    }

    // Roll the dice in Java
    private int roll(int type) {        
        Random r = new Random();
        return r.nextInt(type) + 1;
    }

	
    private void SelectColor()
    {
        System.out.println("\n\nSelect a color");
        System.out.println(ANSI_RESET + " 1. Default");
        System.out.println(ANSI_BLUE + " 2. Blue");
        System.out.println(ANSI_PURPLE + " 3. Puprle");
        System.out.println(ANSI_RED + " 4. Red");
        System.out.println(ANSI_GREEN + " 5. Green" + ANSI_RESET); 

        String selection = System.console().readLine();
        switch(selection)
        {
            default: //set default case to result in default olour beeing chosen
            case "Default":
                System.out.println(ANSI_RESET+ " Default");
                break;

            case "Blue":
                System.out.println(ANSI_BLUE + " Blue");
                break;

            case "Purple":
                System.out.println(ANSI_PURPLE + " Puprle");
                break;

            case "Red":
                System.out.println(ANSI_RED + " Red");
                break;

            case "Green":
                System.out.println(ANSI_GREEN + " Green"); 
                break;
        }
    }

    // Adds an additional integer to a preexisting array. In this case the history array.
    private int[] addToHistory(int newValue, int oldArray[])
    {
        int newArray[] = new int[oldArray.length + 1]; // create a new array with room for a new value
        for(int i = 0; i< oldArray.length; i++) // copy values from the old array to the new one
            newArray[i] = oldArray[i];
        newArray[oldArray.length] = newValue; // add the new value to the end of the array
        return newArray;
    }    
}