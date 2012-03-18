import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Method;
import java.util.HashMap;

import processing.core.PApplet;

public class ProcessingWindow extends Frame {

  // constructor
	
	
	  private static ProcessingWindow single = new ProcessingWindow();
	  
	  public static ProcessingWindow getInstance(){
	        return single;
	    }
	    	

	
  private ProcessingWindow() {

	super("Processing");
	setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));	
	add(Processing.getInstance());
	

	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			System.exit(ERROR);
		}
	});
	Processing.getInstance().init();
	setSize(200, 200);
	//setVisible(true);
	}
  


}