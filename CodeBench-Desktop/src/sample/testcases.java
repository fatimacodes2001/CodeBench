package sample;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

public class testcases implements Initializable {
    int id;
    @FXML
    private BorderPane center;
    @FXML
    private Rectangle rect;
    @FXML
    private ScrollPane scroll;
    @FXML
    private Pane backpane;
    @FXML
    private FlowPane testfp;
    @FXML
    private AnchorPane anchor;
    @FXML
    private TextField lint;
    @FXML
    private TextField time;
    @FXML
    private TextField tit;
    @FXML
    private TextField dead;
    @FXML
    private Label deadlabel;
    @FXML
    private Label titlabel;
    @FXML
    private Label courselabel;
    @FXML
    private Button test;
    @FXML
    private  Button addnew;
    @FXML
    BorderPane mainbpp;
    @FXML Pane linepane1;
    @FXML Pane linepane2;
    @FXML Pane linepane3;
    @FXML Pane linepane4;
    @FXML Label lintdetail;
    @FXML Label lintlab;
    @FXML Label lintlab1;
    @FXML BorderPane lintpane;
    @FXML Label timedetail;
    @FXML Label timelab;
    @FXML Label timelab1;
    @FXML BorderPane timepane;
    @FXML BorderPane statuspane;
    @FXML BorderPane secondary;
    @FXML Rectangle separator;
    @FXML Rectangle shadowline;
    @FXML AnchorPane top1;
    @FXML AnchorPane top2;

    CustomAnimations animator = new CustomAnimations();


    JSONArray testcase=new JSONArray();
    String buttonState="p";
    String course;
    centerteacher cen;
    @FXML
    Label assNo;
    FXMLLoader loader;
    Stage primaryStage;
    FXMLLoader mainbp;
    BorderPane myBorderPane;
    teacherinter tc;
    FXMLLoader load;
    JSONObject newassignment=new  JSONObject();
    ArrayList<Button> testcases=new ArrayList<Button>();
    ArrayList<Card> cards=new ArrayList<Card>();
    int num=0;
    Panel pan;
    String token;
    String a;
    FXMLLoader pani;

    testcases(){
        this(null,null,null,null,null,null,null,0);

    }

    public void getId(){


    }

