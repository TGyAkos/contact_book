package org.contact_book;

import dao.UserDataDao;
import model.UserDataModel;
import view.UserDataView;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        //UserDataDao userDataDao = new UserDataDao();
        UserDataView userDataView = new UserDataView();
        UserDataModel userDataModel = new UserDataModel("fas", "asd", "sdf", 2);


        System.out.println(userDataView.inputData());
        //System.out.println(userDataDao.getAllUserDataModel());
        //System.out.println(userDataDao.getUserDataModelByName("fas"));
    }
}