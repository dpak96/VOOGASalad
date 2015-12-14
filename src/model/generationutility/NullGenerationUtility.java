package model.generationutility;
import java.util.*;

public class NullGenerationUtility extends AbstractGenerationUtility{

	public Collection<IPositionCopyable> generate(){
		return new ArrayList<IPositionCopyable>();
	}
	
}
