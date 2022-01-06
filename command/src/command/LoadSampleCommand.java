package command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JEditorPane;

public class LoadSampleCommand extends Command {

	public LoadSampleCommand(JEditorPane editorPane) {
		super(editorPane);
	}

	@Override
	public boolean execute() {
		
		this.backup();
		
		String textString = "";
		
		try {
			StringBuilder stringBuilder = new StringBuilder();
			File file = new File("src/UnitedStatesConstitution.txt");
	        BufferedReader br = new BufferedReader(new FileReader(file));
	        String st;
			while ( (st = br.readLine()) != null)
			{
				stringBuilder.append(st).append("\n");
				System.out.println(st);
			}
			textString = stringBuilder.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.editorPaneRef.setText(textString);
		return true;
	}

}
