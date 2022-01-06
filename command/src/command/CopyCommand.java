package command;

import javax.swing.JEditorPane;

public class CopyCommand extends Command {

	public CopyCommand(JEditorPane editorPane)
	{
		super(editorPane);
	}
	
	@Override
	public boolean execute() {
		this.backup();
		this.editorPaneRef.copy();
		return true;
	}

}
