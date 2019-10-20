import java.util.Scanner;
import java.security.SecureRandom;

public class mian_p1 {

    public static int difficultyLevel(Scanner scnr) {
        System.out.println("Please select a difficulty level from 1-4:");
        return scnr.nextInt();
    }

    public static int questionType(Scanner scnr) {
        SecureRandom rand = new SecureRandom();

        int choice;

        System.out.println("Please select a question type.");
        System.out.println("1 for addition only");
        System.out.println("2 for multiplication only");
        System.out.println("3 for subtraction only");
        System.out.println("4 for division only");
        System.out.println("5 for a random assortment of all types");

        choice = scnr.nextInt();

        switch (choice) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            default:
                return 5;
        }
    }

    public static int questionGenerator(int difficulty, int type) {
        SecureRandom rand = new SecureRandom();

        int factor1;
        int factor2;
        int randomNum;

        switch(difficulty) {
            case 1:
                factor1 = rand.nextInt(10);
                factor2 = rand.nextInt(10);
                break;
            case 2:
                factor1 = rand.nextInt(100);
                factor2 = rand.nextInt(100);
                break;
            case 3:
                factor1 = rand.nextInt(1000);
                factor2 = rand.nextInt(1000);
                break;
            case 4:
                factor1 = rand.nextInt(10000);
                factor2 = rand.nextInt(10000);
                break;
            default:
                factor1 = rand.nextInt(10);
                factor2 = rand.nextInt(10);
                break;
        }

        switch(type) {
            case 1:
                System.out.println("How much is " + factor1 + " plus " + factor2 + "?");
                return (factor1 + factor2);
            case 2:
                System.out.println("How much is " + factor1 + " times " + factor2 + "?");
                return (factor1 * factor2);
            case 3:
                if(factor1 > factor2) {
                    System.out.println("How much is " + factor1 + " minus " + factor2 + "?");
                    return (factor1 - factor2);
                }
                else {
                    System.out.println("How much is " + factor2 + " minus " + factor1 + "?");
                    return (factor2 - factor1);
                }
            case 4:
                if(factor1 > factor2) {
                    System.out.println("How much is " + factor1 + " divided by " + factor2 + "?");
                    return (factor1 / factor2);
                }
                else {
                    System.out.println("How much is " + factor2 + " divided by " + factor1 + "?");
                    return (factor2 / factor1);
                }
            case 5:
                randomNum = (rand.nextInt(4) + 1);
                if (randomNum == 1) {
                    System.out.println("How much is " + factor1 + " plus " + factor2 + "?");
                    return (factor1 + factor2);
                }
                else if (randomNum == 2) {
                    System.out.println("How much is " + factor1 + " times " + factor2 + "?");
                    return (factor1 * factor2);
                }
                else if (randomNum == 3) {
                    if (factor1 > factor2) {
                        System.out.println("How much is " + factor1 + " minus " + factor2 + "?");
                        return (factor1 - factor2);
                    }
                    else {
                        System.out.println("How much is " + factor2 + " minus " + factor1 + "?");
                        return (factor2 - factor1);
                    }
                }
                else {
                    if (factor1 > factor2) {
                        System.out.println("How much is " + factor1 + " divided by " + factor2 + "?");
                        return (factor1 / factor2);
                    }
                    else {
                        System.out.println("How much is " + factor2 + " divided by " + factor1 + "?");
                        return (factor2 / factor1);
                    }
                }
            default:
                System.out.println("How much is " + factor1 + " plus " + factor2 + "?");
                return (factor1 + factor2);
        }
    }

    public static void messageGenerator(boolean correct) {
        SecureRandom rand = new SecureRandom();

        int randomNum = rand.nextInt(4);

        if(correct) {
            switch(randomNum) {
                case 0:
                    System.out.println("Very good!");
                    break;
                case 1:
                    System.out.println("Excellent!");
                    break;
                case 2:
                    System.out.println("Nice work!");
                    break;
                case 3:
                    System.out.println("Keep up the good work!");
                    break;
            }
        }
        else {
            switch(randomNum) {
                case 0:
                    System.out.println("No. Please try again.");
                    break;
                case 1:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 2:
                    System.out.println("Don't give up!");
                    break;
                case 3:
                    System.out.println("No. Keep trying.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        boolean correct = false;
        boolean flag = true;
        int choice;
        double userAns;
        int correctAns;
        int numCorrect;
        double percentCorrect;
        int i;
        int difficulty;
        int questionType;

        while(flag) {
            numCorrect = 0;

            difficulty = difficultyLevel(scnr);
            questionType = questionType(scnr);

            for(i = 0; i < 10; i++) {
                correct = false;
                correctAns = questionGenerator(difficulty, questionType);
                System.out.println("The correct answer is: " + correctAns);
                userAns = scnr.nextDouble();

                if(Math.abs(userAns - correctAns) < 0.0001) {
                    correct = true;
                    numCorrect++;
                    messageGenerator(correct);
                }
                else {
                    messageGenerator(correct);
                }
            }

            percentCorrect = numCorrect / 10.0;

            if(percentCorrect < 0.75) {
                System.out.println("You answered " + numCorrect + " correctly and " + (10-numCorrect) + " incorrectly.");
                System.out.println("Please ask your teacher for extra help.");
            }
            else {
                System.out.println("You answered " + numCorrect + " correctly and " + (10-numCorrect) + " incorrectly.");
                System.out.println("Congratulations, you are ready to go to the next level!");
            }

            System.out.println("Do you wish to play again? Please type \"1\" to exit and \"2\" to continue.");
            choice = scnr.nextInt();
            if(choice == 1) {
                flag = false;
            }
            else if(choice == 2) {
                flag = true;
            }
        }
    }
}
