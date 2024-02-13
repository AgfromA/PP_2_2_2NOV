package web.service;

import java.util.List;

import web.model.User;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
    public UserDao userDao;


    @Autowired
    public void UserServicelmpl(UserDao userDao) {

        this.userDao = userDao;
    }
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);
    }

    @Transactional
    @Override
    public void updateUser(int id, User updateUser) {
        userDao.updateUser(id, updateUser);
    }
}

