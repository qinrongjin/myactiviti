package cn.tiny77.service.impl;

import cn.tiny77.model.dto.PageDTO;
import cn.tiny77.model.dto.UserDTO;
import cn.tiny77.service.UserService;
import cn.tiny77.util.QBeanUtils;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            user.setFirstName(queryUser.getFirstName());
            user.setLastName(queryUser.getLastName());
            user.setId(queryUser.getId());
            return user;
        }else{
            return null;
        }
    }

    @Override
    public List<UserDTO> getUsers(PageDTO pageDTO) {
        List<User> users = processEngine.getIdentityService().createUserQuery().orderByUserEmail().listPage(pageDTO.getOffset(), pageDTO.getPageSize());
        return QBeanUtils.getConvertedBean(users, UserDTO.class, (o1, o2)->{
            o1.setUsername(o2.getEmail());
            o1.setId(o2.getId());
        });
    }
}
