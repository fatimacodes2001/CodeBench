package sample;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;



public class CenterStudent implements Initializable {

    @FXML
    VBox vbox;
    @FXML
    ScrollPane spane;
    @FXML
    Pane bpane;
    @FXML
    AnchorPane apane;
    @FXML
    Button butt;
    Show show;
    @FXML
    BorderPane myBP;
    static  Boolean bool;
    @FXML
    Button deadline1;
    @FXML
    Label assNo;
    @FXML
    private BorderPane apr;
    @FXML
    private BorderPane apb;
    @FXML
    private BorderPane aps;
    @FXML
    Button butt1;
    @FXML
    Button butt3;
    @FXML
    Button cenbutt;
    @FXML
    private Pane rec;
    Parent parent;
    @FXML
    private BorderPane lb;
    @FXML
    Button deadline;
    @FXML
    Label assName;
    int assId;

    @FXML BorderPane mainpane;
    @FXML BorderPane cenpane;
    @FXML Pane linepane1;
    @FXML Pane linepane2;
    @FXML Pane linepane3;
    @FXML Pane linepane4;
    @FXML Label deadlinetext;
    @FXML Rectangle separator;
    @FXML Rectangle shadowline;
    @FXML AnchorPane top1;
    @FXML AnchorPane top2;

    File sub;
    String token;
    Stage myStage;
    CenterStudent(String token,Stage myStage){
        this.token=token;
        this.myStage=myStage;
    }

    CustomAnimations animator = new CustomAnimations();


    private double xOffset = 0 ;
    private double yOffset = 0 ;

