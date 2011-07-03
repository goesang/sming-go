import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Method;

import processing.core.PApplet;

public class ProcessingWindow extends Frame {

  // constructor
  public ProcessingWindow(PApplet pap) {

	super("Processing");
	setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));	
	add(pap);
	
	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			dispose();
		}
	});
	
	pap.init();
	setVisible(true);
	setSize(pap.width, pap.height);
	}
  


}