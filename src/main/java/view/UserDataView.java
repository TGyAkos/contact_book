package view;

import model.UserDataModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserDataView {

    public void mainMenu() {

        System.out.println("1. - Enter new record");
        System.out.println("2. - Show records");

        switch (inputInt()) {

            case 1 -> inputData();
            case 2 -> showDataMenu();
            default -> System.out.println("No such Option");

        }
    }

    public void showDataMenu() {

        System.out.println("1. - Show all records");
        System.out.println("2. - Search by name");

        switch (inputInt()) {

            case 1 -> inputData();
            case 2 -> searchByName();
            default -> System.out.println("No such Option");

        }
    }

    private void searchByName() {

        System.out.println("Enter the name");

        System.out.println();

    }

    public UserDataModel inputData() {

        UserDataModel userDataModel = new UserDataModel();

        System.out.println("Input Name");
        userDataModel.setName(inputNonNull());

        System.out.println("Input Mother's name");
        userDataModel.setName(inputNonNull());

        System.out.println("Input Email");
        userDataModel.setName(inputNonNull());

        System.out.println("Input Phone number");
        userDataModel.setPhoneNumber(inputInt());

        return userDataModel;
    }

    public String inputNonNull() {

        String result = "";

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (result.isEmpty()) {

            try {
                result = bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println(e);
            }

            if (result.isEmpty()){
                System.out.println("Enter again");
            }
        }

        return result;
    }

    public int inputInt() {

        int result = 0;

        while (result == 0) {

            try {
                int integer = Integer.parseInt(inputNonNull());
                if (integer > 0) {
                    result = integer;
                }

            } catch (NumberFormatException e) {
                System.out.println("Enter a number");
            }
        }

        return result;
    }
}
