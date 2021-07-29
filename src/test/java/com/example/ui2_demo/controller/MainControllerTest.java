package com.example.ui2_demo.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MainControllerTest extends AbstractControllerTest{
    @Autowired
    private MainController mainController;

    @Override
    protected Object controller() {
        return mainController;
    }


    @Test
    public void getIndex() throws Exception {
        mockMvc.perform(get("/"))
        .andExpect(status().isOk());
    }

    @Test
    public void getBoards() throws Exception {
        // TODO
    }

    @Test
    public void postBoard() throws Exception {
        // TODO
    }

    @Test
    public void updateBoard() throws Exception {
        // TODO
    }

    @Test
    public void deleteBoard() throws Exception {
        // TODO
    }
}
