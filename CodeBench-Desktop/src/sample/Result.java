package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class Result implements Initializable {
    @FXML
    Label time;
    @FXML
    Label lint;
    @FXML
    Label total;
    @FXML
    Label agreg;
    @FXML
    Label tpercent;
    @FXML
    Label ttest;
    @FXML
    Label stest;

    @FXML
    private BorderPane center;
    @FXML
    private ScrollPane scroll;
    @FXML
    private Pane backpane;
    @FXML
    FlowPane testfp;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Label courselabel;
    @FXML Button saveresult;
    @FXML BorderPane buttonpane;
    @FXML BorderPane remarkpane;
    @FXML BorderPane back1;
    @FXML BorderPane back11;
    @FXML BorderPane grade2;
    @FXML BorderPane grade22;
    @FXML BorderPane grade222;
    @FXML BorderPane line11;
    @FXML BorderPane line111;
    @FXML Label lab1;
    @FXML Label lab2;
    @FXML Label lab3;
    @FXML Label lab4;
    @FXML Label lab5;
    @FXML Label remark;
    @FXML AnchorPane graph1;
    @FXML AnchorPane graph2;
    @FXML
    Arc testarc;
    @FXML
    Arc lintarc;
    @FXML
    Arc gradearc;
    @FXML TextField remarks;
    @FXML
    Rectangle line1;

    CustomAnimations animatior = new CustomAnimations();



    public void initialize(URL url, ResourceBundle resourceBundle) {

        animatior.FadeIn(back1,100,250);
        animatior.ScaleX(back1,250,0,1,250);
        animatior.LinearMoveX(back1 , 250, -319/2, 0 ,250);
        animatior.FadeIn(back11,100,250);
        animatior.ScaleX(back11,250,0,1,250);
        animatior.LinearMoveX(back11 , 250, -319/2, 0 ,250);

        animatior.FadeIn(grade2,100,250);
        animatior.ScaleX(grade2,250,0,1,250);
        animatior.LinearMoveX(grade2 , 250, -262/2, 0 ,250);


        animatior.FadeIn(grade22,100,250);
        animatior.ScaleX(grade22,250,0,1,250);
        animatior.LinearMoveX(grade22 , 250, -262/2, 0 ,250);

        animatior.FadeIn(grade222,100,250);
        animatior.ScaleX(grade222,250,0,1,250);
        animatior.LinearMoveX(grade222 , 250, -262/2, 0 ,250);

        animatior.FadeIn(lab1,100,500);
        animatior.Scale(lab1, 0 , 1 ,250, 500);

        animatior.FadeIn(lab2,100,500);
        animatior.Scale(lab2, 0 , 1 ,250, 500);

        animatior.FadeIn(lab3,100,500);
        animatior.Scale(lab3, 0 , 1 ,250, 500);

        animatior.FadeIn(lab4,100,500);
        animatior.Scale(lab4, 0 , 1 ,250, 500);

        animatior.FadeIn(lab5,100,500);
        animatior.Scale(lab5, 0 , 1 ,250, 500);

        animatior.FadeIn(remark,100,250);
        animatior.ScaleX(remark,250,0,1,250);
        animatior.LinearMoveX(remark , 250, -440/2, 0 ,250);

        animatior.FadeIn(line111,100,250);
        animatior.ScaleX(line111,250,0,1,250);
        animatior.LinearMoveX(line111 , 250, -440/2, 0 ,250);

        animatior.FadeIn(remarks,100,250);
        animatior.ScaleY(remarks,250,0,1,250);
        animatior.LinearMoveY(remarks , 250, 15/2, 0 ,250);

        animatior.FadeIn(line11,100,250);
        animatior.ScaleY(line11,250,0,1,250);
        animatior.LinearMoveY(line11 , 250, -395/2, 0 ,250);

        animatior.FadeIn(saveresult,100,500);
        animatior.ScaleX(saveresult, 0 , 1 ,250, 500);

        animatior.FadeIn(graph1,100,500);
        animatior.Scale(graph1, 0 , 1 ,250, 500);

        animatior.FadeIn(graph2,100,500);
        animatior.Scale(graph2, 0 , 1 ,250, 500);





        animatior.FadeIn(tpercent,100,1000);
        animatior.FadeIn(agreg,100,1000);
        animatior.FadeIn(ttest,100,1000);
        animatior.FadeIn(stest,100,1000);
        animatior.FadeIn(total,100,1000);
        animatior.FadeIn(lint,100,1000);
        animatior.FadeIn(time,100,1000);

        testfp.prefWidthProperty().bind(scroll.widthProperty());
        testfp.minWidthProperty().bind(scroll.widthProperty());
        testfp.maxWidthProperty().bind(scroll.widthProperty());
        anchor.prefHeightProperty().bind(testfp.heightProperty());
        anchor.minHeightProperty().bind(testfp.heightProperty());
        anchor.maxHeightProperty().bind(testfp.heightProperty());
        backpane.prefHeightProperty().bind(scroll.heightProperty());
        backpane.prefWidthProperty().bind(scroll.widthProperty());
        backpane.minHeightProperty().bind(scroll.heightProperty());
        backpane.minWidthProperty().bind(scroll.widthProperty());
        backpane.maxHeightProperty().bind(scroll.heightProperty());
        backpane.maxWidthProperty().bind(scroll.widthProperty());
        saveresult.prefWidthProperty().bind(buttonpane.widthProperty());
        saveresult.maxWidthProperty().bind(buttonpane.widthProperty());
        remarks.prefWidthProperty().bind(remarkpane.widthProperty());
        remarks.maxWidthProperty().bind(remarkpane.widthProperty());
        remarks.prefHeightProperty().bind(remarkpane.heightProperty());
        remarks.maxHeightProperty().bind(remarkpane.heightProperty());



    }
}
