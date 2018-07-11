package cn.tiny77.service;

import cn.tiny77.model.dto.UserDTO;

public interface UserService {
    UserDTO checkLogin(UserDTO user);
}
