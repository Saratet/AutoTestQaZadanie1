package ru.netology.service;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CashbackHackServiceTest {

    @Test
        //Проверка с суммой менее 1000
    void shouldCountRemain() {
        CashbackHackService service = new CashbackHackService();
        int amount = 522;

        int actual = service.remain(amount);
        int expected = 478;

        Assert.assertEquals(actual, expected);
    }

    @Test
        //Проверка с суммой более 1000
    void shouldResetCountRemaimFromMoreThanThousandValue() {
        CashbackHackService service = new CashbackHackService();
        int amount = 4623;

        int actual = service.remain(amount);
        int expected = 377;

        Assert.assertEquals(actual, expected);
    }

    @Test
        //Проверка уведомления о достижении максимального кэшбека при покупке на 1000
    void shouldResetCountToZero() {
        CashbackHackService service = new CashbackHackService();
        int amount = 1000;

        int actual = service.remain(amount);
        int expected = 0;

        Assert.assertEquals(actual, expected);
    }

    @Test
        //Проверка с наименьшим граничным значением
    void shouldCountRemainWithCloseToCashbackValueLess() {
        CashbackHackService service = new CashbackHackService();
        int amount = 999;

        int actual = service.remain(amount);
        int expected = 1;

        Assert.assertEquals(actual, expected);
    }

    @Test
        //Проверка с наибольшим граничным значением
    void shouldCountRemainWithCloseToCashbackValueMore() {
        CashbackHackService service = new CashbackHackService();
        int amount = 1001;

        int actual = service.remain(amount);
        int expected = 999;

        Assert.assertEquals(actual, expected);
    }
}