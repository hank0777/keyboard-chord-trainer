import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PopUp extends JFrame implements ActionListener
{
	private JLabel givenUpChord, correctChord;
	private JButton cont;
	public PopUp()
	{
		super("Result");
		JPanel popUp = new JPanel();
		popUp.setLayout(new GridLayout());
		
		Color mintGreen = new Color(152, 255, 152);
		
		correctChord = new JLabel("", JLabel.CENTER);
		popUp.add(correctChord);
		correctChord.setFont(new Font(Font.SERIF, Font.PLAIN, 32));
		correctChord.setOpaque(true);
		correctChord.setBackground(Color.WHITE);

		givenUpChord = new JLabel("", JLabel.CENTER);
		popUp.add(givenUpChord);
		givenUpChord.setFont(new Font(Font.SERIF, Font.PLAIN, 32));
		givenUpChord.setOpaque(true);
		givenUpChord.setBackground(Color.WHITE);
		
		cont = new JButton("Continue");
		popUp.add(cont);
		cont.setBackground(mintGreen);
		cont.addActionListener(this);
		
		Box box = Box.createVerticalBox();
		box.add(popUp);
		
		Container c = getContentPane();
		c.add(box, BorderLayout.CENTER);
	}
	
	public void setGivenUpChord(String s)
	{
		givenUpChord.setText(s);
		givenUpChord.setFont(new Font(Font.SERIF, Font.PLAIN, 32));
	}
	
	public void setCorrectChord(String s)
	{
		correctChord.setText(s);
		correctChord.setFont(new Font(Font.SERIF, Font.PLAIN, 32));
	}
	
	public void tryAgainButton()
	{
		Color paleYellow = new Color(255, 255, 191);
		cont.setBackground(paleYellow);
		cont.setText("Try again");
	}
	
	public void actionPerformed(ActionEvent x) 
	{
		this.setVisible(false);
		KeyboardDraw.resetKeyboard();
	}
	
	
}
