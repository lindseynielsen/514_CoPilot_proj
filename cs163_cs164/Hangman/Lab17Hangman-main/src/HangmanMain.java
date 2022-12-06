/*
 * public static void main(String[] args)
For this method, you will need to:
Create a new HangmanGame object
Call the printScreen() method (remember how to call methods on different objects!)
Use getInput("Would you like easy or hard words? ") to get user input on what difficulty they would like
Call initializeWords(), passing in selectDifficulty(), which requires the input from the user you just got.
Call wordSelect().
Print the initial hangman gallows by calling getZero().
Call printWordProgress()
While the game is not finished, get input from the user on what letter they guess using getInput("Guess a letter: ") and call guess(), passing in the guess input.
Parameters:
args -
 */

public class HangmanMain {

    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        game.view.printScreen();
        String difficulty = game.view.getInput("Would you like easy or hard words? ");
        game.initializeWords(game.selectDifficulty(difficulty));
        game.wordSelect();
        game.view.getZero();
        game.printWordProgress();
        while(!game.finished) {
            String guess = game.view.getInput("Guess a letter: ");
            game.guess(guess);
        }
    }
}
