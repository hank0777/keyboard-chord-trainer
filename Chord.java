import java.util.ArrayList;
import java.util.Arrays;

public class Chord
{
	private String key; //maj, min, dim, aug, dom, half-dim
	private String root;
	private int type; //triad=3; seventh = 7 (all of this assumes only two types--triad and seventh chords)
	
	public Chord(String root, String key, int type)
	{
		this.root = root;
		this.key = key;
		this.type = type;
	}
	
	public Chord()
	{
		root = randomRoot();
		key = randomKey();
		type = randomType();
	}
	
	public String randomRoot()
	{
		ArrayList<String> rootNotes = new ArrayList<String>(Arrays.asList("C", "C#", "Db", "D", "D#", "Eb", "E", "F", "F#", "Gb", "G", "G#", "Ab", "A", "A#", "Bb", "B"));
		int pos = (int)(Math.random()*17);
		return rootNotes.get(pos);
		
	}
	
	private String randomKey()
	{
		ArrayList<String> keys = new ArrayList<String>(Arrays.asList("maj", "min", "dim", "aug", "dom", "half-dim"));
		int pos = (int)(Math.random()*6);
		return keys.get(pos);
	}
	
	private int randomType()
	{
		ArrayList<Integer> types = new ArrayList<Integer>(Arrays.asList(3, 7));
		int pos = (int)(Math.random()*2);
		return types.get(pos);
	}

	
	public String getKey()
	{
		return key;
	}
	
	public String getRoot()
	{
		return root;
	}
	
	public int getType()
	{
		return type;
	}
	
	public String nameToNote()
	{
		String notes = "";
		if(this.key.equalsIgnoreCase("dom"))
		{
			notes = Chord.domSeventh(this.root);
		}
		else if(this.key.equalsIgnoreCase("half-dim"))
		{
			notes = Chord.halfDimSeventh(this.root);
		}
		else if(this.getKey().equalsIgnoreCase("aug") && this.type==3)
		{
			notes = Chord.augTriad(this.root);
		}
		else if(this.getKey().equalsIgnoreCase("aug") && this.type==7)
		{
			notes = Chord.augSeventh(this.root);
		}
		else if(this.key.equalsIgnoreCase("dim") && this.type==7)
		{
			notes = Chord.dimSeventh(this.root);
		}
		else if(this.key.equalsIgnoreCase("dim") && this.type==3)
		{
			notes = Chord.dimTriad(this.root);
		}
		else if(this.key.equalsIgnoreCase("min") && this.type==7)
		{
			notes = Chord.minSeventh(this.root);
		}
		else if(this.key.equalsIgnoreCase("min") && this.type==3)
		{
			notes = Chord.minTriad(this.root);
		}
		else if(this.key.equalsIgnoreCase("maj") && this.type==7)
		{
			notes = Chord.majSeventh(this.root);
		}
		else if(this.key.equalsIgnoreCase("maj") && this.type==3)
		{
			notes = Chord.majTriad(this.root);
		}
		return notes;
	}
	
	public String toString() //precondition: type can only be 3 or 7
	{
		String chord = "";
		if(type==3)
			chord = root + " " + key.toLowerCase();
		else if(type==7)	
		{
			if(key.equalsIgnoreCase("half-dim"))
				chord = root + " " + key.toLowerCase();
			else
				chord = root + " " + key.toLowerCase() + type;
		}
		return chord;
	}
	
	
	
	//building chords
	public static String majTriad(String rootNote)
	{
		return majThird(rootNote) + perfectFifth(rootNote).substring(perfectFifth(rootNote).indexOf(" "));
	}
	
	public static String minTriad(String rootNote)
	{
		return minThird(rootNote) + perfectFifth(rootNote).substring(perfectFifth(rootNote).indexOf(" "));
	}
	
	public static String dimTriad(String rootNote)
	{
		return minThird(rootNote) + dimFifth(rootNote).substring(dimFifth(rootNote).indexOf(" "));
	}
	
