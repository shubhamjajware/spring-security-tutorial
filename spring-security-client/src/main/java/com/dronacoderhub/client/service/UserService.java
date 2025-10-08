package com.dronacoderhub.client.service;

import com.dronacoderhub.client.entity.User;
import com.dronacoderhub.client.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);
}
