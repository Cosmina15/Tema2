package ro.mta.se.lab;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ReadFile
{
    public Map<String, List<Country>> citiesByCountry;
    public  void main() {
        try {
            FileReader fileReader = new FileReader("D:\\cursuri_anul_4\\tema2\\src\\ro\\mta\\se\\lab\\input");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            ArrayList <String> countryArrayList = new ArrayList <String>();
            ArrayList <String> cityArrayList = new ArrayList <String>();
            while ((line = bufferedReader.readLine()) != null)
            {
                line.split("\\s+");
                countryArrayList.add(line.split("\\s+")[4]);
                cityArrayList.add(line.split("\\s+")[1]);
            }
            ArrayList<Country> countries = new ArrayList<Country>();
            for (int i=1; i<countryArrayList.size(); i++) {
                 countries.add(new Country(countryArrayList.get(i), cityArrayList.get(i)));
            }

           this.citiesByCountry = countries.stream().collect(Collectors.groupingBy(Country::getCountry));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}