package menu;

public enum ImageFolders {
	ARTICLE ("articles"),
	BACKGROUND ("backgrounds"),
	PLATFORM ("platforms");
	
	private final String myFolder;
	
	private ImageFolders(String folder){
		myFolder = folder;
	}
	
	public String toString(){
		return myFolder;
	}
}
