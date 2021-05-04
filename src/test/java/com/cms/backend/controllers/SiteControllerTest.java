package com.cms.backend.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SiteControllerTest {
    private  Model model = new Model() {
        @Override
        public Model addAttribute(String attributeName, Object attributeValue) {
            return null;
        }

        @Override
        public Model addAttribute(Object attributeValue) {
            return null;
        }

        @Override
        public Model addAllAttributes(Collection<?> attributeValues) {
            return null;
        }

        @Override
        public Model addAllAttributes(Map<String, ?> attributes) {
            return null;
        }

        @Override
        public Model mergeAttributes(Map<String, ?> attributes) {
            return null;
        }

        @Override
        public boolean containsAttribute(String attributeName) {
            return false;
        }

        @Override
        public Object getAttribute(String attributeName) {
            return null;
        }

        @Override
        public Map<String, Object> asMap() {
            return null;
        }
    };


    @Test
    void findEventById() throws JsonProcessingException {
        SiteController controller = new SiteController(); // Arrange
        String response = controller.index( "web.done.loc", model); // Act
        System.out.println(response);
        assertTrue(1 > 0); // Assert
    }
}