module br.com.mazzoni.dukemarket.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    
    requires java.sql;
    
    opens br.com.mazzoni.dukemarket.javafx.controller to javafx.fxml;
    opens br.com.mazzoni.dukemarket.javafx to javafx.fxml;
       
    exports br.com.mazzoni.dukemarket.javafx;
    exports br.com.mazzoni.dukemarket.javafx.controller;
    exports br.com.mazzoni.dukemarket.javafx.DAO;
    exports br.com.mazzoni.dukemarket.javafx.model;
    exports connection;
    
    requires mysql.connector.java;
}
