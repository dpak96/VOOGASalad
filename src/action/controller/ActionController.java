package action.controller;

import gameengine.GameEngine;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class ActionController{
	public static final int SIZE = 400;
	public static final int FRAMES_PER_SECOND = 60;
	private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private GameEngine myGE;
	private double rate;
	Timeline animation;
	private boolean paused;
	
	public ActionController(GameEngine engine){
		myGE = engine;
		set_up_timeline();
		paused = false;
	}

	public void update(String arg1) {
		if(arg1.toUpperCase().equals("Q")){
			if(paused){
				this.resume();
				paused = !paused;
			}
			else{
				this.change_rate(0);
				paused = !paused;
			}
		}
		myGE.update(arg1);
	}

	private void set_up_timeline(){
		/*KeyFrame frame = new KeyFrame(1000.0),
				e -> step(Double.parseDouble(1.0);
		animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.setRate(Double.parseDouble(myResources.getString("StartSpeed")));
		animation.play();*/
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
				e -> step(SECOND_DELAY));
		animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
		rate = animation.getRate();
	}



	public void step(double delay){
		myGE.update("");
		/*if(check_status()) {
			if(ui.change_rate()!= rate){
				change_rate(ui.change_rate());
				rate = ui.change_rate();
			}

			ui.get_panel().update();
			ui.get_chart_panel().chart_handler(ui.get_panel().getSum1(), ui.get_panel().getSum2());

		}*/
	}
	
	public double getRate(){
		return animation.getRate();
	}
	public void change_rate(double dub){
		animation.pause();
		animation.setRate(dub);
		animation.playFromStart();
	}
	
	public void stepper(){
		animation.pause();
		animation.setCycleCount(5);
		animation.setRate(rate);
		animation.playFromStart();
	}
	
	public void resume(){
		animation.pause();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.setRate(rate);
		animation.playFromStart();
	}

}
