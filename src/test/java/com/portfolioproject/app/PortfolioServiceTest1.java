package com.portfolioproject.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.portfolioproject.model.User;
import com.portfolioproject.service.PortfolioService;

class PortfolioServiceTest {

    private PortfolioService service;
    private User user;

    @BeforeEach
    void setUp() {
        service = new PortfolioService();
        user = new User("U101", "Poornima", "poornima@gmail.com");
    }

    @Test
    void testAddUser() {
        service.addUser(user);

        assertTrue(service.userExists("U101"));
    }

    @Test
    void testUserExists() {
        service.addUser(user);

        assertTrue(service.userExists("U101"));
        assertFalse(service.userExists("U102"));
    }

    @Test
    void testGetUser() throws Exception {
        service.addUser(user);

        User result = service.getUser("U101");

        assertEquals("U101", result.getUserid());
        assertEquals("Poornima", result.getName());
        assertEquals("poornima@gmail.com", result.getEmail());
    }

    @Test
    void testGetAllUsers() {
        service.addUser(user);

        assertEquals(1, service.getAllUsers().size());
    }

    @Test
    void testGetUserNotFound() {
        assertThrows(Exception.class, () -> service.getUser("U999"));
    }

    @Test
    void testValidateStockValidData() {
        assertDoesNotThrow(() -> service.validateStock(10, 100.0));
    }

    @Test
    void testValidateStockInvalidQuantity() {
        assertThrows(Exception.class,
                () -> service.validateStock(0, 100.0));
    }

    @Test
    void testValidateStockInvalidPrice() {
        assertThrows(Exception.class,
                () -> service.validateStock(10, 0.0));
    }
}