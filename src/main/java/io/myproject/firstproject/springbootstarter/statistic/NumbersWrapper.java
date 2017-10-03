package io.myproject.firstproject.springbootstarter.statistic;

import java.util.List;

public class NumbersWrapper {
  private List<Long> numbers;

  public NumbersWrapper(List<Long> numbers) {
    this.numbers = numbers;
  }

  public List<Long> getNumbers() {
    return numbers;
  }
}
