package authoring.backend;

import java.util.List;
import model.Article;
import model.Condition;
import model.Executable;


public class FactoryData {
  private String condition;

  private String executableName;
  private Article executableArticle;
  private double executableDouble;

  private String eventName;
  private List<Condition> eventCondition;
  private List<Executable> eventExecutable;

  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public String getExecutableName() {
    return executableName;
  }

  public void setExecutableName(String executableName) {
    this.executableName = executableName;
  }

  public double getExecutableDouble() {
    return executableDouble;
  }

  public void setExecutableDouble(double executableDouble) {
    this.executableDouble = executableDouble;
  }

  public Article getExecutableArticle() {
    return executableArticle;
  }

  public void setExecutableArticle(Article executableArticle) {
    this.executableArticle = executableArticle;
  }

  public String getEventName() {
    return eventName;
  }

  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  public List<Condition> getEventCondition() {
    return eventCondition;
  }

  public void setEventCondition(List<Condition> eventCondition) {
    this.eventCondition = eventCondition;
  }

  public List<Executable> getEventExecutable() {
    return eventExecutable;
  }

  public void setEventExecutable(List<Executable> eventExecutable) {
    this.eventExecutable = eventExecutable;
  }

}
