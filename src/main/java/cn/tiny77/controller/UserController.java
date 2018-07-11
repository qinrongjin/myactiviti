package cn.tiny77.controller;

import cn.tiny77.constant.SessionKey;
import cn.tiny77.model.dto.PageDTO;
import cn.tiny77.model.dto.UserDTO;
import cn.tiny77.model.vo.UserVO;
import cn.tiny77.service.UserService;
import cn.tiny77.util.QBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    @Qualifier(value = "root")
    private UserDTO root;

    @GetMapping("/login")
    public String loginGet(){
        return "user/login";
    }

    @PostMapping("/login")
    public String loginPost(HttpServletRequest request, UserDTO user){
        if(user.getUsername().equals("root") && user.getPassword().equals("root")){
            request.getSession().setAttribute(SessionKey.USER_KEY, root);
            return "index";
        }
        user = userService.checkLogin(user);
        if(user != null){
            request.getSession().setAttribute(SessionKey.USER_KEY, user);
            return "index";
        }else{
            return "user/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute(SessionKey.USER_KEY);
        return "index";
    }

    @GetMapping("/list")
    public String list(Model model, PageDTO pageDTO){
        List<UserDTO> userDTOS = userService.getUsers(pageDTO);
        List<UserVO> users = QBeanUtils.getConvertedBean(userDTOS, UserVO.class);
        model.addAttribute("users", users);
        return "user/list";
    }

}
