package xyz.rbulatov.order.service.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import xyz.rbulatov.order.OrderApplication;
import xyz.rbulatov.order.dto.CustomerDTO;
import xyz.rbulatov.order.dto.ProductDTO;

@SpringBootTest(classes = OrderApplication.class)
@AutoConfigureMockMvc
@DisplayName("Тестирование работы контроллеров")
public class ControllerTest {
    private MockMvc mockMvc;

    @Autowired
    public ControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    @DisplayName("Тестирование вывода пользователя по ID")
    public void getCustomerById1() throws Exception {
        this.mockMvc.perform(get("/customers/1", CustomerDTO.class.getName()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Ruslan")));
    }

    @Test
    @DisplayName("Тестирование вывода продукта по ID")
    public void getProductById1() throws Exception {
        this.mockMvc.perform(get("/products/1", ProductDTO.class.getName()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Apple")));
    }

    @Test
    @DisplayName("Тестирование сохранения продукта")
    public void saveProduct() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Nokia");
        this.mockMvc.perform(post("/products/add")
                .contentType(APPLICATION_JSON_UTF8)
                .content((asJsonString(productDTO))))
                .andExpect(status().isCreated());
}

    @Test
    @DisplayName("Тестирование сохранения пользователя")
    public void saveCustomer() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Dru");
        this.mockMvc.perform(post("/products/add")
                .contentType(APPLICATION_JSON_UTF8)
                .content((asJsonString(customerDTO))))
                .andExpect(status().isCreated());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
