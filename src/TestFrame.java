import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestFrame extends JFrame implements ActionListener
{
	private JLabel givenChord, leftLabel;
	private JButton submit, tryAgain, giveUp;
	private static Chord randomChord;
	private PopUp popUp;
	private Color mintGreen = new Color(152, 255, 152);
	private Color paleYellow = new Color(255, 255, 191);
	private Color lightRed = new Color(255, 204, 203);
	private static String selectedChord = "";
	
	public TestFrame()
	{
		super("Answer");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		
		leftLabel = new JLabel("Select the keys to make", JLabel.CENTER);
		panel.add(leftLabel);
		leftLabel.setOpaque(true);
		leftLabel.setBackground(Color.WHITE);
		leftLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 32));
		
		givenChord = new JLabel("", JLabel.CENTER);
		panel.add(givenChord);
		randomChord = new Chord();
		givenChord.setText(randomChord.toString());
		givenChord.setFont(new Font(Font.SERIF, Font.PLAIN, 32));
		givenChord.setOpaque(true);
		givenChord.setBackground(Color.WHITE);
		
		
		JPanel forButtons = new JPanel();
		forButtons.setLayout(new GridLayout());
		
		submit = new JButton("Submit");
		forButtons.add(submit);
		submit.setBackground(mintGreen);
		tryAgain = new JButton("Try again");
		forButtons.add(tryAgain);
		tryAgain.setBackground(paleYellow);
		giveUp = new JButton("Give up");
		forButtons.add(giveUp);
		giveUp.setBackground(lightRed);
				
		submit.addActionListener(this);
		tryAgain.addActionListener(this);
		giveUp.addActionListener(this);
		
		ButtonGroup gr = new ButtonGroup();
		gr.add(submit);
		gr.add(tryAgain);
		gr.add(giveUp);
		
		Box box = Box.createVerticalBox();
		box.add(panel);
		box.add(forButtons);
		
		Container cont = getContentPane();
		cont.add(box, BorderLayout.CENTER);
		
	}
	
	public void setGivenChord()
	{
		randomChord = new Chord();
		givenChord.setText(randomChord.toString());
		givenChord.setFont(new Font(Font.SERIF, Font.PLAIN, 32));
	}
	
	public static Chord getGivenChord()
	{
		return randomChord;
	}
	
	public void appendSelectedChord(String s)
	{
		selectedChord+=" " + s;
	}
	
	public void resetSelectedChord()
	{
		selectedChord = "";
	}
	
	public static String getSelectedChord()
	{
		return selectedChord;
	}
		
	public void actionPerformed(ActionEvent x)
	{
		popUp = new PopUp();
		if(x.getSource().equals(tryAgain))
		{
			KeyboardDraw.resetKeyboard();
			resetSelectedChord();
		}
		if(x.getSource().equals(giveUp))
		{
			popUp.setBounds(400, 520, 700, 200);
			popUp.setDefaultCloseOperation(EXIT_ON_CLOSE);
			popUp.setResizable(false);
			popUp.setVisible(true);
			popUp.setCorrectChord("Correct chord: ");
			popUp.setGivenUpChord(randomChord.nameToNote());
			
			KeyboardDraw.resetKeyboard();
			KeyboardDraw.highlightCorrectChord(lightRed);
			setGivenChord();
			resetSelectedChord();
		}
		if(x.getSource().equals(submit))
		{
//			System.out.println("selectedChord: " + selectedChord);
//			System.out.println("randomChord nameToNote(): " + randomChord.nameToNote());
//			System.out.println("randomChord: " + randomChord);
//			System.out.println("givenChord: " + givenChord.getText());
			
			popUp.setBounds(400, 520, 700, 200);
			popUp.setDefaultCloseOperation(EXIT_ON_CLOSE);
			popUp.setResizable(false);
			
			if(selectedChord.trim().equals(randomChord.nameToNote().trim()))
			{
				popUp.setCorrectChord("Correct!");
				popUp.setGivenUpChord(randomChord.nameToNote());
				popUp.setVisible(true);
				
				//setGivenChord();
				KeyboardDraw.resetKeyboard();
				KeyboardDraw.highlightCorrectChord(mintGreen);
				setGivenChord();
				resetSelectedChord();
			}
			else
			{
				popUp.setCorrectChord("Incorrect :(");
				popUp.setGivenUpChord("Try Again!");
				popUp.tryAgainButton();
				popUp.setVisible(true);
				
				KeyboardDraw.resetKeyboard();
				KeyboardDraw.highlightSelectedChord(lightRed);
				resetSelectedChord();
			}
		}
	}
}
