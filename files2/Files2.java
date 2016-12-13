package files2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Files2 {
private JLabel jlabMsg;
private JTextArea jta;
private JTextField jtfFName;
private JButton jbtnSave;
private JButton jbtnLoad;
private String fname;
public Files2() {
	JFrame jfrm=new JFrame("Files2...");
	jfrm.getContentPane().setLayout(new FlowLayout());
	jfrm.setSize(270, 350);
	jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jlabMsg=new JLabel();
	jlabMsg.setPreferredSize(new Dimension(200,30) );
	jlabMsg.setHorizontalAlignment(SwingConstants.CENTER);
	JLabel jlabSeparator=new JLabel();
	jlabSeparator.setPreferredSize(new Dimension(200,30));
	JLabel jlabFilename=new JLabel("Filename :");
	jlabFilename.setPreferredSize(new Dimension(70,20));
	jlabFilename.setHorizontalAlignment(SwingConstants.LEFT);
	jta=new JTextArea();
	JScrollPane jscrlp=new JScrollPane(jta);
	jscrlp.setPreferredSize(new Dimension(250,200));
	jtfFName=new JTextField(15);
	jta.addCaretListener(new CaretListener(){
		public void caretUpdate(CaretEvent ce) {
			String str=jta.getText();
			jlabMsg.setText("Current size: "+str.length());
			AsyncData async=new AsyncData(str,jta);
			Thread t=new Thread(async);
			t.start();
			}
	});
	LoadSaveF lsF=new LoadSaveF();
	jbtnSave=new JButton("Save File");
	jbtnLoad=new JButton("Load File");
	jbtnSave.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent le) {
			fname=jtfFName.getText();
			jlabMsg.setText(fname);
			if(isFile(fname)){
			lsF.save(fname,jtfFName,jlabMsg,jta);
			}
		}
	});
	jbtnLoad.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent le) {
			fname=jtfFName.getText();
			jlabMsg.setText(fname);
			if(isFile(fname)){
			lsF.load(fname,jtfFName,jlabMsg,jta);
			}
		}
	});
	Container cp=jfrm.getContentPane();
	cp.add(jscrlp);
	cp.add(jlabFilename);
	cp.add(jtfFName);
	cp.add(jlabSeparator);
	cp.add(jbtnSave);
	cp.add(jbtnLoad);
	cp.add(jlabMsg);
	jfrm.setVisible(true);
}
public boolean isFile(String mfname) {
	if(mfname.length()==0){
		jlabMsg.setText("No filename present...");
				return false;
		}
	return true;
}

}
