package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.jar.Pack200;

public class Controller implements Initializable{
    final Rotate rotationTransformX = new Rotate(230, 0, 0, 0, Rotate.X_AXIS);
    final Rotate rotationTransformY = new Rotate(150, 0, 0, 0, Rotate.Y_AXIS);
    final Rotate rotationTransformZ = new Rotate(50, 0, 0, 0, Rotate.Z_AXIS);
    @FXML
    private Slider sliderX;

    @FXML
    private Slider sliderY;

    @FXML
    private Slider sliderZ;

    @FXML
    private Slider sliderA;

    @FXML
    private Label lable;

    @FXML
    private Label labelA;

    @FXML
    Pane pane;

    @FXML
    Box box1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Group group = new Group();
        PhongMaterial matX = new PhongMaterial();
        matX.setDiffuseColor(Color.RED);

        PhongMaterial matY = new PhongMaterial();
        matY.setDiffuseColor(Color.GREEN);

        PhongMaterial matZ = new PhongMaterial();
        matZ.setDiffuseColor(Color.BLUE);


        Box boxX = new Box(200,10,200);
        boxX.setMaterial(matX);
        boxX.translateYProperty().setValue(100);

        Box boxY = new Box(10,200,200);
        boxY.setMaterial(matY);
        boxY.translateXProperty().setValue(100);

        Box boxZ = new Box(200,200,10);
        boxZ.translateZProperty().setValue(100);
        boxZ.setMaterial(matZ);



        group.getChildren().addAll(boxX, boxY, boxZ);

        pane.getChildren().add(group);

        group.setLayoutX(200);
        group.setLayoutY(200);

        sliderX.setMin(0);
        sliderX.setMax(360);

        sliderY.setMin(0);
        sliderY.setMax(360);

        sliderZ.setMin(0);
        sliderZ.setMax(360);

        sliderA.setMin(1);
        sliderA.setMax(2);


        rotationTransformX.angleProperty().bind(sliderX.valueProperty());

        rotationTransformY.angleProperty().bind(sliderY.valueProperty());

        rotationTransformZ.angleProperty().bind(sliderZ.valueProperty());

        //boxX.translateYProperty().bind(sliderA.valueProperty());
        group.scaleXProperty().bind(sliderA.valueProperty());
        group.scaleYProperty().bind(sliderA.valueProperty());
        group.scaleZProperty().bind(sliderA.valueProperty());




        group.getTransforms().addAll(rotationTransformX, rotationTransformY, rotationTransformZ);

        /*final Timeline rotationAnimation = new Timeline();
        rotationAnimation.getKeyFrames()
                .add(
                        new KeyFrame(
                                Duration.seconds(10),
                                new KeyValue(
                                        rotationTransformX.angleProperty(),
                                        360
                                ),
                                new KeyValue(
                                        rotationTransformY.angleProperty(),
                                        360
                                ),
                                new KeyValue(
                                        rotationTransformZ.angleProperty(),
                                        360
                                )
                        )
                );
        rotationAnimation.setCycleCount(Animation.INDEFINITE);
        rotationAnimation.play();*/




        lable.textProperty().bindBidirectional(sliderX.valueProperty(), new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return object.toString();
            }

            @Override
            public Number fromString(String string) {
                return null;
            }
        });

        labelA.textProperty().bindBidirectional(sliderA.valueProperty(), new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return object.toString();
            }

            @Override
            public Number fromString(String string) {
                return null;
            }
        });
    }
}
