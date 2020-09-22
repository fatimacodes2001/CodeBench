package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentBlank implements Initializable {
    String token;
    FXMLLoader centstudent;
    JSONObject details;
    Stage myStage;
    @FXML
            private BorderPane studentbp;

    StudentBlank(){
        this(null,null,null,null);

    }
    StudentBlank(Stage myStage,JSONObject obj,FXMLLoader load,String token){
        this.token=token;
        this.centstudent=load;
        this.details=obj;
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        drag(studentbp);
        studentbp.setScaleX(1.3);
        studentbp.setScaleY(1.3);

        Rectangle clipper = new Rectangle();
        clipper.setWidth(960);
        clipper.setHeight(540);
        animator.FadeIn(studentbp,100,250);
        animator.ScaleX(studentbp,350,0,1,250);
        animator.ScaleY(studentbp,350,0,1,250);
        animator.Scale(clipper,350,0,1,250);
        animator.Scale(clipper,25,1,5,600);

        FXMLLoader loader2=new FXMLLoader(getClass().getResource("centerstudent.fxml"));
        loader2.setControllerFactory(t -> new CenterStudent(token,myStage));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("stPanel.fxml"));
        loader.setControllerFactory(t -> new StPanel(myStage,token,loader2,centstudent,studentbp,details,studentbp,clipper));
        try {
            Parent root1=loader2.load();
            studentbp.setCenter(root1);
            Parent root3=loader.load();
            studentbp.setLeft(root3);
            studentbp.setClip(clipper);
            Scene scene = new Scene(studentbp);
            scene.setFill(null);
            myStage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
