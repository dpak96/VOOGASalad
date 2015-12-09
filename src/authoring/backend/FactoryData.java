package authoring.backend;

import java.util.List;

import model.article.Article;
import model.processes.Condition;
import model.processes.Executable;


public class FactoryData {
  private String myCondition;

  private String myExecutableName;
  private Article myExecutableArticle;
  private double myExecutableDouble;
  private Object[] myExecutableArray = {myExecutableName, myExecutableArticle, myExecutableDouble};

  private String myEventName;
  private List<Condition> myEventCondition;
  private List<Executable> myEventExecutable;
  private Object[] myEventArray = {myEventName, myEventCondition, myEventExecutable};
  


  public String getCondition() {
    return myCondition;
  }

  public void setCondition(String condition) {
    this.myCondition = condition;
  }

  public String getExecutableName() {
    return myExecutableName;
  }

  public void setExecutableName(String executableName) {
    this.myExecutableName = executableName;
  }

  public double getExecutableDouble() {
    return myExecutableDouble;
  }

  public void setExecutableDouble(double executableDouble) {
    this.myExecutableDouble = executableDouble;
  }

  public Article getExecutableArticle() {
    return myExecutableArticle;
  }

  public void setExecutableArticle(Article executableArticle) {
    this.myExecutableArticle = executableArticle;
  }

  public String getEventName() {
    return myEventName;
  }

  public void setEventName(String eventName) {
    this.myEventName = eventName;
  }

  public List<Condition> getEventCondition() {
    return myEventCondition;
  }

  public void setEventCondition(List<Condition> eventCondition) {
    this.myEventCondition = eventCondition;
  }

  public List<Executable> getEventExecutable() {
    return myEventExecutable;
  }

  public void setEventExecutable(List<Executable> eventExecutable) {
    this.myEventExecutable = eventExecutable;
  }

  public Object[] getExecutableArray() {
    return myExecutableArray;
  }

  public void setExecutableArray(Object[] executableArray) {
    this.myExecutableArray = executableArray;
  }

  public Object[] getEventArray() {
    return myEventArray;
  }

  public void setEventArray(Object[] eventArray) {
    this.myEventArray = eventArray;
  }

}
