package authoring.controller

import authoring.ui.draganddrop.InfiniteDrop
import authoring.ui.editingmenus.ArticlePropertyEditorMenu
import imageeditor.ImageExtender
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.TransferMode
import javafx.scene.layout.Pane
import model.article.Article
import model.controller.ModelController
import resourcemanager.ResourceManager


class InfiniteController {

    private AuthoringController myAuthoringController;
    private ModelController myModelController;
    private Map<Article,Double> randomGenMap;
    private List<List<Article>> constantGen;
    private List<Article> tempList;
    private Article currentArticle;
    private List<Article> articleList;

    public InfiniteController(AuthoringController ac, ModelController mc){
        myAuthoringController = ac;
        myModelController = mc;
        randomGenMap = new HashMap<>();
        constantGen = new ArrayList<>();
        tempList = new ArrayList<>();
        articleList = new ArrayList<>();
    }

    public addToRandom(String prob){
        double d = Double.parseDouble(prob);
		for (Map.Entry<Article, Double> blah: randomGenMap.entrySet()) {
			if (blah.getValue() == 0.0) {
				randomGenMap.put(blah.getKey(), d);
			}
		}
        currentArticle = null;
    }

    public getRandomMap(){
		if (randomGenMap == null) {
			println("the map is null");
		}
        return randomGenMap;
    }

    public addIndConstant(Article n){
        tempList.add(n);
    }

    public addSetToConstant(){
		ArrayList<Article> superTemp = new ArrayList<>();
		for(Article a: tempList){
			superTemp.add(a);
			println(a)
		}
		constantGen.add(new ArrayList<>(superTemp));
        tempList = new ArrayList<>();
    }



    public addInfinite(){

    }

    public genInfinite(){

    }

    public genRandom(){
        myModelController.setRandomGenerator(randomGenMap);
        randomGenMap = new HashMap<>();
    }

    public genConstant(String xDistance,
			String yDistance, String xOffset, String yOffset){
		double d = Double.parseDouble(xDistance);
		double e = Double.parseDouble(yDistance);
		double f = Double.parseDouble(xOffset);
		double g = Double.parseDouble(yOffset);
		println(constantGen.size());
		for (int i = 0; i < constantGen.size(); i++ ) {
			for (int j = 0; j < constantGen.get(i).size(); j++ ) {
				println(constantGen.get(i).get(j));
			}
			println("End of List " + i);
		}
		myModelController.setConstantGenerator(constantGen, d,
		 e, f, g);
        constantGen = new ArrayList<>();
    }

    public makeArticle(e, Pane inf){
        String image = e.getGestureSource().getImageName();
		Article temp = new Article(image,0,0,true);
		randomGenMap.put(temp,0.0);
        currentArticle = temp;
        articleList.add(currentArticle);
		tempList.add(temp);
		println(tempList.size());
        makePopup(currentArticle);
        Image im = (Image) ResourceManager.getResourceManager().getResource("ImageManager", currentArticle.getImageFile());
        ImageView h = new ImageView();
        h.setImage(im);
        inf.getChildren().add(h);
        h.relocate(150,150);
    }

    public void dragOn(event){
        if (event.getGestureSource() != this && event.getDragboard().hasImage()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            //println("yo");
        }

        event.consume();
    }

    public void makePopup(Article selectedArticle){
        ArticlePropertyEditorMenu menu = new ArticlePropertyEditorMenu("Hi",selectedArticle,myAuthoringController);
    }

}
