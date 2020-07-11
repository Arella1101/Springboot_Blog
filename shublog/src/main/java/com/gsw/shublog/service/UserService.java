package com.gsw.shublog.service;

import com.gsw.shublog.po.User;

public interface UserService {

    User checkUser(String username, String password);
}
