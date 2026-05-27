package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ArithServiceTest {

  @InjectMocks private ArithService service;

  @Test
  void add_shouldReturnCorrectSum() {
    assertEquals(5.0, service.add(2.0, 3.0));
  }

  @Test
  void add_withNegativeA_shouldThrow() {
    assertThrows(IllegalArgumentException.class, () -> service.add(-1.0, 3.0));
  }

  @Test
  void add_withNegativeB_shouldThrow() {
    assertThrows(IllegalArgumentException.class, () -> service.add(3.0, -1.0));
  }

  @Test
  void add_withZeroB_shouldThrow() {
    assertThrows(IllegalArgumentException.class, () -> service.add(3.0, 0.0));
  }

  @Test
  void add_withNegativeBAndZeroB_shouldThrowBothMessages() {
    IllegalArgumentException e =
        assertThrows(IllegalArgumentException.class, () -> service.add(-1.0, 0.0));
    assertTrue(e.getMessage().contains("a and b cannot be negative"));
    assertTrue(e.getMessage().contains("nonsense to provide b as 0"));
  }

  @Test
  void sub_shouldReturnCorrectDifference() {
    assertEquals(2.0, service.sub(5.0, 3.0));
  }

  @Test
  void sub_whenResultIsNegative_shouldStillCompute() {
    assertEquals(-1.0, service.sub(2.0, 3.0));
  }

  @Test
  void sub_withNegativeA_shouldThrow() {
    assertThrows(IllegalArgumentException.class, () -> service.sub(-5.0, 2.0));
  }

  @Test
  void sub_withZeroB_shouldThrow() {
    assertThrows(IllegalArgumentException.class, () -> service.sub(4.0, 0.0));
  }

  @Test
  void multiply_shouldReturnCorrectProduct() {
    assertEquals(12.0, service.multiply(3.0, 4.0));
  }

  @Test
  void multiply_withZeroB_shouldThrow() {
    assertThrows(IllegalArgumentException.class, () -> service.multiply(5.0, 0.0));
  }

  @Test
  void multiply_withNegativeA_shouldThrow() {
    assertThrows(IllegalArgumentException.class, () -> service.multiply(-2.0, 4.0));
  }

  @Test
  void divide_shouldReturnCorrectQuotient() {
    assertEquals(2.0, service.divide(6.0, 3.0));
  }

  @Test
  void divide_byZero_shouldThrow() {
    assertThrows(IllegalArgumentException.class, () -> service.divide(5.0, 0.0));
  }

  @Test
  void divide_withNegativeA_shouldThrow() {
    assertThrows(IllegalArgumentException.class, () -> service.divide(-6.0, 3.0));
  }

  @Test
  void divide_withNegativeAndZero_shouldThrowBothMessages() {
    IllegalArgumentException e =
        assertThrows(IllegalArgumentException.class, () -> service.divide(-2.0, 0.0));
    assertTrue(e.getMessage().contains("a and b cannot be negative"));
    assertTrue(e.getMessage().contains("Cannot divide by 0"));
  }
}
