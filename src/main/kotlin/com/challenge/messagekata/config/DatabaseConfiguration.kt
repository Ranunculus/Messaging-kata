package com.challenge.messagekata.config

import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories(basePackages = ["com.challenge.messagekata.repository"])
class JpaConfiguration
