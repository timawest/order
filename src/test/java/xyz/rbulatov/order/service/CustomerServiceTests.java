package xyz.rbulatov.order.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.rbulatov.order.dto.CustomerDTO;
import xyz.rbulatov.order.mapper.CustomerMapper;
import xyz.rbulatov.order.service.CustomerService;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTests {

	private final CustomerService customerService;
	private final CustomerMapper customerMapper;

	@Autowired
	public CustomerServiceTests(CustomerService customerService, CustomerMapper customerMapper) {
		this.customerService = customerService;
		this.customerMapper = customerMapper;
	}

	@Test
	@DisplayName("Тестирование создание пользователя")
	@Transactional
		public void testCreate(){
		CustomerDTO customerDTO=new CustomerDTO();
		customerDTO.setName("TestName");
		customerService.create(customerDTO);
		assertNotNull(customerService.getCustomerByName("TestName"));
		assertNull(customerService.getCustomerByName("Test2Name"));
	}
	@Test
	@DisplayName("Тестирование вывода всех пользователей")
	@Transactional
	public void testReadAll(){
		List<CustomerDTO> list=customerMapper.toCustomerDTOs(customerService.getAllCustomer());
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	@DisplayName("Тестирование вывода пользователя по id")
	@Transactional
	public void testRead(){
		CustomerDTO customerDTO = customerMapper.toCustomerDTO(customerService.getCustomerById(1L).get());
		assertEquals("Ruslan", customerDTO.getName());
	}
	@Test
	@DisplayName("Тестирование обновления пользователя")
	@Transactional
	public void testUpDate(){
		CustomerDTO customerDTO=new CustomerDTO();
		customerDTO.setName("TestName");
		customerService.create(customerDTO);
		CustomerDTO customerDTO1 = customerMapper.toCustomerDTO(customerService.getCustomerByName("TestName"));
		customerDTO.setName("TeStName2");
		customerService.save(customerDTO, customerDTO1.getId());
		CustomerDTO customerDTO2 = customerMapper.toCustomerDTO(customerService.getCustomerByName("TeStName2"));
		assertEquals("TeStName2", customerDTO2.getName());
	}
	@Test
	@DisplayName("Тестирование удаления пользователя по id")
	@Transactional
	public void testDelete () {
		CustomerDTO customerDTO=new CustomerDTO();
		customerDTO.setName("TestName");
		customerService.create(customerDTO);
		CustomerDTO customerDTO1=customerMapper.toCustomerDTO(customerService.getCustomerByName("TestName"));
		customerService.deleteById(customerDTO1.getId());
		assertNull(customerService.getCustomerByName("TestName"));
	}
}