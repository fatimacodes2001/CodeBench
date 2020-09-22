package sample;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Errorstd implements Initializable {
    @FXML
    private Button return1;
    @FXML
    private Rectangle head;
    @FXML
    private Label addLabel;
    @FXML
    Label errorm;
    @FXML
    public Label header;
    @FXML
    public DialogPane dp;
    @FXML
    public Pane linepane;
    Boolean bool;

    CustomAnimations animator = new CustomAnimations();

    String message;
    String name;
    String var1 = "Kuch bhi dikhaya jaa skta hai";
    Errorstd(){
        this(null,null);
    }
    Errorstd(String message, String name){
        this.message=message;
        this.name=name;
    }

    public Line[] createLines(Pane blackpane, String colour){

        Line[] lines = new Line[200];
        double lineX = -200;
        double lineY = -500;


        for (int i = 0 ; i<199 ; i++){

            Line line = new Line();

            line.setStartX(0);
            line.setEndX(2000);
            line.setStartY(0);
            line.setEndY(0);
            line.setRotate(-30);
            line.setFill(Color.web(colour));
            line.setStroke(Color.web(colour));
            line.setStrokeWidth(1.5);
            lines[i] = line;
            lines[i].setLayoutX(lineX);
            lines[i].setLayoutY(lineY);

            if ( i%2 == 1 ) {
                animator.FadeIn(lines[i],100,250);
                animator.LinearMoveX(lines[i], 1500, 1732, 1, 250);
                animator.LinearMoveY(lines[i], 1500, -1000, 1, 250);
            }
            else{
                animator.FadeIn(lines[i],100,1250);
                animator.LinearMoveX(lines[i], 2500, -1732, 1, 250);
                animator.LinearMoveY(lines[i], 2500, 1000, 1, 250);
            }

            blackpane.getChildren().add(lines[i]);

            lineY +=7.5;

        }

        return lines;

    }

    Stage primaryStage;

    private double xOffset = 0 ;
    private double yOffset = 0 ;

    public void drag(Pane apane){

        apane.setOnMousePressed(((event) -> {

            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        }));

        apane.setOnMouseDragged(((event) -> {

            primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            primaryStage.setX(event.getScreenX()-xOffset);
            primaryStage.setY(event.getScreenY()-yOffset);

        }));

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        drag(dp);


        dp.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {

                Stage stage = (Stage) return1.getScene().getWindow();

                stage.close();

            }
        });

        Rectangle clipper = new Rectangle();
        clipper.setWidth(380);
        clipper.setHeight(152);
        clipper.setLayoutX(2);
        clipper.setLayoutY(0);
        linepane.setClip(clipper);

        createLines(linepane,"#4D4D4D");
        errorm.setText(message);
        addLabel.setText(name);
        Vanish(errorm,500);
        FadeIn(errorm,500,500);
        LinearMoveY(return1,750,500,0,0);
        LinearMoveY(head,500,-200,0,0);
        Vanish(addLabel,500);
        FadeIn(addLabel,500,500);


    }

    @FXML
    public void quit(){
        bool=false;

        Stage stage = (Stage) return1.getScene().getWindow();

        popup(return1,120);

        stage.close();

    }

    public void popup(Node node, int duration){

        Scale(node,duration,0,1.2,true,1,0);
        Scale(node,duration,1.2,1,true,1,duration);


    }

    public void Scale(Node node, int duration, double from, double to,boolean repeat,int cycles,int delay){

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDuration(Duration.millis(duration));
        scale.setFromX(from);
        scale.setFromY(from);
        scale.setToX(to);
        scale.setToY(to);
        scale.setCycleCount(cycles);
        scale.setDelay(Duration.millis(delay));
        scale.setAutoReverse(repeat);
        scale.play();


    }


    public void FadeIn(Node node, int duration, int delay){

        FadeTransition fade = new FadeTransition();
        fade.setNode(node);
        fade.setDuration(Duration.millis(duration));
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.setDelay(Duration.millis(delay));
        fade.play();

    }

    public void Vanish(Node node, int duration){

        FadeTransition fade = new FadeTransition();
        fade.setNode(node);
        fade.setDuration(Duration.millis(duration));
        fade.setFromValue(0);
        fade.setToValue(0);
        fade.play();

    }


    public void ScaleX(Node node, int duration, int from, int to,boolean repeat,int cycles,int delay){

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDuration(Duration.millis(duration));
        scale.setFromX(from);
        scale.setToX(to);
        scale.setCycleCount(cycles);
        scale.setDelay(Duration.millis(delay));
        scale.setAutoReverse(repeat);
        scale.play();


    }

    public void LinearMoveY(Node node, int duration, int from, int to , int delay ){

        TranslateTransition move = new TranslateTransition();
        move.setNode(node);
        move.setDuration(Duration.millis(duration));
        move.setFromY(from);
        move.setToY(to);
        move.setCycleCount(1);
        move.setAutoReverse(false);
        move.setDelay(Duration.millis(delay));
        move.play();


    }
}
