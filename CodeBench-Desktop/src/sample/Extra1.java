package sample;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Extra1 implements Initializable {


    @FXML
    VBox box;
    @FXML
    ScrollPane scpane;
    @FXML
    AnchorPane apane;
    @FXML
    BorderPane mainpane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        scpane.prefWidthProperty().bind(mainpane.widthProperty());
        box.prefWidthProperty().bind(mainpane.widthProperty());
        apane.prefHeightProperty().bind(box.heightProperty());

        createCardStd("Detail",1,1000,box,"20", "256","");
        createCardStd("Passed",1,1000,box,"20","256","256");
        createCardStd("Failed",1,1000,box,"20","256","512");



    }




    public Node createCardStd(String status, int num, int delay, VBox bp ,String input , String expectedOutput, String output){


        StudentCard c1 = new StudentCard();
        Node n1 = c1.makeStudentCard(num,status,input,expectedOutput,output);
        Button b1 = c1.getgradeButton();
        Label l1 = c1.getNameLabel();
        BorderPane bpm = c1.getBp1();

//        bpm.prefWidthProperty().bind(bp.widthProperty());
//        bpm.minWidthProperty().bind(bp.widthProperty());
//        bpm.maxWidthProperty().bind(bp.widthProperty());
        bp.getChildren().add(n1);
        Vanish(n1,delay);
        FadeIn(n1,100,delay);
        popup(n1,200,delay);
        Vanish(b1,400+delay);
        FadeIn(b1,200,400+delay);
        ScaleX(b1,200,0,1,false,1,400+delay);
        LinearMoveY(b1,400,-20,-20,300+delay);
        LinearMoveY(b1,200,-20,0,700+delay);
        Vanish(l1,700+delay);
        FadeIn(l1,200,700+delay);
        Vanish(c1.getBp4(),700+delay);
        FadeIn(c1.getBp4(),200,700+delay);
        Vanish(c1.getBp5(),700+delay);
        FadeIn(c1.getBp5(),200,700+delay);
        Vanish(c1.getBp6(),700+delay);
        FadeIn(c1.getBp6(),200,700+delay);

        return n1;


    }



    public void popup(Node node, int duration){

        Scale(node,duration,0,1.2,true,1,0);
        Scale(node,duration,1.2,1,true,1,duration);


    }
    public void popup(Node node, int duration,int delay){

        Scale(node,duration,0,1.2,true,1,delay);
        Scale(node,duration,1.2,1,true,1,duration+delay);


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

    public void ScaleY(Node node, int duration, double from, double to, int delay){

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDuration(Duration.millis(duration));
        scale.setFromY(from);
        scale.setToY(to);
        scale.setCycleCount(Animation.INDEFINITE);
        scale.setAutoReverse(true);
        scale.setDelay(Duration.millis(delay));
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

    public void ScaleX(Node node, int duration, double from, double to, int delay){

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDuration(Duration.millis(duration));
        scale.setFromX(from);
        scale.setToX(to);
        scale.setCycleCount(Animation.INDEFINITE);
        scale.setAutoReverse(true);
        scale.setDelay(Duration.millis(delay));
        scale.play();


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

    public void LinearMoveY(Node node, int duration, double from, double to ,int delay ){

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
    public void LinearMoveX(Node node, int duration, double from, double to ,int delay ){

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



