package leetcode.api.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String getStats(@PathVariable(required = false) String username , @PathVariable(required = false) Integer qid , @PathVariable(required = false) String params) {
        if (username != null && qid != null) {

            System.out.println(username +' '+ qid + ' ' + params) ;
            // String datastr =  username + String.valueOf(qid);

            JSONObject data = new JSONObject();
            data.put("username", username);
            data.put("qid", qid);
            System.out.println(data);
            JSONObject qdata  = new JSONObject();
            qdata = jsonService.getJSON(username , qid , params);


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

