/**********************************************************************
 * @file Jeopardy.java
 * @brief correctly aligning string data with user input, how to call on Question method/class
 * @author ANNA HALLORAN, MEG WONG
 * @date: 5/2/24
 * @acknowledgement: Mallory Pits
 ***********************************************************************/

import java.util.Scanner;
public class Jeopardy { // class 1

    public static void main(String[] args) { // main method for gam board and switch turns of players and report winner

        System.out.println("Welcome to Wake Forest Jeopardy! Let's get started!"); // print header and welcome message
        Question[] questions = questionData(); // call on Question method/class

        String[][] board = {{"100", "100", "100", "100", "100"}, // string array to store question levels (easiest to hardest)
                {"200", "200", "200", "200", "200"},
                {"300", "300", "300", "300", "300"},
                {"400", "400", "400", "400", "400"}};

        Scanner scanner = new Scanner(System.in);

        int questionsLeft = 20; // define and declare variables
        int playerNumber = 1;
        int player1points = 0;
        int player2points = 0;

        while (questionsLeft > 0) { // BIG while loop to rotate player turns and keep track of player points

            System.out.println("---------------------------------------------------");
            System.out.println("It is Player " + playerNumber + "'s Turn!");
            System.out.println("---------------------------------------------------");

            if (playerNumber == 1) {

                player1points += askQuestion(questions, board);
                playerNumber = 2;
            }
            else {
                player2points += askQuestion(questions, board);
                playerNumber = 1;
            }

            System.out.println("---------------------------------------------------");
            System.out.println("Player 1 points: " + player1points + "   Player 2 points: " + player2points);
            System.out.println("---------------------------------------------------"); // display player points after each question is answered

            System.out.print("Do you want to continue (c) or quit (q)? "); // prompt players to continue playing or quit
            String continueOrQuit = scanner.next().toUpperCase();

            if (continueOrQuit.equals("Q")) { // if player(s) quit, display ending game stats (points) and who won/ if it's a tie
                System.out.println("---------------------------------------------------");
                System.out.println("Player 1 points: " + player1points + "   Player 2 points: " + player2points);
                if (player1points > player2points) {
                    System.out.println("Player 1 wins!");
                }
                else {
                    if (player1points < player2points) {
                    System.out.println("Player 2 wins!"); }
                    else {
                            System.out.println("It's a tie!");
                        }
                }
                System.out.println("---------------------------------------------------");
                System.exit(0);
            }

            questionsLeft--;

        }
    }

