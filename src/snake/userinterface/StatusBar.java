package snake.userinterface;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.w3c.dom.css.Rect;

import java.security.SecurityPermission;

public class StatusBar {

    //MEMBER VARIABLES
    private int BAR_HEIGHT;
    private HBox statusBar;
    private Text lives;
    private Text apples;

    public StatusBar() {
        this.statusBar = new HBox();
        BAR_HEIGHT = Gui.WINDOW_Y - Gui.WINDOW_X;
        statusBar.setPrefHeight(BAR_HEIGHT);
        statusBar.setPrefWidth(Gui.WINDOW_X);
        statusBar.setAlignment(Pos.CENTER);
        drawStatusBar();
    }

    private void drawStatusBar() {
        Font font = Font.font("System", FontWeight.BOLD, 30);

        ImageView heartImg = portImage("/assets/heart.png");
        lives = new Text("3");
        lives.setFont(font);
        lives.setFill(Color.WHITE);

        Rectangle sep = new Rectangle(Gui.WINDOW_X - (3 * Gui.WINDOW_X / 8), 1);
        sep.setFill(Color.TRANSPARENT);

        ImageView appleImg = portImage("/assets/apple.png");
        apples = new Text("0");
        apples.setFont(font);
        apples.setFill(Color.WHITE);

        statusBar.getChildren().addAll(heartImg, lives, sep, appleImg, apples);
    }

    private ImageView portImage(String url) {

        int imgHeight = BAR_HEIGHT - 4;
        Image img = new Image(url, imgHeight, imgHeight, true, true);
        ImageView imgView = new ImageView(img);
        Rectangle2D viewportRect = new Rectangle2D(1, 1, imgHeight, imgHeight);
        imgView.setViewport(viewportRect);
        imgView.setStyle("-fx-background-color: #4A752D;");
        return imgView;
    }

    public HBox getStatusBar() {
        return statusBar;
    }

    public int getLives() {
        return Integer.parseInt(lives.getText());
    }

    public int getApples() {
        return Integer.parseInt(apples.getText());
    }

}
