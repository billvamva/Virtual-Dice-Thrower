import java.util.*;

public class VDiceThrower{
    public int nthrows;

    // constructor with input
    public VDiceThrower(final int MyThrows) {
        nthrows = MyThrows;
    }

    // constructor for case without input
    public VDiceThrower() {
        nthrows = 0;
    }

    // get sides using scanner input
    public int getSides(final Scanner input) {
        
        int nsides = 0;
        while (true) {
            System.out.printf("Enter number of dice sides: \n");    
            try{
                nsides = input.nextInt();
            // exception handling for case of double
            }catch (InputMismatchException e) {
                System.out.println("Something went wrong. Input not accepted. Try inputting an integer. \n");
                input.nextLine();
                continue;
            }
            
            if (nsides < 2) {
                System.out.printf("the number of sides should be more than 2! \n");
                continue;
            }
            else {
                break;
            }
        }

        return nsides;
    }

    // get number of throws using scanner input and int n with is number of sides
    public void getThrows(final Scanner input, final int n) {
       
        while (true) {
            System.out.printf("Enter how many times the dice should be thrown (multiple of sides): \n");
            try{
                this.nthrows = input.nextInt();
            //using InputMismatch exception to handle cases where user inputs a double instead of an integer
            }catch(InputMismatchException e){
                System.out.println("Something went wrong. Input not accepted. Try inputting an integer or a smaller value. \n");
                input.nextLine();
                continue;
            }
            // we want to make sure that throws are a multiple of 
            if (this.nthrows % n != 0||this.nthrows<1) {
                System.out.printf("the number of throws must be a positive multiple of the number of sides! \n");
                continue;
            }
            break;
        }
    }

    public static void main(final String[] args) {
        // initialize scanner and random number generator
        final Scanner input = new Scanner(System.in);
        final Random RandGen = new Random();
        // initialize new object dice
        final VDiceThrower dice = new VDiceThrower();

        final int number = dice.getSides(input);// get number of sides
        dice.getThrows(input, number);// get number of throws
        
        //array of integers cases which will be of length of the sides of the dice and will represent the instances it occurs
        int[] cases = null;
        cases = new int[number];


        System.out.printf("%d\n", dice.nthrows);
        for (int i = 0; i < dice.nthrows; i++) {
            final int randint = RandGen.nextInt(number);
            // random number used to indicate one side winning for each dice throw
            final int j = randint;
            cases[j] = cases[j]+1;
        }
        //iterate through cases array and print information
        for(int a = 0; a < number;a++){
            System.out.printf("Side: " + a + " Number: " + cases[a] + "\n");
        }
    }
}