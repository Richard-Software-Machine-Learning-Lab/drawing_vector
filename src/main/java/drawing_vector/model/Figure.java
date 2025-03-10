package drawing_vector.model;

public abstract class Figure {

      private int[] startPosition = new int[2];

      private int[] endPosition = new int[2];

      private int[] colorChannels = new int[4];

      public Figure(int[] startPosition, int[] endPosition, int[] colorChannels) {
    	  if (startPosition[0] >= 0 && startPosition[1] >= 0 && endPosition[0] >= 0 && endPosition[1] >= 0) {
    		  this.startPosition[0] = startPosition[0];
        	  this.startPosition[1] = startPosition[1];
        	  this.endPosition[0] = endPosition[0];
        	  this.endPosition[1] = endPosition[1];
    	  } else {
    		  throw new IllegalArgumentException("The positions are not positive");
    	  }	  
    	 if (verifyColorChannel(colorChannels[0]) && verifyColorChannel(colorChannels[1]) && verifyColorChannel(colorChannels[2]) && verifyColorChannel(colorChannels[3])) {
    		 this.colorChannels[0] = colorChannels[0];
       	     this.colorChannels[1] = colorChannels[1];
       	     this.colorChannels[2] = colorChannels[2];
       	     this.colorChannels[3] = colorChannels[3];
    	 } else {
    		 throw new IllegalArgumentException("One or more channels are not in the range between 0 and 255");
    	 }  	 
      }

      public abstract void drawFigure();

      public boolean verifyColorChannel(int colorChannel) {
    	  boolean verification = false;
    	  if (colorChannel >= 0 && colorChannel <=255) {
    		  verification = true;
    	  }
    	  return verification;
      }

      public int[] getStartPosition() {
    	  return startPosition;
      }

      public int[] getEndPosition() {
    	  return endPosition;
      }

      public int[] getColor() {
    	  return colorChannels;
      }
}
