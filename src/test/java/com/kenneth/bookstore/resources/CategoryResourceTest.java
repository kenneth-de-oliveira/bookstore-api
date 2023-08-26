package com.kenneth.bookstore.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenneth.bookstore.domain.dto.CategoryDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class CategoryResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void find_whenToGetId_returns200() throws Exception {

        mockMvc.perform(get("/category/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty());

    }

    @Test
    void findAll_whenSuccess_returns200() throws Exception {

        mockMvc.perform(get("/category"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));

    }

    @Test
    void create_whenToGetCategory_returns201() throws Exception {

        mockMvc.perform(post("/category")
                .content(getCategory())
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$").isNotEmpty());

    }

    @Test
    void update_whenToGetIdAndCategory_returns200() throws Exception {

        mockMvc.perform(put("/category/2")
                        .content(getCategory())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty());

    }

    @Test
    void delete_whenToGetId_returns204() throws Exception {

        mockMvc.perform(delete("/category/1"))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$").doesNotExist());

    }

    private String getCategory() throws JsonProcessingException {
        var categoryDTO = new CategoryDTO();
        categoryDTO.setName("Informatica");
        categoryDTO.setDescription("Livros de TI");
        return objectMapper.writeValueAsString(categoryDTO);
    }


}