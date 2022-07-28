package leetcode.api.service;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import leetcode.api.response.responseHandler;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class jsonService {
    
    public static JSONObject getJSON(String username , int qid ) {
    // public static void getJSON(String username , int qid ) {
        
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        // String query = String.format("{`\"query\":\"query getUserProfile($username: String!) { allQuestionsCount { difficulty count } matchedUser(username: $username) { contributions { points } profile { reputation ranking } submissionCalendar submitStats { acSubmissionNum { difficulty count submissions } totalSubmissionNum { difficulty count submissions } } } } \",\"variables\":{\"username\":\"%s\"}}", username);
        String query = Query.getQuery(qid, username);

        
        RequestBody body = RequestBody.create(mediaType, query);
        Request request = new Request.Builder()
                .url("https://leetcode.com/graphql/")
                .method("POST", body)
                .addHeader("referer", String.format("https://leetcode.com/%s/", username))
        
                .addHeader("Content-Type", "application/json")
                .build();

        // JSONObject responseBody = null;

        try {
            Response response = client.newCall(request).execute();

            // Inspect response
            String responseString = response.body().string();

            System.out.println("RESPONSE STRING _____" + responseString);
            // JSONObject jsonObject = new JSONObject(responseString);
            System.out.println("HTTPCODE _____------ " + response.code() );
            // Integer httpCode = Integer.parseInt(response.message());
            Integer httpCode = response.code();

            if (response.isSuccessful()) {          //200ish code
                System.out.println("___________SUCESSFUL_______");
                // Parse GraphQL response
                // User not found
                return responseHandler.scanResponse(responseString, httpCode);
                

                // if (jsonObject.has("errors")) {
                //     System.out.println("yooohoooo 1");
                //     JSONObject errmsg = null;
                //     // return StatsResponse.error("error", "user does not exist");
                //     // return errmsg;
                // } else { // Parse user info
                //     System.out.println(jsonObject);
                //     // return jsonObject;

                //     // return decodeGraphqlJson(jsonObject);
                // }
            } else {
                System.out.println("-- ");
                // JSONObject errmsg = null;
                return responseHandler.scanResponse(responseString, httpCode);

                // return errmsg;
            }
        } catch (IOException | JSONException ex) {
            System.out.println("IN CATCH ");
            // return StatsResponse.error("error", ex.getMessage());
            String errDat = ex.getMessage().toString();
            return responseHandler.responseError(errDat);
            // JSONObject errmsg = ;
            // return ;
        }
        // finally{
        //     if(responseBody == null){
        //         responseBody = new JSONObject();
        //         responseBody.put("errors", "unknownerror");

        //     }
        // }
        
    }
}
