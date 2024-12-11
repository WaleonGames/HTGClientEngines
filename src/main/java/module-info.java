module custom.htgmc.htgclientengines {
    requires javafx.controls;
    requires javafx.fxml;


    opens custom.htgmc to javafx.fxml;
    exports custom.htgmc;
}