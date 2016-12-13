package files2;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
public class AsyncData implements Runnable {
private String str;
private JTextArea jta;
private List<ChangeHandler> listener=new ArrayList<>();
public AsyncData(String str,JTextArea jta) {
	this.str=str;
	this.jta=jta;
	}
	public String getAsync(JTextArea mjta) {
	String str=mjta.getText();
	return str;	
    }

	public void run() {
		while(true){
		 
			 compare();
			 try {
	                Thread.sleep(3000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
		 }
}
	public boolean isEqual(String str){
	return true;
	}
public void compare() {
	String strtmp=new String(str);
	str=getAsync(jta);
	if(!strtmp.equals(str)){
		Writer writer = null;
		try {
	        writer = new FileWriter("last_file");
	         {
	            writer.write(str);

	        }
	        writer.flush();
	        writer.close();
	    } catch (Exception e) {
	    	System.out.println("I/O error...");
	        
	    } 
		jta.setText(str);
		onChange();
	}
	}
public void addListener(ChangeHandler eventHandler){
	listener.add(eventHandler);
}
public void onChange() {
	for(ChangeHandler item:listener){
		item.onChange();
	
	}
}
}