    testcases(Stage pm,FXMLLoader loader,String course,FXMLLoader mainbp,FXMLLoader load,FXMLLoader pani,String token,int id){
        this.token=token;
        this.loader=loader;
        this.id=id;
        this.primaryStage=pm;
        this.course=course;
        this.mainbp=mainbp;
        tc=mainbp.getController();
        myBorderPane=tc.borderpane;
        this.load=load;
        this.pani=pani;

        pan=(Panel)pani.getController();
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



    public String getTitle(){
        try {
            if (tit.getText().length()==0) {
                throw new TitleEx("Title field cannot be blank");
            } else {
                System.out.println("NON-EMPTY");
                return tit.getText();
            }
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
            throw new TitleEx("Title field cannot be blank");
        }

    }




    public String getDead() throws IllegalArgumentException,Exception{
        String deadline=dead.getText();
        try {
            if (deadline.length() != 16 ) {

                throw new IllegalArgumentException("Please enter the deadline in YYYY-MM-DD HH:MM format");
            }
            else {
                String year=deadline.substring(0,4);
                String month=deadline.substring(5,7);
                String day=deadline.substring(8,10);
                String hour=deadline.substring(11,13);
                String minute=deadline.substring(14,16);
                LocalDateTime deadLine=LocalDateTime.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day),Integer.parseInt(hour),Integer.parseInt(minute));
                System.out.println(deadline);

                return deadLine.toString();
            }
        }
        catch (NumberFormatException e){
            System.out.println("Please enter the deadline in YYYY-MM-DD HH:MM format ");
            throw new IllegalArgumentException("Enter the deadline in YYYY-MM-DD HH:MM\nFormat e.g 2020:12:12 12:12");
        }
        catch (IllegalArgumentException e){
            System.out.println("Please enter the deadline in YYYY-MM-DD HH:MM format ");
            throw new IllegalArgumentException("Enter the deadline in YYYY-MM-DD HH:MM \nFormat e.g 2020:12:12 12:12");

        }catch (Exception e){
            System.out.println("Please enter the deadline in YYYY-MM-DD HH:MM format ");
            throw new Exception("Enter the deadline in YYYY-MM-DD HH:MM \nFormat e.g 2020:12:12 12:12");
        }

    }

    public int getIndex(ArrayList<Button> a,Button butt){
        System.out.println(a.indexOf(butt));
        return a.indexOf(butt);
    }

    public double getTime() throws Exception{
        try{
            double number=Double.parseDouble(time.getText());
            if(number>0){
            return number;}
            else if(number==0){
                return 99998;
            }
            else{
                throw new Exception();
            }
        }
        catch (Exception ex){
            throw new Exception("Enter valid time constraints");
        }

    }

    public double getLint(){
        try{
            double per=Double.parseDouble(lint.getText());
            if(per>30){
                throw new TitleEx("Linting weightage should be less than 30");
            }
            else{
                return per;
            }
        }catch(NumberFormatException ex){
            throw new NumberFormatException("Enter a valid weightage for Linting");
        }

    }


    public void setCourselabel() {
        courselabel.setText(Panel.courseh);
    }


    public void dateFormatter(TextField setScale){

        setScale.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {


                String[] ints = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l"
                        ,"m","n","o","p","q","r","s","t","u","v","w","x","y","z","`","-","_","=","=","[","{","]","}","\\","|"
                        ,";",":","'","\"",",","<",".",">","/","?","!","@","#","$","%","^","&","*","(",")"," "} ;

                
                if (setScale.getLength()>5) {
                    for (int i = 2; i < 68; i++) {
                        if (t1.substring(5, 6).equals(ints[i])) {
                            setScale.setText(t1.substring(0, 5));
                            setScale.positionCaret(setScale.getCaretPosition() - 1);
                        }
                    }
                }
                if (setScale.getLength()>6){
                    for (int i = 3; i < 68; i++) {
                        if (t1.substring(5, 6).equals("1") && t1.substring(6, 7).equals(ints[i])) {
                            setScale.setText(t1.substring(0, 6));
                            setScale.positionCaret(setScale.getCaretPosition() - 1);
                        }
                    }
                }

                if (setScale.getLength()>9) {
                    if (t1.substring(5, 7).equals("01") || t1.substring(5, 7).equals("03") || t1.substring(5, 7).equals("05") || t1.substring(5, 7).equals("07")
                            || t1.substring(5, 7).equals("08") || t1.substring(5, 7).equals("10") || t1.substring(5, 7).equals("12")) {
                        for (int i = 2; i < 68; i++) {
                            if (t1.substring(8, 9).equals("3") && t1.substring(9, 10).equals(ints[i])) {
                                setScale.setText(t1.substring(0, 9));
                                setScale.positionCaret(setScale.getCaretPosition() - 1);
                            }
                        }
                    }
                    if (t1.substring(5, 7).equals("04") || t1.substring(5, 7).equals("06") || t1.substring(5, 7).equals("09") || t1.substring(5, 7).equals("11")) {
                        for (int i = 1; i < 68; i++) {
                            if (t1.substring(8, 9).equals("3") && t1.substring(9, 10).equals(ints[i])) {
                                setScale.setText(t1.substring(0, 9));
                                setScale.positionCaret(setScale.getCaretPosition() - 1);
                            }
                        }
                    }
                }
                if (setScale.getLength()>8){

                    if (t1.substring(5, 7).equals("02")) {
                        for (int i = 3; i < 68; i++) {
                            if (t1.substring(8, 9).equals(ints[i])) {
                                setScale.setText(t1.substring(0, 8));
                                setScale.positionCaret(setScale.getCaretPosition() - 1);
                            }
                        }
                    } else {
                        for (int i = 4; i < 68; i++) {
                            if (t1.substring(8, 9).equals(ints[i])) {
                                setScale.setText(t1.substring(0, 8));
                                setScale.positionCaret(setScale.getCaretPosition() - 1);
                            }
                        }
                    }

                }

                if(setScale.getLength()>11){

                    for (int i = 3; i < 68; i++) {
                        if (t1.substring(11, 12).equals(ints[i])) {
                            setScale.setText(t1.substring(0, 11));
                            setScale.positionCaret(setScale.getCaretPosition() - 1);
                        }
                    }
                }

                if(setScale.getLength()>12){

                    for (int i = 4; i < 68; i++) {
                        if (t1.substring(11,12).equals("2") && t1.substring(12, 13).equals(ints[i])) {
                            setScale.setText(t1.substring(0, 12));
                            setScale.positionCaret(setScale.getCaretPosition() - 1);
                        }
                    }
                }

                if(setScale.getLength()>14){

                    for (int i = 6; i < 68; i++) {
                        if (t1.substring(14, 15).equals(ints[i])) {
                            setScale.setText(t1.substring(0, 14));
                            setScale.positionCaret(setScale.getCaretPosition() - 1);
                        }
                    }
                }


                if(setScale.getLength()>0){

                    for (int i = 9; i < 68; i++) {
                        if (t1.substring(0, 1).equals(ints[i]) || t1.substring(0, 1).equals("0")|| t1.substring(0, 1).equals("1")) {
                            setScale.setText(t1.substring(0, 0));
                            setScale.positionCaret(setScale.getCaretPosition() - 1);
                        }
                    }
                }
                if(setScale.getLength()>1){

                    for (int i = 9; i < 68; i++) {
                        if (t1.substring(1, 2).equals(ints[i]) ) {
                            setScale.setText(t1.substring(0, 1));
                            setScale.positionCaret(setScale.getCaretPosition() - 1);
                        }
                    }
                }
                if(setScale.getLength()>2){

                    for (int i = 9; i < 68; i++) {
                        if (t1.substring(2, 3).equals(ints[i]) || t1.substring(2, 3).equals("0")|| t1.substring(2, 3).equals("1")) {
                            setScale.setText(t1.substring(0, 2));
                            setScale.positionCaret(setScale.getCaretPosition() - 1);
                        }
                    }
                }
                if(setScale.getLength()>3){

                    for (int i = 9; i < 68; i++) {
                        if (t1.substring(3, 4).equals(ints[i]) ) {
                            setScale.setText(t1.substring(0, 3));
                            setScale.positionCaret(setScale.getCaretPosition() - 1);
                        }
                    }
                }

                if (setScale.getLength() == 4 || setScale.getLength() == 7 ) {
                    setScale.setText(t1 + "-");
                    setScale.positionCaret(setScale.getCaretPosition() + 1);
                    System.out.println("dash added");
                }

                if ( setScale.getLength() == 13) {
                    setScale.setText(t1 + ":");
                    setScale.positionCaret(setScale.getCaretPosition() + 1);
                    System.out.println("colon added");
                }

                if (setScale.getLength() == 10) {
                    setScale.setText(t1 + " ");
                    setScale.positionCaret(setScale.getCaretPosition() + 1);
                    System.out.println("space added");
                }
                if (setScale.getLength() > 16) {
                    setScale.setText(t1.substring(0, 16));
                    setScale.positionCaret(setScale.getCaretPosition() - 1);
                }



                setScale.setOnKeyPressed(e -> {
                    if (e.getCode() == KeyCode.BACK_SPACE) {

                        if (setScale.getLength() == 5 ) {

                                    int pos = setScale.getCaretPosition();
                                    setScale.setText(t1.substring(0, 3));
                                    setScale.positionCaret(pos);


                        }

                        if (setScale.getLength() == 8 ) {

                                    int pos = setScale.getCaretPosition();
                                    setScale.setText(t1.substring(0, 6));
                                    setScale.positionCaret(pos);

                        }

                        if (setScale.getLength() == 11 ) {

                                    int pos = setScale.getCaretPosition();
                                    setScale.setText(t1.substring(0, 9));
                                    setScale.positionCaret(pos);

                        }

                        if (setScale.getLength() == 14 ) {

                                    int pos = setScale.getCaretPosition();
                                    setScale.setText(t1.substring(0, 12));
                                    setScale.positionCaret(pos);

                        }

                    }

                    if (e.getCode() == KeyCode.ENTER) {

                        lint.requestFocus();
                        lint.setFocusTraversable(true);

                    }
                    if (e.getCode() == KeyCode.UP) {

                        tit.requestFocus();
                        tit.setFocusTraversable(true);

                    }
                    if (e.getCode() == KeyCode.DOWN) {

                        lint.requestFocus();
                        lint.setFocusTraversable(true);

                    }

                });




            };
        });

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dateFormatter(dead);

        tit.requestFocus();
        tit.setFocusTraversable(true);


        tit.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {

                dead.requestFocus();
                dead.setFocusTraversable(true);

            }
            if (e.getCode() == KeyCode.DOWN) {

                dead.requestFocus();
                dead.setFocusTraversable(true);

            }
        });

