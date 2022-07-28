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

    public static JSONObject getJSON(String username, int qid) {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");

        String query = Query.getQuery(qid, username);

        RequestBody body = RequestBody.create(mediaType, query);
        Request request = new Request.Builder()
                .url("https://leetcode.com/graphql/")
                .method("POST", body)
                .addHeader("referer", String.format("https://leetcode.com/%s/", username))

                .addHeader("Content-Type", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();

            String responseString = response.body().string();

            System.out.println("RESPONSE STRING _____" + responseString);

            System.out.println("HTTPCODE _____------ " + response.code());

            Integer httpCode = response.code();

            if (response.isSuccessful()) { // 200ish code
                System.out.println("___________SUCESSFUL_______");

                return responseHandler.scanResponse(responseString, httpCode);

            } else {
                System.out.println("-- ");

                return responseHandler.scanResponse(responseString, httpCode);

            }
        } catch (IOException | JSONException ex) {
            System.out.println("IN CATCH ");

            String errDat = ex.getMessage().toString();
            return responseHandler.responseError(errDat);

        }

    }
}
