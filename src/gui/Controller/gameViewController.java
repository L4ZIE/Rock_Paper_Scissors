package gui.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class gameViewController {

    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";
    private Image image;

    @FXML
    private Button rockButton;

    @FXML
    private Button paperButton;

    @FXML
    private Button scissorsButton;

    @FXML
    private Label result;

    @FXML
    private Label pScore;

    @FXML
    private Label cScore;

    @FXML
    private ImageView pChoice;

    @FXML
    private ImageView cChoice;

    @FXML
    private void pTurn(ActionEvent event){
        String playerChoice = null;
        switch(((Button) event.getSource()).getId()){
            case "paperButton":
                image = new Image("@../../Images/ic_paper.png");
                playerChoice=PAPER;
                break;
            case "scissorsButton":
                image= new Image("@../../Images/ic_scissors.png");
                playerChoice=SCISSORS;
                break;
            case "rockButton":
                image= new Image("@../../Images/ic_rock.png");
                playerChoice = ROCK;
                break;
        }
        pChoice.setImage(image);

        winner(playerChoice, cTurn());
    }



    private String cTurn(){
        String computerChoice = null;
        int random =(int) (Math.random()*3);
        switch (random){
            case 0:
                image= new Image("@../../Images/ic_rock.png");
                computerChoice = ROCK;
                break;
            case 1:
                image= new Image("@../../Images/ic_paper.png");
                computerChoice = PAPER;
                break;
            case 2:
                image= new Image("@../../Images/ic_scissors.png");
                computerChoice = SCISSORS;
                break;
        }
        cChoice.setImage(image);
        return computerChoice;
    }

    public void pWin(){
        result.setText("You actually won");
        pScore.setText(String.valueOf(Integer.parseInt(pScore.getText()) + 1));
    }

    public void cWin(){
        result.setText("HAHA too bad");
        cScore.setText(String.valueOf(Integer.parseInt(cScore.getText()) + 1));
    }

    public void draw(){
        result.setText("Draw, try again");
    }

    private void winner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)){
            draw();
            return;
        }
        if (playerChoice.equals(ROCK)){
            if (computerChoice.equals(PAPER)){
                cWin();
            } else if (computerChoice.equals(SCISSORS)){
                pWin();
            }
        } else if (playerChoice.equals(PAPER)) {
            if (computerChoice.equals(SCISSORS)){
                cWin();
            } else if (computerChoice.equals(ROCK)) {
                pWin();
            }
        } else if (playerChoice.equals(SCISSORS)) {
            if (computerChoice.equals(ROCK)){
                cWin();
            } else if (computerChoice.equals(PAPER)){
                pWin();
            }
        }
    }
}
