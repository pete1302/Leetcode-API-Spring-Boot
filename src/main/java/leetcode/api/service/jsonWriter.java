package leetcode.api.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONObject;

/**
 * jsonWriter
 */
public class jsonWriter {

    public static void writer(JSONObject data) {
        
        String path = "C:\\Users\\PETE\\Desktop\\archive\\maven-workspace\\leetcode-stats-api\\src\\main\\java\\leetcode\\api\\service\\data.json";

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write("\n");
            out.write(data.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    // public static void main(String[] args) throws Exception {
    //     File f = new File("C:\\Users\\PETE\\Desktop\\archive\\maven-workspace\\leetcode-stats-api\\src\\main\\java\\leetcode\\api\\service\\data.json");
    //     if (f.exists()){
    //         InputStream is = new FileInputStream("file.json");
    //         String jsonTxt = IOUtils.toString(is, "UTF-8");
    //         System.out.println(jsonTxt);
    //         JSONObject json = new JSONObject(jsonTxt);       
    //         String a = json.getString("1000");
    //         System.out.println(a);   
    //     }
    // }

}


 