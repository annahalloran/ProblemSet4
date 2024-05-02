public class Question { // "client" method
    private String prompt;
    private String[] options = new String[4];
    private char answer;

    public Question(String prompt, String[] options, char answer) { // Constructor for Question parameters to be retrieved in Jeopardy class.
        //Display prompt, options, and correct answer associated with user's input
        this.prompt = prompt;
        this.answer = answer;
        this.options[0] = options[0];
        this.options[1] = options[1];
        this.options[2] = options[2];
        this.options[3] = options[3];
    }

    public String getPrompt() { //Display prompt on user's screen from Jeopardy class's prompt String
        return prompt;
    }

    public String[] getOptions() { //Display options on user's screen from Jeopardy class's options String
        return options;
    }

    public char getAnswer() { //Display if the user correctly identified answer, pulling from char array in Jeopardy class
        return answer;
    }
}
