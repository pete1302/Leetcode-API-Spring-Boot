package leetcode.api.Error;

import org.json.JSONObject;

public class custError {
    
    JSONObject errorObject ;
    custError(String body){
        if( body == null){

            errorObject = new JSONObject();
            errorObject.put("error", "unknown Error");


        }else{
            errorObject = new JSONObject();
            errorObject.put("error", body);
        }

    }    
    public JSONObject thorwError(String body) {

        custError throwableError = new custError(body);
        return throwableError; 
        
    }
    public String    toString(){
        
        custError throwableError = new custError(body);
        return throwableError.toString(); 

    }

}
