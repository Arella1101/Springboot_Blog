package com.gsw.shublog.service;

import com.gsw.shublog.dao.UserRepository;
import com.gsw.shublog.po.User;
import com.gsw.shublog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password){
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));

        return user;

    }

}
