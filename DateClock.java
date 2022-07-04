//��¥�� ���� ǥ��
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
	String year = cal.get(Calendar.YEAR)+"�� ";
	String month = cal.get(Calendar.MONTH)+1+"�� ";
	String date = cal.get(Calendar.DATE)+"��";
	int dow = cal.get(Calendar.DAY_OF_WEEK);
	JLabel dateLabel;
	
	
	public DateClock(){ //������ ������
		
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Monospaced",Font.BOLD,30)); //��Ʈ����
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
				case 1 : DOW="�Ͽ���";break;
				case 2 : DOW="������";break;
				case 3 : DOW="ȭ����";break;
				case 4 : DOW="������";break;
				case 5 : DOW="�����";break;
				case 6 : DOW="�ݿ���";break;
				case 7 : DOW="�����";break;
			}
			dateLabel.setForeground(Color.PINK);
			dateLabel.setText("������ "+DOW+"�Դϴ�");
		}
		
	}
	
}