package io.myproject.firstproject.springbootstarter.statistic;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.myproject.firstproject.springbootstarter.statistic.StatisticController;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StatisticServiceTest extends TestCase {
  @Autowired
  private StatisticController controller;

  @Test
  public void checkNumIsNullTest() {
    assertThat(controller.getStatistic()).isNull();
  }

  @Test
  public void checkNumIsEqualTest() {
    controller.addNumber("2");
    controller.addNumber("2");
    assertEquals(2, controller.getNumberCount());
    controller.getStatistic().getNumberList().clear();
  }

  @Test
  public void checkNumIsNotEqualTest() {
    controller.addNumber("2");
    controller.addNumber("3");
    assertNotEquals(3, controller.getNumberCount());
    controller.getStatistic().getNumberList().clear();
  }

  @Test
  public void checkGetSumTest() {
    controller.addNumber("2");
    controller.addNumber("3");
    assertEquals("Sum = 5.0", controller.getSpecificStatistic("sum"));
    controller.getStatistic().getNumberList().clear();
  }

  @Test
  public void checkGetAvgTest() {
    controller.addNumber("2");
    controller.addNumber("4");
    controller.addNumber("6");
    assertEquals("Average = 4.0", controller.getSpecificStatistic("average"));
    controller.getStatistic().getNumberList().clear();
  }

  @Test
  public void checkGetMedianTest() {
    controller.addNumber("2");
    controller.addNumber("3");
    controller.addNumber("5");
    assertEquals("Median = 3", controller.getSpecificStatistic("median"));
    controller.getStatistic().getNumberList().clear();
  }
}
