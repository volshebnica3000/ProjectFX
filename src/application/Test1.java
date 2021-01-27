package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test1 {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testSignInn() {
		Boolean realUserExists = true;
		Boolean getUserExists = Authorization.SignInn("user09", "9999");
		assertEquals(realUserExists, getUserExists);
	}
	
	@Test
	final void testSignIn() {
		Boolean realUserExists = false;
		Boolean getUserExists = Authorization.SignInn("user199", "99989");
		assertEquals(realUserExists, getUserExists);
	}
	
	@Test
	final void testAddUser() {
		int i = ManageUsers.addUser("user22", "123456");
		int Exp = 1;
		assertEquals(Exp, i);
	}
	
	@Test
	final void testUpdateUser() {
		int i = ManageUsers.updateUser("654321", "user22");
		int Exp = 1;
		assertEquals(Exp, i);
	}
	
	@Test
	final void testDeleteUser() {
		int i = ManageUsers.deleteUser("user22");
		int Exp = 1;
		assertEquals(Exp, i);
	}
	
	@Test
	final void testAboutUser() {
		String get = ManageUsers.aboutUser("user09");
		assertEquals("Логин пользователя: user09\nПароль пользователя: 9999",get);
	}
//	@Test
//	final void testAddWorker() {
//		int i = ManageWorkers.addWorker("Veronica", "trainer", "3", "2", "uru");
//		int Exp = 1;
//		
//		assertEquals(Exp, i);
//	}
//	
//	@Test
//	final void testUpdateWorker(){
//		int exp = 1;
//		int i = ManageWorkers.updateWorker("Veronica PP", "new", "1", "1", "uru");
//		assertEquals(exp, i);
//	}
//	
	
	
	@Test
	final void testAboutWorker() {
		String get = ManageWorkers.aboutWorker("Yuri Plisetsky");
		assertEquals("ФИО: Yuri Plisetsky\nДолжность: electrician\nРазряд: 2\nУчастие в профсоюзе: не состоит в профсоюзе\nЛогин: user02",get);
	}
	
	@Test
	final void testAboutPay() {
		String get = Pay.aboutPay("Otabek Altin");
		assertEquals("ФИО: Otabek Altin\nЗаработная плата: 18596\nНачислено: 19600\nУдержано: 1100\nВсего выплачено: 30364", get);
	}
	
//	@Test
//	final void testAddPay() {
//		int exp = 1;
//		int i  = Pay.addPay("Veronica PP", "2200", "2222", "56", "55665");
//		assertEquals(exp, i);
//	}
//	
//	@Test
//	final void testUpdatePay() {
//		int exp = 1;
//		int i  = Pay.updatePay("1", "2", "3", "4", "Veronica PP");
//		assertEquals(exp, i);
//	}
//	
//	
//	@Test
//	final void testDeletePay() {
//		int i = Pay.deletePay("Veronica PP", "1");
//		int exp = 1;
//		assertEquals(exp, i);
//	}
	
	@Test
	final void testAboutTariff(){
		String get = Tariff.aboutTariff("3");
		assertEquals("Разряд: 3\nКоэффициент: 1.9", get);
		String get2 = Tariff.aboutTariff("5");
		assertEquals("Разряд: 5\nКоэффициент: 2.8", get2);
	}
}
