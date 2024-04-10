package mg.inclusiv.controller;

import mg.inclusiv.entity.Tache;
import mg.inclusiv.entity.Utilisateur;
import mg.inclusiv.service.TacheService;
import mg.inclusiv.service.UserDetailsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class HomeControllerTest {

    @InjectMocks
    private HomeController homeController;

    @Mock
    private TacheService tacheService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHome() {
        // Mocking UserDetailsImpl and its associated user
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);

        UserDetailsImpl userDetails = new UserDetailsImpl();

        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null);
        SecurityContextHolder.getContext().setAuthentication(auth);

        // Mocking behavior of TacheService
        List<Tache> taches = new ArrayList<>();
        // Add some dummy tasks for testing
        taches.add(new Tache());
        taches.add(new Tache());

        when(tacheService.getAllTaches(1L)).thenReturn(taches);

        // Mocking behavior of Model
        Model model = mock(Model.class);

        // Call home method
        String result = homeController.home(model);

        // Verify that getAllTaches is called with the correct user ID
        verify(tacheService, times(1)).getAllTaches(1L);

        // Verify that taches attribute is added to the model
        verify(model, times(1)).addAttribute("taches", taches);

        // Verify that the correct view is returned
        assertEquals("index.html", result);
    }
}
