package drawing_vector.model;

public class LineFigure extends Figure {

    private int coordinateX1;
    private int coordinateY1;
    private int coordinateX2;
    private int coordinateY2;

	public LineFigure (int[] startPosition, int[] endPosition, int[] color) {
		super(startPosition, endPosition, color);
		drawFigure();
	}

	@Override
	public void drawFigure() {
		this.coordinateX1 = super.getStartPosition()[0];
		this.coordinateY1 = super.getStartPosition()[1];
		this.coordinateX2 = super.getEndPosition()[0];
		this.coordinateY2 = super.getEndPosition()[1];
	}

	public int getCoordinateX1() {
		return this.coordinateX1;
	}

	public int getCoordinateY1() {
		return this.coordinateY1;
	}

	public int getCoordinateX2() {
		return this.coordinateX2;
	}

	public int getCoordinateY2() {
		return this.coordinateY2;
	}
}
