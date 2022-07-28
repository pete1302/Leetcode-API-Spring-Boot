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
    
    // public static JSONObject getJSON(String username , Integer qid , String params) {
    public static void getJSON(String username , Integer qid , String params) {
        
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        // String query = String.format("{`\"query\":\"query getUserProfile($username: String!) { allQuestionsCount { difficulty count } matchedUser(username: $username) { contributions { points } profile { reputation ranking } submissionCalendar submitStats { acSubmissionNum { difficulty count submissions } totalSubmissionNum { difficulty count submissions } } } } \",\"variables\":{\"username\":\"%s\"}}", username);
        String query = Query.getQuery( username , qid , params);

        
        RequestBody body = RequestBody.create(mediaType, query);
        Request request = new Request.Builder()
                .url("https://leetcode.com/graphql/")
                .method("POST", body)
                .addHeader("referer", String.format("https://leetcode.com/%s/", username))
        
                .addHeader("Content-Type", "application/json")
                .build();

//---------

        try {
            Response response = client.newCall(request).execute();

            // Inspect response
            String responseString = response.body().string();

            responseHandler.scanResponse(responseString);
            

            JSONObject jsonObject = new JSONObject(responseString);
            // JSONObject nullResponse = new JSONObject();

            if (response.isSuccessful()) {
                // Parse GraphQL response

                // User not found
                if (jsonObject.has("errors")) {
                    System.out.println("yooohoooo 1");
                    JSONObject errmsg = null;
                    // return   .error("error", "user does not exist");
                    // return errmsg;
                }
                // else if ( jsonObject == null){
                //     nullResponse.put("error", "user dosen't exist");

                //     return nullResponse;

                // }
                 else { // Parse user info
                    System.out.println(jsonObject);
                    // return jsonObject;
                    // return decodeGraphqlJson(jsonObject);
                }
            } else {
                System.out.println("yooohoooo 2");
                JSONObject errmsg = null;
                // return errmsg;
            }
        } catch (IOException | JSONException ex) {
            System.out.println("yoohooo 3");
            // return StatsResponse.error("error", ex.getMessage());
            // JSONObject errmsg = null;
            responseHandler.responseError(ex.getMessage());
            // return errmsg;
        }
        
    }
}
