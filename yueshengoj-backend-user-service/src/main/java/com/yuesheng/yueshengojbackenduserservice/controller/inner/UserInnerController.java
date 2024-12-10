package com.yuesheng.yueshengojbackenduserservice.controller.inner;

import com.yuesheng.yueshengojbackendmodel.model.entity.User;
import com.yuesheng.yueshengojbackendserviceclient.service.UserFeignClient;
import com.yuesheng.yueshengojbackenduserservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @Author: Dai
 * @Date: 2024/12/09 16:37
 * @Description: UserInnerController
 * @Version: 1.0
 */
@RestController
@RequestMapping("/inner")
public class UserInnerController implements UserFeignClient {

    @Resource
    private UserService userService;
    /**
     * 根据id获取用户
     * @param userId
     * @return
     */
    @Override
    @GetMapping("/get/id")
    public User getById(@RequestParam("userId") Long userId){
        return userService.getById(userId);
    }

    /**
     * 根据id集合获取用户列表
     * @param idList
     * @return
     */
    @Override
    @GetMapping("get/ids")
    public List<User> listByIds(@RequestParam("idList") Collection<Long> idList){
        return userService.listByIds(idList);
    }
}
