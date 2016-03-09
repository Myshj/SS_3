import java.util.Scanner;

public class Main {

    private static Parabola parabola = new Parabola();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            // Local variable
            int swValue;

            // Display menu graphics
            showMainMenu();
            swValue = Keyin.inInt(" Select option: ");

            // Switch construct
            switch (swValue) {
                case 1:
                    showFunction();
                    break;
                case 2:
                    editFunction();
                    break;
                case 3:
                    calculateForward();
                    break;
                case 4:
                    calculateBackward();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid selection");
                    break; // This break is not really necessary
            }
        }
    }

    private static void showMainMenu() {
        clearConsole();
        System.out.println("\tMAIN MENU");
        System.out.println("Options");
        System.out.println("1. Show function");
        System.out.println("2. Change function");
        System.out.println("3. Calculate forward");
        System.out.println("4. Calculate backward");
        System.out.println("5. Exit");
    }

    private static void showFunction() {
        clearConsole();
        System.out.println("\tCURRENT FUNCTION");
        System.out.println("y = " + parabola.getA() + " * x * x + " + parabola.getB() + " * x + " + parabola.getC());
        System.out.println("Press Enter to return to main menu.");
        scanner.nextLine();
    }

    private static void editFunction() {
        clearConsole();
        System.out.println("\tEDIT FUNCTION");

        System.out.println("Current A is: " + parabola.getA());
        System.out.println("Do you want to change A? (y/n)");
        if (0 == scanner.nextLine().compareToIgnoreCase("y")) {
            System.out.println("Enter new A.");
            try {
                parabola.setA(Keyin.inDouble(""));
                System.out.println("A changed.");
            } catch (Exception ex) {
                System.out.println("Something went wrong. Nothing changed.");
            }
        }

        System.out.println("Current B is: " + parabola.getB());
        System.out.println("Do you want to change B? (y/n)");
        if (0 == scanner.nextLine().compareToIgnoreCase("y")) {
            System.out.println("Enter new B.");
            try {
                parabola.setB(Keyin.inDouble(""));
                System.out.println("B changed.");
            } catch (Exception ex) {
                System.out.println("Something went wrong. Nothing changed.");
            }
        }

        System.out.println("Current C is: " + parabola.getC());
        System.out.println("Do you want to change C? (y/n)");
        if (0 == scanner.nextLine().compareToIgnoreCase("y")) {
            System.out.println("Enter new C.");
            try {
                parabola.setC(Keyin.inDouble(""));
                System.out.println("C changed.");
            } catch (Exception ex) {
                System.out.println("Something went wrong. Nothing changed.");
            }
        }

        System.out.println("Press Enter to return to main menu.");
        scanner.nextLine();

    }

    private static void calculateForward() {
        clearConsole();
        System.out.println("\tCALCULATE FORWARD");
        System.out.println("Current function is:");
        System.out.println("y = " + parabola.getA() + " * x * x + " + parabola.getB() + " * x + " + parabola.getC());

        System.out.println("Enter argument (x):");

        try {
            System.out.println("y = " + parabola.calculate(Keyin.inDouble("")));
        } catch (Exception ex) {
            System.out.println("Something went wrong. Nothing calculated.");
        }

        System.out.println("Press Enter to return to main menu.");
        scanner.nextLine();
    }

    private static void calculateBackward() {
        clearConsole();
        System.out.println("\tCALCULATE BACKWARD");
        System.out.println("Current function is:");
        System.out.println("y = " + parabola.getA() + " * x * x + " + parabola.getB() + " * x + " + parabola.getC());

        System.out.println("Enter function value (y):");

        try {
            double y = Keyin.inDouble("");
            double[] roots = parabola.doBackwardCalculation(y);

            switch (roots.length) {
                case 0:
                    System.out.println("It is impossible to calculate arguments from provided function value.");
                    if (parabola.getA() == 0 && parabola.getB() == 0 && parabola.getC() == y) {
                        System.out.println("Any real number would be correct.");
                    }
                    break;
                case 1:
                    System.out.println("X = " + roots[0]);
                    break;
                case 2:
                    System.out.println("X1 = " + roots[0]);
                    System.out.println("X2 = " + roots[1]);
                    break;
                default:
                    System.out.println("Something went wrong");
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong. Nothing calculated.");
        }

        System.out.println("Press Enter to return to main menu.");
        scanner.nextLine();
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }
}

//**********************************************************
//**********************************************************
//Program: Keyin
//Reference: Session 20
//Topics:
// 1. Using the read() method of the ImputStream class
//    in the java.io package
// 2. Developing a class for performing basic console
//    input of character and numeric types
//**********************************************************
//**********************************************************

class Keyin {

    //*******************************
    //   support methods
    //*******************************
    //Method to display the user's prompt string
    public static void printPrompt(String prompt) {
        System.out.print(prompt + " ");
        System.out.flush();
    }

    //Method to make sure no data is available in the
    //input stream
    public static void inputFlush() {
        int dummy;
        int bAvail;

        try {
            while ((System.in.available()) != 0)
                dummy = System.in.read();
        } catch (java.io.IOException e) {
            System.out.println("Input error");
        }
    }

    //********************************
    //  data input methods for
    //string, int, char, and double
    //********************************
    public static String inString(String prompt) {
        inputFlush();
        printPrompt(prompt);
        return inString();
    }

    public static String inString() {
        int aChar;
        String s = "";
        boolean finished = false;

        while (!finished) {
            try {
                aChar = System.in.read();
                if (aChar < 0 || (char) aChar == '\n')
                    finished = true;
                else if ((char) aChar != '\r')
                    s = s + (char) aChar; // Enter into string
            } catch (java.io.IOException e) {
                System.out.println("Input error");
                finished = true;
            }
        }
        return s;
    }

    public static int inInt(String prompt) {
        while (true) {
            inputFlush();
            printPrompt(prompt);
            try {
                return Integer.valueOf(inString().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Not an integer");
            }
        }
    }

    public static char inChar(String prompt) {
        int aChar = 0;

        inputFlush();
        printPrompt(prompt);

        try {
            aChar = System.in.read();
        } catch (java.io.IOException e) {
            System.out.println("Input error");
        }
        inputFlush();
        return (char) aChar;
    }

    public static double inDouble(String prompt) {
        while (true) {
            inputFlush();
            printPrompt(prompt);
            try {
                return Double.valueOf(inString().trim());
            } catch (NumberFormatException e) {
                System.out
                        .println("Invalid input. Not a floating point number");
            }
        }
    }
}
