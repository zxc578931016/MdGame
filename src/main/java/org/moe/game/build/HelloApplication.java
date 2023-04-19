package org.moe.game.build;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {


        List<Label> allLabel = new ArrayList<>();
        List<HBox> allHBox = new ArrayList<>();


        VBox vBoxTopLeft = new VBox();
        vBoxTopLeft.setPrefHeight(24);
        vBoxTopLeft.setPrefWidth(90);
        Label labelTopLeft = new Label();
        labelTopLeft.setAlignment(Pos.CENTER);
        labelTopLeft.setPrefHeight(24);
        labelTopLeft.setPrefWidth(90);
        labelTopLeft.setText("敌方");
        vBoxTopLeft.getChildren().addAll(labelTopLeft);


        Button button = new Button();
        button.setText("重置回合效果");
        button.setPrefHeight(24);
        button.setPrefWidth(90);
        button.setOnAction(actionEvent -> {
            for (Label label : allLabel) {
                label.setText("");
            }
        });

        VBox vBoxTopRight = new VBox();
        vBoxTopRight.setPrefHeight(24);
        vBoxTopRight.setPrefWidth(90);
        Label labelTopRight = new Label();
        labelTopRight.setAlignment(Pos.CENTER);
        labelTopRight.setPrefHeight(24);
        labelTopRight.setPrefWidth(90);
        labelTopRight.setText("我方");
        vBoxTopRight.getChildren().addAll(labelTopRight);


        HBox hBoxTop = new HBox();
        hBoxTop.setPrefHeight(24);
        hBoxTop.setPrefWidth(300);
        hBoxTop.getChildren().setAll(vBoxTopLeft, button, vBoxTopRight);

        allHBox.add(hBoxTop);

        File directory = new File("");
        String absolutePath = directory.getAbsolutePath();


        File file = new File(absolutePath + "/img");
        File[] fs = file.listFiles();

        if (fs != null) {
            for (File f : fs) {
                if (!f.isDirectory()) {
                    List<HBox> hBoxList = new ArrayList<>();
                    for (int i = 1; i < 3; i++) {
                        Label label = new Label();
                        label.setAlignment(Pos.CENTER);
                        label.setPrefHeight(24);
                        label.setPrefWidth(30);
                        label.setId(i + "left");
                        allLabel.add(label);

                        Button button1 = new Button();
                        button1.setText("效果" + i);
                        button1.setPrefHeight(24);
                        button1.setPrefWidth(60);
                        button1.setOnAction(actionEvent -> {
                            label.setText("*");
                        });
                        HBox hBox = new HBox();
                        hBox.setPrefHeight(24);
                        hBox.setPrefWidth(90);
                        hBox.getChildren().addAll(button1, label);
                        hBoxList.add(hBox);
                    }

                    VBox vBox1 = new VBox();
                    vBox1.setPrefHeight(120);
                    vBox1.setPrefWidth(90);
                    vBox1.getChildren().addAll(hBoxList);


                    VBox vBox2 = new VBox();
                    //vBox2.setPrefSize(200,120);
                    vBox2.setPrefHeight(120);
                    vBox2.setPrefWidth(90);
                    ImageView imageView = new ImageView();
                    imageView.setFitHeight(120);
                    imageView.setFitWidth(90);
                    imageView.setPickOnBounds(true);
                    imageView.setPreserveRatio(true);
                    imageView.setImage(new Image(f.getPath()));
                    vBox2.getChildren().addAll(imageView);


                    List<HBox> hBoxList3 = new ArrayList<>();
                    for (int i = 1; i < 3; i++) {
                        Label label = new Label();
                        label.setAlignment(Pos.CENTER);
                        label.setPrefHeight(24);
                        label.setPrefWidth(30);
                        label.setId(i + "left");
                        allLabel.add(label);

                        Button button1 = new Button();
                        button1.setText("效果" + i);
                        button1.setPrefHeight(24);
                        button1.setPrefWidth(60);
                        button1.setOnAction(actionEvent -> {
                            label.setText("*");
                        });
                        HBox hBox = new HBox();
                        hBox.setPrefHeight(24);
                        hBox.setPrefWidth(90);
                        hBox.getChildren().addAll(label, button1);
                        hBoxList3.add(hBox);
                    }

                    VBox vBox3 = new VBox();
                    vBox3.setPrefHeight(120);
                    vBox3.setPrefWidth(90);
                    vBox3.getChildren().addAll(hBoxList3);


                    HBox hBox = new HBox();
                    //hBox.setPrefSize(200,360);
                    hBox.setPrefHeight(100);
                    hBox.setPrefWidth(300);
                    hBox.getChildren().setAll(vBox1, vBox2, vBox3);
                    allHBox.add(hBox);
                }
            }
        }


        VBox vBox = new VBox();
        //120
        assert fs != null;
        vBox.setPrefHeight(fs.length * 120 + 30);
        vBox.setPrefWidth(300);
        vBox.setSpacing(20);
        vBox.getChildren().addAll(allHBox);


        Scene scene = new Scene(vBox, 270, fs.length * 120 + 30);


        //宽，高
        stage.setTitle("珠泪记录器");
        stage.setScene(scene);
        stage.show();
    }
}