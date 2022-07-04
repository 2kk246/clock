//���� ������ 
package clock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main_clock extends JFrame {
	private JPanel m_panel = new JPanel();
	private JPanel l_panel = new JPanel();
	private JPanel r_panel = new JPanel();
	
	private JPanel clock = new DigitalClock(); //����Ŭ������ ����Ŭ������ġ(������)
	private JPanel date = new DateClock();
	private JPanel dream = new DreamWrite();
	
	private JLabel label; //���Ұ��� ���� ��
	private JComboBox Funktion; //��ɼ���
	
	Main_clock(){
		setTitle("�ð�");
		setSize(530,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�гο� ��ư �߰�
		m_panel.setLayout(new BorderLayout());
		m_panel.add(l_panel,BorderLayout.CENTER);
		m_panel.add(r_panel, BorderLayout.EAST);
		l_panel.setLayout(new BorderLayout());
		l_panel.add(date,BorderLayout.NORTH);// DatePanelŬ������ date��ü
		l_panel.add(clock,BorderLayout.CENTER);// ClockPanelŬ������ clock��ü
		l_panel.add(dream,BorderLayout.SOUTH);//DreamWriteŬ������ dream��ü
		add(m_panel);
		

		//r_panel�� ��ɼ��� �߰�
				label = new JLabel("����� �����ϼ���");
				label.setFont(new Font("����", Font.BOLD, 15));
				r_panel.setBackground(Color.BLACK);
				label.setForeground(Color.WHITE);
				r_panel.setLayout(new GridLayout(0,1));
				r_panel.add(label);
				String list[] = {"����","Ÿ�̸�"};
				Funktion = new JComboBox(list);
				Funktion.setFont(new Font("", Font.BOLD, 30));
				r_panel.add(Funktion);
				Funktion.addActionListener(new ActionListener() { //����Ŭ����
					public void actionPerformed(ActionEvent e) {
						String f = Funktion.getSelectedItem().toString();
						label.setText("������ ���:  " + f);
						if(f=="����") {
							new f_D_day();
						}
						else if(f=="Ÿ�̸�") {
							new f_Timer();
						}
					}
				});

				
		setVisible(true);
	}

	
	public static void main(String[] args) {
		Main_clock mainclock = new Main_clock();
	}

}
