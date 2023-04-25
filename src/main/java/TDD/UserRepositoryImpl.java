package TDD;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    Map<String , User> map = new HashMap<>();

    @Override
    public boolean save(User user) {

        boolean isSaved = false;

        if (!map.containsKey(user.name)){
            map.put(user.name , user);
            isSaved = true;
        }

        return isSaved;

    }
}
