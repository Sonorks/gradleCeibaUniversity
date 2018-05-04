package co.ceiba.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.ceiba.domain.Person;
import co.ceiba.testdatabuilder.PersonTestDataBuilder;

public class NotifyPersonServiceTest {

	private NotifyPersonService notifyPersonService;
	private EmailService emailService;
	
	@Before
	public void setup() {
		emailService = new EmailService();
		notifyPersonService = new NotifyPersonService(emailService);
	}
	
	@Test
	public void notifyTest() {
		//Arrange
		emailService = Mockito.mock(EmailService.class);
		Mockito.when(emailService.sendMail(Mockito.anyString())).thenReturn("Hola mundo");
		Person person = new PersonTestDataBuilder().build();
		//Act
		String message = notifyPersonService.notify(person);
		//Assert
		Assert.assertNotNull(message);
	}
}
