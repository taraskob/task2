package files2;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

public class LoadSaveF {
		void save(String mfname,JTextComponent mjtfFName, JLabel mjlabMsg, JTextArea mjta) {
		FileWriter fw;

		try {
			fw=new FileWriter(mfname);
			mjta.write(fw);
			fw.close();
			mjlabMsg.setText("");
			} catch(IOException exc) {
			mjlabMsg.setText("Error opening or writing file...");
			return;
		}
		mjlabMsg.setText("File written successfully...");
	}
		void load(String mfname,JTextComponent mjtfFName, JLabel mjlabMsg, JTextArea mjta) {
			FileReader fw;
			
		try {
				fw=new FileReader(mfname);
				mjta.read(fw, null);
				fw.close();
				mjlabMsg.setText("");
			}catch(IOException exc) {
				mjlabMsg.setText("Error opening or writing file...");
				return;
			}
		}	
}

