package UI;

import java.awt.Container;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

class Bar extends JPanel {
	
	public Bar () {
		setLayout(new GridLayout(2,1,5,5));
		add(new Menubar());
		add(new Toolbar());
		Color color = new Color(39,63,111);
		setBackground(color);
		setOpaque(true);
		setVisible(true);
	}
}

class Menubar extends JMenuBar {
	
	static final long serialVersionUID = 1L;
	public Menubar () {//Menu Bar
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new JMenu("새로 만들기"));
		add(new JMenu("열기"));
		add(new JMenu("저장"));
		add(new JMenu("다른 이름으로 저장"));
		add(new JMenu("닫기"));
		add(new JMenu("적용"));
		add(new JMenu("변경"));
		Color color = new Color(143,170,223);
		this.setMaximumSize(new Dimension(1000,10));
		setBackground(color);
		setOpaque(true);
		setVisible(true);
	}
}

class Toolbar extends JToolBar {
	static final long serialVersionUID= 1L;
		public Toolbar() {//Tool bar 생성자
		setLayout(new FlowLayout(FlowLayout.LEFT));	
		add(new JButton("새로 만들기"));
		add(new JButton("열기"));
		add(new JButton("저장"));
		add(new JButton("다른 이름으로 저장"));
		add(new JButton("닫기"));
		add(new JButton("적용"));
		add(new JButton("변경"));
		Color color = new Color(143,170,223);
		this.setMaximumSize(new Dimension(1000,10));
		setBackground(color);
		setVisible(true);
		}
	}

class SouthPanel extends JPanel {
	
	static final long serialVersionUID = 1L;
	public SouthPanel () {//ContentPane
		setLayout(new BorderLayout()); // BorderLayout으로 초기화
		add(BorderLayout.EAST, new AttributePane());
		add(BorderLayout.CENTER, new MindMapPane());
		add(BorderLayout.WEST, new TextEditorPane());
	}
}

/*TextEditorPane 클래스 정의*/
class TextEditorPane extends JPanel {
	static final long serialVersionUID = 1L;

	public TextEditorPane () {
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, new title("Text Editor Pane"));
		add(BorderLayout.CENTER, new TextEditor());
		add(BorderLayout.SOUTH, new button("적용"));
		this.setBackground(Color.BLUE);
		this.setOpaque(true);
	}
}

class TextEditor extends JTextArea {
	static final long serialVersionUID = 1L;
	
	public TextEditor () {
		setVisible(true);
	}
}

/*MindMapPane 클래스 정의*/
class MindMapPane extends JPanel {

	private static final long serialVersionUID = 1L;

	public MindMapPane() {
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, new title("Mind Map Pane"));
		add(BorderLayout.CENTER, new MindMapView());
		setBackground(Color.CYAN);
		setOpaque(true);
	}
}

/*AttributePane 클래스 정의*/
class AttributePane extends JPanel {

	private static final long serialVersionUID = 1L;

	public AttributePane () {
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, new title("AttributePane"));
		add(BorderLayout.CENTER, new BlockOptionPane());
		add(BorderLayout.SOUTH, new button("변경"));
		setBackground(Color.WHITE);
		setOpaque(true);
	}
}

class BlockOptionPane extends JPanel {	

	private static final long serialVersionUID = 1L;

	public BlockOptionPane () {//BlockOptionPane 생성자
		GridLayout grid = new GridLayout(6,2,5,5);
		grid.setVgap(60);
		setLayout(grid);
		add(new JLabel("TEXT:	"));
		add(new JTextField(20));
		add(new JLabel("X:		"));
		add(new JTextField(20));
		add(new JLabel("Y:		"));
		add(new JTextField(20));
		add(new JLabel("W:		"));
		add(new JTextField(20));
		add(new JLabel("H:		"));
		add(new JTextField(20));
		add(new JLabel("Color:	"));
		add(new JTextField(10));
		setVisible(true);
	}
}

class MindMapView extends JPanel {

	private static final long serialVersionUID = 1L;

	public MindMapView() {
		JPanel panel = new JPanel();
		//panel.setLayout(null);
	}
}

class title extends JPanel {	

	private static final long serialVersionUID = 1L;

	public title (String s) {
		add(new JLabel (s));	
	}
}

class button extends JPanel {	

	private static final long serialVersionUID = 1L;

	public button (String s) {//button 생성자
		setLayout(new FlowLayout());
		JButton B = new JButton(s);
		B.setBackground(Color.RED);
		B.setOpaque(true);
		add(B);
	}
}

public class UI_test extends JFrame {

	private static final long serialVersionUID = 1L;

	public UI_test () {//UI_test 생성자
		JFrame window = new JFrame("MindMap_UI_Test");
		setTitle(window.getTitle());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
		c.add(new Bar());
		c.add(new SouthPanel());
		this.setPreferredSize(new Dimension(1000,1000));
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new UI_test();
	}
}
