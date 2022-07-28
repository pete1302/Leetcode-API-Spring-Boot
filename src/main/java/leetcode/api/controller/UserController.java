package leetcode.api.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import leetcode.api.service.jsonService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @GetMapping(value = { "/home", "/" })
    public String home() {

        return "home";
    }

    @GetMapping(value = { "api/user/{username}/{qid}", "/" })

    public String getStats(@PathVariable Optional<String> username, @PathVariable int qid) {
        if (username.isPresent()) {

            System.out.println(username.get() + ' ' + qid);

            JSONObject data = new JSONObject();
            data.put("username", username.get());
            data.put("qid", qid);
            System.out.println(data);

            JSONObject qdata = new JSONObject();
            qdata = jsonService.getJSON(username.get(), qid);

            return qdata.toString();

        } else {

            System.out.println("ERROR1");
            JSONObject errmsg = new JSONObject();
            errmsg.put("error", JSONObject.NULL);

            return errmsg.toString();
        }
    }

    @GetMapping(value = { "param/{username}/{params}", "/" })
    public String getstats_2s(@PathVariable(required = false) String username,
            @PathVariable(required = false) String params) {
        return "in mapping 2";
    }

    @GetMapping(value = { "**", "/" })
    public String wildCard() {

        return "redirect:/home";
    }
}