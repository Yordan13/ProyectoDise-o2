package Util;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;

public class JSON_Util {

    public static ArrayList<String> jsonToList(JSONArray pJson) {
        Iterator<String> iterator = pJson.iterator();
        ArrayList<String> finalList = new ArrayList<>();
        while (iterator.hasNext()) {
            finalList.add(iterator.next());
        }
        
        return finalList;
    } 
}
