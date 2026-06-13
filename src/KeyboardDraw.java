import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class KeyboardDraw extends JFrame implements ActionListener
{
	private static JButton c, d, e, f, g, a, b, cd, de, fg, ga, ab;
	private TestFrame testFrame;
	private static Color mintGreen = new Color(152, 255, 152);
	private static Color lightRed = new Color(255, 204, 203);
	
	public KeyboardDraw()
	{
		super("Piano Keyboard");
		testFrame = new TestFrame();
		testFrame.setBounds(400, 520, 700, 200);
		testFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		testFrame.setResizable(false);
		testFrame.setVisible(true);
		
		//buttons for white keys
		c = new JButton("0");
		d = new JButton("2");
		e = new JButton("4");
		f = new JButton("5");
		g = new JButton("7");
		a = new JButton("9");
		b = new JButton("11");
		//buttons for black keys
		cd = new JButton("1");
		de = new JButton("3");
		fg = new JButton("6");
		ga = new JButton("8");
		ab = new JButton("10");
		resetKeyboard();
		
		//actionlisteners
		c.addActionListener(this);
		cd.addActionListener(this);
		d.addActionListener(this);
		de.addActionListener(this);
		e.addActionListener(this);
		f.addActionListener(this);
		fg.addActionListener(this);
		g.addActionListener(this);
		ga.addActionListener(this);
		a.addActionListener(this);
		ab.addActionListener(this);
		b.addActionListener(this);
		
		//white keys on the jpanel
		JPanel kboard = new JPanel();
		kboard.setBounds(0, 0, 700, 319);
		kboard.setLayout(new GridLayout(1, 7));
		kboard.add(c);
		kboard.add(d);
		kboard.add(e);
		kboard.add(f);
		kboard.add(g);
		kboard.add(a);
		kboard.add(b);
		//first black key on jpanel
		JPanel blackKey1 = new JPanel();
		blackKey1.setBounds(71, 0, 58, 186);
		blackKey1.setLayout(new GridLayout(1, 1));
		blackKey1.add(cd);
		//second black key on jpanel
		JPanel blackKey2 = new JPanel();
		blackKey2.setBounds(171, 0, 58, 186);
		blackKey2.setLayout(new GridLayout(1, 1));
		blackKey2.add(de);
		//third black key
		JPanel blackKey3 = new JPanel();
		blackKey3.setBounds(371, 0, 58, 186);
		blackKey3.setLayout(new GridLayout(1, 1));
		blackKey3.add(fg);
		//fourth black key
		JPanel blackKey4 = new JPanel();
		blackKey4.setBounds(471, 0, 58, 186);
		blackKey4.setLayout(new GridLayout(1, 1));
		blackKey4.add(ga);
		//fifth black key
		JPanel blackKey5 = new JPanel();
		blackKey5.setBounds(571, 0, 58, 186);
		blackKey5.setLayout(new GridLayout(1, 1));
		blackKey5.add(ab);		
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.add(kboard, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(blackKey1, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(blackKey2, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(blackKey3, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(blackKey4, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(blackKey5, JLayeredPane.PALETTE_LAYER);
        
		Box box = Box.createVerticalBox();
		box.add(layeredPane);
		
		Container cont = getContentPane();
		cont.add(box, BorderLayout.CENTER);
	}
	
	public static void resetKeyboard()
	{
		c.setBackground(Color.WHITE);
		c.setForeground(Color.WHITE);
		d.setBackground(Color.WHITE);
		d.setForeground(Color.WHITE);
		e.setBackground(Color.WHITE);
		e.setForeground(Color.WHITE);
		f.setBackground(Color.WHITE);
		f.setForeground(Color.WHITE);
		g.setBackground(Color.WHITE);
		g.setForeground(Color.WHITE);
		a.setBackground(Color.WHITE);
		a.setForeground(Color.WHITE);
		b.setBackground(Color.WHITE);
		b.setForeground(Color.WHITE);
		cd.setBackground(Color.BLACK);
		cd.setForeground(Color.BLACK);
		de.setBackground(Color.BLACK);
		de.setForeground(Color.BLACK);
		fg.setBackground(Color.BLACK);
		fg.setForeground(Color.BLACK);
		ga.setBackground(Color.BLACK);
		ga.setForeground(Color.BLACK);
		ab.setBackground(Color.BLACK);
		ab.setForeground(Color.BLACK);
	}
	
	public static void highlightCorrectChord(Color x)
	{
		String[] givenChordArr = TestFrame.getGivenChord().nameToNote().trim().split(" ");
		for(String note : givenChordArr)
		{
			if(KeyboardDraw.getKeyValue(note)==0)
			{
				c.setBackground(x);
				c.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==1)
			{
				cd.setBackground(x);
				cd.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==2)
			{
				d.setBackground(x);
				d.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==3)
			{
				de.setBackground(x);
				de.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==4)
			{
				e.setBackground(x);
				e.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==5)
			{
				f.setBackground(x);
				f.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==6)
			{
				fg.setBackground(x);
				fg.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==7)
			{
				g.setBackground(x);
				g.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==8)
			{
				ga.setBackground(x);
				ga.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==9)
			{
				a.setBackground(x);
				a.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==10)
			{
				ab.setBackground(x);
				ab.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==11)
			{
				b.setBackground(x);
				b.setForeground(x);
			}
		}
	}
	
	public static void highlightSelectedChord(Color x)
	{
		String[] selectedChordArray = TestFrame.getSelectedChord().split(" ");
		for(String note : selectedChordArray)
		{
			if(KeyboardDraw.getKeyValue(note)==0)
			{
				c.setBackground(x);
				c.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==1)
			{
				cd.setBackground(x);
				cd.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==2)
			{
				d.setBackground(x);
				d.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==3)
			{
				de.setBackground(x);
				de.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==4)
			{
				e.setBackground(x);
				e.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==5)
			{
				f.setBackground(x);
				f.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==6)
			{
				fg.setBackground(x);
				fg.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==7)
			{
				g.setBackground(x);
				g.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==8)
			{
				ga.setBackground(x);
				ga.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==9)
			{
				a.setBackground(x);
				a.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==10)
			{
				ab.setBackground(x);
				ab.setForeground(x);
			}
			if(KeyboardDraw.getKeyValue(note)==11)
			{
				b.setBackground(x);
				b.setForeground(x);
			}
		}
	}
	
	public static String getKeyName(int n, String rootNote)
	{
		String key = rootNote;
		switch(key)
		{
			case "C":
			{
				if(n==0)
					return "C";
				if(n==3)
					return "Eb";
				if(n==4)
					return "E";
				if(n==6)
					return "Gb";
				if(n==7)
					return "G";
				if(n==8)
					return "G#";
				if(n==9)
					return "Bbb";
				if(n==10)
					return "Bb";
				if(n==11)
					return "B";
			}
			case "C#":
			{
				if(n==0)
					return "B#";
				if(n==1)
					return "C#";
				if(n==4)
					return "E♮";
				if(n==5)
					return "E#";
				if(n==7)
					return "G♮";
				if(n==8)
					return "G#";
				if(n==9)
					return "Gx";
				if(n==10)
					return "Bb";
				if(n==11)
					return "B♮";
			}
			case "Db":
			{
				if(n==0)
					return "C";
				if(n==1)
					return "Db";
				if(n==4)
					return "Fb";
				if(n==5)
					return "F";
				if(n==7)
					return "Abb";
				if(n==8)
					return "Ab";
				if(n==9)
					return "A♮";
				if(n==10)
					return "Cbb";
				if(n==11)
					return "Cb";
			}
			case "D":
			{
				if(n==0)
					return "C♮";
				if(n==1)
					return "C#";
				if(n==2)
					return "D";
				if(n==5)
					return "F♮";
				if(n==6)
					return "F#";
				if(n==8)
					return "Ab";
				if(n==9)
					return "A";
				if(n==10)
					return "A#";
				if(n==11)
					return "Cb";
			}
			case "D#":
			{
				if(n==0)
					return "C♮";
				if(n==1)
					return "C#";
				if(n==2)
					return "Cx";
				if(n==3)
					return "D#";
				if(n==6)
					return "F#";
				if(n==7)
					return "Fx";
				if(n==9)
					return "A♮";
				if(n==10)
					return "A#";
				if(n==11)
					return "Ax";
			}
			case "Eb":
			{
				if(n==0)
					return "Dbb";
				if(n==1)
					return "Db";
				if(n==2)
					return "D";
				if(n==3)
					return "Eb";
				if(n==6)
					return "Gb";
				if(n==7)
					return "G";
				if(n==9)
					return "Bbb";
				if(n==10)
					return "Bb";
				if(n==11)
					return "B♮";
			}
			case "E":
			{
				if(n==0)
					return "B#";
				if(n==1)
					return "Db";
				if(n==2)
					return "D♮";
				if(n==3)
					return "D#";
				if(n==4)
					return "E";
				if(n==7)
					return "G♮";
				if(n==8)
					return "G#";
				if(n==10)
					return "Bb";
				if(n==11)
					return "B";
			}
			case "Fb":
			{
				if(n==0)
					return "B#";
				if(n==1)
					return "Ebbb";
				if(n==2)
					return "Ebb";
				if(n==3)
					return "Eb";
				if(n==4)
					return "Fb";
				if(n==7)
					return "Abb";
				if(n==8)
					return "Ab";
				if(n==10)
					return "Cbb";
				if(n==11)
					return "Cb";
			}
			case "E#":
			{
				if(n==0)
					return "B#";
				if(n==1)
					return "Bx";
				if(n==2)
					return "D♮";
				if(n==3)
					return "D#";
				if(n==4)
					return "Dx";
				if(n==5)
					return "E#";
				if(n==8)
					return "G#";
				if(n==9)
					return "Gx";
				if(n==11)
					return "B♮";
			}
			case "F":
			{
				if(n==0)
					return "C";
				if(n==1)
					return "C#";
				if(n==2)
					return "Ebb";
				if(n==3)
					return "Eb";
				if(n==4)
					return "E";
				if(n==5)
					return "F";
				if(n==8)
					return "Ab";
				if(n==9)
					return "A";
				if(n==11)
					return "Cb";
			}
			case "F#":
			{
				if(n==0)
					return "C♮";
				if(n==1)
					return "C#";
				if(n==2)
					return "Cx";
				if(n==3)
					return "Eb";
				if(n==4)
					return "E♮";
				if(n==5)
					return "E#";
				if(n==6)
					return "F#";
				if(n==9)
					return "A♮";
				if(n==10)
					return "A#";
			}
			case "Gb":
			{
				if(n==0)
					return "Dbb";
				if(n==1)
					return "Db";
				if(n==2)
					return "D♮";
				if(n==3)
					return "Fbb";
				if(n==4)
					return "Fb";
				if(n==5)
					return "F";
				if(n==6)
					return "Gb";
				if(n==9)
					return "Bbb";
				if(n==10)
					return "Bb";
			}
			case "G":
			{
				if(n==1)
					return "Db";
				if(n==2)
					return "D";
				if(n==3)
					return "Fbb";
				if(n==4)
					return "Fb";
				if(n==5)
					return "F♮";
				if(n==6)
					return "F#";
				if(n==7)
					return "G";
				if(n==10)
					return "Bb";
				if(n==11)
					return "B";
			}
			case "G#":
			{
				if(n==0)
					return "B#";
				if(n==2)
					return "D♮";
				if(n==3)
					return "D#";
				if(n==4)
					return "Dx";
				if(n==5)
					return "F♮";
				if(n==6)
					return "F#";
				if(n==7)
					return "Fx";
				if(n==8)
					return "G#";
				if(n==11)
					return "B♮";
			}
			case "Ab":
			{
				if(n==0)
					return "C";
				if(n==2)
					return "Ebb";
				if(n==3)
					return "Eb";
				if(n==4)
					return "E♮";
				if(n==5)
					return "Gbb";
				if(n==6)
					return "Gb";
				if(n==7)
					return "G";
				if(n==8)
					return "Ab";
				if(n==11)
					return "Cb";
			}
			case "A":
			{
				if(n==0)
					return "C♮";
				if(n==1)
					return "C#";
				if(n==3)
					return "Eb";
				if(n==4)
					return "E";
				if(n==5)
					return "E#";
				if(n==6)
					return "Gb";
				if(n==7)
					return "G♮";
				if(n==8)
					return "G#";
				if(n==9)
					return "A";
			}
			case "A#":
			{
				if(n==1)
					return "C#";
				if(n==2)
					return "Cx";
				if(n==4)
					return "E♮";
				if(n==5)
					return "E#";
				if(n==6)
					return "Ex";
				if(n==7)
					return "G♮";
				if(n==8)
					return "G#";
				if(n==9)
					return "Gx";
				if(n==10)
					return "A#";
			}
			case "Bb":
			{
				if(n==1)
					return "Db";
				if(n==2)
					return "D";
				if(n==4)
					return "Fb";
				if(n==5)
					return "F";
				if(n==6)
					return "F#";
				if(n==7)
					return "Abb";
				if(n==8)
					return "Ab";
				if(n==9)
					return "A";
				if(n==10)
					return "Bb";
			}
			case "B":
			{
				if(n==2)
					return "D♮";
				if(n==3)
					return "D#";
				if(n==5)
					return "F♮";
				if(n==6)
					return "F#";
				if(n==7)
					return "Fx";
				if(n==8)
					return "Ab";
				if(n==9)
					return "A♮";
				if(n==10)
					return "A#";
				if(n==11)
					return "B";
			}
			case "Cb":
			{
				if(n==2)
					return "Ebb";
				if(n==3)
					return "Eb";
				if(n==5)
					return "Gbb";
				if(n==6)
					return "Gb";
				if(n==7)
					return "G♮";
				if(n==8)
					return "Bbbb";
				if(n==9)
					return "Bbb";
				if(n==10)
					return "Bb";
				if(n==11)
					return "Cb";
			}
			case "B#":
			{
				if(n==0)
					return "B#";
				if(n==3)
					return "D#";
				if(n==4)
					return "Dx";
				if(n==6)
					return "F#";
				if(n==7)
					return "Fx";
				if(n==8)
					return "F#x";
				if(n==9)
					return "A♮";
				if(n==10)
					return "A#";
				if(n==11)
					return "Ax";
			}
		}
		return "";
	}
	
	public static int getKeyValue(String s)
	{
		if(s.equalsIgnoreCase("C") || s.equalsIgnoreCase("B#") || s.equalsIgnoreCase("C♮") || s.equalsIgnoreCase("Dbb"))
			return 0;
		if(s.equalsIgnoreCase("C#") || s.equalsIgnoreCase("Db") || s.equalsIgnoreCase("Ebbb") || s.equalsIgnoreCase("Bx"))
			return 1;
		if(s.equalsIgnoreCase("D") || s.equalsIgnoreCase("Cx") || s.equalsIgnoreCase("Ebb") || s.equalsIgnoreCase("D♮"))
			return 2;
		if(s.equalsIgnoreCase("D#") || s.equalsIgnoreCase("Eb") || s.equalsIgnoreCase("Fbb"))
			return 3;
		if(s.equalsIgnoreCase("E") || s.equalsIgnoreCase("Fb") || s.equalsIgnoreCase("Dx") || s.equalsIgnoreCase("E♮"))
			return 4;
		if(s.equalsIgnoreCase("F") || s.equalsIgnoreCase("E#") || s.equalsIgnoreCase("Gbb") || s.equalsIgnoreCase("F♮"))
			return 5;
		if(s.equalsIgnoreCase("F#") || s.equalsIgnoreCase("Gb") || s.equalsIgnoreCase("Ex"))
			return 6;
		if(s.equalsIgnoreCase("G") || s.equalsIgnoreCase("Abb") || s.equalsIgnoreCase("Fx") || s.equalsIgnoreCase("G♮"))
			return 7;
		if(s.equalsIgnoreCase("G#") || s.equalsIgnoreCase("Ab") || s.equalsIgnoreCase("Bbbb") || s.equalsIgnoreCase("F#x"))
			return 8;
		if(s.equalsIgnoreCase("A") || s.equalsIgnoreCase("Bbb") || s.equalsIgnoreCase("Gx") || s.equalsIgnoreCase("A♮"))
			return 9;
		if(s.equalsIgnoreCase("A#") || s.equalsIgnoreCase("Bb") || s.equalsIgnoreCase("Cbb"))
			return 10;
		if(s.equalsIgnoreCase("B") || s.equalsIgnoreCase("Cb") || s.equalsIgnoreCase("Ax") || s.equalsIgnoreCase("B♮"))
			return 11;
		return -1;
	}
	
	public void actionPerformed(ActionEvent x)
	{				
		if(x.getSource().equals(c))
		{
			c.setBackground(lightRed);
			c.setForeground(lightRed);
			String rN = TestFrame.getGivenChord().getRoot();
			testFrame.appendSelectedChord(getKeyName(0, rN));
		}
		if(x.getSource().equals(cd))
		{
			cd.setBackground(lightRed);
			cd.setForeground(lightRed);
			String rN = TestFrame.getGivenChord().getRoot();
			testFrame.appendSelectedChord(getKeyName(1, rN));
		}
		if(x.getSource().equals(d)) 
		{
			d.setBackground(lightRed);
			d.setForeground(lightRed);
			String rN = TestFrame.getGivenChord().getRoot();
			testFrame.appendSelectedChord(getKeyName(2, rN));
		}
		if(x.getSource().equals(de))
		{
			de.setBackground(lightRed);
			de.setForeground(lightRed);
			String rN = TestFrame.getGivenChord().getRoot();
			testFrame.appendSelectedChord(getKeyName(3, rN));
		}
		if(x.getSource().equals(e))
		{
			e.setBackground(lightRed);
			e.setForeground(lightRed);
			String rN = TestFrame.getGivenChord().getRoot();
			testFrame.appendSelectedChord(getKeyName(4, rN));
		}
		if(x.getSource().equals(f))
		{
			f.setBackground(lightRed);
			f.setForeground(lightRed);
			String rN = TestFrame.getGivenChord().getRoot();
			testFrame.appendSelectedChord(getKeyName(5, rN));
		}
		if(x.getSource().equals(fg))
		{
			fg.setBackground(lightRed);
			fg.setForeground(lightRed);
			String rN = TestFrame.getGivenChord().getRoot();
			testFrame.appendSelectedChord(getKeyName(6, rN));
		}
		if(x.getSource().equals(g))
		{
			g.setBackground(lightRed);
			g.setForeground(lightRed);
			String rN = TestFrame.getGivenChord().getRoot();
			testFrame.appendSelectedChord(getKeyName(7, rN));
		}
		if(x.getSource().equals(ga))
		{
			ga.setBackground(lightRed);
			ga.setForeground(lightRed);
			String rN = TestFrame.getGivenChord().getRoot();
			testFrame.appendSelectedChord(getKeyName(8, rN));
		}
		if(x.getSource().equals(a))
		{
			a.setBackground(lightRed);
			a.setForeground(lightRed);
			String rN = TestFrame.getGivenChord().getRoot();
			testFrame.appendSelectedChord(getKeyName(9, rN));
		}
		if(x.getSource().equals(ab))
		{
			ab.setBackground(lightRed);
			ab.setForeground(lightRed);
			String rN = TestFrame.getGivenChord().getRoot();
			testFrame.appendSelectedChord(getKeyName(10, rN));
		}
		if(x.getSource().equals(b))
		{
			b.setBackground(lightRed);
			b.setForeground(lightRed);
			String rN = TestFrame.getGivenChord().getRoot();
			testFrame.appendSelectedChord(getKeyName(11, rN));
		}
	}
	
	public static void main(String[] args)
	{
		KeyboardDraw window = new KeyboardDraw();
		window.setBounds(400, 200, 700, 319);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
	}
	
}
