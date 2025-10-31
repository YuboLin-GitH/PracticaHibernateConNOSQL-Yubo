module com.yubo.practicahibernateconnosql {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.yubo.practicahibernateconnosql to javafx.fxml;
    exports com.yubo.practicahibernateconnosql;
}