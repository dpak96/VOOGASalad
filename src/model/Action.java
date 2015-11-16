package model;
import java.util.*;

public abstract class Action {

	protected List<ArticleControllable> myArticles;
	
	public abstract void execute();
}
