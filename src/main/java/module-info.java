module cm.polytechnique {
    requires javafx.controls;
    requires javafx.fxml;

    opens cm.polytechnique to javafx.fxml;
    exports cm.polytechnique;
}
