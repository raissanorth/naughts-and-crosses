import java.util.Scanner;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class NaC {
	String X;
	String O;
	Field[][] values = new Field[3][3];

	public NaC() {
	}

	/** Create an instance of values and populate it */
	public static NaC newGame() {
		NaC game = new NaC();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				game.values[i][j] = new Field();
				game.values[i][j].setX(i);
				game.values[i][j].setY(j);
			}
		}
		return game;
	}

	/** checks fill of all cells and determines if GAME OVER */
	public Boolean checkWinner() {
		Boolean winner = false;
		if (values[0][0].getColor() == values[0][1].getColor() && values[0][0].getColor() == values[0][2].getColor()
				&& values[0][0].getColor() != null) {
			winner = true;
		} else if (values[1][0].getColor() == values[1][1].getColor()
				&& values[1][0].getColor() == values[1][2].getColor() 
				&& values[1][0].getColor() != null) {
			winner = true;
		} else if (values[2][0].getColor() == values[2][1].getColor()
				&& values[2][0].getColor() == values[2][1].getColor() 
				&& values[2][0].getColor() != null) {
			winner = true;
		} else if (values[0][0].getColor() == values[1][0].getColor()
				&& values[0][0].getColor() == values[2][0].getColor() 
				&& values[0][0].getColor() != null) {
			winner = true;
		} else if (values[0][1].getColor() == values[1][1].getColor()
				&& values[0][1].getColor() == values[2][1].getColor() 
				&& values[0][1].getColor() != null) {
			winner = true;
		} else if (values[0][2].getColor() == values[1][2].getColor()
				&& values[0][2].getColor() == values[2][2].getColor() 
				&& values[0][2].getColor() != null) {
			winner = true;
		} else if (values[0][0].getColor() == values[1][1].getColor()
				&& values[0][0].getColor() == values[2][2].getColor() 
				&& values[0][0].getColor() != null) {
			winner = true;
		} else if (values[2][0].getColor() == values[1][1].getColor()
				&& values[2][0].getColor() == values[0][2].getColor() 
				&& values[2][0].getColor() != null) {
			winner = true;
		}
		return winner;
	}

	public void update(int turn, int col, int row) {
		// check if field is not already taken
		if (values[col][row].isTaken() == false) {
			// determine player and associated color
			if (turn % 2 == 0) {
				values[col][row].setColor(Color.GOLD);
				values[col][row].setTaken(true);
			} else {
				values[col][row].setColor(Color.BLUE);
				values[col][row].setTaken(true);
			}

		}

	}

	/** checks fill of all cells and determines if GAME OVER */
	public Boolean checkFill() {
		Boolean allFilled = true;
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values.length; j++) {
				if (values[i][j].isTaken() == false) {
					allFilled = false;
					break;
				}
			}
		}
		return allFilled;
	}

}
