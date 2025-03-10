package drawing_vector.main;
import drawing_vector.controller.FiguresController;
import drawing_vector.model.FiguresModel;
import drawing_vector.view.FiguresView;

public class Main {

       public static void main(String[] args) {

    	   FiguresModel model = new FiguresModel();

    	   FiguresController controller = new FiguresController(model);

    	    new FiguresView(model, controller);
       }
}
