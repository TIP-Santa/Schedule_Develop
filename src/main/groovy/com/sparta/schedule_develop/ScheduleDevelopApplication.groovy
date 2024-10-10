package com.sparta.schedule_develop

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing


@EnableJpaAuditing
@SpringBootApplication
class ScheduleDevelopApplication {

    static void main(String[] args) {
        SpringApplication.run(ScheduleDevelopApplication, args)
    }

}
