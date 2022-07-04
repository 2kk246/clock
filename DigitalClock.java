//�ð� ǥ��,�ð��� ������ �ٲ�
package clock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer; 

public class DigitalClock extends JPanel { 
  private JTextField timeField;
  private Timer t;
  private JButton button;
  private Color color;
  
  public DigitalClock() { //������ ������
	//�ð�
    timeField = new JTextField(7); 
    timeField.setEditable(false); 
    timeField.setFont(new Font("sansserif", Font.PLAIN, 45)); 
    add(timeField); 
    t = new Timer(1000, new ClockListener()); 
    t.start(); 
    
    //��ư
    button = new JButton("����");
	button.addActionListener(new ClockListener());
	button.setPreferredSize(new Dimension(70,70));
	add(button);
	
	//����
	color = new Color(0,0,0);
  } 
  public void paintComponent(Graphics g) { //���󺯰�� �׷��� JPanel�� ����ؾ� �� 
      	super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, 390, 200);
        repaint(); //fillRect�� ���� ���������� �ٲ��.
  }

  private class ClockListener implements ActionListener { //����Ŭ���� 1
   boolean colon = false; 
   public void actionPerformed(ActionEvent e) { 
	 Calendar cal =Calendar.getInstance();
     int hour = cal.get(Calendar.HOUR); //hour�� �ð��� ������
     int min = cal.get(Calendar.MINUTE); //min�� ���� ������
     int sec = cal.get(Calendar.SECOND); //sec�� �ʸ� ������
     int amPm = cal.get(Calendar.AM_PM); //AM�� PM�� ������
     timeField.setText((amPm == 0 ? "AM " : "PM ") + (hour < 10 ? "0" + hour : hour) + (colon ? ":" : " ") 
     + (min < 10 ? "0" + min : min) + (colon ? ":" : " ") + (sec < 10 ? "0" + sec : sec)); 
     colon = !colon; // �ݷ��� �����̵��� ����
     
     if(e.getSource() == button) { //��ư�� ������ �������� �ð� �ؽ�Ʈ�� ������ �ʱ�ȭ
    	 color = new Color((int)(Math.random()*255.0),(int) (Math.random()*255.0),(int) (Math.random()*255.0));
    	 timeField.setForeground(color); 
    	 
     }
     
  } 
} 
 

}
