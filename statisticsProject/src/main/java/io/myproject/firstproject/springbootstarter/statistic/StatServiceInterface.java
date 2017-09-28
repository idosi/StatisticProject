package io.myproject.firstproject.springbootstarter.statistic;

import java.util.List;

public interface StatServiceInterface
{
	Statistic getStatistic();
	String getSpecificStatistic(String specificStats);
	void addNumber(String number);
	List<Integer> getAllNumbers();
	int getNumberCount();
	void addNumbers(NumbersWrapper numbers);
}
