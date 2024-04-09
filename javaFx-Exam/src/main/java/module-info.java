module org.example.javafxexam {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens org.example.javafxexam to javafx.fxml;
    exports org.example.javafxexam;
}