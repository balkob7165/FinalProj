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
			root.getChildren().add(bg1); 
			Image coin = new Image(getClass().getResource("/Assets/Coin.png").toString(), true);
			ImageView coin1 = new ImageView(coin);
			Image goblin = new Image(getClass().getResource("/Assets/Goblin.png").toString(), true);
			ImageView goblin1 = new ImageView(goblin);
			Image player = new Image(getClass().getResource("/Assets/Player.png").toString(), true);
			ImageView player1 = new ImageView(player);
			root.getChildren().add(player1);
			Image tree = new Image(getClass().getResource("/Assets/TreeSprite.png").toString(), true);
			ImageView tree1 = new ImageView(tree);
			tree1.setX(160);
			tree1.setY(240);
			ImageView[] trees = new ImageView[150];
			root.getChildren().add(tree1);
			int numtrees = 0;
			
			//Generates Map
			Map[][] map = new Map[15][10];
			for(int i = 0;i<15;i++) {
				for(int j = 0;j<10;j++) {
					Map mapdata = new Map();
					map[i][j]= mapdata;
				}
			}
			
			for(int i = 0;i<15;i++) {
				for(int j = 0;j<10;j++) {
					if(map[i][j].hasItem()) {
						if(map[i][j].tree()) {
							trees[numtrees]=new ImageView(tree);
							trees[numtrees].setX(i*32);
							trees[numtrees].setY(j*32);
							root.getChildren().add(trees[numtrees]);
							numtrees++;
						}
					}
				}
			}
			
			int coins=0;
			Scene scene = new Scene(root,480,320);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Coins:"+coins);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
