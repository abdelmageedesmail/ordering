package com.abdelmageed.ordering.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream
import java.io.IOException

@Configuration
class FirebaseConfig {
    @Bean
    fun initializeFirebase(): FirebaseApp {
        try {
            val serviceAccount = this.javaClass.classLoader.getResourceAsStream("serviceAccountKey.json")
                ?: throw RuntimeException("Service account key not found!")
            val options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build()
            return FirebaseApp.initializeApp(options)
        } catch (e: IOException) {
            throw RuntimeException("Failed to initialize Firebase", e)
        }
    }
}