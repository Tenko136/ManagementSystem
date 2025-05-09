package kz.tenko.BankCard.ManagementSystem;

import kz.tenko.BankCard.ManagementSystem.DAO.CardDAO;
import kz.tenko.BankCard.ManagementSystem.DAO.UserDAO;
import kz.tenko.BankCard.ManagementSystem.DTO.FindCardsRequestDTO;
import kz.tenko.BankCard.ManagementSystem.service.CardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class CardTests {

    CardServiceImpl underTest;
    UserDAO userDAO;
    CardDAO cardDAO;

    @BeforeEach
    public void setUp() {
        userDAO = Mockito.mock(UserDAO.class);
        cardDAO = Mockito.mock(CardDAO.class);
        underTest = new CardServiceImpl(cardDAO, userDAO);

    }

    @Test
    public void findCardsForAdminTest() {
        Authentication authentication = Mockito.mock(Authentication.class);
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
        Mockito.when(authentication.getAuthorities()).thenReturn((Collection) grantedAuthorities);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        underTest.findCards(new FindCardsRequestDTO());

        verify(cardDAO, times(1)).findCards(Mockito.any(FindCardsRequestDTO.class));
    }


}