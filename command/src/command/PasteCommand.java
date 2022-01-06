package command;

import javax.swing.JEditorPane;

public class PasteCommand extends Command {

	public PasteCommand(JEditorPane editorPane)
	{
		super(editorPane);
	}
	
	@Override
	public boolean execute() {
		this.backup();
		this.editorPaneRef.paste();
		return true;
	}

}
