package com.juliemartin.currencyconverter.app;

import com.juliemartin.currencyconverter.presentation.CurrencyConverterFX;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Julie Martin
 */
public class CurrencyConverterMain extends Application {

    private CurrencyConverterFX gui;

    @Override
    public void init() {
        gui = new CurrencyConverterFX();
    }

    @Override
    public void start(Stage primaryStage) {
        gui.start(primaryStage);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}