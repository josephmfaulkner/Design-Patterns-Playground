package command;

import javax.swing.JEditorPane;

public abstract class Command {
	
	protected String backupText;
	protected JEditorPane editorPaneRef;

	public Command(JEditorPane editorPane)
	{
		this.backupText = null;
		this.editorPaneRef = editorPane;
	}

	public abstract boolean execute();
	
	protected void backup()
	{
		this.backupText = this.editorPaneRef.getText();
	}
	
	public boolean undo(){
		this.editorPaneRef.setText(this.backupText);
		return true;
	}

}
