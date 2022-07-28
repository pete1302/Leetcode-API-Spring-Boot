package leetcode.api.service;

import org.json.JSONObject;

/**
 * jsonParse
 */
public class jsonParse {

    public static void jsonParser() {
        JSONObject data = new JSONObject( );
        // data.put("head", "{\"data\":{\"matchedUser\":{\"contributions\":{\"points\":1499},\"profile\":{"skillTags":[],"userAvatar":"https://assets.leetcode.com/users/votrubac/avatar_1610271695.png","jobTitle":"Software Engineer","reputation":59001,"reputationDiff":784,"postViewCount":5222119,"aboutMe":"","solutionCount":1241,"realName":"Vlad","postViewCountDiff":67588,"school":"Kharkiv Air Force University","categoryDiscussCountDiff":0,"solutionCountDiff":8,"ranking":3,"websites":["https://www.linkedin.com/groups/13938406/"],"company":"Google","countryName":"United States","categoryDiscussCount":3},"activeBadge":null}}}");
        


        System.out.println(data.toString());

        
    }
    public static void main(String[] args) {
        jsonParser();
    }
}