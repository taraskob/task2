package files2;

import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
public class Filecontr implements ChangeHandler{
	private List<ChangeHandler> listener=new ArrayList<>();
	private String str;
	private JTextArea jta;
	public Filecontr(String str,JTextArea jta) {
		this.str=str;
		this.jta=jta;
		}
	{AsyncData async=new AsyncData(this);
	Thread t=new Thread(async);
	t.start();}
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
	public String getAsync(JTextArea mjta) {
	String str=mjta.getText();
	return str;	
    }
    public void onChange(){
        for(ChangeHandler item:listener){
            item.onChange();
        }
    }

}
