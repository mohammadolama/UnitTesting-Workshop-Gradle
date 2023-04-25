package TDD;

public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String name, String lastname, String email) {

        if (name == null || name.trim().length()==0){
            throw new IllegalArgumentException("name must not be empty!");
        }
        if (lastname == null || lastname.trim().length() == 0){
            throw new IllegalArgumentException("lastname must not be empty!");
        }
        User user = new User(name , lastname , email);

        try {
            boolean save = userRepository.save(user);
            if (!save){
                throw new RuntimeException("User not saved.");
            }

            return user;
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            throw e;
        }

    }

}
