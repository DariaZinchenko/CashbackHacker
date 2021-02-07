package ru.netology.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CashbackHackServiceJUnitJupiterTest {

    CashbackHackService service = new CashbackHackService();

    @Test
    public void remainNegativeAmountTest(){
        assertThrows(IllegalArgumentException.class, () -> service.remain(-1));
    }

    @Test
    public void remainZeroAmountTest(){
        int actual = service.remain(0);
        int expected = 1000;

        assertEquals(actual, expected);
    }

    @Test
    public void remainOneAmountTest(){
        int actual = service.remain(1);
        int expected = 999;

        assertEquals(actual, expected);
    }

    @Test
    public void remainAverageAmountTest(){
        int actual = service.remain(900);
        int expected = 100;

        assertEquals(actual, expected);
    }

    @Test
    public void remainUnderThousandAmountTest(){
        int actual = service.remain(999);
        int expected = 1;

        assertEquals(actual, expected);
    }

    @Test
    public void remainThousandAmountTest(){
        int actual = service.remain(1000);
        int expected = 0;

        assertEquals(actual, expected);
    }

    @Test
    public void remainOverThousandAmountTest(){
        int actual = service.remain(1001);
        int expected = 999;

        assertEquals(actual, expected);
    }

}