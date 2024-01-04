package htwberlin.webtech.web;

import htwberlin.webtech.PlantService;
import htwberlin.webtech.web.api.Plant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlantController.class)
public class PlantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlantService service;

    @Test
    public void testGetRoute() throws Exception {
        //Test Daten und Service Mock
        Plant p1 = new Plant("Rose", "3");
        p1.setId(42L);
        when(service.get(42L)).thenReturn(p1);

        //Erwartetes Ergebnis
        String expected = "{\"id\":42,\"name\":\"Rose\",\"duration\":\"3\"}";

        //Aufruf und Vergleich
        this.mockMvc.perform(get("/plants/42"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }
}