/*23SW56
 * Sadiq Iqbal Rajar
 * Calculator application
 */
package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class SimpleCalculator extends Application{

	private TextField tf =new TextField();
	private long num1 =0;
	private long num2=0;
	private String op="";
	private boolean start=true;

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage pStage) throws Exception{
		tf.setFont(Font.font(20));
		tf.setPrefHeight(50);
		tf.setAlignment(Pos.CENTER_RIGHT);
		tf.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2;");
		//		tf.setEditable(false);


		StackPane sp= new StackPane();
		sp.setPadding(new Insets(4));
		sp.getChildren().add(tf);
//		sp.setStyle("-fx-border-color: black; -fx-border-width: 1;");


		TilePane tP=new TilePane();
		tP.setHgap(10);
		tP.setVgap(10);
		tP.setAlignment(Pos.TOP_CENTER);
		tP.setStyle("-fx-background-color: SKYBLUE;");
		tP.getChildren().addAll(
				createButtonforNumbers("7"),
				createButtonforNumbers("8"),
				createButtonforNumbers("9"),
				createButtonforOperators("/"),

				createButtonforNumbers("4"),
				createButtonforNumbers("5"),
				createButtonforNumbers("6"),
				createButtonforOperators("x"),

				createButtonforNumbers("1"),
				createButtonforNumbers("2"),
				createButtonforNumbers("3"),
				createButtonforOperators("-"),

				createButtonforNumbers("0"),
				createButtonforClear("C"),
				createButtonforOperators("="),
				createButtonforOperators("+")
				);


		BorderPane root= new BorderPane();
		root.setTop(sp);
		root.setCenter(tP);
		root.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 4;");
		Scene sc=new Scene(root,250,303);
		pStage.setScene(sc);
		pStage.setTitle("23SW56 (Sadiq Iqbal Rajar)");
		pStage.setResizable(false);
		//		Image image=new Image("CalculatorIcon.png");
		//		pStage.getIcons().add(image);
		pStage.show();

	}

	private Button createButtonforNumbers(String ch) {
		Button btn=new Button(ch);
		btn.setPrefSize(50, 50);
		btn.setFont(Font.font(20));
		btn.setTextFill(Color.DARKBLUE);
		btn.setStyle("-fx-background-color: darkgrey;-fx-border-color: black; -fx-border-width: 1;");
		btn.setOnAction(this:: processNumber);//Method refrence operator
		return btn;
	}

	private Button createButtonforOperators(String ch) {
		Button btn=new Button(ch);
		btn.setPrefSize(50, 50);
		btn.setFont(Font.font(20));
		btn.setTextFill(Color.DARKRED );
		btn.setStyle("-fx-background-color: grey; -fx-border-color: black; -fx-border-width: 1;");
		btn.setOnAction(this::processOperator);//Method refrence operator
		return btn;
	}

	private Button createButtonforClear(String ch) {
		Button btn = new Button(ch);
		btn.setPrefSize(50, 50);
		btn.setFont(Font.font(20));
		btn.setTextFill(Color.BLACK);
		btn.setStyle("-fx-background-color: grey; -fx-border-color: black; -fx-border-width: 1;");
		btn.setOnAction(e->{//lamda expression
			tf.setText("");
			op="";
			start=true;
		});
		return btn;
	}

	private void processNumber(ActionEvent e) {
		if (start) {
			tf.setText("");
			start=false;
		}
		String value=((Button)e.getSource()).getText();//getText from the sourse button clicked
		//		tf.setText(value);// get current value
		tf.setText(tf.getText()+value);// get updated value (old + new)
	}
	private void processOperator(ActionEvent e) {
	    String value = ((Button) e.getSource()).getText();
	    if (!value.equals("=")) {
	        if (!op.isEmpty()) {
	            return;
	        } else {
	            num1 = Long.parseLong(tf.getText());
	            op = value;
	            tf.setText(tf.getText() + " " + op + " ");
	        }
	    } else {
	        if (op.isEmpty()) {
	            return;
	        } else {
	            num2 = Long.parseLong(tf.getText().split(" ")[2]);
	            double result = calculate(num1, num2, op);
	            
	            // Display result
	            if (result == (long) result) {
	                tf.setText(String.valueOf((long) result)); // Display as long if it's an integer
	            } else {
	                tf.setText(String.valueOf(result)); // Display as double if it's a floating-point number
	            }
	            num1 = (long) result; // Yeh line add ki gayi hai - Update num1 to hold the result for further calculations
	            op = ""; // Yeh line add ki gayi hai - Reset operator for next operation
	            start = false; // Yeh line add ki gayi hai - Ready for next input
	        }
	    }
	}


	private double calculate(long num1,long num2, String op ) {
		switch (op) {
		case "+":return num1+num2;
		case "-":return num1-num2;
		case "x":return num1*num2;
		case "/":
			if (num2==0) {
				return 0;
			}else {
				return (double) num1/num2;
			}
		default:return 0;
		}
	}
}

