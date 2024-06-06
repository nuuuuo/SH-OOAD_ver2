package db;

import data.Drink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class DrinkDBManagerTest {

    private final DrinkDBManager manager = DrinkDBManager.getManager();

    @Test
    public void testHasDrink() {
        // 재고가 있는 음료 테스트
        Assertions.assertTrue(manager.hasDrink("콜라", 1));
        // 재고가 없는 음료 테스트
        Assertions.assertFalse(manager.hasDrink("밀크티", 100));
    }

    @Test
    public void testGetDrink() {
        // 재고가 충분한 경우
        Drink drink = manager.getDrink("사이다", 1);
        Assertions.assertNotNull(drink);
        Assertions.assertEquals("사이다", drink.getDrinkName());
        // 재고가 부족한 경우
        drink = manager.getDrink("콜라", 100);
        Assertions.assertNull(drink);
    }

    @Test
    public void testGetDrinkQuantity() {
        // 특정 음료의 재고 수량 확인
        int quantity = manager.getDrinkQuantity("녹차");
        Assertions.assertEquals(10, quantity);
    }

    @Test
    public void testSetDrink() {
        // 음료 재고 갱신 테스트
        boolean result = manager.setDrink("사이다", 7);
        Assertions.assertTrue(result);
        // 존재하지 않는 음료 갱신 테스트
        result = manager.setDrink("오렌지주스", 3);
        Assertions.assertFalse(result);
    }

    @Test
    public void testGetAllDrinkStatus() {
        // 모든 음료의 재고 현황 확인
        List<Drink> drinks = manager.getAllDrinkStatus();
        Assertions.assertEquals(7, drinks.size());
        // 첫 번째 음료 확인
        Drink firstDrink = drinks.get(0);
        Assertions.assertEquals(1, firstDrink.getId());
        Assertions.assertEquals("콜라", firstDrink.getDrinkName());
    }

    @Test
    public void testGetMenuList() {
        // 전체 메뉴 목록 확인
        List<Drink> menuList = manager.getMenuList();
        Assertions.assertEquals(20, menuList.size());
        // 첫 번째 메뉴 확인
        Drink firstMenu = menuList.get(0);
        Assertions.assertEquals(1, firstMenu.getId());
        Assertions.assertEquals("콜라", firstMenu.getDrinkName());
    }
}
