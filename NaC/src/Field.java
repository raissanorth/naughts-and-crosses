import javafx.scene.paint.Color;

public class Field {
Boolean taken = false;
Color color;
int x;
int y;


public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

public Color getColor() {
	return color;
}

public void setColor(Color c) {
	this.color = c;
}

public Field() {
}

public Boolean isTaken(){
	return taken;
}

public void setTaken(Boolean t) {
	this.taken = t;
}

}
