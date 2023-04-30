package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			//adds images
			Image bg = new Image(getClass().getResource("/Assets/Grassfield.png").toString(), true);
			ImageView bg1 = new ImageView(bg);
			Image coin = new Image(getClass().getResource("/Assets/Coin.png").toString(), true);
			ImageView coin1 = new ImageView(coin);
			Image goblin = new Image(getClass().getResource("/Assets/Goblin.png").toString(), true);
			ImageView goblin1 = new ImageView(goblin);
			Image player = new Image(getClass().getResource("/Assets/Player.png").toString(), true);
			ImageView player1 = new ImageView(player);
			Image tree = new Image(getClass().getResource("/Assets/TreeSprite.png").toString(), true);
			ImageView tree1 = new ImageView(tree);
			
			
			root.getChildren().add(bg1); 
			
			Scene scene = new Scene(root,480,320);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Map[][] map = new Map[15][10];
			for(int i = 0;i<15;i++) {
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