//        dead.setOnKeyPressed(e -> {
//            if (e.getCode() == KeyCode.ENTER) {
//
//                lint.requestFocus();
//                lint.setFocusTraversable(true);
//
//            }
//            if (e.getCode() == KeyCode.UP) {
//
//                tit.requestFocus();
//                tit.setFocusTraversable(true);
//
//            }
//            if (e.getCode() == KeyCode.DOWN) {
//
//                lint.requestFocus();
//                lint.setFocusTraversable(true);
//
//            }
//        });

        lint.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {

                time.requestFocus();
                time.setFocusTraversable(true);

            }
            if (e.getCode() == KeyCode.UP) {

                dead.requestFocus();
                dead.setFocusTraversable(true);

            }
            if (e.getCode() == KeyCode.DOWN) {

                time.requestFocus();
                time.setFocusTraversable(true);

            }
        });




        time.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {

                lint.requestFocus();
                lint.setFocusTraversable(true);

            }

            if (e.getCode() == KeyCode.ENTER) {

                increment();
                try {
                    testcase.put(num-1,"null");
                } catch (JSONException h) {
                    h.printStackTrace();
                }
                Card myCard= null;
                try {
                    myCard = createCard(TestCase.getLength(testcase),num-1,  100);

                } catch (JSONException g) {
                    g.printStackTrace();
                }
                Button b1=(Button) myCard.n;
                testcases.add(b1);
                setAction(b1,num-1);

            }
        });

        addnew.getStylesheets().add("addred.css");

        animator.FadeIn(courselabel,100,250+250);
        animator.ScaleY(courselabel,250,0,1,250+250);
        animator.LinearMoveY(courselabel,250,23/2,0,250+250);

        animator.FadeIn(titlabel,100,250+250+250+250);
        animator.FadeIn(tit,100,250+250+250);
        animator.FadeIn(deadlabel,100,250+250+250+250);
        animator.FadeIn(dead,100,250+250+250);
        animator.FadeIn(lint,100,250+250+250);
        animator.FadeIn(time,100,250+250+250);

        animator.ScaleY(titlabel,250,0,1,250+250+250+250);
        animator.LinearMoveY(titlabel,250,22/2,0,250+250+250+250);
        animator.ScaleY(deadlabel,250,0,1,250+250+250+250);
        animator.LinearMoveY(deadlabel,250,22/2,0,250+250+250+250);
        animator.ScaleX(tit,250,0,1,250+250+250);
        animator.LinearMoveX(tit,250,-444/2,0,250+250+250);
        animator.ScaleX(dead,250,0,1,250+250+250);
        animator.LinearMoveX(dead,250,-444/2,0,250+250+250);
        animator.ScaleX(lint,250,0,1,250+250+250);
        animator.LinearMoveX(lint,250,202/2,0,250+250+250);
        animator.ScaleX(time,250,0,1,250+250+250);
        animator.LinearMoveX(time,250,202/2,0,250+250+250);
        animator.FadeIn(lintlab,250,1000);
        animator.FadeIn(lintlab1,250,1000);
        animator.FadeIn(lintdetail,250,1000);
        animator.FadeIn(timelab1,250,1000);
        animator.FadeIn(timelab,250,1000);
        animator.FadeIn(timedetail,250,1000);

        animator.Scale(test,250,0,1,500);

        animator.FadeIn(addnew,100,250+250);
        animator.FadeIn(separator,100,250+250+250);
        animator.LinearMoveY(separator,250,-50,0,250+250+250);
        animator.FadeIn(assNo,100,250+250);

        animator.FadeIn(top1,100,0);
        animator.FadeIn(top2,100,0);
        animator.FadeIn(shadowline,100,0);
        animator.LinearMoveY(top1,500,-100,0,0);
        animator.LinearMoveY(top2,500,-100,0,0);
        animator.LinearMoveY(shadowline,500,-100,0,0);

        animator.Scale(center,250,0,1,250);
        animator.FadeIn(center,100,250);

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

        statuspane.prefWidthProperty().bind(lintpane.widthProperty());

        lintlab.prefWidthProperty().bind(secondary.widthProperty());
