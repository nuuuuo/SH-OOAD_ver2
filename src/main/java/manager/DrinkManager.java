package manager;

import controller.DrinkController;
import data.Drink;
import db.DBManager;
import db.DrinkDBManager;

import java.util.*;

public class DrinkManager {

    private List<Drink> menuList;

    public DrinkManager() {
        this.menuList = reqAmountOfDrink();
    }

    public Boolean hasDrink(String drinkType, int drinkNum) {
        // TODO implement here
        DrinkDBManager drinkDBManager = DrinkDBManager.getManager();
        return drinkDBManager.hasDrink(drinkType, drinkNum);
    }

    public Drink getDrink(String drinkType, int drinkNum) {
        // TODO implement here
        DrinkDBManager drinkDBManager = DrinkDBManager.getManager();
        return drinkDBManager.getDrink(drinkType, drinkNum);
    }

    public List<Drink> getMenuInfo() {
        // TODO implement here
        return menuList;
    }///////////getMenuInfo의 리턴값을 void -> List<Drink>로 변경

    public int getDrinkQuantity(String drinkType) {
        // TODO implement here
        DrinkDBManager drinkDBManager = DrinkDBManager.getManager();
        return drinkDBManager.getDrinkQuantity(drinkType);
    }///////////getDrinkQuantity의 리턴값을 void -> int로 변경

    public boolean manageDrink(String drinkType, int drinkNum) {    // drinkNum 얘가 양수던 음수던 보내주게 함
        // TODO implement here
        DrinkDBManager drinkDBManager = DrinkDBManager.getManager();
        return drinkDBManager.setDrink(drinkType, drinkNum);
    }///////////manageDrink 파라미터 drinkNum의 타입을 String -> int로 변경
    ///////////manageDrink 리턴값을 void -> boolean 변경

    public List<Drink> reqAmountOfDrink() {
        // TODO implement here
        DrinkDBManager drinkDBManager = DrinkDBManager.getManager();
        this.menuList = drinkDBManager.getAllDrinkStatus();
        return menuList;
    }

}



//////////지금까지 5개 고침. DrinkManager getMenuInfo, DrinkManager getDrinkQuantity, AdminDBManager checkUser, DrinkManager manageDrink, DrinkManager manageDrink

///////AdminAccountManager logout 질문
