package org.ds.practice.api;

import org.ds.practice.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class UserController {

    private final static List<User> userList = new LinkedList<>();

    @GetMapping("/users")
    public String getUserList(
            @RequestParam(value = "name", required = false) final String name,
            @RequestParam(value = "part", required = false) final String part){

//        if(name.equals(name))
//            return userList.toString();
//        if(part.equals(part))
//            return userList.toString();
//        else
//            return "없습니다.";

        if(userList.size()==0)
            return "없습니다.";
        else
            return userList.toString();
    }

    @GetMapping("/users/{user_idx}")
    public String getUserList_Idx(@PathVariable(value = "user_idx") final int user_idx) {
        return "없습니다.";
    }

    @PostMapping("/users")
    public String postUserList(@RequestBody final User user) {
        userList.add(user);
        return user.getName()+"저장했습니다.";
    }

    @PutMapping("/users/{user_idx}")
    public String putUserList(
            @PathVariable(value = "user_idx") final int user_idx,
            @RequestBody final User user) {
                userList.remove(user);
                userList.add(userList.size(),user);
                return "삭제하고 다시 저장했습니다.";
    }


    @DeleteMapping("/users/{user_idx}")
    public String deleteUserList(@PathVariable(value = "user_idx") final int user_idx) {
        userList.remove(userList);
        return "다 삭제해 버렸다^^";
    }

}