//        lintlab.minWidthProperty().bind(statuspane.widthProperty().divide(2).subtract(10));
//        lintlab.maxWidthProperty().bind(statuspane.widthProperty().divide(2).subtract(10));
        timelab.prefWidthProperty().bind(statuspane.widthProperty().divide(2).add(40));
//        timelab.minWidthProperty().bind(statuspane.widthProperty().divide(2));
//        timelab.maxWidthProperty().bind(statuspane.widthProperty().divide(2));
        lintdetail.prefWidthProperty().bind(lintpane.widthProperty());
//        lintdetail.minWidthProperty().bind(lintpane.widthProperty());
//        lintdetail.maxWidthProperty().bind(lintpane.widthProperty());
        timedetail.prefWidthProperty().bind(timepane.widthProperty());
//        timedetail.minWidthProperty().bind(timepane.widthProperty());
//        timedetail.maxWidthProperty().bind(timepane.widthProperty());


        createLines(linepane1,"#E6E6E6");
        createLines(linepane2,"#E6E6E6");
        createLines(linepane3,"#E6E6E6");
        createLines(linepane4,"#E6E6E6");

        Rectangle clipper1 = new Rectangle();
        clipper1.setHeight(47);
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

        linepane1.setClip(clipper1);
        linepane2.setClip(clipper2);
        linepane3.setClip(clipper3);
        linepane4.setClip(clipper4);


        addnew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    try{

                        newassignment.put("deadline",getDead());
                        newassignment.put("title",getTitle());

                        //HashMap<String,Integer> hashed=pan.getCourses();
                        //int id=hashed.get(course);
                        newassignment.put("group_id",Panel.courseId);
                        newassignment.put("test_cases",TestCase.returner(testcase));
                        newassignment.put("linting",getLint());
                        newassignment.put("time_limit",getTime());
                        FirstLineService firstLineService=new FirstLineService("newAss",token,newassignment);
                        firstLineService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                            @Override
                            public void handle(WorkerStateEvent event) { ;
                                JSONObject response=(JSONObject) event.getSource().getValue();
                                System.out.println(newassignment.toString());
                                System.out.println(testcase.toString());
                                if(response.equals("success")){
                                    System.out.println("Assignment uploaded!");
                                }


                                //Clearing the components of testcase window
                                tit.clear();
                                dead.clear();
                                testfp.getChildren().removeAll(testfp.getChildren());
                                pan.modify();


                                for(int i=0;i<testcase.length();i++){
                                    testcase.remove(i);
                                }
                                num=0;

                            }
                        });
                        firstLineService.start();

                    }
                    catch (JSONException e){
                        e.printStackTrace();
                    }

                }
                catch(TitleEx ex){
                    System.out.println(ex);
                    ErrorBox eb=new ErrorBox("ERROR",ex.getMessage(),myBorderPane);
                    eb.showDialogue();
                }
                catch (NullPointerException e){
                    e.printStackTrace();
                }
                catch (Exception ex){
                    System.out.println(ex);

                    ErrorBox eb=new ErrorBox("ERROR",ex.getMessage(),myBorderPane);
                    eb.showDialogue();

                }


            }
        });



        mainbpp.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(tit.getText().trim().isEmpty() || dead.getText().trim().isEmpty() || lint.getText().trim().isEmpty() || time.getText().trim().isEmpty()){
                    addnew.getStylesheets().add("addred.css");
                }else{
                    addnew.getStylesheets().add("addgreen.css");
                }
                if(tit.getText().trim().isEmpty() || dead.getText().trim().isEmpty() || lint.getText().trim().isEmpty() || time.getText().trim().isEmpty()){
                    addnew.getStylesheets().add("addred.css");
                }else{
                    addnew.getStylesheets().add("addgreen.css");
                }
                if(tit.getText().trim().isEmpty() || dead.getText().trim().isEmpty() || lint.getText().trim().isEmpty() || time.getText().trim().isEmpty()){
                    addnew.getStylesheets().add("addred.css");
                }else{
                    addnew.getStylesheets().add("addgreen.css");
                }

                if(lint.getText().equals("0") || lint.getText().trim().isEmpty()){

                    lintlab.setText("Linting is Disabled");
                    lintlab.setTextFill(Color.web("#A60028"));

                }
                else{

                    lintlab.setText("Linting is Enabled");
                    lintlab.setTextFill(Color.web("#00A684"));

                }
                if(tit.getText().trim().isEmpty() || dead.getText().trim().isEmpty() || lint.getText().trim().isEmpty() || time.getText().trim().isEmpty()){
                    addnew.getStylesheets().add("addred.css");
                }else{
                    addnew.getStylesheets().add("addgreen.css");
                }

                if(lint.getText().equals("0") || lint.getText().trim().isEmpty()){

                    lintlab.setText("Linting is Disabled");
                    lintlab.setTextFill(Color.web("#A60028"));

                }
                else{

                    lintlab.setText("Linting is Enabled");
                    lintlab.setTextFill(Color.web("#00A684"));

                }









            }


        });





        cen=(centerteacher)loader.getController();

        test.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                increment();
                try {
                    testcase.put(num-1,"null");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Card myCard= null;
                try {
                    myCard = createCard(TestCase.getLength(testcase),num-1,  100);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Button b1=(Button) myCard.n;
                testcases.add(b1);
                setAction(b1,num-1);

            }
        });

    }
    public void addingTest(JSONObject js,int n) throws JSONException {
        testcase.put(n,js);
        System.out.println(num);
    }
    public void increment(){
        num+=1;
    }

    public Card createCard(int disp,int testnum, int delay){
        Pane hbox=testfp;
        Card c1 = new Card();
        cards.add(c1);
        c1.n= c1.makeCard(disp,testnum,"Delete");
        Button b1 = c1.getgradeButton();
        Label l1 = c1.getNameLabel();
        c1.number=testnum;
        HashMap<Node,Integer> singleCard=new HashMap<>();

        buttonState="p";
        hbox.getChildren().add(c1.n);
        cen.Vanish(c1.n,delay);
        cen.FadeIn(c1.n,100,delay);
        cen.popup(c1.n,200,delay);
        cen.Vanish(b1,400+delay);
        cen.FadeIn(b1,200,400+delay);
        cen.ScaleX(b1,200,0,1,false,1,400+delay);
        cen.LinearMoveY(b1,400,-20,-20,300+delay);
        cen.LinearMoveY(b1,200,-20,0,700+delay);
        cen.Vanish(l1,700+delay);
        cen.FadeIn(l1,200,700+delay);
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                testfp.getChildren().remove(c1.n);
                buttonState="n";
                try {
                    testcase.put(testnum,"null");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        return c1;
    }
    public BorderPane getAnchorPane() {

        return myBorderPane;
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
    public ArrayList<JSONObject> returns(JSONArray ar,ArrayList<JSONObject> j){
        for (int i=0;i<ar.length();i++) {

        }
        return j;
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
    public  void setAction(Button butt,int n){
        butt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(buttonState.equals("p")){

                    ColorAdjust dim = new ColorAdjust();

                    dim.setBrightness(-0.3);
                    dim.setSaturation(-0.3);
                    dim.setContrast(-0.3);
                    BoxBlur blur = new BoxBlur(0,0,0);
                    System.out.println("click");
                    Dialog<ButtonType> dialog = new Dialog<>();
                    dialog.initOwner(myBorderPane.getScene().getWindow());


                    dialog.initStyle(StageStyle.UNDECORATED);
                    blur.setInput(dim);
                    myBorderPane.setEffect(blur);
                    animator.smoothBlurOn(myBorderPane,250);


                    try {

                        FXMLLoader mine=new FXMLLoader(getClass().getResource("dialougueBox.fxml"));
                        int index= getIndex(testcases,butt);
                        mine.setControllerFactory(t ->new DialogController(load,index));
                        Parent root1=mine.load();
                        DialogController myDg=(DialogController)mine.getController();
                        dialog.getDialogPane().setContent(root1);


                        myDg.setInt(testcase.getJSONObject(index).getString("input"));
                        myDg.setOut(testcase.getJSONObject(index).getString("output"));




                    } catch(IOException | JSONException e){
                        System.out.println("Unable to load Dialogue Box");

                    }
                    Optional<ButtonType> result = dialog.showAndWait();
                    if(result.isPresent()){
                        //nothing
                    }
                    else{
                        myBorderPane.setEffect(null);
                        animator.smoothBlurOff(myBorderPane,250);

                    }}else{
                    buttonState="p";
                }
            }
        });

    }



}

class TitleEx extends IllegalArgumentException{
    TitleEx(String message){
        super(message);
    }

}
