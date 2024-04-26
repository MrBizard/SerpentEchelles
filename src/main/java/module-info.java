module grp.info.serpentechelles {
    requires javafx.controls;
    requires javafx.fxml;


    opens grp.info.serpentechelles to javafx.fxml;
    exports grp.info.serpentechelles;
}