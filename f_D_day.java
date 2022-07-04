//디데이
package clock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class f_D_day extends JFrame implements ActionListener {
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	
	private JLabel label1 = new JLabel("디데이 명을 입력하세요");
	private JLabel label1_1 = new JLabel(" D -");
	private JLabel label1_2 = new JLabel("");
	private JTextField name_dday = new JTextField(10);
	
	private JLabel label2 = new JLabel("년,월,일을 입력하세요");
	private JTextField tf_y,tf_m,tf_d;
	private int year,month,day;
	
	private JButton button = new JButton("입력");
	
	private JLabel label3 = new JLabel("");
	
	private Calendar now = Calendar.getInstance();
	private Calendar d_day = Calendar.getInstance();
	
	
	f_D_day(){
		setTitle("디데이 계산기");
		setSize(500,150);
		setLayout(new BorderLayout());
		
		panel1.setBackground(Color.CYAN);
		panel1.add(label1);
		name_dday.setForeground(Color.BLUE);
		panel1.add(name_dday);
		add(panel1,BorderLayout.NORTH);
		
	    tf_y=new JTextField(3);
	    tf_m=new JTextField(3);
	    tf_d=new JTextField(3);
	    panel2.add(label2);
	    panel2.add(tf_y);
	    panel2.add(tf_m);
	    panel2.add(tf_d);
	    panel2.setBackground(Color.CYAN);
	    button.setBackground(Color.black);
	    button.setForeground(Color.white);
		button.addActionListener(this);
	    panel2.add(button);
		add(panel2,BorderLayout.CENTER);
		panel3.setBackground(Color.white);
		add(panel3,BorderLayout.SOUTH);
	    
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (button == e.getSource()) {
			label3.setText(name_dday.getText());
			label3.setForeground(Color.blue);
			label3.setFont(new Font("휴먼편지체", Font.BOLD, 20));
			panel3.add(label3);
			label1_1.setFont(new Font("휴먼편지체", Font.BOLD, 20));
			label1_2.setFont(new Font("휴먼편지체", Font.BOLD, 20));
			panel3.add(label1_1);
			panel3.add(label1_2);
			
			int year =Integer.parseInt(tf_y.getText());
			int month =Integer.parseInt(tf_m.getText());
			int date = Integer.parseInt(tf_d.getText());
			d_day.set(year, month-1, date,0, 0, 0);
			long millisecond = d_day.getTime().getTime()-now.getTime().getTime(); //디데이 설정날짜에서 현재날짜를 뺀 후 millisecond에 저장
			long calculate_day = millisecond / (1000*60*60*24) ; //하루단위 계산
			
			label1_2.setText(calculate_day+"일");
			
		}
	}

}