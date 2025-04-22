module cm.polytechnique {
    requires javafx.controls;
    requires javafx.fxml;

    opens cm.polytechnique to javafx.fxml;
    opens cm.polytechnique.Controller;
    exports cm.polytechnique;
    exports cm.polytechnique.Controller;
}
