package controller;

import dao.UserDataDao;
import view.UserDataView;

public class UserDataController {

    UserDataView userDataView = new UserDataView();
    UserDataDao userDataDao = new UserDataDao();

    public void initializeView() {

        userDataView.mainMenu();

    }
    //Implement events and listeners CUS IT'S THE RIGHT WAY TO DO IT
    public

}