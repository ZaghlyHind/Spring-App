package com.example.cvtheque;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5, fileSizeThreshold = 1024 * 1024)
public class MyMultipartConfig {
    // Cette classe configure la gestion des demandes multiparties
}
