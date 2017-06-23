package com.juliemartin.currencyconverter.app;

import com.juliemartin.currencyconverter.calc.Calculations;
import com.juliemartin.currencyconverter.data.MoneyBean;
import com.juliemartin.currencyconverter.data.RecordBean;
import com.juliemartin.currencyconverter.presentation.CurrencyConverterFX;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Julie Martin
 */
public class CurrencyConverterMain extends Application {

    private Calculations calc;
    private MoneyBean money;
    private RecordBean record;
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