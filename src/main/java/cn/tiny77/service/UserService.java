package cn.tiny77.service;

import cn.tiny77.model.dto.PageDTO;
import cn.tiny77.model.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO checkLogin(UserDTO user);

    List<UserDTO> getUsers(PageDTO pageDTO);

    void postUser(UserDTO userDTO);
}
