package model.XMLutility;

import java.io.ObjectStreamException;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import model.Event;
import model.article.Article;
import model.conditions.Condition;
import model.executables.Executable;
 

@XStreamAlias("Model")
public class ModelAnnotations {
	
	
	
   @XStreamAlias("myEvents")
   private List<Event> myEvents;

   @XStreamAlias("myButtonMap")
   private Map<String, List<Event>> myButtonMap;
 
   @XStreamImplicit(itemFieldName = "myArticles")
   private List<Article> myArticles;
   
   @XStreamAlias("myExecutables")
   private List<Executable> myExecutables;
   
   @XStreamAlias("myConditions")
   private List<Condition> myConditions;
   
   @XStreamAlias("myViewPoint")
   private Article myViewpoint;
   
   @XStreamAlias("myCharacter")
   private Article myCharacter;
 
   @XStreamAlias("default-attribute")
   @XStreamAsAttribute
   private String defaultAttribute;
	
   public ModelAnnotations() {
       System.out.println("Trying to load");
   }
 
   @Override
   public String toString() {
       return "";
   }
 
   private/* or public or protected or none */Object readResolve()
           throws ObjectStreamException {
       if (defaultAttribute == null) {
           defaultAttribute = "DEFAULT ATTRIBUTE VALUE";
       }
       return this;
   }
}