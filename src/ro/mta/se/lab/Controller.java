package ro.mta.se.lab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable
{
    @FXML private Label labelCountry;
    @FXML private Label labelCity;
    @FXML private ComboBox<String> comboBoxCountry;
    @FXML private ComboBox<String> comboBoxCity;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        labelCountry.setText("Country");
        labelCity.setText("City");
        ReadFile readFile = new ReadFile();
        readFile.main();
        for (Map.Entry<String, List<Country>> entry: readFile.citiesByCountry.entrySet()) {
            comboBoxCountry.getItems().add(entry.getKey());
        }
        comboBoxCountry.setPromptText("Choose a country");
    }
    public void whenComboBoxCountryIsSelected()
    {
        ReadFile readFile = new ReadFile();
        readFile.main();
        comboBoxCity.getItems().clear();
        for (Map.Entry<String, List<Country>> entry: readFile.citiesByCountry.entrySet())
        {
            if(comboBoxCountry.getValue().toString().equals(entry.getKey().toString()))
            {
                String citiesValues =  entry.getValue().toString().split("[\\[\\]]")[1];
                String[] citiesTokens = citiesValues.split(",\\s");
                comboBoxCity.getItems().add(citiesTokens[0]);
                comboBoxCity.getItems().add(citiesTokens[1]);
            }
        }
    }
}
