package Setting;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Total_setting {
    int value;
    public Total_setting(int option){
        value=option;
    }
    public void WritePrinter() {
        //this is dictionary inside dictionary
        JSONObject printerKeyValue = new JSONObject();
        printerKeyValue.put("PrinterOption", value);
        //this is main dictionary
        JSONObject PrinterObj = new JSONObject();
        PrinterObj.put("PrinterConfig", printerKeyValue);
        //Add employees to list
        JSONArray printerList = new JSONArray();
        printerList.add(PrinterObj);

        //Write JSON file
        try (FileWriter file = new FileWriter("Printer.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(printerList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadPrinter() {
        //Get employee object within list
        try {
            FileReader reader = new FileReader("Printer.json");
            JSONParser parser = new JSONParser();
            Object object = parser.parse(reader);
            //JSONArray printerList = (JSONArray) object;
            //System.out.println(printerList);
            JSONObject mainObj = (JSONObject) object;
            //Get employee first name
            String firstName = (String) mainObj.get("firstName");
            System.out.println(firstName);

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void WriteResultAccess(String date,String terminal,String which_class) {
        //this is dictionary inside dictionary
        JSONObject printerKeyValue = new JSONObject();
        printerKeyValue.put("date", date);
        printerKeyValue.put("terminal", terminal);
        printerKeyValue.put("which_class", which_class);

        //this is main dictionary
        JSONObject PrinterObj = new JSONObject();
        PrinterObj.put("PrinterConfig", printerKeyValue);
        //Add employees to list
        JSONArray printerList = new JSONArray();
        printerList.add(PrinterObj);

        //Write JSON file
        try (FileWriter file = new FileWriter("ResultSearch.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(printerList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadResultAccess() {
        //Get employee object within list
        try {
            FileReader reader = new FileReader("ResultSearch.json");
            JSONParser parser = new JSONParser();
            Object object = parser.parse(reader);
            //JSONArray printerList = (JSONArray) object;
            //System.out.println(printerList);
            JSONObject mainObj = (JSONObject) object;
            //Get employee first name
            String firstName = (String) mainObj.get("firstName");
            System.out.println(firstName);

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}