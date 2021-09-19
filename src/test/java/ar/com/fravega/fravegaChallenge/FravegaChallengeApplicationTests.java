package ar.com.fravega.fravegaChallenge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import ar.com.fravega.fravegaChallenge.request.BranchRequest;
import ar.com.fravega.fravegaChallenge.request.PickupPointRequest;

@SpringBootTest
@AutoConfigureMockMvc
public class FravegaChallengeApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testaddBranch() throws Exception {
		BranchRequest request = new BranchRequest();

		request.setAddress("locura");
		request.setDateAttention("2021-01-12");
		request.setLatitude("-30");
		request.setLongitude("30");

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(request);

		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/branch")
				.contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	void testaddBranchError() throws Exception {
		BranchRequest request = new BranchRequest();

		request.setAddress("locura");
		request.setDateAttention("2021-01-12");
		request.setLatitude("-30");

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(request);

		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/branch")
				.contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	void testaddPickupPoint() throws Exception {
		PickupPointRequest request = new PickupPointRequest();

		request.setCapacity(100);
		request.setLatitude("-30");
		request.setLongitude("30");

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(request);

		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/pickupPoint")
				.contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testFindNode() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/").param("id", "2")
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
