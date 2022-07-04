//타이머 : 특정시간을 입력한 후 버튼을 누르면 얼마후 종료를 알린다. 
package clock;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class f_Timer extends JFrame implements ActionListener{
	private JPanel panel = new JPanel();
	private JLabel label;
	private static String list[] = {"5","10","30","60"};
	private JComboBox sec_list = new JComboBox(list);
	private JTextField tf;
	private JButton button;
	f_Timer(){
		setSize(300,150);
		setTitle("타이머");
		panel.setLayout(new GridLayout(0,2));
		label = new JLabel("초를 선택하세요 : ");
		panel.add(label);
		
		panel.add(sec_list);
		
		button = new JButton("시작");
		button.addActionListener(this);
		panel.add(button);
		
		tf = new JTextField();
		
		
		panel.add(tf);
		
		add(panel);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		String f = sec_list.getSelectedItem().toString();
		int int_sec = Integer.parseInt(f); //정수로 변환된 입력 받는 millisecond
		int isec = int_sec*1000;//1초 = 1000밀리세컨드

		tf.setForeground(Color.blue);
		tf.setText(int_sec+"초 후에 울립니다");

		if(button == e.getSource()) {			
			Timer timer = new Timer();
			timer.schedule(new TimerTask() { //무명클래스
				@Override
				public void run() {
					tf.setForeground(Color.red);
					tf.setText("Ring !");
				}
			}, isec);
		}
	}
}