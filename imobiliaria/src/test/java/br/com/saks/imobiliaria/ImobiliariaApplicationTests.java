package br.com.saks.imobiliaria;


import br.com.saks.imobiliaria.model.Administrador;
import br.com.saks.imobiliaria.model.Cliente;
import br.com.saks.imobiliaria.model.Imovel;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
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
//    @Test
//    void create2Cliente()throws Exception {
//        Cliente cliente = new Cliente();
//        cliente.setNome("Teste 2");
//        cliente.setSenha("Teste 2");
//        cliente.setEmail("Teste@Teste2");
//        cliente.setTelefone("Teste2");
//        mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(cliente)))
//                .andExpect(status().isOk());
//    }
//    
    @Test
    void getCliente() throws Exception {
       mockMvc.perform(MockMvcRequestBuilders.get("/clientes")
       .contentType(MediaType.APPLICATION_JSON))
       .andExpect(status().isOk());
   } 
    
    @Test
    void alteraCliente() throws Exception {
       Cliente cliente = new Cliente();
       cliente.setNome("Alterado");
       cliente.setSenha("TestaAlterado");
       cliente.setEmail("Testa@Alterado");
       cliente.setTelefone("Testa alterado");
       mockMvc.perform(MockMvcRequestBuilders.put("/clientes/{id}",3)
       .contentType(MediaType.APPLICATION_JSON)
       .content(objectMapper.writeValueAsString(cliente)))
       .andExpect(status().isOk());
   }
    
    @Test
    void deletaCliente() throws Exception {
         mockMvc.perform(MockMvcRequestBuilders.delete("/clientes/{id}",4)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createImovel() throws Exception {
        Imovel imovel = new Imovel();
        imovel.setTitulo("Teste2dddd");
        imovel.setDescricao("Teste2ddddd");
        imovel.setDataCriacao(new Date());
        imovel.setValor(20204);
        imovel.setStatus(1);
        mockMvc.perform(MockMvcRequestBuilders.post("/imoveis")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(imovel)))
                .andExpect(status().isOk());
    }

   @Test
   void getImovel() throws Exception {
       mockMvc.perform(MockMvcRequestBuilders.get("/imoveis")
       .contentType(MediaType.APPLICATION_JSON))

       .andExpect(status().isOk());
   } 
    
   @Test
   void alteraImovel() throws Exception {
       Imovel imovel = new Imovel();
       imovel.setTitulo("Alterado imovel");
       imovel.setDataCriacao(new Date());
       imovel.setDescricao("imovel legal");
       imovel.setValor(3030);
       imovel.setStatus(1);
       mockMvc.perform(MockMvcRequestBuilders.put("/imoveis/{id}",3)
       .contentType(MediaType.APPLICATION_JSON)
       .content(objectMapper.writeValueAsString(imovel)))
       .andExpect(status().isOk());
   }
    
    @Test
    void deletaImovel() throws Exception {
         mockMvc.perform(MockMvcRequestBuilders.delete("/imoveis/{id}",4)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
   
    @Test
    void createAdministrador()throws Exception {
        Administrador administrador = new Administrador();
        administrador.setNome("TesteCriado");
        administrador.setSenha("TesteCriado");
        administrador.setEmail("Teste@TesteCriado");
        administrador.setStatus(0);
        mockMvc.perform(MockMvcRequestBuilders.post("/administradores")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(administrador)))
                .andExpect(status().isOk());
    }
    
    @Test
    void getAdministrador() throws Exception {
       mockMvc.perform(MockMvcRequestBuilders.get("/administradores")
       .contentType(MediaType.APPLICATION_JSON))
       .andExpect(status().isOk());
   } 
    
    @Test
    void alteraAdministrador() throws Exception {
       Administrador administrador = new Administrador();
       administrador.setNome("TestaPonto");
       administrador.setSenha("TestaLararirara");
       administrador.setEmail("Teste@Testaaaaaaaaa");
       administrador.setStatus(0);
       mockMvc.perform(MockMvcRequestBuilders.put("/administradores/{id}",2)
       .contentType(MediaType.APPLICATION_JSON)
       .content(objectMapper.writeValueAsString(administrador)))
       .andExpect(status().isOk());
   }
    
    @Test
    void deletaAdministrador() throws Exception {
         mockMvc.perform(MockMvcRequestBuilders.delete("/administradores/{id}",1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
