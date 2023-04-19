module org.moe.game.build {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.moe.game.build to javafx.fxml;
    exports org.moe.game.build;
}