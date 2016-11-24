import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class GUIworld extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnPressToSee, btnPressToSee_1;
	JTextPane txtpnPlacki, textPane;

	/**
	 * function which create whole GUI interface 
	 * in this function our Size and colours are determined 
	 * of buttons,text area , and generally whole GUI
	 * 
	 */
	public GUIworld() {
		setBackground(UIManager.getColor("Button.foreground"));
		setSize(1438, 1202);
		setTitle("MY GUIworld");
		getContentPane().setLayout(null);

		btnPressToSee = new JButton("Press to see all bonks and zaps");
		btnPressToSee.setBackground(UIManager.getColor("Button.foreground"));
		btnPressToSee.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnPressToSee.setBounds(0, 0, 729, 60);
		getContentPane().add(btnPressToSee);
		btnPressToSee.addActionListener(this);
		
				txtpnPlacki = new JTextPane();
				txtpnPlacki.setFont(new Font("Tahoma", Font.PLAIN, 13));
				txtpnPlacki.setBackground(SystemColor.info);
				txtpnPlacki.setBounds(0, 62, 729, 975);
				getContentPane().add(txtpnPlacki);

		btnPressToSee_1 = new JButton("Press to see the last calculation");
		btnPressToSee_1.setBackground(UIManager.getColor("CheckBox.foreground"));
		btnPressToSee_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnPressToSee_1.setBounds(727, 0, 681, 60);
		getContentPane().add(btnPressToSee_1);
		btnPressToSee_1.addActionListener(this);

		textPane = new JTextPane();
		textPane.setBackground(SystemColor.info);
		textPane.setFont(new Font("Tahoma", Font.ITALIC, 40));
		textPane.setBounds(727, 62, 681, 975);
		getContentPane().add(textPane);

	}

	/* 
	 * what happened when we press our button in this situation 
	 * print our Zaps and bonks , and also end calcuation
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		if (source == btnPressToSee) {
			txtpnPlacki.setText(GameDriver.ZapsGrids);
		} else if (source == btnPressToSee_1) {
			textPane.setText(GameDriver.Calculation);
		}

	}
}