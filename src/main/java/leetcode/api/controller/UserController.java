package leetcode.api.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leetcode.api.service.jsonService;
import leetcode.api.service.serviceInfo;

// impotr 

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    // @Autowired
    // private StatsService statsService;

    @GetMapping(value ={"/{username}/{qid}", "/"})
    // public ResponseEntity<JSONObject> getStats(@PathVariable Optional<String> username , @PathVariable long qid) {
    // public String getStats(@PathVariable Optional<String> username , @PathVariable int qid) {
    public String getStats(@PathVariable(required = false) String username , @PathVariable(required = false) Integer qid) {
        if (username != null && qid != null) {
            // StatsServiceImpl service = new StatsServiceImpl();
            // return statsService.getStats(username.get());
            // System.out.println(username.get() +' '+ qid);
            // String datastr =  username.get() + String.valueOf(qid);

            // JSONObject data = new JSONObject();
            // data.put("username", username.get());
            // data.put("qid", qid);
            // System.out.println(data);
            // // return new ResponseEntity<JSONObject>(data, HttpStatus.OK);
            // // return username.get();
            // // return data.toString();
            // JSONObject qdata  = new JSONObject();
            // qdata = jsonService.getJSON(username.get() , qid);

            System.out.println(username +' '+ qid);
            String datastr =  username + String.valueOf(qid);

            JSONObject data = new JSONObject();
            data.put("username", username);
            data.put("qid", qid);
            System.out.println(data);
            // return new ResponseEntity<JSONObject>(data, HttpStatus.OK);
            // return username.get();
            // return data.toString();
            JSONObject qdata  = new JSONObject();
            qdata = jsonService.getJSON(username , qid);


            return qdata.toString();
            
        } else {
            // String status = "error";
            // String msg = "please enter your username (ex: leetcode-stats-api.herokuapp.com/LeetCodeUsername)";
            // return StatsResponse.error(status, msg);
            // System.out.println("ERROR1");
            // JSONObject errmsg = new JSONObject();
            // errmsg.put("error", JSONObject.NULL);

            String infoStr = serviceInfo.getServiceInfo();
            // return new ResponseEntity<JSONObject>(errmsg, HttpStatus.OK);
            // return new String();
            // return errmsg.toString();
            return infoStr;
        }
    }
    // @RequestMapping("/")
    // public String getInfo(){
        
    //     return serviceInfo.getServiceInfo();
    // }
    // @GetMapping(value = {"/" , "/"})
    // public String getInfo(){
        
    //     return serviceInfo.getServiceInfo();
    //     // return new String();
    // }
}

