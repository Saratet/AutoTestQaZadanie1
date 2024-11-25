package ru.netology.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class CashbackHackServiceTest {

    @Test
    //Проверка с суммой менее 1000
    public void shouldCountRemain() {
    CashbackHackService service = new CashbackHackService();
    int amount = 522;

    int actual = service.remain(amount);
    int expected = 478;

    assertEquals(expected, actual);
    }

    @Test
    //Проверка с суммой более 1000
    public void shouldResetCountRemaimFromMoreThanThousandValue() {
        CashbackHackService service = new CashbackHackService();
        int amount = 4623;

        int actual = service.remain(amount);
        int expected = 377;

        assertEquals(expected, actual);
    }

    @Test
    //Проверка уведомления о достижении максимального кэшбека при покупке на 1000
    public void shouldResetCountToZero() {
        CashbackHackService service = new CashbackHackService();
        int amount = 1000;

        int actual = service.remain(amount);
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    //Проверка с наименьшим граничным значением
    public void shouldCountRemainWithCloseToCashbackValueLess() {
        CashbackHackService service = new CashbackHackService();
        int amount = 999;

        int actual = service.remain(amount);
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    //Проверка с наибольшим граничным значением
    public void shouldCountRemainWithCloseToCashbackValueMore() {
        CashbackHackService service = new CashbackHackService();
        int amount = 1001;

        int actual = service.remain(amount);
        int expected = 999;

        assertEquals(expected, actual);
    }
}