package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SmillyFace extends Application {
@Override
public void start(Stage primaryStage) {
//	create a root pane
	Pane rootPane=new Pane();
	
//	Create a circle for the head
	Circle headCircle=new Circle(150,150,100);
	Circle headCircle2=new Circle(400,150,100);
	Circle headCircle3=new Circle(650,150,100);
	headCircle.setFill(Color.YELLOW);
	headCircle.setStroke(Color.BLACK);
	headCircle2.setFill(Color.YELLOW);
	headCircle2.setStroke(Color.BLACK);
	headCircle3.setFill(Color.YELLOW);
	headCircle3.setStroke(Color.BLACK);
	
//	Creat two circles for the eyes
	Circle leftEyeCircle=new Circle(110,100,15);
	Circle leftEyeCircle2=new Circle(360,100,15);
	Circle leftEyeCircle3=new Circle(610,100,15);
	leftEyeCircle.setFill(Color.BLACK);
	leftEyeCircle.setStroke(Color.ANTIQUEWHITE);
//	leftEyeCircle.strokeWidthProperty();
	leftEyeCircle2.setFill(Color.BLACK);
	leftEyeCircle2.setStroke(Color.ANTIQUEWHITE);
	leftEyeCircle2.strokeWidthProperty();
	leftEyeCircle3.setFill(Color.BLACK);
	leftEyeCircle3.setStroke(Color.ANTIQUEWHITE);
	leftEyeCircle3.strokeWidthProperty();
	
	
	Circle rightEyeCircle=new Circle(190,100,15);
	Circle rightEyeCircle2=new Circle(420,100,15);
	Circle rightEyeCircle3=new Circle(650,100,15);
	rightEyeCircle.setFill(Color.BLACK);
	rightEyeCircle.setStroke(Color.ANTIQUEWHITE);
	rightEyeCircle2.setFill(Color.BLACK);
	rightEyeCircle2.setStroke(Color.ANTIQUEWHITE);
	rightEyeCircle3.setFill(Color.BLACK);
	rightEyeCircle3.setStroke(Color.ANTIQUEWHITE);
	
//	Create arcs for the mounth (Smile)
	Arc mouth=new Arc(150,150,20,30,180,180);
	Arc mouth2=new Arc(390,180,20,30,0,180);
	Arc mouth3=new Arc(630,150,20,30,180,180);
	mouth.setType(ArcType.CHORD);
	mouth.setFill(Color.BLACK);
	mouth.setStroke(Color.ANTIQUEWHITE);
	mouth2.setType(ArcType.CHORD);
	mouth2.setFill(Color.BLACK);
	mouth2.setStroke(Color.ANTIQUEWHITE);
	mouth3.setType(ArcType.CHORD);
	mouth3.setFill(Color.BLACK);
	mouth3.setStroke(Color.ANTIQUEWHITE);
	
//	Add all shapes to the root pane
	rootPane.getChildren().addAll(headCircle,leftEyeCircle,rightEyeCircle,mouth) ;
	rootPane.getChildren().addAll(headCircle2,leftEyeCircle2,rightEyeCircle2,mouth2);
	rootPane.getChildren().addAll(headCircle3,leftEyeCircle3,rightEyeCircle3,mouth3) ;

//	Create a scene and set it on the stage
	Scene scene=new Scene(rootPane,900,300);
	primaryStage.setTitle("Smily Face Example");
	primaryStage.setScene(scene);
	primaryStage.show();
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
