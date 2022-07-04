//메인 프레임 
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
	
	private JPanel clock = new DigitalClock(); //상위클래스에 하위클래스배치(다형성)
	private JPanel date = new DateClock();
	private JPanel dream = new DreamWrite();
	
	private JLabel label; //뭐할건지 묻는 라벨
	private JComboBox Funktion; //기능선택
	
	Main_clock(){
		setTitle("시계");
		setSize(530,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//패널에 버튼 추가
		m_panel.setLayout(new BorderLayout());
		m_panel.add(l_panel,BorderLayout.CENTER);
		m_panel.add(r_panel, BorderLayout.EAST);
		l_panel.setLayout(new BorderLayout());
		l_panel.add(date,BorderLayout.NORTH);// DatePanel클래스의 date객체
		l_panel.add(clock,BorderLayout.CENTER);// ClockPanel클래스의 clock객체
		l_panel.add(dream,BorderLayout.SOUTH);//DreamWrite클래스의 dream객체
		add(m_panel);
		

		//r_panel에 기능선택 추가
				label = new JLabel("기능을 선택하세요");
				label.setFont(new Font("굴림", Font.BOLD, 15));
				r_panel.setBackground(Color.BLACK);
				label.setForeground(Color.WHITE);
				r_panel.setLayout(new GridLayout(0,1));
				r_panel.add(label);
				String list[] = {"디데이","타이머"};
				Funktion = new JComboBox(list);
				Funktion.setFont(new Font("", Font.BOLD, 30));
				r_panel.add(Funktion);
				Funktion.addActionListener(new ActionListener() { //무명클래스
					public void actionPerformed(ActionEvent e) {
						String f = Funktion.getSelectedItem().toString();
						label.setText("선택한 기능:  " + f);
						if(f=="디데이") {
							new f_D_day();
						}
						else if(f=="타이머") {
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
