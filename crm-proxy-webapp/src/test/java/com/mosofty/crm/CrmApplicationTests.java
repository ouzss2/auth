package com.mosofty.crm;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mosofty.crm.model.RegisterUser;






//@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrmApplication.class)
//@WebMvcTest
@AutoConfigureMockMvc
public class CrmApplicationTests {

	

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;
	
	
	
	@SuppressWarnings("deprecation")
	@Before("")
	public void before() {
	    MockitoAnnotations.initMocks(this);
	    MockMvcBuilders.webAppContextSetup(this.context).dispatchOptions(true).build();
	   
	}
	
	@Test
	public void getAllUser() throws Exception 
	{
	  mockMvc.perform( MockMvcRequestBuilders
	      .get("/GetUser")
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print());
	     // .andExpect(status().isOk());
	      //.andExpect(MockMvcResultMatchers.jsonPath("$.users").exists())
	      //.andExpect(MockMvcResultMatchers.jsonPath("$.users[*].id").isNotEmpty());
	}
	
	@Test
	public void getRUserById() throws Exception 
	{
	  mockMvc.perform( MockMvcRequestBuilders
	      .get("/user/{id}", 4)
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print());
	     // .andExpect(status().isOk());
	    //  .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(0));
	}
	@Test
	public void createRUser() throws Exception 
	{
	  mockMvc.perform( MockMvcRequestBuilders
	      .post("/AddUser")
	      .content(asJsonString(new RegisterUser(0, "sam","sam@gmail.com", "sam", "sam", "sam", "sam", "sam", "sam", "sam", "sam", 2, "sam", "sam", "sam", "sam", "sam", 1)))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	    //  .andExpect(MockMvcResultMatchers.jsonPath("$.id",is(0)));
	}
	@Test
	public void deleteRUser() throws Exception 
	{
	  mockMvc.perform( MockMvcRequestBuilders
			  .delete("/delete/{id}", 0) );
	       // .andExpect(status().isAccepted());
	}	 
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	

	
	
	
	
	
}
