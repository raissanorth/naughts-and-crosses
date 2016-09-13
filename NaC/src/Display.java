import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Display extends Application {
	int xcoord;
	int ycoord;
	int size = 100;
	int width = 300;
	int height =300;
	int turn = 1;
	NaC logic;
	Group board;
	StackPane stack;

	@Override
	public void start(Stage primaryStage) throws Exception {

		board = new Group();
		stack = new StackPane();
		
		logic = NaC.newGame();
		redraw();
		
		// board.set(Pos.CENTER);
		Label winner = new Label("Hurray, you are the winner of the game!");
		winner.setAlignment(Pos.CENTER);
		winner.setFont(Font.font("Arial",FontWeight.BOLD, 15));
		winner.setMaxWidth(width);
		
		Label gameover = new Label("GAME OVER");
		gameover.setAlignment(Pos.CENTER);
		gameover.setFont(Font.font("Arial",FontWeight.BOLD, 15));
		gameover.setMaxWidth(width);

		board.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				System.out.println("Entered EventHandler"); // EXECUTED
				board.getChildren().clear();
				System.out.println("Clared board");


				int x = (int) event.getSceneX();
				int y = (int) event.getSceneY();
				System.out.println("x = " + x + " y = " + y); // EXECUTED


				xcoord = (x - x % size)/size;
				ycoord = (y - y % size)/size;
				System.out.println("xcoord = " + xcoord + " ycoord = " + ycoord); // EXECUTED


				logic.update(turn, xcoord, ycoord);

				redraw();
				//0.5s delay to see execution before method
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// check if the person won --EXECUTED
				if (logic.checkWinner() == true) {
					//board.getChildren().clear();
					stack.getChildren().add(winner);
				}
				else if (logic.checkFill() == true) {
					//board.getChildren().clear();
					stack.getChildren().add(gameover);
				}
				turn++;
			}
		});
		
		stack.getChildren().add(board);
		Scene scene = new Scene(stack, width, height);

		primaryStage.setTitle("Naughts and Crosses");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void redraw() {
		for (int i = 0; i < logic.values.length; i++) {
			for (int j = 0; j < logic.values.length; j++) {
				//Create new rectangle
				Rectangle r = new Rectangle(logic.values[i][j].getX() * size, logic.values[i][j].getY() * size,size,size);
				r.setStroke(Color.BLACK);
				r.setArcWidth(20);//rounded corners
				r.setArcHeight(20);
				System.out.println("Outline color set in redraw method.");
				if (logic.values[i][j].getColor() != null) {
					r.setFill(logic.values[i][j].getColor());
					System.out.println("I = " + i + " J = " + j + " Color = " + logic.values[i][j].getColor());
				}
				board.getChildren().add(r);
				System.out.println("Added rectangle to group.");
			}
		}
	}

	public static void main(String[] args) {
		NaC.newGame();
		Application.launch(args);
	}

}
