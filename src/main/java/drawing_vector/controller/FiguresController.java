package drawing_vector.controller;
import drawing_vector.model.FiguresModel;

public class FiguresController {

       private FiguresModel model;

       public FiguresController(FiguresModel model) {
    	   this.model = model;
       }

       public void controlRectangle(int[] startPosition, int[] endPosition, int[] color) {
    	   model.drawRectangle(startPosition, endPosition, color);
       }

       public void controlLine(int[] startPosition, int[] endPosition, int[] color) {
    	   model.drawLine(startPosition, endPosition, color);
       }

       public void controlEllipse(int[] startPosition, int[] endPosition, int[] color) {
            model.drawEllipse(startPosition, endPosition, color);
       }

       public void controllerUndo() {
    	   model.undo();
       }

       public void controllerRedo() {
    	   model.redo();
       }
}
