package classes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Utils {

    //--IMPORTANT-- ALL the Java custom methods called from Karate API need to be static.
    public static boolean assertPets(String expectedJson, String responseJson) throws ParseException {
        boolean jsonMatch = false;
        JSONParser parser = new JSONParser();

       //JSONObject expectedObject = (JSONObject) parser.parse(expectedJson);
        Object obj  = parser.parse(expectedJson);
        JSONArray expectedPets = new JSONArray();
        expectedPets.add(obj);

        Object obj2  = parser.parse(responseJson);
        JSONArray responsePets = new JSONArray();
        responsePets.add(obj2);

        if (expectedPets.equals(responsePets))
            jsonMatch=true;
        return jsonMatch;
    }

    public static boolean assertPet(String expectedJson, String responseJson) throws ParseException {
        boolean jsonMatch = false;
        JSONParser parser = new JSONParser();

        JSONObject expectedPet  = (JSONObject) parser.parse(expectedJson);
        JSONObject responsePet  = (JSONObject) parser.parse(responseJson);

        if (expectedPet.equals(responsePet))
            jsonMatch=true;
        return jsonMatch;
    }

    public static boolean assertPetsState(String responseJson, String expectedState) throws ParseException {
        boolean jsonMatch = true;
        JSONParser parser = new JSONParser();
        JSONObject expectedPET = null;

        Object obj  = parser.parse(responseJson);
        JSONArray expectedPets = new JSONArray();
        expectedPets.add(obj);
        String petStatus;

        for (int i=0; i < expectedPets.size(); i++) {
            expectedPET = (JSONObject)(((JSONArray)expectedPets.get(i)).get(0));
            petStatus = (String) expectedPET.get("status");
            if (!petStatus.equals(expectedState)) {
                jsonMatch = false;
                break;
            }
        }
        return jsonMatch;
    }
}