    public void drag(Pane apane){

        apane.setOnMousePressed(((event) -> {

            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        }));

        apane.setOnMouseDragged(((event) -> {

            myStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            myStage.setX(event.getScreenX()-xOffset);
            myStage.setY(event.getScreenY()-yOffset);

        }));

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


    public Label getAssNo() {
        return assNo;
    }

    public Button getDeadline() {
        return deadline;
    }

    public Label getAssName() {
        return assName;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        drag(mainpane);

        animator.hoverOnbg(deadline,"#A60028","#A60028","#A60028","#A60028",4,2,10);
        animator.hoverOnText(deadline,"#A60028","#A60028","#A60028","#A60028",10);

        createLines(linepane1,"#4D4D4D");
        createLines(linepane2,"#4D4D4D");
        createLines(linepane3,"#4D4D4D");
        createLines(linepane4,"#4D4D4D");

        Rectangle clipper1 = new Rectangle();
        clipper1.setHeight(10);
        clipper1.setWidth(5000);
        clipper1.setLayoutX(0);
        clipper1.setLayoutY(0);
        Rectangle clipper2 = new Rectangle();
        clipper2.setHeight(5000);
        clipper2.setWidth(10);
        clipper2.setLayoutX(0);
        clipper2.setLayoutY(0);
        Rectangle clipper3 = new Rectangle();
        clipper3.setHeight(10);
        clipper3.setWidth(5000);
        clipper3.setLayoutX(0);
        clipper3.setLayoutY(0);
        Rectangle clipper4 = new Rectangle();
        clipper4.setHeight(5000);
        clipper4.setWidth(10);
        clipper4.setLayoutX(0);
        clipper4.setLayoutY(0);


        linepane2.setClip(clipper2);
        linepane4.setClip(clipper4);
        linepane3.setClip(clipper3);
        linepane1.setClip(clipper1);

        animator.FadeIn(butt1,100,500);
        animator.FadeIn(butt3,100,500);
        animator.FadeIn(cenbutt,100,500);
        animator.Vanish(deadline,100);
        animator.Vanish(deadlinetext,100);
        animator.Vanish(separator,100);
        animator.Vanish(assName,100);
        animator.Vanish(assNo,100);
        animator.FadeIn(top1,100,500);
        animator.FadeIn(top2,100,500);
        animator.FadeIn(shadowline,100,500);
        animator.LinearMoveY(top1,500,-100,0,500);
        animator.LinearMoveY(top2,500,-100,0,500);
        animator.LinearMoveY(shadowline,500,-100,0,500);
        animator.FadeIn(butt,250,1000);
        animator.Scale(myBP,250,0,1,0);

        spane.prefWidthProperty().bind(myBP.widthProperty());
        vbox.prefWidthProperty().bind(myBP.widthProperty());
        apane.prefHeightProperty().bind(vbox.heightProperty());
        bpane.prefHeightProperty().bind(myBP.heightProperty());
        bpane.prefWidthProperty().bind(spane.widthProperty().add(20));
        cenbutt.prefWidthProperty().bind(cenpane.widthProperty().add(10));

        //createCardStd("Detail",1,1000,vbox,"20", "256","");
        //createCardStd("Detail",1,1000,vbox,"20","256","256");
        //createCardStd("Detail",1,1000,vbox,"20","256","512");

        butt1.setText("Add submission");
        butt3.setText("+ Submit Assignment");

        rec.prefWidthProperty().bind(lb.widthProperty());
        deadline1.setVisible(false);
        cenbutt.setText("Please choose your submission file.");
        butt1.setVisible(false);
        butt3.setVisible(false);
        cenbutt.setVisible(false);
        butt1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                FileChooser fc=new FileChooser();
                FileChooser.ExtensionFilter pyFilter = new FileChooser.ExtensionFilter(".py Files (*.py)","*.py");
                fc.getExtensionFilters().add(pyFilter);

                sub=fc.showOpenDialog(null);
                if(sub!=null){
                    System.out.println(sub.getAbsolutePath());
                    butt3.getStylesheets().add("right2.css");
                    cenbutt.setText("Submit the file to run it.");
                    butt1.setText(sub.getName());

                }

            }

        });

        butt3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // FileSend fileSend=new FileSend("student/assignments/"+assId+"/submit",token,sub.getAbsolutePath());
                //fileSend.sendFile();
                String charset = "UTF-8";
                String requestURL = "http://127.0.0.1:5000/student/assignments/" + assId + "/submit";

                MultipartUtility multipart = null;
                String response = "";
                try {

                    //StPanel.mine=StPanel.assignments;

                    multipart = new MultipartUtility(requestURL, charset, token);
                    multipart.addFormField("source_code", "source_code");
                    multipart.addFilePart("source_code", new File(sub.getAbsolutePath()));
                    showDialogue("Are you sure you\nwant to submit this file?");
                    response = multipart.finish();

                    Getters g1=new Getters();
                    StPanel.assignments=g1.studAssign(token);



                    if (bool == true) {
                        try {

                            JSONObject visible = new JSONObject(response);
                            if (visible.getJSONArray("visible_test_cases").length() > 0) {
                                if (vbox.getChildren() != null) {
                                    vbox.getChildren().clear();
                                }
                                JSONArray arr = visible.getJSONArray("visible_test_cases");
                                for (int i = 0; i < arr.length(); i++) {
                                    System.out.println(arr.length());
                                    JSONObject single = arr.getJSONObject(i);
                                    String inp = single.getString("expected_input");
                                    String out = single.getString("expected_output");
                                    String actual = single.getString("output");
                                    boolean stat = single.getBoolean("passed");
                                    String status = stat ? "Passed" : "Failed";
                                    createCardStd(status, i, 1000, vbox, inp, out, actual);

                                }
                                butt.setText("SUBMITTED");

                            }   else {
                                butt.setText("SUBMITTED");

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("No visible cases");

                    }
                } catch(NullPointerException e){
                    Prompt prompt=new Prompt("ERROR","Please choose a valid file",mainpane);
                    prompt.showDialogue();



                }catch (IOException e){
                    Prompt prompt=new Prompt("ERROR","Please choose a valid file",mainpane);
                    prompt.showDialogue();
                  
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }});
    }









    public Node createCardStd(String status, int num, int delay, VBox bp , String input , String expectedOutput, String output){


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


    public void showDialogue(String message){

        ColorAdjust dimi = new ColorAdjust();
        dimi.setBrightness(-0.3);
        dimi.setSaturation(-0.3);
        dimi.setContrast(-0.3);
        BoxBlur blur = new BoxBlur(3,3,3);
        System.out.println("Click");
        Dialog<ButtonType> dialog = new Dialog<>();

        dialog.initOwner(mainpane.getScene().getWindow());
        dialog.initStyle(StageStyle.UNDECORATED);
        blur.setInput(dimi);
//        mainpane.setEffect(blur);
        animator.smoothBlurOn(mainpane,250);
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("showBox.fxml"));
            loader.setControllerFactory(t ->new Show(message,"Prompt"));
            show=loader.getController();
            Parent parent=loader.load();
            dialog.getDialogPane().setContent(parent);

        } catch(IOException e){

            System.out.println("Unable to load dialouge Box");
        }
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent()){
        }
        else{
//            mainpane.setEffect(null);
            animator.smoothBlurOff(mainpane,250);
        }


    }

}















