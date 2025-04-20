package com.puretech.payment;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MathUtilsTest {

    @Test
    void testMockStaticMethod() {
        try (MockedStatic<MathUtils> mock = mockStatic(MathUtils.class)) {
            mock.when(() -> MathUtils.doubleIt(5)).thenReturn(99);

            int result = MathUtils.doubleIt(5);
            assertEquals(99, result);
        }
    }
}