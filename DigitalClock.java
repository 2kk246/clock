//시각 표시,시각의 색상을 바꿈
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
  
  public DigitalClock() { //묵시적 생성자
	//시간
    timeField = new JTextField(7); 
    timeField.setEditable(false); 
    timeField.setFont(new Font("sansserif", Font.PLAIN, 45)); 
    add(timeField); 
    t = new Timer(1000, new ClockListener()); 
    t.start(); 
    
    //버튼
    button = new JButton("색상");
	button.addActionListener(new ClockListener());
	button.setPreferredSize(new Dimension(70,70));
	add(button);
	
	//색상
	color = new Color(0,0,0);
  } 
  public void paintComponent(Graphics g) { //색상변경시 그래픽 JPanel을 상속해야 함 
      	super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, 390, 200);
        repaint(); //fillRect의 색상도 누를때마다 바뀐다.
  }

  private class ClockListener implements ActionListener { //내부클래스 1
   boolean colon = false; 
   public void actionPerformed(ActionEvent e) { 
	 Calendar cal =Calendar.getInstance();
     int hour = cal.get(Calendar.HOUR); //hour에 시간을 가져옴
     int min = cal.get(Calendar.MINUTE); //min에 분을 가져옴
     int sec = cal.get(Calendar.SECOND); //sec에 초를 가져옴
     int amPm = cal.get(Calendar.AM_PM); //AM과 PM을 가져옴
     timeField.setText((amPm == 0 ? "AM " : "PM ") + (hour < 10 ? "0" + hour : hour) + (colon ? ":" : " ") 
     + (min < 10 ? "0" + min : min) + (colon ? ":" : " ") + (sec < 10 ? "0" + sec : sec)); 
     colon = !colon; // 콜론을 깜빡이도록 해줌
     
     if(e.getSource() == button) { //버튼을 누르면 랜덤으로 시각 텍스트의 색상을 초기화
    	 color = new Color((int)(Math.random()*255.0),(int) (Math.random()*255.0),(int) (Math.random()*255.0));
    	 timeField.setForeground(color); 
    	 
     }
     
  } 
} 
 

}
