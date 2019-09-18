package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepo;

	@Autowired
	DistilleryRepository distilleryRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findAllWhiskysByYear() {
		List<Whisky> found = whiskyRepo.findAllWhiskiesByYear(1995);
		assertEquals("The Macallan Anniversary Malt", found.get(0).getName());
	}

	@Test
	public void findAllDistilleriesByRegion() {
		List<Distillery> found = distilleryRepo.findAllDistilleriesByRegion("Highland");
		assertEquals("Glendronach", found.get(0).getName());
	}

	@Test
	public void findAllWhiskyFromDistilleryByAge() {
		List<Whisky> found = whiskyRepo.findAllWhiskiesFromDistilleryByAge(1L, 15);
		assertEquals("The Glendronach Revival", found.get(0).getName());
	}

	@Test
	public void findAllWhiskysByRegion() {
		List<Whisky> found = whiskyRepo.findAllWhiskiesByRegion("Lowland");
		assertEquals("The Rosebank 12 - Flora and Fona", found.get(0).getName());
	}

	@Test
	public void findAllDistilleriesWith12YearOldWhiskies() {
		List<Distillery> found = distilleryRepo.findAllDistilleriesWith12YearOldWhiskies();
		assertEquals(2, found.size());
	}

}
