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
public class StatisticServiceTest  extends TestCase
{	
	@Autowired
	private StatisticController controller;
	
	@Test
    public void checkNumIsNullTest()
    {
        assertThat(controller.getStatistic()).isNull();
    }
	
	@Test
    public void checkNumIsEqualTest()
    {
		controller.getStatistic().getNumberList().clear();
		controller.addNumber("2");
		controller.addNumber("2");
        assertEquals(2, controller.getNumberCount());
    }
	
	@Test
    public void checkNumIsNotEqualTest()
    {
		controller.getStatistic().getNumberList().clear();
		controller.addNumber("2");
		controller.addNumber("3");
		assertNotEquals(6, controller.getSpecificStatistic("sum"));
    }
}
