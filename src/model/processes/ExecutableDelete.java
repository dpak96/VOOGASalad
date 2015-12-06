package model.processes;

import java.util.Map;

import model.Model;

public class ExecutableDelete extends Executable{
	
	protected Model myModel;

	public ExecutableDelete(Map<String, Object> parameters) {
		super(parameters);
	}
	
	public void setModel(Model m){
		myModel = m;
	}

	@Override
	public void execute() {
		myModel.removeArticle(myActor);
	}

}
