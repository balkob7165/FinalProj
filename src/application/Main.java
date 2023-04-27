package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			//adds background image
			Image bg = new Image("C:\\Users\\GoetschCorbin\\OneDrive - University of Wisconsin-Stout\\Documents\\GitHub\\FinalProj\\FinalProj\\Grassfield.png");
			ImageView img = new ImageView(bg);
			root.getChildren().add(img);
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Map[][] map = new Map[10][10];
			for(int i = 0;i<10;i++) {
				for(int j = 0;j<10;j++) {
					Map mapdata = new Map();
					map[i][j]= mapdata;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
