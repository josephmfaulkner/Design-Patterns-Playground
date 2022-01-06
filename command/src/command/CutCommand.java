package command;

import javax.swing.JEditorPane;

public class CutCommand extends Command {

	public CutCommand(JEditorPane editorPane)
	{
		super(editorPane);
	}
	
	@Override
	public boolean execute() {
		this.backup();
		this.editorPaneRef.cut();
		return true;
	}

}
