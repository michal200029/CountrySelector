package pl.opalka.CountrySelector.services;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import pl.opalka.CountrySelector.model.Basic;
import pl.opalka.CountrySelector.model.Point;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class BasicInfoParser {


    public List<Point> getBasicData() throws IOException {

        List<Point> pointsList = new ArrayList<>();
        URL url = new URL("https://restcountries.eu/rest/v2/all?fields=name;latlng");

        InputStreamReader reader = new InputStreamReader(url.openStream());
        Basic[] basics = new Gson().fromJson(reader, Basic[].class);

        for(Basic item: basics) {
            if(item.getLatlng().size()<1){
                continue;
            }else{
                double latitude = item.getLatlng().get(0);
                double longitude = item.getLatlng().get(1);
                String countryName = item.getName();
                pointsList.add(new Point(latitude,longitude,countryName));
            }
        }

        return pointsList;

    }
}
