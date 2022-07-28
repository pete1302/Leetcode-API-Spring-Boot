package leetcode.api.response;

<<<<<<< Updated upstream
import java.io.IOException;

import org.json.JSONException;
=======
>>>>>>> Stashed changes
import org.json.JSONObject;

public class responseHandler {
    
    public static JSONObject scanResponse(String responseString) {

        JSONObject data = new JSONObject(responseString);
        // JSONObject data = null;

        if (data.has("errors")) {
            System.out.println("--error in json --");
            JSONObject errmsg = null;
            errmsg.put("errors", )
            // return   .error("error", "user does not exist");
            // return errmsg;
        }
        // else if ( jsonObject == null){
        //     nullResponse.put("error", "user dosen't exist");

        //     return nullResponse;

        // }
        else { // Parse user info
            System.out.println(data);
            // return jsonObject;
            // return decodeGraphqlJson(jsonObject);
        }


        return data;
    }

    public static JSONObject responseError(String errorString){
        JSONObject errData = new JSONObject(errorString);
        
        return errData;
    }

}