class StudentCard {

    public Label line1;
    public BorderPane bp1;
    public BorderPane bp2;
    public BorderPane bp3;
    public BorderPane bp4;
    public BorderPane bp5;
    public BorderPane bp6;
    public TextArea t1;
    public TextArea t2;
    public TextArea t3;
    public Label lab1;
    public Label lab2;
    public Label lab3;
    public Button buttong;

    int number;
    public Node n;

    public StudentCard() {

        bp1 = new BorderPane();
        bp2 = new BorderPane();
        bp3 = new BorderPane();
        bp4 = new BorderPane();
        bp5 = new BorderPane();
        bp6 = new BorderPane();
        t1 = new TextArea();
        t2 = new TextArea();
        t3 = new TextArea();
        lab1 = new Label();
        lab2 = new Label();
        lab3 = new Label();
        line1 = new Label();
        buttong = new Button();

    }

    public Node getStudentCard() {
        return this.bp1;
    }


    public Node makeStudentCard( int num, String status,String input , String expectedOutput , String output) {


        line1.setText("Test Case " + (num + 1));
        line1.setAlignment(Pos.CENTER);
        line1.setContentDisplay(ContentDisplay.CENTER);
        line1.setPrefWidth(86);
        line1.setMaxWidth(86);
        line1.setMinWidth(86);

        t1.setText(input);
        t2.setText(expectedOutput);
        t3.setText(output);


//        vbox = new VBox();
//        vbox.setSpacing(3);
//        vbox.setPadding(new Insets(2, 2, 4, 2));
//        vbox.getChildren().addAll(line1);

        buttong.setText(status);



//        vbox.getChildren().add(buttong);
//        vbox.setCursor(Cursor.HAND);

        bp1.setMaxHeight(66);
        bp1.setMinHeight(66);
        bp1.setPrefHeight(66);
        bp1.setMargin(bp1 , new Insets(10,10,10,10));

        bp1.setLeft(bp2);

        bp1.setStyle("-fx-background-color: #2D2D2D ; -fx-background-radius: 10 ");

        bp2.setMaxHeight(64);
        bp2.setMinHeight(64);
        bp2.setPrefHeight(64);
        bp2.setPrefWidth(106);
        bp2.setMinWidth(106);
        bp2.setMaxWidth(106);

        buttong.setPrefWidth(86);
        buttong.setMaxWidth(86);
        buttong.setMinWidth(86);

        bp2.setPadding(new Insets(10,10,10,10));
        bp2.setTop(line1);
        bp2.setMargin(buttong,new Insets(5,0,0,0));
        bp2.setBottom(buttong);
        buttong.setPadding(new Insets(1,1,1,1));

        DropShadow shadow = new DropShadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);

        shadow.setColor(Color.color(0.1, 0.1, 0.1));
        shadow.setOffsetX(2);
        shadow.setOffsetY(3);
        shadow.setSpread(0.36);
        shadow.setHeight(0);
        shadow.setWidth(40);
        shadow.setRadius(12);

        bp2.setEffect(shadow);

        bp3.setMaxHeight(66);
        bp3.setMinHeight(66);
        bp3.setPrefHeight(66);

        bp1.setCenter(bp3);
        bp3.setLeft(bp4);
        bp3.setCenter(bp5);

