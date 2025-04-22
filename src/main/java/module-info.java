module cm.polytechnique {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.sql;

    opens cm.polytechnique to javafx.fxml, java.sql;
    exports cm.polytechnique;
}
