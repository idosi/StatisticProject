package io.myproject.firstproject.springbootstarter.statistic;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StatisticController
{	
	@Autowired
	private StatisticService statService;
	
	@RequestMapping("/statistic")
	public Statistic getStatistic()
	{
		return statService.getStatistic();
	}
	
	@RequestMapping("/statistic/{id}")
	public String getSpecificStatistic(@PathVariable String id)
	{
		return statService.getSpecificStatistic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addNumber")
	public void addNumber(@RequestBody String number){
		statService.addNumber(number);
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="/addNumbers")
//	public void addNumbers(@RequestBody List<String> numbers){
//		statService.addNumbers(numbers);
//	}
	
	@RequestMapping("/numbers")
	public List<Integer> getAllNumbers()
	{	
		return statService.getAllNumbers();
	}
	
	@RequestMapping("/count")
	public String getNumberCount()
	{	
		return statService.getNumberCount();
	}
}
