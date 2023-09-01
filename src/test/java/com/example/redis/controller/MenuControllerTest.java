package com.example.redis.controller;

import com.example.redis.entity.Menu;
import com.example.redis.repository.MenuRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MenuControllerTest {

    @InjectMocks
    private MenuController menuController;

    @Mock
    private MenuRepo menuRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        Menu menu = new Menu(1, "Pizza", 1000L);
        when(menuRepo.save(any(Menu.class))).thenReturn(menu);

        Menu result = menuController.save(menu);

        assertEquals(menu, result);
    }

    @Test
    public void testGetMenus() {
        List<Menu> mockMenus = Arrays.asList(
                new Menu(1, "Pizza", 1000L),
                new Menu(2, "Sushi", 2000L)
        );

        when(menuRepo.findAll()).thenReturn(mockMenus);

        List<Menu> result = menuController.getMenus();

        assertEquals(mockMenus, result);
    }

    @Test
    public void testFindMenuItemById() {
        Menu menu = new Menu(1, "Pizza", 1000L);
        when(menuRepo.findItemById(1)).thenReturn(menu);

        Menu result = menuController.findMenuItemById(1);

        assertEquals(menu, result);
    }

    @Test
    public void testDeleteMenuById() {
        String expectedResult = "Menu deleted successfully !!";
        when(menuRepo.deleteMenu(1)).thenReturn(expectedResult);

        String result = menuController.deleteMenuById(1);

        assertEquals(expectedResult, result);
    }
}
