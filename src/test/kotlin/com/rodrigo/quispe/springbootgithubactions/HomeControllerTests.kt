package com.rodrigo.quispe.springbootgithubactions

import org.json.JSONObject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun home() {
        val homeController = HomeController()
        val message = homeController.home()
        assertEquals("Hello World!", message["message"])
    }

    @Test
    fun `home controller success`() {
        mockMvc.perform(
            MockMvcRequestBuilders
                .get("/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Hello World!"))
    }

    @Test
    fun `home controller user success`() {
        val body = JSONObject()
            .put("username", "rdquispe")
            .toString()

        mockMvc.perform(
            MockMvcRequestBuilders
                .post("/user")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("rdquispe"))
    }
}
