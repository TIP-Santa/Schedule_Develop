package com.sparta.schedule;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;



@SpringBootTest
@AutoConfigureMockMvc
class ScheduleApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGlobalExceptionHandler() throws Exception {
        mockMvc.perform(get("/api/test/error"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorMessage").value("테스트용 오류 발생!"))
                .andExpect(jsonPath("$.statusCode").value(400));
    }
}
