package view;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Transition {

    public TranslateTransition translateTransition(double duration, double fromX, double toX, double fromY, double toY, Node target) {

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), target);
        translateTransition.setFromX(fromX);
        translateTransition.setFromY(fromY);
        translateTransition.setToX(toX);
        translateTransition.setToY(toY);
        translateTransition.play();

        return translateTransition;
    }

    public FadeTransition fadeTransition(double duration, Node target, double fromValue, double toValue) {

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(duration), target);
        fadeTransition.setFromValue(fromValue);
        fadeTransition.setToValue(toValue);
        fadeTransition.play();

        return fadeTransition;
    }
}
