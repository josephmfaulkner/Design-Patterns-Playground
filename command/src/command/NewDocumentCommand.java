package command;

import javax.swing.JEditorPane;

public class NewDocumentCommand extends Command {

	public NewDocumentCommand(JEditorPane editorPane)
	{
		super(editorPane);
	}
	
	@Override
	public boolean execute() {
		this.backup();
		this.editorPaneRef.setText("");
		return true;
	}

}
