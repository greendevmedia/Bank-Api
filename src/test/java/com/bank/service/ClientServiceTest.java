package com.bank.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bank.feature.client.ClientService;
import com.bank.feature.client.IClientDao;
import com.bank.model.Client;
import com.bank.util.TestEntityProvider;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
public class ClientServiceTest {

	@Mock
	private IClientDao clientDao;

	private ClientService clientService;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		clientService = new ClientService(clientDao);
	}

	@Test
	public void shouldFindAll() {
		Mockito.when(clientDao.findAll()).thenReturn(TestEntityProvider.CLIENT_LIST);
		final List<Client> result = clientService.findAll();
		Mockito.verify(clientDao).findAll();
		assertEquals(TestEntityProvider.CLIENT_LIST.size(), result.size());
	}

	@Test
	public void shouldGetOne() {
		Mockito.when(clientDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.CLIENT_CORRECT);
		final Client client = clientService.getOne(Matchers.anyLong());
		Mockito.verify(clientDao).getOne(Matchers.anyLong());
		assertEquals(TestEntityProvider.CLIENT_CORRECT.getEmail(), client.getEmail());
	}

	@Test
	public void shouldDelete() {
		Mockito.doNothing().when(clientDao).delete(Matchers.any(Client.class));
		clientService.delete(TestEntityProvider.CLIENT_CORRECT);
		Mockito.verify(clientDao).delete(Matchers.any(Client.class));
	}

	@Test
	public void shouldSave() {
		Mockito.when(clientDao.save(TestEntityProvider.CLIENT_CORRECT)).thenReturn(TestEntityProvider.CLIENT_CORRECT);
		clientService.save(TestEntityProvider.CLIENT_CORRECT);
		Mockito.verify(clientDao).save(TestEntityProvider.CLIENT_CORRECT);
	}
}
