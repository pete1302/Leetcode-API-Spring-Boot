package leetcode.api.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import leetcode.api.service.jsonService;
import leetcode.api.service.jsonWriter;
import leetcode.api.service.serviceInfo;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
<<<<<<< Updated upstream
    // @Autowired
    // private StatsService statsService;
    @GetMapping(value = { "/home" , "/" })
    public String home(){
        // JSONObject homeDesc = new JSONObject();
        // serviceInfo.getServiceInfo();
        return "home";
    }

    @GetMapping(value ={"/api/user/{username}/{qid}", "/"} )
    // @GetMapping(path ="/{username}/{qid}" )
    // public ResponseEntity<JSONObject> getStats(@PathVariable Optional<String> username , @PathVariable long qid) {
    // public String getStats(@PathVariable Optional<String> username , @PathVariable int qid) {
    public String getStats(@PathVariable(required = false) String username ,
                         @PathVariable(required = false) Integer qid ) {
        // if (username != null && qid != null && params != null) {
            
        //     System.out.println(username +' '+ qid + ' ' + params) ;+
        //     // String datastr =  username + String.valueOf(qid);
    
        //     JSONObject data = new JSONObject();
        //     data.put("username", username);
        //     data.put("qid", qid);
        //     System.out.println(data);
        //     JSONObject qdata  = new JSONObject();
        //     qdata = jsonService.getJSON(username , qid , params);
        //     return qdata.toString();
            
        // }
        // else if(username != null && qid != null && params == null) {
            
        //     System.out.println( "paramless" +  username +' '+ qid + ' ' + params) ;
    
        //     JSONObject data = new JSONObject();
        //     data.put("username", username);
        //     data.put("qid", qid);
        //     System.out.println(data);
        //     JSONObject qdata  = new JSONObject();
        //     qdata = jsonService.getJSON(username , qid , params);
    
    
        //     return qdata.toString();
        // }
        if (username != null && qid != null ){
            System.out.println(username +' '+ qid ) ;
            // String datastr =  username + String.valueOf(qid);
    
=======

    @GetMapping(value ={"/{username}/{qid}", "/"})

    public String getStats(@PathVariable Optional<String> username , @PathVariable int qid) {
        if (username.isPresent()) {
            System.out.println(username.get() +' '+ qid);

>>>>>>> Stashed changes
            JSONObject data = new JSONObject();
            data.put("username", username);
            data.put("qid", qid);
            System.out.println(data);
            JSONObject qdata  = new JSONObject();
            qdata = jsonService.getJSON(username , qid , null);
            jsonWriter.writer(qdata);
            return qdata.toString();
            
<<<<<<< Updated upstream
=======
        } else {
            System.out.println("ERROR1");
            JSONObject errmsg = new JSONObject();
            errmsg.put("error", JSONObject.NULL);
            return errmsg.toString();
>>>>>>> Stashed changes
        }
         else {

            String infoStr = serviceInfo.getServiceInfo();
            return infoStr;
        }
    }
    @GetMapping(value ={"param/{username}/{params}", "/"})
    // @GetMapping(path ="/{username}/{params}")
    public String getstats_2s(@PathVariable(required = false) String username  ,@PathVariable(required = false) String params) {
        return "in mapping 2";
    }
    @GetMapping(value = { "**"  ,"/" })
    public String wildCard(){
        
        return "redirect:/home";   // ret error json
    }



}

