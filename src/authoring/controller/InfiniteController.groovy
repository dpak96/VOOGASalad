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

    public InfiniteController(AuthoringController ac, mc){
        myAuthoringController = ac;
        myModelController = mc;
        randomGenMap = new HashMap<>();
        constantGen = new ArrayList<>();
        tempList = new ArrayList<>();
        articleList = new ArrayList<>();
    }

    public addToRandom(double d){
        randomGenMap.put(currentArticle, d);
        currentArticle = null;
        println("hi");
    }

    public getRandomMap(){
        return randomGenMap;
    }

    public addIndConstant(Article n){
        tempList.add(n);
    }

    public addSetToConstant(){
        constantGen.add(tempList);
        tempList = new ArrayList<>();
    }



    public addInfinite(){

    }

    public genInfinite(){

    }

    public genRandom(){
        myModelController.g
        randomGenMap = new HashMap<>();
    }

    public genConstant(){

        constantGen = new ArrayList<>();
    }

    public makeArticle(e, Pane inf){
        println("po")
        String image = e.getGestureSource().getImageName();
        currentArticle = new Article(image,0,0,true);
        articleList.add(currentArticle);
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
