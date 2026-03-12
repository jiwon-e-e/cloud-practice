package com.example.membermanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test") // 테스트용 프로파일을 분리합니다.
class MemberManagementApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void healthEndpointReturnsUp() throws Exception {
        // Actuator/health 대신 아주 간단한 컨트롤러를 테스트하거나,
        // Actuator가 실행되도록 설정 오류를 방지해야 합니다.
        mockMvc.perform(get("/actuator/health"))
                .andExpect(status().isOk());
    }
}