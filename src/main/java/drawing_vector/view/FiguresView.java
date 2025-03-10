package drawing_vector.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import drawing_vector.controller.FiguresController;
import drawing_vector.model.EllipseFigure;
import drawing_vector.model.Figure;
import drawing_vector.model.FiguresModel;
import drawing_vector.model.LineFigure;
import drawing_vector.model.RectangleFigure;

public class FiguresView implements Observer, ActionListener, ChangeListener {

	private FiguresModel model;
	private FiguresController controller;

    private JFrame mainFrame;
	private JPanel panelButtons;
	private JPanel panelColor;
	private JPanel panelCanvas;

    private static int DEFAULT_FRAME_WIDTH = 800;
	private static int DEFAULT_FRAME_HEIGHT = 900;

	protected static String BUTTON_LINE = "Line";
	protected static String BUTTON_RECTANGLE = "Rectangle";
	protected static String BUTTON_ELLIPSE = "Ellipse";
	protected static String BUTTON_UNDO = "Undo";
    protected static String BUTTON_REDO = "Redo";
    protected static String BUTTON_CLEAR = "Clear";

	private JButton lineButton;
	private JButton rectangleButton;
	private JButton ellipseButton;
	private JButton undoButton;
	private JButton redoButton;

	private int idFigure = 0;

	private JColorChooser chooser;

	private int redChannel;
	private int greenChannel;
	private int blueChannel;
	private int alphaChannel;

	private boolean buttonClicked = false;

	public FiguresView(FiguresModel model, FiguresController controller) {

		this.model = model;
		this.controller = controller;

		this.redChannel = 255;
		this.greenChannel = 255;
		this.blueChannel = 255;
		this.alphaChannel = 255;

		mainFrame = new JFrame("FIGURES");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
        mainFrame.setVisible(true);

        panelButtons = new JPanel();
        panelColor = new JPanel();
        panelCanvas = new JPanel();
        panelButtons.setPreferredSize(new Dimension(800, 50));
        panelColor.setPreferredSize(new Dimension(800, 300));
        panelCanvas.setPreferredSize(new Dimension(800, 550));
        panelButtons.setBackground(Color.black);
        panelCanvas.setBackground(Color.white);

        mainFrame.getContentPane().add(panelButtons, BorderLayout.NORTH);
        mainFrame.getContentPane().add(panelColor, BorderLayout.CENTER);
        mainFrame.getContentPane().add(panelCanvas, BorderLayout.SOUTH);

        initializeColorChooser();

        addElements();

        mainFrame.setResizable(false);
        undoButton.setEnabled(false);
        redoButton.setEnabled(false);

        elementsListener();

        ((Observable) model).addObserver(this);

        mainFrame.pack();
}

	public void initializeColorChooser() {
		chooser = new JColorChooser();
		chooser.getSelectionModel().addChangeListener(this);
		removeExtraPalettes();
	}

	public void removeExtraPalettes() {
		chooser.removeChooserPanel(chooser.getChooserPanels()[4]);
		chooser.removeChooserPanel(chooser.getChooserPanels()[0]);
		chooser.removeChooserPanel(chooser.getChooserPanels()[0]);
		chooser.removeChooserPanel(chooser.getChooserPanels()[0]);
	}

