package TDD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    String name;
    String lastname;
    String email;




    @BeforeEach
    void setUp() {
        name = "Mojtaba";
        lastname = "Olama";
        email = "olama@mail.com";
        // password
        // repeatedPassword
    }

    @Test
    @DisplayName("create user")
    public void testCreateUser_whenDetailsAreProvided_returnUserObject() {
        // Arrange / init

//        Mockito.when(userRepository.save(Mockito.any(User.class)))
//                .thenReturn(true);
        long id = 123;

        Mockito.when(userRepository.save(Mockito.any(User.class)))
                .then(invocation -> {
                    User argument = invocation.getArgument(0, User.class);
                    argument.id = id;
                    System.out.println(argument);
                    return true;
                });


        //  Act
        User user = userService.createUser(name, lastname, email);

        // Assert
        assertNotNull(user);
        assertEquals(name, user.getName());
        assertEquals(email , user.getEmail());
        assertEquals(id , user.getId());
    }

    @Test
    @DisplayName("create user")
    public void testCreateUser_whenUsernameIsEmpty_throwException() {
        // Arrange / init
        String name = "";
        String exceptionError = "name must not be empty!";

        //  Act
        // Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            User user = userService.createUser(name, lastname, email);
        });

        assertEquals(exceptionError, exception.getMessage());

    }

    @Test
    @DisplayName("create user")
    public void testCreateUser_whenLastnameIsEmpty_throwException() {
        // Arrange / init
        String lastname = "";
        String exceptionError = "lastname must not be empty!";

        //  Act
        // Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            User user = userService.createUser(name, lastname, email);
        });

        assertEquals(exceptionError, exception.getMessage());

    }

    @Test
    public void testCreateUser_whenMockThrowException_throwException() {
        // Arrange / init
        String exceptionError = "a";

        Mockito.when(userRepository.save(Mockito.any(User.class)))
                .thenThrow(new RuntimeException(exceptionError));
        //  Act
        // Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            User user = userService.createUser(name, lastname, email);
        });

        assertEquals(exceptionError, exception.getMessage());

    }


}
