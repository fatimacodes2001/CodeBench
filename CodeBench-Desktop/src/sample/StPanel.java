
package sample;

import javafx.animation.ScaleTransition;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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

public class StPanel implements Initializable {

    CustomAnimations animator = new CustomAnimations();
    ArrayList<Button> arays=new ArrayList<>();

    @FXML Button close;
    @FXML Button maximize;
    @FXML Button minimize;
    @FXML BorderPane sidepane;
    @FXML Rectangle toprect;
    @FXML
    Rectangle maxrect;
    JSONArray subs;
    static JSONArray assignments;

    @FXML
    private Label name;
    @FXML
    private Button signout;
    @FXML
    private VBox vbox;
    @FXML
    private Label courselab;
    @FXML
    private ScrollPane sp;
    @FXML BorderPane mainpane;
    @FXML Rectangle clipper;
    JSONArray mine;
    Stage primaryStage;
    FXMLLoader center;
    FXMLLoader stint;
    String token;
    BorderPane back;
    JSONObject details;
    int groupId;
    int studentId;
    CenterStudent myCent;
    CENTER centre;
    BorderPane borderPane;
    StPanel(){

    }
    StPanel(Stage primaryStage, String token, FXMLLoader f1, FXMLLoader f2, BorderPane bp, JSONObject js, BorderPane mainpane , Rectangle clipper){
        this.primaryStage=primaryStage;
        this.token=token;
        this.center=f1;
        this.stint=f2;
        this.back=bp;
        this.details=js;
        this.mainpane = mainpane;
        this.clipper = clipper;
        this.myCent=f1.getController();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        animator.FadeIn(sidepane,100,500);
        animator.LinearMoveX(sidepane,500,-500,0,500);
        animator.LinearMoveY(toprect,250,-50,0,500+500);
        animator.FadeIn(signout,250,750+500);
        animator.FadeIn(close,250,750+500);
        animator.FadeIn(maximize,250,750+500);
        animator.FadeIn(maxrect,250,750+500);
        animator.FadeIn(minimize,250,750+500);

        try {
            signout.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    animator.Scale(mainpane,250,1,0,0);
                    ScaleTransition scale = animator.ScaleReturn(clipper,250,1,0,0);
                    scale.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {

                            FXMLLoader load1=new FXMLLoader(getClass().getResource("sample.fxml"));
                            load1.setControllerFactory(t -> new Controller(primaryStage));
                            try {
                                Scene sc=new Scene(load1.load());
                                sc.setFill(Color.TRANSPARENT);
                                primaryStage.setScene(sc);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    });


                }
            });

            maximize.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(primaryStage.isMaximized()){
                        primaryStage.setMaximized(false);
                    }
                    else{
                        primaryStage.setMaximized(true);
                    }
                }
            });

            minimize.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    primaryStage.setIconified(true);
                }
            });

            close.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent actionEvent) {

                    animator.Scale(mainpane,250,1,0,0);
                    ScaleTransition scale = animator.ScaleReturn(clipper,250,1,0,0);
                    scale.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {

                            primaryStage.close();

                        }
                    });


                }

            });

            close.setOnMouseEntered(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOnText(close,"#2ecef0","#2ecef0","#CE4869","#CE4869",100);

                }

            });

            close.setOnMouseExited(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOffText(close,"#2ecef0","#2ecef0","#CE4869","#CE4869",100);

                }

            });


            close.setOnMousePressed(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOnText(close,"#CE4869","#CE4869","#A60028","#A60028",100);

                }

            });

            close.setOnMouseReleased(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOffText(close,"#CE4869","#CE4869","#A60028","#A60028",100);

                }

            });

            minimize.setOnMouseEntered(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOnText(minimize,"#2ecef0","#2ecef0","#5BB3FF","#5BB3FF",100);

                }

            });

            minimize.setOnMouseExited(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOffText(minimize,"#2ecef0","#2ecef0","#5BB3FF","#5BB3FF",100);

                }

            });


            minimize.setOnMousePressed(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOnText(minimize,"#5BB3FF","#5BB3FF","#8DE4FF","#8DE4FF",100);

                }

            });

            minimize.setOnMouseReleased(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOffText(minimize,"#5BB3FF","#5BB3FF","#8DE4FF","#8DE4FF",100);

                }

            });

            maximize.setOnMouseEntered(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.ColourShiftRectBd(maxrect,"#2ecef0","#2ecef0","#00A684","#00A684",100,0);

                }

            });

            maximize.setOnMouseExited(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.ColourShiftRectBd(maxrect,"#00A684","#00A684","#2ecef0","#2ecef0",100,0);

                }

            });


            maximize.setOnMousePressed(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.ColourShiftRectBd(maxrect,"#00A684","#00A684","#00E5B6","#00E5B6",100,0);

                }

            });

            maximize.setOnMouseReleased(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.ColourShiftRectBd(maxrect,"#00E5B6","#00E5B6","#00A684","#00A684",100,0);

                }

            });


            FXMLLoader load1=new FXMLLoader(getClass().getResource("CENTER.fxml"));
            centre=(CENTER)load1.getController();
            load1.setControllerFactory(t -> new CENTER());
            courselab.setText(""+details.getJSONObject("group").get("name"));
            groupId=details.getJSONObject("group").getInt("id");
            studentId=details.getInt("cms_id");
            name.setText(""+details.get("first_name") +" "+ details.get("last_name"));

            Getters g1=new Getters();
            assignments=g1.studAssign(token);
            mine=assignments;
            FirstLineService1 fs=new FirstLineService1("get",token);
            HashMap<Integer,Boolean> hashed=new HashMap<>();
            HashMap<Integer,Integer> hashed1=new HashMap<>();

            fs.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    subs=(JSONArray)event.getSource().getValue();

                    System.out.println("SUCCESS");
                    try{
                        int num=assignments.length();
                        int truth=0;
                        int ok=0;
                        for(int i=0;i<num;i++){
                            if(assignments.getJSONObject(i).getBoolean("submission")){

                                int id=assignments.getJSONObject(i).getInt("id");
                                JSONObject obj=subs.getJSONObject(ok);
                                hashed1.put(id,ok);

                                Boolean graded=obj.getBoolean("graded");
                                //if(graded){
                                //  hashed1.put(id,truth);
                                //truth++;
                                //}
                                hashed1.put(id,ok);
                                hashed.put(id,graded);
                                ok++;

                            }
                            else {
                                int id=assignments.getJSONObject(i).getInt("id");
                                hashed.put(id,false);
                            }}
                        ToggleGroup assignment=new ToggleGroup();
                        ToggleButton[] buttons=new ToggleButton[assignments.length()];
                        for(int in=0;in<assignments.length();in++){
                            buttons[in]=new ToggleButton();
                            buttons[in].setToggleGroup(assignment);
                            buttons[in].setAlignment(Pos.CENTER_LEFT);
                            buttons[in].setPadding(new Insets(0,0,0,10));
                            buttons[in].setText("Assignment "+(in+1)+" "+assignments.getJSONObject(in).getString("title"));
                            buttons[in].setCursor(Cursor.HAND);
                            buttons[in].getStylesheets().add("togglestudent.css");

                            animator.FadeIn(buttons[in],50,(in+1)*100);
                            animator.Scale(buttons[in],200,0,1,(in+1)*100);

                            int finalI = in;
                            buttons[in].setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {

                                    animator.FadeIn(myCent.getAssNo(),250,0);
                                    animator.FadeIn(myCent.getAssName(),250,0);
                                    animator.FadeIn(myCent.getDeadline(),250,0);
                                    animator.FadeIn(myCent.separator,100,0);
                                    animator.LinearMoveY(myCent.separator,250,-60,0,0);
                                    animator.FadeIn(myCent.deadlinetext,250,0);

                                    String ded= null;

                                    try {
                                        ded = assignments.getJSONObject(finalI).getString("deadline");
                                        myCent.deadline.setText(ded.substring(0,10)+" "+ded.substring(11,16));
                                        myCent.deadline.setVisible(true);
                                        myCent.vbox.getChildren().clear();
                                        myCent.deadline1.setVisible(false);
                                        myCent.deadline1.setText(ded.substring(0,10)+" "+ded.substring(11,16));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                    myCent.mainpane.setCenter(myCent.myBP);

                                    //********************************
                                    //********************************
                                    //********************************
                                    //********************************
                                    //********************************
                                    //********************************


                                    if(Panel.toDate(ded).isAfter(LocalDateTime.now())){


                                    }


                                    //********************************
                                    //********************************
                                    //********************************
                                    //********************************
                                    //********************************
                                    //********************************


                                    if(myCent.parent!=null){
                                        myCent.parent.setVisible(false);
                                        myCent.myBP.setCenter(myCent.butt);


                                    }
                                    try {
                                        myCent.butt1.setVisible(true);
                                        myCent.cenbutt.setVisible(true);
                                        myCent.butt3.setVisible(true);
                                        ded=assignments.getJSONObject(finalI).getString("deadline");
                                        myCent.cenbutt.setText("Add the submission file to run it.");
                                        animator.hoverOffbg(myCent.cenbutt,"#2D2D2D","#2D2D2D","#2D2D2D","#2D2D2D",2,2,10);
                                        animator.hoverOff(myCent.cenbutt,"#1a1a1a","#1a1a1a","#1a1a1a","#1a1a1a",2,10);
                                        animator.hoverOffText(myCent.cenbutt,"#2D2D2D","#2D2D2D","#2D2D2D","#2D2D2D",10);
                                        myCent.cenbutt.setOnMouseEntered(new EventHandler<MouseEvent>() {
                                            @Override
                                            public void handle(MouseEvent mouseEvent) {
                                                animator.hoverOnbg(myCent.cenbutt,"#2D2D2D","#2D2D2D","#2D2D2D","#2D2D2D",2,2,10);
                                                animator.hoverOff(myCent.cenbutt,"#1a1a1a","#1a1a1a","#1a1a1a","#1a1a1a",2,10);
                                                animator.hoverOnText(myCent.cenbutt,"#2D2D2D","#2D2D2D","#2D2D2D","#2D2D2D",10);
                                            }
                                        });

                                        myCent.cenbutt.setOnMouseExited(new EventHandler<MouseEvent>() {
                                            @Override
                                            public void handle(MouseEvent mouseEvent) {
                                                animator.hoverOff(myCent.cenbutt,"#1a1a1a","#1a1a1a","#1a1a1a","#1a1a1a",2,10);
                                                animator.hoverOffbg(myCent.cenbutt,"#2D2D2D","#2D2D2D","#2D2D2D","#2D2D2D",2,2,10);
                                                animator.hoverOffText(myCent.cenbutt,"#2D2D2D","#2D2D2D","#2D2D2D","#2D2D2D",10);
                                            }
                                        });

                                        myCent.cenbutt.setOnMousePressed(new EventHandler<MouseEvent>() {
                                            @Override
                                            public void handle(MouseEvent mouseEvent) {
                                                animator.hoverOff(myCent.cenbutt,"#1a1a1a","#1a1a1a","#1a1a1a","#1a1a1a",2,10);
                                                animator.hoverOnbg(myCent.cenbutt,"#2D2D2D","#2D2D2D","#2D2D2D","#2D2D2D",2,2,10);
                                                animator.hoverOnText(myCent.cenbutt,"#2D2D2D","#2D2D2D","#2D2D2D","#2D2D2D",10);
                                            }
                                        });

                                        myCent.cenbutt.setOnMouseReleased(new EventHandler<MouseEvent>() {
                                            @Override
                                            public void handle(MouseEvent mouseEvent) {
                                                animator.hoverOff(myCent.cenbutt,"#1a1a1a","#1a1a1a","#1a1a1a","#1a1a1a",2,10);
                                                animator.hoverOffbg(myCent.cenbutt,"#2D2D2D","#2D2D2D","#2D2D2D","#2D2D2D",2,2,10);
                                                animator.hoverOffText(myCent.cenbutt,"#2D2D2D","#2D2D2D","#2D2D2D","#2D2D2D",10);
                                            }
                                        });

                                        myCent.butt.setStyle("-fx-border-color:#333333 ");
                                        myCent.butt.setStyle("-fx-text-fill:#333333 ");

                                        if(assignments.getJSONObject(finalI).getBoolean("submission")==false)

                                        {
                                            if(Panel.toDate(ded).isBefore(LocalDateTime.now())){

                                                myCent.butt.setTextFill(Color.web("#CE4869"));
                                                myCent.butt.setStyle("-fx-text-fill: #CE4869");
                                                myCent.butt.setText("DEADLINE HAS EXPIRED");

                                                myCent.butt.setStyle("-fx-border-color: #CE4869");
                                                myCent.deadline1.setVisible(true);
                                                myCent.deadline.setVisible(false);


                                            }
                                            else{
                                                myCent.butt.setText("ASSIGNMENT HAS NOT BEEN\n SUBMITTED");
                                                myCent.butt1.setText("Add Submission");


                                            }

                                        }
                                        else {
                                            myCent.butt.setText("SUBMISSION HAS BEEN\n MADE-RESULTS AWAITED");
                                            myCent.butt1.setText("EDIT SUBMISSION");
                                            Boolean bool=hashed.get(assignments.getJSONObject(finalI).getInt("id"));
                                            System.out.println(hashed +" "+hashed1);
                                            if(bool){
                                                myCent.cenbutt.setText("View Results");
                                                animator.hoverOff(myCent.cenbutt,"#1a1a1a","#1a1a1a","#1a1a1a","#1a1a1a",2,10);
                                                animator.hoverOnbg(myCent.cenbutt,"#2D2D2D","#2D2D2D","#5FD4BC","#5FD4BC",2,2,250);
                                                animator.hoverOnText(myCent.cenbutt,"#2D2D2D","#2D2D2D","#5FD4BC","#5FD4BC",250);
                                                myCent.butt.setText("SUBMISSION HAS BEEN MADE");
                                                int index=hashed1.get(assignments.getJSONObject(finalI).getInt("id"));
                                                int sub=subs.getJSONObject(index).getInt("id");
                                                FirstLineService first=new FirstLineService("res",sub,token);
                                                first.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                                                    @Override
                                                    public void handle(WorkerStateEvent event) {
                                                        JSONObject obj=(JSONObject)event.getSource().getValue();
                                                        //System.out.println(obj);


                                                        if(myCent.cenbutt.getText().equals("View Results")){

                                                            myCent.cenbutt.setOnMouseEntered(new EventHandler<MouseEvent>() {
                                                                @Override
                                                                public void handle(MouseEvent mouseEvent) {
                                                                    animator.hoverOff(myCent.cenbutt,"#1a1a1a","#1a1a1a","#1a1a1a","#1a1a1a",2,10);
                                                                    animator.hoverOnbg(myCent.cenbutt,"#5FD4BC","#5FD4BC","#008469","#008469",2,2,10);
                                                                    animator.hoverOnText(myCent.cenbutt,"#5FD4BC","#5FD4BC","#008469","#008469",10);
                                                                }
                                                            });

                                                            myCent.cenbutt.setOnMouseExited(new EventHandler<MouseEvent>() {
                                                                @Override
                                                                public void handle(MouseEvent mouseEvent) {
                                                                    animator.hoverOff(myCent.cenbutt,"#1a1a1a","#1a1a1a","#1a1a1a","#1a1a1a",2,10);
                                                                    animator.hoverOffbg(myCent.cenbutt,"#5FD4BC","#5FD4BC","#008469","#008469",2,2,10);
                                                                    animator.hoverOffText(myCent.cenbutt,"#5FD4BC","#5FD4BC","#008469","#008469",10);
                                                                }
                                                            });

                                                            myCent.cenbutt.setOnMousePressed(new EventHandler<MouseEvent>() {
                                                                @Override
                                                                public void handle(MouseEvent mouseEvent) {
                                                                    animator.hoverOff(myCent.cenbutt,"#1a1a1a","#1a1a1a","#1a1a1a","#1a1a1a",2,10);
                                                                    animator.hoverOnbg(myCent.cenbutt,"#008469","#008469","#00DEB0","#00DEB0",2,2,10);
                                                                    animator.hoverOnText(myCent.cenbutt,"#008469","#008469","#00DEB0","#00DEB0",10);
                                                                }
                                                            });

                                                            myCent.cenbutt.setOnMouseReleased(new EventHandler<MouseEvent>() {
                                                                @Override
                                                                public void handle(MouseEvent mouseEvent) {
                                                                    animator.hoverOff(myCent.cenbutt,"#1a1a1a","#1a1a1a","#1a1a1a","#1a1a1a",2,10);
                                                                    animator.hoverOffbg(myCent.cenbutt,"#008469","#008469","#00DEB0","#00DEB0",2,2,10);
                                                                    animator.hoverOffText(myCent.cenbutt,"#008469","#008469","#00DEB0","#00DEB0",10);
                                                                }
                                                            });


                                                            myCent.cenbutt.setOnAction(new EventHandler<ActionEvent>() {
                                                                @Override
                                                                public void handle(ActionEvent event) {

                                                                    FXMLLoader load1=new FXMLLoader(getClass().getResource("result.fxml"));
                                                                    load1.setControllerFactory(t -> new Result());
                                                                    Parent root= null;
                                                                    try {
                                                                        root = load1.load();
                                                                        myCent.mainpane.setCenter(root);
                                                                        Result result=(Result)load1.getController();
                                                                        if((obj.getDouble("time_limit"))==99998){
                                                                            result.time.setText("None");
                                                                        }else{
                                                                        result.time.setText(obj.getDouble("time_limit")+"");}
                                                                        int tot=0;
                                                                        int pass=0;
                                                                        JSONArray arr=obj.getJSONArray("test_cases");
                                                                        for(int numb=0;numb<arr.length();numb++){
                                                                            tot=arr.length();
                                                                            if(arr.getJSONObject(numb).getBoolean("passed")){
                                                                                pass++;
                                                                            }
                                                                        }
                                                                        result.ttest.setText(tot+"");
                                                                        result.stest.setText(pass+"");
                                                                        result.tpercent.setText(pass+"");

                                                                        animator.ArcAnimation(result.testarc,250,tot,pass,1000,tot);

                                                                        double score=obj.getJSONObject("scores").getDouble("overall");
                                                                        String sco=score+"";
                                                                        if(sco.length()>4){
                                                                            sco=sco.substring(0,4);
                                                                        }
                                                                        else {
                                                                            sco=sco;
                                                                        }
                                                                        result.agreg.setText(sco);
                                                                        result.total.setText(sco+"");

                                                                        animator.ArcAnimation(result.gradearc,250,100,score,1500,100);

                                                                        String lint;
                                                                        double lin=0;
                                                                        lin=obj.getJSONObject("scores").getDouble("linter");
                                                                        if(lin<1E-1){
                                                                            lint=lin+"";
                                                                            lint=0+"";

                                                                        }else{
                                                                            lint=lin+"";
                                                                            lint = lint.substring(0,3);
                                                                        }
                                                                        double tlin=obj.getJSONObject("percentages").getDouble("linter");
                                                                        String tlint;
                                                                        if(tlin<1E-1){
                                                                            tlint=tlin+"";
                                                                            tlint=tlint.substring(0,3);

                                                                        }else{
                                                                            tlint=tlin+"";
                                                                        }
                                                                        result.lint.setText(lint+"/"+tlint);
                                                                        animator.FadeIn(result.testarc,100,750);
                                                                        animator.FadeIn(result.gradearc,100,1500);
                                                                        animator.FadeIn(result.lintarc,100,1000);
//                                                                        animator.ArcAnimation(result.testarc,250,0,10,750);
//                                                                        animator.ArcAnimation(result.gradearc,250,0,10,750);
//                                                                        animator.ArcAnimation(result.lintarc,250,0,10,1000);
                                                                        animator.ArcAnimation(result.lintarc,250,tlin,lin,1250,tlin);

                                                                        result.remarks.setText(subs.getJSONObject(index).getString("remarks"));
                                                                        System.out.println(index);
                                                                        JSONArray array=obj.getJSONArray("test_cases");
                                                                        for(int n=0;n<array.length();n++){
                                                                            JSONObject test=array.getJSONObject(n);
                                                                            String status;
                                                                            Boolean stat=test.getBoolean("passed");
                                                                            if(stat){
                                                                                status="Passed";
                                                                            }
                                                                            else{
                                                                                status="Failed";
                                                                            }
                                                                            String e=test.getString("expected_input");
                                                                            String o= test.getString("expected_output");
                                                                            String ao=test.getString("output");
                                                                            Double to=test.getDouble("time_elapsed");
                                                                            String ti=to+"";
                                                                            ti=ti.substring(0,3);

                                                                            centerteacher t=new centerteacher();
                                                                            Button butt=(Button)t.createstudentCard(status,n,1000,result.testfp,0);
                                                                            arays.add(butt);
                                                                            settingAction(butt,n,e,o,ao,ti);


                                                                        }



                                                                    } catch (IOException | JSONException e) {
                                                                        e.printStackTrace();
                                                                    }






                                                                }
                                                            });

                                                        }


                                                    }
                                                });
                                                first.start();

                                            }
                                        }

                                        myCent.butt1.setText("Add Submission");



                                        myCent.assName.setText("  "+assignments.getJSONObject(finalI).getString("title"));
                                        myCent.assNo.setText("Assignment No "+(finalI+1));
                                        myCent.assId=assignments.getJSONObject(finalI).getInt("id");
                                    }catch (JSONException e){
                                        e.printStackTrace();
                                    }


                                }
                            });


                            vbox.getChildren().add(buttons[in]);

                        }



                    }
                    catch(JSONException  e){

                    }


                }
            });
            fs.start();


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    public void settingAction(Button button,int i,String e,String o,String ou,String ti){
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BorderPane bp=myCent.mainpane;

                ColorAdjust dim = new ColorAdjust();
                dim.setBrightness(-0.3);
                dim.setSaturation(-0.3);
                dim.setContrast(-0.3);
                BoxBlur blur = new BoxBlur(3,3,3);
                System.out.println("click");
                Dialog<ButtonType> dialog = new Dialog<>();
                dialog.initOwner(bp.getScene().getWindow());
                dialog.initStyle(StageStyle.UNDECORATED);
                blur.setInput(dim);
//                bp.setEffect(blur);
                animator.smoothBlurOn(bp,250);


                try {
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("DialogBox2std.fxml"));
                    loader.setControllerFactory(t ->new Dialog2stdController(e,o,ou,ti));
                    Parent root = loader.load();
                    dialog.getDialogPane().setContent(root);


                } catch(IOException e){

                    System.out.println("Unable to load dialouge Box");

                }


                Optional<ButtonType> result = dialog.showAndWait();
                if(result.isPresent()){
                    //nothing
                }
                else{
//                    bp.setEffect(null)
                    animator.smoothBlurOff(bp,250);
                }





            }
        });

    }



}