	public void elementsListener() {

		   int[] startPosition = new int[2];
    	   int[] endPosition = new int[2];

    	   lineButton.addActionListener( new ActionListener() {
               public void actionPerformed(ActionEvent e) {
            	   buttonClicked = true;
            	   idFigure = 1;
               }
           });

		   rectangleButton.addActionListener( new ActionListener() {
               public void actionPerformed(ActionEvent e) {
            	   buttonClicked = true;
            	   idFigure = 2;
               }
           });

		   ellipseButton.addActionListener( new ActionListener() {
               public void actionPerformed(ActionEvent e) {
            	   buttonClicked = true;
            	   idFigure = 3;
               }
           });

		   undoButton.addActionListener( new ActionListener() {
               public void actionPerformed(ActionEvent e) {
            	   mainFrame.repaint();
            	   controller.controllerUndo();
               }
           });

		   redoButton.addActionListener( new ActionListener() {
               public void actionPerformed(ActionEvent e) {
            	   mainFrame.repaint();
            	   controller.controllerRedo();
               }
           });

		   panelCanvas.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				startPosition[0] = e.getX();
				startPosition[1] = e.getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				 endPosition[0] = e.getX();
				 endPosition[1] = e.getY();
				if (buttonClicked) {
					 verifyControllerFigure(idFigure, startPosition, endPosition, redChannel, greenChannel, blueChannel, alphaChannel); 
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
}

	public void enableButtons() {
		   undoButton.setEnabled(true);
	       redoButton.setEnabled(true);
	}

	public void verifyControllerFigure(int idFigure, int[] startPosition, int[] endPosition, int redChannel, int greenChannel, int blueChannel, int alphaChannel) {
		int[] color = new int[4];
		color[0] = redChannel;
		color[1] = greenChannel;
		color[2] = blueChannel;
		color[3] = alphaChannel;
		if (idFigure == 1) {
			undoButton.setEnabled(true);
			controller.controlLine(startPosition, endPosition, color);
		} 
		else if (idFigure == 2) {
			undoButton.setEnabled(true);
			controller.controlRectangle(startPosition, endPosition, color);
		}
		else if (idFigure == 3) {
			undoButton.setEnabled(true);
			controller.controlEllipse(startPosition, endPosition, color);
		}	
	}

	public void addElements() {
		undoButton = new JButton (BUTTON_UNDO);
	    redoButton = new JButton (BUTTON_REDO);
   	    lineButton = new JButton(BUTTON_LINE);
        rectangleButton = new JButton(BUTTON_RECTANGLE);
        ellipseButton = new JButton (BUTTON_ELLIPSE);
        panelButtons.add(lineButton);
        panelButtons.add(rectangleButton);
        panelButtons.add(ellipseButton);
        panelButtons.add(undoButton);
        panelButtons.add(redoButton);
        panelColor.add(chooser);
   }

	@Override
	public void update(Observable o, Object arg) {
		SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                    	Stack<Figure> stack = model.getStack();
                    	Stack<Figure> stackUndo = model.getStackUndo();
                    	drawFigures(panelCanvas.getGraphics(), stack, stackUndo);
                    }
                });
		
	}

	public void drawFigures(Graphics g, Stack<Figure> stack, Stack<Figure> stackUndo) {
		for (int i = 0; i < stack.size(); i++) {	
			Figure figure = stack.get(i);
			int[] color = figure.getColor();
			if (figure instanceof RectangleFigure) {
				RectangleFigure rec = ((RectangleFigure) figure);
				g.setColor(new Color(color[0], color[1], color[2], color[3]));
				g.drawRect(rec.getCoordinateX(), rec.getCoordinateY(), rec.getWidth(), rec.getHeight());
			} 
			else if (figure instanceof LineFigure) {
				LineFigure line = ((LineFigure) figure);
				g.setColor(new Color(color[0], color[1], color[2], color[3]));
				g.drawLine(line.getCoordinateX1(), line.getCoordinateY1(), line.getCoordinateX2(), line.getCoordinateY2());
			}
			else if  (figure instanceof EllipseFigure) {
				EllipseFigure ellipse = ((EllipseFigure) figure);
				g.setColor(new Color(color[0], color[1], color[2], color[3]));
				g.drawOval(ellipse.getCoordinateX(), ellipse.getCoordinateY(), ellipse.getWidth(), ellipse.getHeight());
			}
		}

		availableAndDisableButtons(stack, undoButton);
		availableAndDisableButtons(stackUndo, redoButton);
	}

	public void availableAndDisableButtons(Stack<Figure> stack, JButton button) {
		if ((stack.size()) == 0) {
			button.setEnabled(false);
		} else {
			button.setEnabled(true);
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Color theColor = chooser.getColor();
		redChannel = theColor.getRed();
		greenChannel = theColor.getGreen();
		blueChannel = theColor.getBlue();
		alphaChannel = theColor.getAlpha();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