        bp4.setMaxHeight(44);
        bp4.setMinHeight(44);
        bp4.setPrefHeight(44);
        bp4.setMargin(bp4, new Insets( 10,5,10,10 ));
        bp4.setPadding( new Insets(5,5,5,5) );
        bp4.setStyle("-fx-background-color: #1a1a1a ; -fx-border-color: #2ecef0 ; -fx-border-width: 2; -fx-border-radius: 5");

        bp4.setTop(lab1);
        lab1.setText("Input");
        lab1.setStyle("-fx-background-color: #2ecef0 ; -fx-font-size: 10 ; -fx-font-family: \"Square721 BT\"  ");
        lab1.setAlignment(Pos.TOP_LEFT);
        bp4.setMargin(lab1,new Insets(-5,-5,-5,-5));
        lab1.setPadding(new Insets(0,5,0,5));

        bp4.setCenter(t1);
        t1.setMinHeight(28);
        t1.setMaxHeight(28);
        t1.setPrefHeight(28);
        t1.getStylesheets().add("textpane.css");
        bp4.setMargin(t1,new Insets(5,-5,-5,-5));

        bp5.setMaxHeight(44);
        bp5.setMinHeight(44);
        bp5.setPrefHeight(44);
        bp5.setPadding( new Insets(5,5,5,5) );
        bp5.setStyle("-fx-background-color: #1a1a1a ; -fx-border-color: #2ecef0 ; -fx-border-width: 2; -fx-border-radius: 5");

        bp5.setTop(lab2);
        lab2.setText("Expected Output");
        lab2.setStyle("-fx-background-color: #2ecef0 ; -fx-font-size: 10 ; -fx-font-family: \"Square721 BT\" ");
        lab2.setAlignment(Pos.TOP_LEFT);
        bp5.setMargin(lab2,new Insets(-5,-5,-5,-5));
        lab2.setPadding(new Insets(0,5,0,5));

        bp5.setCenter(t2);
        t2.setMinHeight(25);
        t2.setMaxHeight(25);
        t2.setPrefHeight(25);
        t2.getStylesheets().add("textpane.css");
        bp5.setMargin(t2,new Insets(5,-5,-5,-5));

