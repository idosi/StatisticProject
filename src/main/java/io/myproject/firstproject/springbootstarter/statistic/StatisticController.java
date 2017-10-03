package io.myproject.firstproject.springbootstarter.statistic;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StatisticController {
  @Autowired
  private StatisticsService statService;

  @RequestMapping("/statistic")
  public Statistic getStatistic() {
    return statService.getStatistic();
  }

  @RequestMapping("/statistic/{specificStats}")
  public String getSpecificStatistic(@PathVariable String specificStats) {
    return statService.getSpecificStatistic(specificStats);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/addNumber")
  public void addNumber(@RequestBody Long number) {
    statService.addNumber(number);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/addNumbers")
  public void addNumbers(@RequestBody NumbersWrapper numbers) {
    statService.addNumbers(numbers);
  }

  @RequestMapping("/numbers")
  public List<Long> getAllNumbers() {
    return statService.getAllNumbers();
  }

  @RequestMapping("/count")
  public int getNumberCount() {
    return statService.getNumberCount();
  }
}
