package drawing_vector.model;

public class EllipseFigure extends Figure {
    private int coordinateX;
	private int coordinateY;
	private int width;
	private int height;

	public EllipseFigure(int[] startPosition, int[] endPosition, int[] color) {
		super(startPosition, endPosition, color);
		drawFigure();
	}

	@Override
	public void drawFigure() {

		if (super.getStartPosition()[0] <= super.getEndPosition()[0]) {
			this.coordinateX = super.getStartPosition()[0];
			this.coordinateY = super.getStartPosition()[1];
			this.width = super.getEndPosition()[0] -  super.getStartPosition()[0];
			this.height = super.getEndPosition()[1] -  super.getStartPosition()[1];
		}
		else if (super.getStartPosition()[0] > super.getEndPosition()[0]) {
			this.coordinateX = super.getEndPosition()[0];
			this.coordinateY = super.getStartPosition()[1];
			this.width = super.getStartPosition()[0] -  super.getEndPosition()[0];
			this.height = super.getEndPosition()[1] -  super.getStartPosition()[1];
		}
	}

	public int getCoordinateX() {
		return coordinateX;
	}

	public int getCoordinateY() {
		return coordinateY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