	public static String augTriad(String rootNote)
	{
		return majThird(rootNote) + augFifth(rootNote).substring(augFifth(rootNote).indexOf(" "));
	}
	
	public static String augSeventh(String rootNote)
	{
		return augTriad(rootNote) + majSev(rootNote).substring(majSev(rootNote).indexOf(" "));
	}
	
	public static String domSeventh(String rootNote)
	{
		return majTriad(rootNote) + minSev(rootNote).substring(minSev(rootNote).indexOf(" "));
	}
	
	public static String majSeventh(String rootNote)
	{
		return majTriad(rootNote) + majSev(rootNote).substring(majSev(rootNote).indexOf(" "));
	}
	
	public static String minSeventh(String rootNote)
	{
		return minTriad(rootNote) + minSev(rootNote).substring(minSev(rootNote).indexOf(" "));
	}
	
	public static String halfDimSeventh(String rootNote)
	{
		return dimTriad(rootNote) + minSev(rootNote).substring(minSev(rootNote).indexOf(" "));
	}
	
	public static String dimSeventh(String rootNote)
	{
		return dimTriad(rootNote) + dimSev(rootNote).substring(dimSev(rootNote).indexOf(" "));
	}
	
	//helper methods to create intervals
	private static String majThird(String rootNote)
	{
		int r = KeyboardDraw.getKeyValue(rootNote);
		String s = "";
		if(r<=7)
			s = KeyboardDraw.getKeyName(r+4, rootNote);
		else
			s = KeyboardDraw.getKeyName(r-12+4, rootNote);
		return rootNote + " " + s;
	}
	
	private static String minThird(String rootNote)
	{
		int r = KeyboardDraw.getKeyValue(rootNote);
		String s = "";
		if(r<=8)
			s = KeyboardDraw.getKeyName(r+3, rootNote);
		else
			s = KeyboardDraw.getKeyName(r-12+3, rootNote);
		return rootNote + " " + s;
	}
	
	private static String perfectFifth(String rootNote)
	{
		int r = KeyboardDraw.getKeyValue(rootNote);
		String s = "";
		if(r<=4)
			s = KeyboardDraw.getKeyName(r+7, rootNote);
		else
			s = KeyboardDraw.getKeyName(r-12+7, rootNote);
		return rootNote + " " + s;
	}
	
	private static String augFifth(String rootNote)
	{
		int r = KeyboardDraw.getKeyValue(rootNote);
		String s = "";
		if(r<=3)
			s = KeyboardDraw.getKeyName(r+8, rootNote);
		else
			s = KeyboardDraw.getKeyName(r-12+8, rootNote);
		return rootNote + " " + s;
	}
	
	private static String dimFifth(String rootNote)
	{
		int r = KeyboardDraw.getKeyValue(rootNote);
		String s = "";
		if(r<=5)
			s = KeyboardDraw.getKeyName(r+6, rootNote);
		else
			s = KeyboardDraw.getKeyName(r-12+6, rootNote);
		return rootNote + " " + s;
	}
	
	private static String majSev(String rootNote)
	{
		int r = KeyboardDraw.getKeyValue(rootNote);
		String s = "";
		if(r<=0)
			s = KeyboardDraw.getKeyName(r+11, rootNote);
		else
			s = KeyboardDraw.getKeyName(r-12+11, rootNote);
		return rootNote + " " + s;
	}
	
	private static String minSev(String rootNote)
	{
		int r = KeyboardDraw.getKeyValue(rootNote);
		String s = "";
		if(r<=1)
			s = KeyboardDraw.getKeyName(r+10, rootNote);
		else
			s = KeyboardDraw.getKeyName(r-12+10, rootNote);
		return rootNote + " " + s;
	}
	
	private static String dimSev(String rootNote)
	{
		int r = KeyboardDraw.getKeyValue(rootNote);
		String s = "";
		if(r<=2)
			s = KeyboardDraw.getKeyName(r+9, rootNote);
		else
			s = KeyboardDraw.getKeyName(r-12+9, rootNote);
		return rootNote + " " + s;
	}
}
