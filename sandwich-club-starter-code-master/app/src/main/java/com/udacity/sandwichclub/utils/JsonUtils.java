package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject s = new JSONObject(json);
            JSONObject n = s.getJSONObject("name");
            String mainName = n.getString("mainName");
            JSONArray alsoKnownAs = n.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsList = new ArrayList<>();
            if (alsoKnownAs != null){
                for (int i=0;i<alsoKnownAs.length();i++){
                    alsoKnownAsList.add(alsoKnownAs.getString(i));
                }
            }
            String placeOfOrigin = s.getString("placeOfOrigin");
            String description = s.getString("description");
            String image = s.getString("image");
            JSONArray ingredients =  s.getJSONArray("ingredients");
            List<String> ingredientsList = new ArrayList<>();
            if (ingredients != null){
                for (int i=0;i<ingredients.length();i++){
                    ingredientsList.add(ingredients.getString(i));
                }
            }

            Sandwich sandwitchObject = new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);
                    return sandwitchObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }
}
