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
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.json.JSONArray;

import java.net.URL;
import java.util.ResourceBundle;

public class Dialog2stdController implements Initializable {
    JSONArray myjson;
    int index;
    String einp;
    String eout;
    String out;
    String timel;
    Dialog2stdController(String einp,String eout,String out, String timel){
        this.einp=einp;
        this.eout=eout;
        this.out=out;
        this.timel=timel;

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

    Dialog2stdController(JSONArray myjson, int index){
        this.myjson=myjson;
        this.index=index;
    }

    @FXML
    private Button return1;
    @FXML
    private Button time;
    @FXML
    private Rectangle head;
    @FXML
    private Label addLabel;
    @FXML
    private TextArea eoutput;
    @FXML
    private TextArea output;
    @FXML
    private TextArea input;
    @FXML
    private Label label1;
    @FXML
    private Label timelab;
    @FXML
    private Label label11;
    @FXML
    private Label label2;
    @FXML
    private DialogPane dp;
    @FXML
    private Pane linepane;
    @FXML
    private Line sep;

    public Line[] createLines(Pane blackpane, String colour){

        Line[] lines = new Line[200];
        double lineX = -200;
        double lineY = -500;

        CustomAnimations animator = new CustomAnimations();

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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        drag(dp);
        createLines(linepane,"#4D4D4D");

        dp.requestFocus();
        dp.setFocusTraversable(true);

        dp.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {

                Stage stage = (Stage) return1.getScene().getWindow();

                stage.close();

            }
        });

        LinearMoveY(head,500,-200,0,0);
        FadeIn(addLabel,250,500);
        LinearMoveY(return1,500,200,0,0);
        ScaleX(input,750,2,1,0);
        LinearMoveX(output,750,500,0,0);
        LinearMoveX(eoutput,750,-500,0,0);
        FadeIn(label1,1000,500);
        FadeIn(label11,1000,500);
        FadeIn(label2,1000,500);
        FadeIn(timelab,100,1000);
        FadeIn(sep,100,750);
        FadeIn(time,100,1000);
        LinearMoveX(sep,250,100,-0,750);
        LinearMoveY(time,250,-100,0,1000);
        LinearMoveY(timelab,250,-100,0,1000);


        input.setText(einp);
        eoutput.setText(eout);
        output.setText(out);
        time.setText(timel);









    }



    @FXML
    public void quit(){



        Stage stage = (Stage) return1.getScene().getWindow();

        stage.close();


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

    public void ScaleX(Node node, int duration, double from, double to, int delay){

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDuration(Duration.millis(duration));
        scale.setFromX(from);
        scale.setToX(to);
        scale.setDelay(Duration.millis(delay));
        scale.play();


    }

    public void FadeIn(Node node, int duration, int delay){

        Vanish(node,delay);
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

    public void LinearMoveX(Node node, int duration, int from, int to ,int delay ){

        TranslateTransition move = new TranslateTransition();
        move.setNode(node);
        move.setDuration(Duration.millis(duration));
        move.setFromX(from);
        move.setToX(to);
        move.setCycleCount(1);
        move.setAutoReverse(false);
        move.setDelay(Duration.millis(delay));
        move.play();


    }


}



