//꿈 내용 적는거 파일
package clock;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;//요소가 변하는 배열
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DreamWrite extends JPanel implements ActionListener{
	private JComboBox combobox = new JComboBox();
	private JTextField tf = new JTextField(18);
	private JLabel label1 = new JLabel("오늘 꾼 꿈내용 : ");
	private JLabel label2 = new JLabel("날짜 선택 : ");
	private JLabel label3 = new JLabel("");
	private JButton button = new JButton("입력");
	
	private Calendar cal =Calendar.getInstance();
	private int year = cal.get(Calendar.YEAR);
	private int month = cal.get(Calendar.MONTH)+1;
	private int date = cal.get(Calendar.DATE);
	
	DreamWrite(){
		setLayout(new BorderLayout());
		JPanel panel0 = new JPanel();
		panel0.add(label3);
		add(panel0,BorderLayout.NORTH);
		
		JPanel panel1 = new JPanel();
		panel1.add(label2);
		combobox.addActionListener(this);
		panel1.add(combobox);
		add(panel1,BorderLayout.CENTER);
		
		JPanel panel2 = new JPanel();
		panel2.add(label1);
		panel2.add(tf);
		button.addActionListener(this);
		panel2.add(button);
		add(panel2,BorderLayout.SOUTH);
		
		combobox.addItem(""+year+month+date); //.addItem 으로 combobox에 직접 넣는다.
		combobox.addItem(""+year+month+(date-1));
		combobox.addItem(""+year+month+(date-2));
		
	}
	public void actionPerformed(ActionEvent e){
		try {
			String f = combobox.getSelectedItem().toString();
			FileReader fr = new FileReader(f);
			int i;
			String s = "";
			while((i = fr.read()) != -1){
				s = s+(char)i;
				label3.setText(s);
			}
		}catch(Exception ee) {}
		if(e.getSource()==button) {
			try {
				char input[] = new char[tf.getText().length()];
				tf.getText().getChars(0, tf.getText().length(), input, 0);
				FileWriter fw = new FileWriter(""+year+month+date);
				fw.write(input);
				fw.close();
				
				String f = combobox.getSelectedItem().toString();
				FileReader fr = new FileReader(f);
				int i;
				String s = "";
				while((i = fr.read()) != -1){
					s = s+(char)i;
					label3.setText(s);
				}
				fr.close();
				
			}catch(Exception ee) {}
			
		}
	}
	

}
