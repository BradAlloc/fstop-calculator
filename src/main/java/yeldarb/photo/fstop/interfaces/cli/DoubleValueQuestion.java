package yeldarb.photo.fstop.interfaces.cli;

import java.util.Scanner;

/**Facilitates asking a question to the user on CLI and storing the answer.*/
public class DoubleValueQuestion{
    private static final String DEFAULT_ERROR_MESSAGE = "Entered number was not a valid Double.";

    private Double value;
    private Boolean hasLegalValue;
    private String questionText;
    private String errorMessage;

    /**Initialize a question with a blank prompt.*/
    public DoubleValueQuestion(){
        this.errorMessage = DEFAULT_ERROR_MESSAGE;
        this.hasLegalValue = false;
        this.questionText = "";
    }

    /**Set the Question text
     *
     * @param questionText The text for the question to ask as the prompt.*/
    public DoubleValueQuestion(String questionText){
        this.errorMessage = DEFAULT_ERROR_MESSAGE;
        this.hasLegalValue = false;
        this.questionText = questionText;
    }

    /**Ask the question until it's properly answered.  Prompt does not include line break.*/
    public void ask(){
        this.hasLegalValue = false;
        this.value = null;

        if(questionText != null){
            while(!this.hasLegalValue) {
                System.out.print(questionText);

                String userInput = "";
                Scanner in = new Scanner(System.in);
                userInput = in.nextLine();

                try{
                   this.value = Double.valueOf(userInput);
                   this.hasLegalValue = true;
                } catch (NumberFormatException nfe){
                    //Don't set sentinal to be valid.
                    System.out.println(errorMessage);
                }

                System.out.print('\n');
            }
        }
    }

    public Double getValue(){
        return this.value;
    }

    public void setQuestionText(String questionText){
        this.questionText = questionText;
    }
}
