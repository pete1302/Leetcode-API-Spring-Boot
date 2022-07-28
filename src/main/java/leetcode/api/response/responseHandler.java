package leetcode.api.response;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class responseHandler {
    
    public static JSONObject scanResponse(String responseString , int httpCode) {

        JSONObject jsonData = new JSONObject(responseString);

        System.out.println(" IN JSON ");
        // JSONObject data = null;

        if (jsonData.has("errors")) {
            System.out.println("--error in json --");
            JSONObject errmsg = new JSONObject();
            // String errData = data.getJSONobject("errors")  ; 
            // JSONArray array = jsonData.getJSONArray("errors").getJSONObject(0).getString("message");
            // JSONObject errData2 = array.getJSONObject(0);
            String errStr = jsonData.getJSONArray("errors").getJSONObject(0).getString("message");
            // String errData = array.getJSONObject(0).toString();

            // System.out.println(array);
            System.out.println(errStr);
            // System.out.println(errData);
            // System.out.println(errData2);

            errmsg.put("errors" , errStr);  
            errmsg.put("responseCode", httpCode);
            return errmsg; 
            // return   .error("error", "user does not exist");
            // return errmsg;
        }
        else { // Parse user info
            System.out.println(jsonData);
            return jsonData;
            // return jsonObject;
            // return decodeGraphqlJson(jsonObject);
        }
        // return jsonData;
    }

    public static JSONObject responseError(String errorString){
        JSONObject errData = new JSONObject();
        errData.put("errors", errorString);
        
        return errData;
    }

}
