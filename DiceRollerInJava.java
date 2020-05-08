import java.util.Random;
import java.util.Scanner;
 
// dice roller java source code
// Also outputs the dice face as ASCII art
public class DiceRollerInJava {
 
    // This has printing information for all numbers
    // For each number,3x3 matrix represents the face
    int[][][] faceConfig = { 
                           { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 } }, //1

                           { { 0, 0, 0, 0, 0, 0, 0, 0, 1 },{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0} }, //2

                           { { 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0 } }, //3

                           { { 1, 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 } }, //4

                           { { 1, 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 } }, //5

                           { { 1, 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 } } //6
                           };
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DiceRollerInJava dice = new DiceRollerInJava();
        while (true) {
            int result = dice.roll();
            System.out.println("dice face value:" + result);
            dice.draw(result);
 
            System.out.println("Roll again? (type no to quit):");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("n") || 
                    input.equalsIgnoreCase("no")) {
                System.out.println("Bye!");
                scanner.close();
                return;
            }
        }
    }
 
    // Draw the dice face using ascii characters
    private void draw(int value) {
        int[][] displayVal = faceConfig[value - 1];
        System.out.println("◤--------◥");
 
        for (int i = 0; i < 5; i++) {         
            System.out.print("|");
            for (int j = 0; j < 9; j++) {
                if (displayVal[i][j] == 1) {
                    Symbol();

                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println("◣--------◢");
 
    }
 
    // Roll the dice in Java
    private int roll() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }

    private void Symbol()
    {
        Random s = new Random();
        int symbol = s.nextInt(6) + 1;
        if(symbol == 1)
        System.out.print("✈");
        if(symbol == 2)
        System.out.print("✎");
        if(symbol == 3)
        System.out.print("㋡");
        if(symbol == 4)
        System.out.print("☢");
        if(symbol == 5)
        System.out.print("♬");
        if(symbol == 6)
        System.out.print("♖");
    }
}

/*
◤---------◥
 |O       O|
 |         |
 |    ✈   |
 |         |
 |O       O|
◣---------◢

*/