package drawing_vector.model;
public class TriangleFigure extends Figure {
	private int[] coordinatesX;
	private int[] coordinatesY;
     public TriangleFigure (int[] startPosition, int[] endPosition, int[] color) {
    	super(startPosition, endPosition, color);
 		drawFigure();
     }
	@Override
	public void drawFigure() {
		if (super.getStartPosition()[0] <= super.getEndPosition()[0]) {
			this.coordinatesX[0] = ((super.getEndPosition()[0] - super.getStartPosition()[0]) / 2) + 1;
			this.coordinatesY[0] = super.getEndPosition()[0];
			this.coordinatesX[1] = super.getEndPosition()[0];
			this.coordinatesY[1] = super.getEndPosition()[1];
			this.coordinatesX[2] = super.getStartPosition()[0];
			this.coordinatesY[2] = super.getEndPosition()[1];
		}
		else if (super.getStartPosition()[0] > super.getEndPosition()[0]) {
			this.coordinatesX[0] = ((super.getStartPosition()[1] - super.getStartPosition()[0]) / 2) + 1;
			this.coordinatesY[0] = super.getEndPosition()[0];
			this.coordinatesX[1] = super.getEndPosition()[0];
			this.coordinatesY[1] = super.getEndPosition()[1];
			this.coordinatesX[2] = super.getStartPosition()[0];
			this.coordinatesY[2] = super.getEndPosition()[1];
		}
	}
}
