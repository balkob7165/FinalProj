package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Main extends Application {
	//this checks whether or not the player is going to run into something and reacts accordingly
	public boolean checkColision(Player z, Map[][] map,ImageView[] coins,int coin,int x,int y,BorderPane root) {
		if(map[z.getX()+x][z.getY()+y].coin()) {
			map[z.getX()+x][z.getY()+y].collectCoin();
			System.out.println("Coins "+map[0][0].getTotalCoins());
			coin++;
			map[0][0].setTotalCoins(map[0][0].getTotalCoins()-1);
			root.getChildren().remove(coins[map[z.getX()+x][z.getY()+y].getImgNum()]);
			if(map[0][0].getTotalCoins()==0) {
				Alert win = new Alert(AlertType.INFORMATION,"You win!");
				win.showAndWait();
				System.exit(0);
			}
			return true;
		}
		if(map[z.getX()+x][z.getY()+y].npc()) {
			Alert gameover = new Alert(AlertType.INFORMATION,"Game Over");
			gameover.showAndWait();
			System.exit(0);
			return false;
		}
		if(map[z.getX()+x][z.getY()+y].tree()) {
			return false;
		}
		return true;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			//add background image
			Image bg = new Image(getClass().getResource("/Assets/Grassfield.png").toString(), true);
			ImageView bg1 = new ImageView(bg);
			root.getChildren().add(bg1);
			
			//adds and counts coins
			Image coin = new Image(getClass().getResource("/Assets/Coin.png").toString(), true);
			ImageView[] coins = new ImageView[150];
			int numcoins = 0;
			int coinscollected=0;
			
			//adds and counts goblins
			Image goblin = new Image(getClass().getResource("/Assets/Goblin.png").toString(), true);
			ImageView[] goblins = new ImageView[150];
			int numgoblins = 0;
			
			//add player image
			Player plr = new Player(0,0);
			Image player = new Image(getClass().getResource("/Assets/Player.png").toString(), true);
			ImageView player1 = new ImageView(player);
			player1.setX(plr.getX()*32);
			player1.setY(plr.getY()*32);
			root.getChildren().add(player1);
			
			//adds and counts trees
			Image tree = new Image(getClass().getResource("/Assets/TreeSprite.png").toString(), true);
			ImageView[] trees = new ImageView[150];
			int numtrees = 0;
			
			//Generates Map
			Map[][] map = new Map[15][10];
			for(int i = 0;i<15;i++) {
				for(int j = 0;j<10;j++) {
					if(i==0&&j==0) {
					map[i][j] = new Map(false,false,false);
					map[i][j].setTotalCoins(0);
					}
					else {
					Map mapdata = new Map();
					map[i][j]= mapdata;
					}
				}
			}
			
			//generates images for each map element
			for(int i = 0;i<15;i++) {
				for(int j = 0;j<10;j++) {
						if(map[i][j].tree()) {
							trees[numtrees]=new ImageView(tree);
							trees[numtrees].setX(i*32);
							trees[numtrees].setY(j*32);
							root.getChildren().add(trees[numtrees]);
							map[i][j].setImgNum(numtrees);
							numtrees++;
						}
						if(map[i][j].npc()) {
							goblins[numgoblins] = new ImageView(goblin);
							goblins[numgoblins].setX(i*32);
							goblins[numgoblins].setY(j*32);
							root.getChildren().add(goblins[numgoblins]);
							map[i][j].setImgNum(numgoblins);
							numgoblins++;
						}
						if(map[i][j].coin()) {
							coins[numcoins] = new ImageView(coin);
							coins[numcoins].setX(i*32);
							coins[numcoins].setY(j*32);
							root.getChildren().add(coins[numcoins]);
							map[i][j].setImgNum(numcoins);
							numcoins++;
							
						}
					}
				}
			map[0][0].setTotalCoins(numcoins);
			
			Scene scene = new Scene(root,480,320);
			
			//reacts to button press and moves character
			scene.setOnKeyPressed(event -> {
	            switch (event.getCode()) {
	                case UP:
	                	if(checkColision(plr,map,coins,coinscollected,0,-1,root)) {
	                    plr.moveUp();
	                    player1.setY(plr.getY()*32);
	                	}
	                    break;
	                case DOWN:
	                	if(checkColision(plr,map,coins,coinscollected,0,1,root)) {
	                    plr.moveDown();
	                    player1.setY(plr.getY()*32);
	                	}
	                    break;
	                case LEFT:
	                	if(checkColision(plr,map,coins,coinscollected,-1,0,root)) {
	                    plr.moveLeft();
	                    player1.setX(plr.getX()*32);
	                	}
	                    break;
	                case RIGHT:
	                	if(checkColision(plr,map,coins,coinscollected,1,0,root)) {
	                    plr.moveRight();
	                    player1.setX(plr.getX()*32);
	                    }
	                    break;
	            }
	            primaryStage.setScene(scene);
	            primaryStage.setTitle("Coins: "+(map[0][0].getTotalCoins()));
	            primaryStage.show();
	        });
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Coins: "+map[0][0].getTotalCoins());
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
