package com.laplaz.reginfo;

import static org.junit.Assert.*;

import org.junit.Test;

public class HomeControllerTest {

	@Test
	public void test() {
		HomeController homeController = new HomeController();
		assertNotNull("Kein Home Controlller", homeController);
	}

}
