package cn.tiny77.service.impl;

import cn.tiny77.model.dto.UserDTO;
import cn.tiny77.service.UserService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private ProcessEngine processEngine;

    @Override
    public UserDTO checkLogin(UserDTO user) {
        boolean checkPassword = processEngine.getIdentityService().checkPassword(user.getUsername(), user.getPassword());
        if(checkPassword) {
            User queryUser = processEngine.getIdentityService().createUserQuery().userEmail(user.getUsername()).singleResult();
            user.setUsername(queryUser.getEmail());
            user.setName(queryUser.getFirstName() + " " + queryUser.getLastName());
            user.setId(queryUser.getId());
            return user;
        }else{
            return null;
        }
    }
}
