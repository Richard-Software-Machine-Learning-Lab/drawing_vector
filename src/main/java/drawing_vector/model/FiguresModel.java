package drawing_vector.model;
import java.util.Observable;
import java.util.Stack;

public class FiguresModel extends Observable {

         Figure figure;
         Stack<Figure> stack; 
         Stack<Figure> stackUndo;

         public FiguresModel() {
        	 this.figure = null;
        	 stack = new Stack<Figure>(); 
        	 stackUndo = new Stack<Figure>();
         }

         private void update() {
             this.setChanged();
             this.notifyObservers();
         }

         public void drawRectangle(int[] startPosition, int[] endPosition, int[] color) {
        	 figure  = new RectangleFigure(startPosition, endPosition, color);
        	 stack.push(figure);
        	 update();       	
         }

         public void drawLine(int[] startPosition, int[] endPosition, int[] color) {
        	 figure  = new LineFigure(startPosition, endPosition, color);
        	 stack.push(figure);
        	 update();
         }

         public void drawEllipse(int[] startPosition, int[] endPosition, int[] color) {
        	 figure = new EllipseFigure(startPosition, endPosition, color);
        	 stack.push(figure);
        	 update();
         }

         public void undo() {
        	 this.stackUndo.push(getStack().pop());
        	 update();  
         }

         public void redo() {
        	 this.stack.push(getStackUndo().pop());
        	 update();  
         }

         public Figure getFigure() {
        	 return this.figure;
         }

         public Stack<Figure> getStack(){
        	 return this.stack;
         }

         public Stack<Figure> getStackUndo(){
        	 return this.stackUndo;
         }
       
}
