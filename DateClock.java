//날짜와 요일 표시
package clock;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DateClock extends JPanel {
	Calendar cal =Calendar.getInstance();
	String year = cal.get(Calendar.YEAR)+"년 ";
	String month = cal.get(Calendar.MONTH)+1+"월 ";
	String date = cal.get(Calendar.DATE)+"일";
	int dow = cal.get(Calendar.DAY_OF_WEEK);
	JLabel dateLabel;
	
	
	public DateClock(){ //묵시적 생성자
		
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Monospaced",Font.BOLD,30)); //폰트설정
		dateLabel.setText(year+month+date);
		dateLabel.addMouseListener(new mouse());
		add(dateLabel);
		setVisible(true);
		}
	class mouse extends MouseAdapter{
		@Override
		public void mouseExited(MouseEvent e) {
			dateLabel.setForeground(Color.BLACK);
			super.mouseExited(e);
			dateLabel.setText(year+month+date);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			String DOW="";
			switch (dow) {
				case 1 : DOW="일요일";break;
				case 2 : DOW="월요일";break;
				case 3 : DOW="화요일";break;
				case 4 : DOW="수요일";break;
				case 5 : DOW="목요일";break;
				case 6 : DOW="금요일";break;
				case 7 : DOW="토요일";break;
			}
			dateLabel.setForeground(Color.PINK);
			dateLabel.setText("오늘은 "+DOW+"입니다");
		}
		
	}
	
}