        t1.setCursor(Cursor.DISAPPEAR);
        t2.setCursor(Cursor.DISAPPEAR);
        t3.setCursor(Cursor.DISAPPEAR);

        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);

        String smallStatus = status.toLowerCase();
        if(smallStatus.equals("passed")){

            bp3.setRight(bp6);

            bp5.setMargin(bp5, new Insets( 10,5,10,5 ));

            bp6.setMaxHeight(44);
            bp6.setMinHeight(44);
            bp6.setPrefHeight(44);
            bp6.setMargin(bp6, new Insets( 10,10,10,5 ));
            bp6.setPadding( new Insets(5,5,5,5) );
            bp6.setStyle("-fx-background-color: #1a1a1a ; -fx-border-color: #2ecef0 ; -fx-border-width: 2; -fx-border-radius: 5");

            bp6.setTop(lab3);
            lab3.setText("Output");
            lab3.setStyle("-fx-background-color: #2ecef0 ; -fx-font-size: 10 ; -fx-font-family: \"Square721 BT\" ");
            lab3.setAlignment(Pos.TOP_LEFT);
            bp6.setMargin(lab3,new Insets(-5,-5,-5,-5));
            lab3.setPadding(new Insets(0,5,0,5));

            bp6.setCenter(t3);
            t3.setMinHeight(25);
            t3.setMaxHeight(25);
            t3.setPrefHeight(25);
            t3.getStylesheets().add("textpane.css");
            bp6.setMargin(t3,new Insets(5,-5,-5,-5));

            line1.setStyle("-fx-font-weight: bold ; -fx-background-color: transparent ; -fx-text-fill: #191919 ; -fx-font-size: 12 ; -fx-background-radius: 2 ; -fx-font-family: \"Square721 BT\"");

            bp2.setStyle("-fx-background-color: #5FD4BC ; -fx-background-radius: 10 ");
            buttong.setStyle("-fx-font-weight: normal ; -fx-background-color: transparent ; -fx-border-color: #191919 ; -fx-border-radius: 5 ; -fx-border-width: 2 ; -fx-text-fill:  #191919 ; -fx-font-family: \"Square721 BT\" ");

            bp4.prefWidthProperty().bind(bp3.widthProperty().divide(3).subtract(15));
            bp5.prefWidthProperty().bind(bp3.widthProperty().divide(3).subtract(15));
            bp6.prefWidthProperty().bind(bp3.widthProperty().divide(3).subtract(15));


        }

        if(smallStatus.equals("failed")){

            bp3.setRight(bp6);

            bp5.setMargin(bp5, new Insets( 10,5,10,5 ));

            bp6.setMaxHeight(44);
            bp6.setMinHeight(44);
            bp6.setPrefHeight(44);
            bp6.setMargin(bp6, new Insets( 10,10,10,5 ));
            bp6.setPadding( new Insets(5,5,5,5) );
            bp6.setStyle("-fx-background-color: #1a1a1a ; -fx-border-color: #2ecef0 ; -fx-border-width: 2; -fx-border-radius: 5");

            bp6.setTop(lab3);
            lab3.setText("Input");
            lab3.setStyle("-fx-background-color: #2ecef0 ; -fx-font-size: 10 ; -fx-font-family: \"Square721 BT\" ");
            lab3.setAlignment(Pos.TOP_LEFT);
            bp6.setMargin(lab3,new Insets(-5,-5,-5,-5));
            lab3.setPadding(new Insets(0,5,0,5));

            bp6.setCenter(t3);
            t3.setMinHeight(25);
            t3.setMaxHeight(25);
            t3.setPrefHeight(25);
            t3.getStylesheets().add("textpane.css");
            bp6.setMargin(t3,new Insets(5,-5,-5,-5));

            line1.setStyle("-fx-font-weight: bold ; -fx-background-color: transparent ; -fx-text-fill: #191919 ; -fx-font-size: 12 ; -fx-background-radius: 2 ; -fx-font-family: \"Square721 BT\"");

            bp2.setStyle("-fx-background-color: #CE4869 ; -fx-background-radius: 10 ");
            buttong.setStyle("-fx-font-weight: normal ; -fx-background-color: transparent ; -fx-border-color: #191919 ; -fx-border-radius: 5 ; -fx-border-width: 2 ; -fx-text-fill:  #191919 ; -fx-font-family: \"Square721 BT\" ");

            bp4.prefWidthProperty().bind(bp3.widthProperty().divide(3).subtract(15));
            bp5.prefWidthProperty().bind(bp3.widthProperty().divide(3).subtract(15));
            bp6.prefWidthProperty().bind(bp3.widthProperty().divide(3).subtract(15));


        }
        else if (status.equals("detail") || status.equals("Detail")){

            bp5.setMargin(bp5, new Insets( 10,10,10,5 ));

            line1.setStyle("-fx-font-weight: bold ; -fx-background-color: transparent ; -fx-text-fill: #2ecef0 ; -fx-font-size: 12 ; -fx-background-radius: 2 ; -fx-font-family: \"Square721 BT\"");
            bp2.setStyle("-fx-background-color: #2D2D2D ; -fx-background-radius: 10 ");
            buttong.setStyle("-fx-font-weight: normal ; -fx-background-color: transparent ; -fx-border-color: #2ecef0 ; -fx-border-radius: 5 ; -fx-border-width: 2 ; -fx-text-fill:  #2ecef0 ; -fx-font-family: \"Square721 BT\" ");
            bp4.prefWidthProperty().bind(bp3.widthProperty().divide(2).subtract(15));
            bp5.prefWidthProperty().bind(bp3.widthProperty().divide(2).subtract(15));

        }

        return bp1;
    }


    public Label getNameLabel() {
        return line1;
    }

    public BorderPane getBp1() {
        return bp1;
    }

    public BorderPane getBp2() {
        return bp2;
    }

    public BorderPane getBp3() {
        return bp3;
    }

    public BorderPane getBp4() {
        return bp4;
    }

    public BorderPane getBp5() {
        return bp5;
    }

    public BorderPane getBp6() {
        return bp6;
    }

    public TextArea getT1() {
        return t1;
    }

    public TextArea getT2() {
        return t2;
    }

    public TextArea getT3() {
        return t3;
    }

    public Button getgradeButton() {
        return buttong;

    }






}

