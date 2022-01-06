import java.util.Stack;

import command.Command;

public class CommandStack {

	private Stack<Command> undoCommandStack;
	private Stack<Command> redoCommandStack;
	
	public CommandStack()
	{
		this.undoCommandStack = new Stack<Command>();
		this.redoCommandStack = new Stack<Command>();
	}
	
	public void runCommand(Command command)
	{
		if(command.execute()){
			this.undoCommandStack.push(command);
			this.redoCommandStack.clear();
		}
	}
	
	public void undo()
	{
		if(!this.undoCommandStack.isEmpty())
		{
			Command command = this.undoCommandStack.pop();
			command.undo();
			this.redoCommandStack.push(command);
		}
	}
	
	public void redo()
	{
		if(!this.redoCommandStack.isEmpty())
		{
			Command command = this.redoCommandStack.pop();
			command.undo();
			this.undoCommandStack.push(command);
		}
	}
	
}
