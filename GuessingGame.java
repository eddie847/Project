import java.util.*;


class GuessingGame<T> {
	
    private final ArrayList<T> guessHistory; 	//ArrayList to store the players guesses
    private final Set<T> duplicateCheck;				//HashSet to check for duplicates
    private final int secretNumber;
    private int attempts;

    public GuessingGame(int maxNumber) {
        this.guessHistory = new ArrayList<>();
        this.duplicateCheck= new HashSet<>();
        
        //random number between 1 and 100
        Random rand = new Random();
        this.secretNumber = rand.nextInt(maxNumber) + 1;
        this.attempts = 0;
    }

   public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean isGameOver = false;

        System.out.println("Welcome to the Generic Number Guessing Game!");
        System.out.println("I have chosen a number between 1 and 100. Try to guess it!");

        while (!isGameOver) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            T guess =(T) Integer.valueOf(userGuess);
            
            if(duplicateCheck.contains(guess)) {
            	System.out.println("You already guessed that number! " );
            }
            
            storeGuess(guess);
            attempts++;

            if (userGuess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                isGameOver = true;
            }

            //Shows all previous guesses
            System.out.println("Your guesses so far: " + guessHistory);
        }
        
    }


    private void storeGuess(T guess) {
        guessHistory.add(guess);
        duplicateCheck.add(guess);
    }


  public static void main(String[] args) {
        GuessingGame<Integer> game = new GuessingGame<>(100); 
        game.play();
    }
}


