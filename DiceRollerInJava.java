import java.util.Random;
import java.util.Scanner;
 
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
                           { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } }
                           };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DiceRollerInJava dice = new DiceRollerInJava();
        int input = 0, a = 0;
        while (input != 5) {
            Scanner ScanInt = new Scanner( System.in );
            System.out.println("\n 1. Circle\n 2. Change the color\n 3. Record\n 4. Number \n 5. Quit");
            input = ScanInt.nextInt();
            //ScanInt.close();
            int result = dice.roll();
            int data[] = new int[10];

            //if(input != 3)
            //data[a] = result;
            System.out.println(" result = " + result);
            a++;
            
            System.out.println(" data[a] = " + data[a]);
            switch(input)
            {
                case 1:
                System.out.println("dice face value:" + result);
                dice.draw(result);
                break;

                case 2:         
                dice.SelectColor();
                break;

                case 3:
                for(int x = 0; x < data.length; x++) {
                    //if(data[x] == 0)
                    //break;
                    System.out.println(data[x]); 
                }
                break;

                case 4:
                int number = 0;
                System.out.println(" The point u want");
                number = ScanInt.nextInt();
                dice.draw(number);
                break;


                case 5:
                System.out.println("Bye!");
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
    private int roll() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }

    private void SelectColor()
    {
        System.out.println("\n\nSelect a color");
        System.out.println("\033[39;49m" + " 1. Default");
        System.out.println("\033[1;94m" + " 2. Blue");
        System.out.println("\033[1;95m" + " 3. Puprle");
        System.out.println("\033[31m" + " 4. Red");
        System.out.println("\033[32m" + " 5. Green");               
        //System.out.println("\033[44m" + "Background"+"\033[m");
        //System.out.println("\033[45m" + "Background"+"\033[m");
        int col = 0;
        Scanner ScanInt = new Scanner( System.in );
        col = ScanInt.nextInt();

        switch(col)
        {
            case 1:
            System.out.println("\033[39;49m" + " Default");
            break;

            case 2:
            System.out.println("\033[1;94m" + " Blue");
            break;

            case 3:
            System.out.println("\033[1;95m" + " Puprle");
            break;

            case 4:
            System.out.println("\033[31m" + " Red");
            break;

            case 5:
            System.out.println("\033[32m" + " Green"); 
            break;
        }
    }
}