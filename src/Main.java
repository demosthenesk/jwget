import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.scene.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/mainWindow.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("jwget");
//        stage.getIcons().add(new Image("file:/resources/logo_jwget.png"));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/logo_jwget.png")));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        launch(args);
    }

}