import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class Ahnso {
  Display display = new Display();
  Shell shlSminggo = new Shell(display);
  StyledText styledText;
  boolean unsaved;
  File file;
  String lastDirectory;
  
  public Ahnso() {
  shlSminggo.setMinimumSize(new Point(200, 500));
  shlSminggo.setLayout(null);
  ToolBar toolBar = new ToolBar(shlSminggo, SWT.FLAT | SWT.RIGHT );
  toolBar.setBounds(5, 5, 351, 38);
  ToolItem item1 = new ToolItem(toolBar, SWT.PUSH);
  item1.setImage(SWTResourceManager.getImage("I:\\workspace\\SmingGos\\icon\\document-new.png"));
  item1.addListener(SWT.Selection, new Listener() {
  public void handleEvent(Event event) {
  if(saveChanges())  {
  file = null;
  styledText.setText("");
  }
  }
  });
  ToolItem item2 = new ToolItem(toolBar, SWT.PUSH);
  item2.setImage(SWTResourceManager.getImage("I:\\workspace\\SmingGos\\icon\\document-open.png"));
  item2.addListener(SWT.Selection, new Listener() {
  public void handleEvent(Event event) {
  loadText();
  }
  });
  ToolItem item3 = new ToolItem(toolBar, SWT.PUSH);
  item3.setImage(SWTResourceManager.getImage("I:\\workspace\\SmingGos\\icon\\document-save.png"));
  item3.addListener(SWT.Selection, new Listener() {
  public void handleEvent(Event event) {
  saveText();
  }
  });  
  ToolItem item4 = new ToolItem(toolBar, SWT.PUSH);
  item4.setImage(SWTResourceManager.getImage("I:\\workspace\\SmingGos\\icon\\edit-undo.png"));
  item4.addListener(SWT.Selection, new Listener() {
  public void handleEvent(Event event) {
  styledText.copy();
  }
  });
  ToolItem item5 = new ToolItem(toolBar, SWT.PUSH);
  item5.setImage(SWTResourceManager.getImage("I:\\workspace\\SmingGos\\icon\\edit-redo.png"));
  item5.addListener(SWT.Selection, new Listener() {
  public void handleEvent(Event event) {
  styledText.cut();
  }
  });
  ToolItem item6 = new ToolItem(toolBar, SWT.PUSH);
  item6.setImage(SWTResourceManager.getImage("I:\\workspace\\SmingGos\\icon\\emblem-system.png"));
  item6.addListener(SWT.Selection, new Listener() {
  public void handleEvent(Event event) {
  styledText.paste();
  }
  });
  
  ToolItem item7 = new ToolItem(toolBar, SWT.NONE);
  item7.setImage(SWTResourceManager.getImage("I:\\workspace\\SmingGos\\icon\\emblem-unreadable.png"));
  
  ToolItem item8 = new ToolItem(toolBar, SWT.NONE);
  item8.setImage(SWTResourceManager.getImage("I:\\workspace\\SmingGos\\icon\\help-browser.png"));
  ToolItem item9 = new ToolItem(toolBar, SWT.PUSH);
  item9.setImage(SWTResourceManager.getImage("I:\\workspace\\SmingGos\\icon\\system-log-out.png"));
  item9.addListener(SWT.Selection, new Listener() {
  public void handleEvent(Event event) {
  if(saveChanges())
  shlSminggo.dispose();
  }
  });
  toolBar.pack();
  Font font = new Font(shlSminggo.getDisplay(),"Book Antiqua",12,
   SWT.NORMAL);
  shlSminggo.setText("SmingGo");
  shlSminggo.setSize(369, 200);
  
  TabFolder tabFolder = new TabFolder(shlSminggo, SWT.NONE);
  tabFolder.setBounds(5, 48, 351, 202);
  
  TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
  tabItem.setText("New Item");
  styledText =
  new StyledText(tabFolder,SWT.MULTI| SWT.WRAP|SWT.BORDER|
  SWT.H_SCROLL|SWT.V_SCROLL);
  tabItem.setControl(styledText);
  
    styledText.addModifyListener(new ModifyListener() {
    public void modifyText(ModifyEvent e) {
    unsaved = true;
    }
    });
  
  StyledText styledText_1 = new StyledText(shlSminggo, SWT.BORDER);
  styledText_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
  styledText_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
  styledText_1.setBounds(5, 280, 351, 178);
  
  Label lblNewLabel = new Label(shlSminggo, SWT.NONE);
  lblNewLabel.setBounds(10, 262, 61, 12);
  lblNewLabel.setText("Console");
  shlSminggo.open();
  while (!shlSminggo.isDisposed()) {
  if (!display.readAndDispatch()) {
  display.sleep();
  }
  }
  display.dispose();
  }

 boolean saveChanges() {
  if(! unsaved)
  return true;
  MessageBox box = new MessageBox(shlSminggo,SWT.ICON_WARNING|SWT.YES| 
  SWT.NO | SWT.CANCEL);
  box.setMessage("save changes? " );
  box.setText("Editor");
  int condition = box.open();
  if(condition == SWT.YES) {
  return saveText();
  }else if(condition == SWT.NO) {
  return true;
  }else{
  return false;
  }
  }

  boolean loadText() {
  FileDialog dialog = new FileDialog(shlSminggo, SWT.OPEN);
  if (lastDirectory != null)
  dialog.setFilterPath(lastDirectory);

  String selectedFile = dialog.open();
 if (selectedFile == null) {
  System.out.println("File is not opened");
  return false;
  }
  file = new File(selectedFile);
  lastDirectory = file.getParent();
  
  try {
  BufferedReader reader = new BufferedReader(new FileReader(file));
  StringBuffer buffer = new StringBuffer();
  String line = null;
  while((line = reader.readLine()) != null) {
  buffer.append(line);
  buffer.append("\r\n");
  }
  styledText.setText(buffer.toString());
  return true;
  }catch(IOException e) {}  
  return false;
  }

  boolean saveText() {
  if (file == null) {
  FileDialog fileDialog = new FileDialog(shlSminggo, SWT.SAVE);
  if (lastDirectory != null)
  fileDialog.setFilterPath(lastDirectory);

  String selectedFile = fileDialog.open();
 if (selectedFile == null) {
  System.out.println("File is not saved");
  return false;
  }
  file = new File(selectedFile);
  lastDirectory = file.getParent();
  }
  try {
  FileWriter writer = new FileWriter(file);
  writer.write(styledText.getText());
  writer.close();
  unsaved = false;
  return true;
  } catch (IOException e) {}
  return false;
  }
 public static void main(String[] args) {
  new Ahnso();
  }
}