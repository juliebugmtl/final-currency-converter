package com.juliemartin.currencyconverter.presentation;

import com.juliemartin.currencyconverter.calc.Calculations;
import com.juliemartin.currencyconverter.data.CurrencyDB;
import com.juliemartin.currencyconverter.data.CurrencyDBImpl;
import com.juliemartin.currencyconverter.data.CurrencyData;
import com.juliemartin.currencyconverter.data.MoneyBean;
import com.juliemartin.currencyconverter.data.RecordBean;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Julie Martin
 */
public class CurrencyConverterFX {
    
    private final MoneyBean money;
    private final RecordBean record;
    private final CurrencyDB currencyDB;

    private TextField currencyCodeField;
    private TextField currencyAmountField;
    private TextField valueField;
    private Label amountLabel;
    private Label title;

    private int calculationType;

    /**
     * Default constructor
     */
    public CurrencyConverterFX() {
        
        money = new MoneyBean();
        record = new RecordBean();
        currencyDB = new CurrencyDBImpl(); // instantiate the db dao object
    }
    
    
//    public CurrencyConverterFX(MoneyBean money, RecordBean record, Calculations calc) {
//        this.calc = calc;
//        this.money = money;
//        this.record = record;
//        calculationType = 0; // Buy
//        calculationType = 1; // Sell
//    }
//  
 /**
     * This method creates a Label that is centered inside an HBox.
     *
     * @param text
     * @return
     */
    private HBox createTitle() {
        title = new Label("Currency Converter"); // default

        // Style the label using CSS
        // Possible fonts can be found at http://www.webdesigndev.com/16-gorgeous-web-safe-fonts-to-use-with-css/
        title.setStyle("-fx-font-size:18pt; -fx-font-weight:bold; -fx-font-family:Verdana, sans-serif");

        // To center the title and give it padding create an HBox, set the
        // padding and alignment, add the label and then add the HBox to the BorderPane.
        HBox hbox = new HBox();
        hbox.getChildren().add(title);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20, 20, 20, 20));

        return hbox;
    }

    /**
     * This method creates a BorderPane that has a title in the top and a
     * GridPane in the center. The GridPane contains a form.
     *
     * @return The BorderPane to add to the Scene
     */
    private BorderPane buildForm() {

        // Create the pane that will hold the controls
        BorderPane converterPane = new BorderPane();

        // Add a Title
        converterPane.setTop(createTitle());

        // Craete an empty GridPane
        GridPane converterGrid = new GridPane();

        // Column 0, Row 0 Currency Code
        Label currencyCodeLabel = new Label("Currency Code");
        currencyCodeLabel.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-font-family:Verdana, sans-serif");
        converterGrid.add(currencyCodeLabel, 0, 0);

        // Column 1, Row 0 Empty field for currency code
        currencyCodeField = new TextField();
        currencyCodeField.setMaxWidth(75);
        currencyCodeField.setStyle("-fx-font-size:14pt; -fx-font-weight:normal; -fx-font-family:Verdana, sans-serif");
        currencyCodeField.setAlignment(Pos.CENTER_LEFT);
        converterGrid.add(currencyCodeField, 1, 0);

        // Column 0, Row 1 Amount
        Label amountLabel = new Label("Amount");
        amountLabel.setAlignment(Pos.CENTER_RIGHT);
        amountLabel.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-font-family:Verdana, sans-serif");
        converterGrid.add(amountLabel, 0, 1);

        // Column 1, Row 1 Empty field for amount
        currencyAmountField = new TextField();
        currencyAmountField.setStyle("-fx-font-size:14pt; -fx-font-weight:normal; -fx-font-family:Verdana, sans-serif");
        currencyAmountField.setAlignment(Pos.CENTER_LEFT);
        converterGrid.add(currencyAmountField, 1, 1);

        // Column 0, Row 2 Value
        Label valueLabel = new Label("Value");
        valueLabel.setAlignment(Pos.CENTER_RIGHT);
        valueLabel.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-font-family:Verdana, sans-serif");
        converterGrid.add(valueLabel, 0, 2);

        // Column 1, Row 2 Empty field for value and set not editable
        valueField = new TextField();
        valueField.setStyle("-fx-font-size:14pt; -fx-font-weight:normal; -fx-font-family:Verdana, sans-serif");
        valueField.setAlignment(Pos.CENTER_LEFT);
        valueField.setEditable(false);
        converterGrid.add(valueField, 1, 2);
        
        // Convert Button
        Button buy = new Button("Buy");
        buy.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-font-family:Verdana, sans-serif");
        buy.setOnAction(this::findButtonHandler);

        // Sell Button
        Button sell = new Button("Sell");
        sell.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-font-family:Verdana, sans-serif");
        sell.setOnAction(this::findButtonHandler);

        // Exit button
        Button exit = new Button("Exit");
        exit.setStyle("-fx-font-size:14pt; -fx-font-weight:bold;  -fx-font-family:Verdana, sans-serif");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Platform.exit();
            }
        }
        );

        
        // HBox that will span 2 columns so that buttons can be centered 
        HBox hboxBtn = new HBox();

        // Add the buttons to the HBox
        hboxBtn.getChildren().addAll(buy, sell, exit);

        // Center the contents of the HBox
        hboxBtn.setAlignment(Pos.CENTER);
        
        // Spacing around the controls in the HBox
        hboxBtn.setPadding(new Insets(20.0));

        // Add spacebetween buttons
        hboxBtn.setSpacing(10.0); // Spacing around the controls in the HBox

        // Place the HBOX in column 0, row 4, spanning 2 columns and 1 row
        converterGrid.add(hboxBtn, 0, 4, 2, 1);

        // Set the column widths as a percentage
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(30.0);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(70.0);

        converterGrid.getColumnConstraints().addAll(col1, col2);

        // Add space around the outside of the GridPane
        converterGrid.setPadding(new Insets(20.0));
        // Add space between rows and columns of the GridPane
        converterGrid.setHgap(10.0);
        converterGrid.setVgap(10.0);

        // Load the GridPane into the pane
        converterPane.setCenter(converterGrid);

        return converterPane;
    }


    /**
     * This is the event handler when the button is being pressed. If there is a
     * NumberFormatException when the Id field is converted to an int then an
     * Alert box is displayed
     *
     * There is a better way to handle strings that cannot convert and you will
     * learn how in the Java Desktop course.
     *
     * @param e
     */
    private void findButtonHandler(ActionEvent e) {
        boolean doFind = true;
        String currencyCodeValue = "";
        double amountValue = 0;
        double valueValue = 0;
        try {
            currencyCodeValue = currencyCodeField.getText();
            amountValue = Double.parseDouble(currencyAmountField.getText());
            money.setCurrencyCode(currencyCodeValue);
            money.setAmount(amountValue);
        } catch (NumberFormatException nfe) {
            doFind = false;
            numberFormatAlert(currencyCodeField.getText(), "CurrencyCode");
        }

        if (doFind == true) {
          //  String theCurrency = CurrencyDB.getIdQueryRecord(currencyCodeValue).toString;
            
          //  valueField.setText(theCurrency);
     
        }

    }

        /**
     * Display an Alert box if there is a NumberFormatException detected in the
     * saveButtonHandler of findButtonHandler
     *
     * @param badValue
     * @param textField
     */
    private void numberFormatAlert(String badValue, String textField) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Number Format Error");
        alert.setHeaderText("The value \"" + badValue + "\" cannot be converted to a number for the " + textField);
        alert.setContentText("Number Format Error");

        alert.showAndWait();
    }
    


    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        root.setCenter(buildForm());

        Scene scene = new Scene(root, 600, 450);

        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

