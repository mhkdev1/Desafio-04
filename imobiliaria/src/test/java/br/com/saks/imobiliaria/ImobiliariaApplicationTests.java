package br.com.saks.imobiliaria;


import br.com.saks.imobiliaria.model.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.yml")
class ImobiliariaApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    void contextLoads() {
    }
    
    @Test
    void createCliente()throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNome("Teste");
        cliente.setSenha("Teste");
        cliente.setEmail("Teste@Teste");
        cliente.setTelefone("Teste");
        mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk());
    }

}
