import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class RockPaperScissorsUI extends Application {

    private int playerWins = 0;
    private int computerWins = 0;
    private int ties = 0;
    private final String[] choices = {"Rock", "Paper", "Scissors"};
    private final Random random = new Random();

    private Label resultLabel = new Label("Make your choice!");
    private Label scoreLabel = new Label("Player: 0 | Computer: 0 | Ties: 0");

    @Override
    public void start(Stage primaryStage) {
        Button rockBtn = new Button("Rock");
        Button paperBtn = new Button("Paper");
        Button scissorsBtn = new Button("Scissors");

        rockBtn.setOnAction(e -> playRound("Rock"));
        paperBtn.setOnAction(e -> playRound("Paper"));
        scissorsBtn.setOnAction(e -> playRound("Scissors"));

        VBox root = new VBox(15, resultLabel, rockBtn, paperBtn, scissorsBtn, scoreLabel);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 30; -fx-background-color: #f0f0f0;");

        resultLabel.setFont(new Font("Arial", 18));
        scoreLabel.setFont(new Font("Arial", 16));
        rockBtn.setFont(new Font(14));
        paperBtn.setFont(new Font(14));
        scissorsBtn.setFont(new Font(14));

        Scene scene = new Scene(root, 350, 350);
        primaryStage.setTitle("Rock Paper Scissors");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void playRound(String playerChoice) {
        String computerChoice = choices[random.nextInt(3)];

        if (playerChoice.equalsIgnoreCase(computerChoice)) {
            resultLabel.setText("Computer chose " + computerChoice + ". It's a tie!");
            ties++;
        } else if ((playerChoice.equalsIgnoreCase("Rock") && computerChoice.equalsIgnoreCase("Scissors")) ||
                (playerChoice.equalsIgnoreCase("Scissors") && computerChoice.equalsIgnoreCase("Paper")) ||
                (playerChoice.equalsIgnoreCase("Paper") && computerChoice.equalsIgnoreCase("Rock"))) {
            resultLabel.setText("Computer chose " + computerChoice + ". You win!");
            playerWins++;
        } else {
            resultLabel.setText("Computer chose " + computerChoice + ". Computer wins!");
            computerWins++;
        }

        scoreLabel.setText("Player: " + playerWins + " | Computer: " + computerWins + " | Ties: " + ties);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
