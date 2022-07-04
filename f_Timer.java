//Ÿ�̸� : Ư���ð��� �Է��� �� ��ư�� ������ ���� ���Ḧ �˸���. 
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
		setTitle("Ÿ�̸�");
		panel.setLayout(new GridLayout(0,2));
		label = new JLabel("�ʸ� �����ϼ��� : ");
		panel.add(label);
		
		panel.add(sec_list);
		
		button = new JButton("����");
		button.addActionListener(this);
		panel.add(button);
		
		tf = new JTextField();
		
		
		panel.add(tf);
		
		add(panel);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		String f = sec_list.getSelectedItem().toString();
		int int_sec = Integer.parseInt(f); //������ ��ȯ�� �Է� �޴� millisecond
		int isec = int_sec*1000;//1�� = 1000�и�������

		tf.setForeground(Color.blue);
		tf.setText(int_sec+"�� �Ŀ� �︳�ϴ�");

		if(button == e.getSource()) {			
			Timer timer = new Timer();
			timer.schedule(new TimerTask() { //����Ŭ����
				@Override
				public void run() {
					tf.setForeground(Color.red);
					tf.setText("Ring !");
				}
			}, isec);
		}
	}
}