    public static void printBoard(String[][] board) { //printBoard method to display jeopardy board at the beggining of the game and after each turn
        System.out.println("| Library | Stadium |   Gym   |   Pit   |  Chapel |");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < 4; i++) {
            System.out.print("|   ");
            for (int j = 0; j < 5; j++) { // center point numbers on board and equally space them
                System.out.print(board[i][j] + "   |   ");
            }
            System.out.println();
        }
    }


    public static int askQuestion(Question[] questions, String[][] board) { //askQuestion method for user interaction

        char playerCategoryChoice; // define and declare variables
        int playerPointChoice;
        int playerQuestionChoice;

        Scanner scanner = new Scanner(System.in);

        printBoard(board);
        System.out.print("Select Category (Enter first lowercase initial; ex: l (Library), s (Stadium), g (Gym), p (Pit), or c (Wait Chapel): "); // prompt user to choice their category
        playerCategoryChoice = scanner.next().charAt(0);
        System.out.print("Enter point value selection: "); // prompt user to select question level (100, 200, 300, 400)
        playerPointChoice = scanner.nextInt();
        playerQuestionChoice = (playerPointChoice / 100) - 1;
        int i = 0;
        if (playerCategoryChoice == 'l') { // call on library questions if entered "l"
            i = 0;
        } else if (playerCategoryChoice == 's') { // call on stadium questions if entered "s"
            i = 1;
            playerQuestionChoice += 4;
        } else if (playerCategoryChoice == 'g') { // call on gym questions if entered "g"
            i = 2;
            playerQuestionChoice += 8;
        } else if (playerCategoryChoice == 'p') { // call on Pit questions if entered "p"
            i = 3;
            playerQuestionChoice += 12;
        } else if (playerCategoryChoice == 'c') { // call on chapel questions if entered "c"
            i = 4;
            playerQuestionChoice += 16;
        }
        System.out.println("---------------------------------------------------");
        System.out.println(questions[playerQuestionChoice].getPrompt());
        String[] currentOptions = questions[playerQuestionChoice].getOptions(); // print multiple choice for each question
        System.out.println("A. " + currentOptions[0]);
        System.out.println("B. " + currentOptions[1]);
        System.out.println("C. " + currentOptions[2]);
        System.out.println("D. " + currentOptions[3]);

        board[(playerPointChoice / 100) - 1][i] = "   ";

        System.out.print("Enter your answer (A, B, C, or D): "); // prompt user for answer (A, B, C, D)
        String input = scanner.next().toUpperCase();

        if (input.charAt(0) == questions[playerQuestionChoice].getAnswer()) { // check answer incorrect/correct and + points amount if correct
            System.out.println("Correct!");
            return playerPointChoice;
        } else {
            System.out.println("Incorrect. The correct answer is option " + questions[playerQuestionChoice].getAnswer());
            return 0; // if incorrect, display correct answer and count points as 0
        }

    }

    public static Question[] questionData() { // questionData method to store/define game data (questions, answers, multiple choice, etc.)

        Question[] questions = new Question[20]; // call back on question array

        //String array for prompts
        String[] prompts = {"How many floors are there in the ZSR Library?",
                "Which notable author's personal papers are housed in the special collections department?",
                "How many study rooms are available for student use in the ZSR Library?",
                "When was the ZSR Library at Wake Forest University established?",
                "How many football seasons did Sam Hartman play for the Deacs?",
                "When was the last time the Wake Forest football team won the ACC Championship?",
                "Who is the winningest head coach in Wake Forest football history?",
                "What is the capacity of the Allegacy Federal Credit Union Stadium?",
                "Which of the following amenities is NOT available at Reynolds?",
                "Which of the following group fitness classes is NOT offered at Reynolds gym at Wake Forest?",
                "What are the operating hours of the gym during weekdays?",
                "How many square feet is Reynolds gymnasium at Wake Forest University?",
                "The North Dining Hall does NOT have which of the following?",
                "What is the name of the student-led organization that redistributes food from the pit to our community partners?",
                "What is the largest meal plan a student may have?",
                "How many food stations are at the pit?",
                "What is the name of the Moravian celebration held annually at the chapel?",
                "What year was the Face to Face program launched?",
                "What year was the chapel built?",
                "Who was a speaker during the virtual Face to Face forum?"};

        //String array for options
        String[][] optionArray = {{"8", "7", "6", "5"},
                {"William Shakespeare", "Maya Angelou", "George Orwell", "Oscar Wilde"},
                {"40", "70", "100", "50"},
                {"1941", "1962", "1956", "1966"},
                {"3", "4", "5", "2"},
                {"1970", "2006", "2021", "1994"},
                {"Jim Caldwell", "Dave Clawson", "Jim Grobe", "Peahead Walker"},
                {"31,500", "30,000", "42,000", "30,500"},
                {"Indoor pool", "Hot tub", "Steam rooms", "Badminton Courts"},
                {"Pilates", "Cycling", "Hot yoga", "Cardio dance"},
                {"6:30AM–11:30PM", "6:00AM–12AM", "6:00AM–11PM", "5:30AM-12:30AM"},
                {"235,000", "132,000", "290,000", "315,000"},
                {"Soups", "Peanut butter", "Vegan station", "Coffee machine"},
                {"Campus Kitchen", "Campus Gardens", "Swipe Out Hunger", "dEaCOfriendly"},
                {"Forestry Plan", "Freedom Plan", "Gold Plan", "Black Plus Plan"},
                {"5", "10", "11", "12"},
                {"Luminaries", "Face to Face", "Communion", "Lovefeast"},
                {"1985", "2006", "2018", "2020"},
                {"1834", "1956", "1962", "1974"},
                {"Isabel Wilkerson", "George W. Bush", "Malcolm Gladwell", "Yo Yo Ma"},
        };

        char[] answers = {'A', 'B', 'D', 'C', 'C', 'B', 'D', 'A', 'C', 'C', 'D', 'A', 'C', 'A', 'B', 'C', 'D', 'D', 'B', 'A'}; // char array for answers

        for (int i = 0; i < 20; i++) { // for loop to organize the right questions with the right answers/ letter choices
            String prompt = prompts[i];
            String[] options = {optionArray[i][0], optionArray[i][1], optionArray[i][2], optionArray[i][3]};
            char answer = answers[i];
            questions[i] = new Question(prompt, options, answer);
        }

        return questions; // return the questions above when chosen by user
    }
}