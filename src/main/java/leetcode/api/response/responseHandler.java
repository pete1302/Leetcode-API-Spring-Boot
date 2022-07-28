package leetcode.api.response;

import org.json.JSONObject;

public class responseHandler {

    public static JSONObject scanResponse(String responseString, int httpCode) {

        JSONObject jsonData = new JSONObject(responseString);

        System.out.println(" IN JSON ");

        if (jsonData.has("errors")) {
            System.out.println("--error in json --");
            JSONObject errmsg = new JSONObject();

            String errStr = jsonData.getJSONArray("errors").getJSONObject(0).getString("message");

            System.out.println(errStr);
            ;

            errmsg.put("errors", errStr);
            errmsg.put("responseCode", httpCode);
            return errmsg;

        } else {
            System.out.println(jsonData);
            return jsonData;

        }

    }

    public static JSONObject responseError(String errorString) {
        JSONObject errData = new JSONObject();
        errData.put("errors", errorString);

        return errData;
    }

}
