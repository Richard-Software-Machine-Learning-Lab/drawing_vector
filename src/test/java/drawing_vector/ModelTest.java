package drawing_vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import drawing_vector.model.*;

public class ModelTest {
        private FiguresModel model;
        private int[] startPosition;
        private int[] endPosition;
        private int[] color;
        
        @BeforeEach
        public void setup() {
        	startPosition = new int[] {3,4};
        	endPosition = new int[] {10, 14};
        	color = new int[] {0,0,0,255};
        	model = new FiguresModel();      	
        }
        
        @Test
        public void testExists() {
        	assertNotNull(model);
        }
        
        @Test
        public void testDrawRectangle() {
        	model.drawRectangle(startPosition, endPosition, color);
        	assertTrue(model.getFigure() instanceof RectangleFigure);
        	assertEquals(3, model.getFigure().getStartPosition()[0]);
        	assertEquals(4, model.getFigure().getStartPosition()[1]);
        	assertEquals(10, model.getFigure().getEndPosition()[0]);
        	assertEquals(14, model.getFigure().getEndPosition()[1]);
        	
        }
        
        @Test
        public void testDrawLine() {
        	model.drawLine(startPosition, endPosition, color);
        	assertTrue(model.getFigure() instanceof LineFigure);
        	assertEquals(3, model.getFigure().getStartPosition()[0]);
        	assertEquals(4, model.getFigure().getStartPosition()[1]);
        	assertEquals(10, model.getFigure().getEndPosition()[0]);
        	assertEquals(14, model.getFigure().getEndPosition()[1]);
        }
        
        @Test
        public void testDrawEllipse() {
        	model.drawEllipse(startPosition, endPosition, color);
        	assertTrue(model.getFigure() instanceof EllipseFigure);
        	assertEquals(3, model.getFigure().getStartPosition()[0]);
        	assertEquals(4, model.getFigure().getStartPosition()[1]);
        	assertEquals(10, model.getFigure().getEndPosition()[0]);
        	assertEquals(14, model.getFigure().getEndPosition()[1]);
        }
        
        @Test
        public void testUndoAndStacks() {
        	model.drawRectangle(startPosition, endPosition, color);
        	model.drawLine(startPosition, endPosition, color);
        	model.drawEllipse(startPosition, endPosition, color);
        	model.undo();
        	assertEquals(2, model.getStack().size());
        	assertEquals(1, model.getStackUndo().size());
        }
        
        @Test
        public void testRedoAndStacks() {
        	model.drawRectangle(startPosition, endPosition, color);
        	model.drawLine(startPosition, endPosition, color);
        	model.drawEllipse(startPosition, endPosition, color);
        	model.undo();
        	model.redo();
        	assertEquals(3, model.getStack().size());
        	assertEquals(0, model.getStackUndo().size());
        }
        /*
        @Test(expected = IllegalArgumentException.class)
        public void testWrongColorInput() {
        	System.out.println("Testing wrong input color.");
        	int[] newColor = {-200,100,100,100};
        	model.drawRectangle(startPosition, endPosition, newColor);
            fail("The last line should have thrown an exception");
        }
        
        @Test(expected = IllegalArgumentException.class)
        public void testWrongStartPosition() {
        	System.out.println("Testing wrong start position.");
        	int[] newStartPosition = new int[] {-13,4};
        	model.drawRectangle(newStartPosition, endPosition, color);
            fail("The last line should have thrown an exception");
        }
        
        @Test(expected = IllegalArgumentException.class)
        public void testWrongEndPosition() {
        	System.out.println("Testing wrong end position");
        	int[] newEndPosition = new int[] {-13,4};
        	model.drawRectangle(startPosition, newEndPosition, color);
            fail("The last line should have thrown an exception");
        } */
        
}
