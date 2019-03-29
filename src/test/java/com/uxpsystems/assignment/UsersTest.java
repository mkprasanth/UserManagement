package com.uxpsystems.assignment;


import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.google.gson.Gson;
import com.uxpsystems.assignment.dao.Status;
import com.uxpsystems.assignment.dao.User;
import com.uxpsystems.assignment.service.UserRepository;


@ComponentScan(basePackages = "com.uxpsystems.assignment")
@RunWith(SpringRunner.class)
@WebMvcTest
public class UsersTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	UserRepository userRepo;

	@WithMockUser(value = "user")
	@Test
	public void testRetrieveUsers()  throws Exception{
		
		mockMvc.perform(get("/users")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@WithMockUser(value="user")
	@Test
	public void testCreateUser()  throws Exception{
		
		User user=new User(1,"Manu", "ManuP", Status.DEACTIVATED);
		when(userRepo.save(any(User.class))).thenReturn(user);
		
		mockMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(user))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(header().string("location", containsString("/users/1")));
			}
	
	@WithMockUser(value="user")
	@Test
	public void testUpdateUser()  throws Exception{
		
		
		User user=new User(1,"Manu", "ManuP", Status.DEACTIVATED);
		when(userRepo.save(any(User.class))).thenReturn(user);
		
		mockMvc.perform(put("/users/id/"+user.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(user))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(header().string("location", containsString("/users/id/1")));
			}
	
	@WithMockUser(value="user")
	@Test
	public void testDeleteUser()  throws Exception{		
				
		mockMvc.perform(delete("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
			}


}
