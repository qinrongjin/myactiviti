package cn.tiny77.config;

import cn.tiny77.model.bean.UserDO;
import cn.tiny77.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class DataConfig {

    @Bean(name = "root", autowire = Autowire.BY_NAME)
    public UserDTO getRootUser(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId("0");
        userDTO.setUsername("root");
        userDTO.setFirstName("root");
        userDTO.setLastName("os");
        userDTO.setPassword("root");
        return userDTO;
    }

}
