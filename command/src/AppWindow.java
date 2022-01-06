import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

import command.Command;
import command.CopyCommand;
import command.CutCommand;
import command.LoadSampleCommand;
import command.NewDocumentCommand;
import command.PasteCommand;

public class AppWindow {

	private JFrame frame;
	private CommandStack commandStack;
	/**
	 * Create the application.
	 */
	public AppWindow() {
		initialize();
		this.frame.setVisible(true);
		this.commandStack = new CommandStack();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));		
		
		JEditorPane editorPane = new JEditorPane();
		frame.getContentPane().add(editorPane, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.SOUTH);
		
		JButton btnUndo = new JButton("Undo");
		toolBar.add(btnUndo);
		
		btnUndo.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	commandStack.undo();
		    }
		});
		
		JButton btnRedo = new JButton("Redo");
		toolBar.add(btnRedo);
		btnRedo.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	commandStack.redo();
		    }
		});
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnTestMenu = new JMenu("File");
		menuBar.add(mnTestMenu);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnTestMenu.add(mntmNew);
		bindButtonToCommand(mntmNew, () -> new NewDocumentCommand(editorPane));

		JMenuItem mntmLoad = new JMenuItem("Load");
		mnTestMenu.add(mntmLoad);
		bindButtonToCommand(mntmLoad, () -> new LoadSampleCommand(editorPane));
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);
		bindButtonToCommand(mntmCut, () -> new CutCommand(editorPane));
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		bindButtonToCommand(mntmCopy, () -> new CopyCommand(editorPane));
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		bindButtonToCommand(mntmPaste, () -> new PasteCommand(editorPane));
		
	}
	
	private interface NewCommandFunction
	{
		public Command call();
	}
	
	private void bindButtonToCommand(AbstractButton button , NewCommandFunction makeNewCommand)
	{
		button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        Command command = makeNewCommand.call();
		    	commandStack.runCommand(command);
		    }
		});
	}
	
}
