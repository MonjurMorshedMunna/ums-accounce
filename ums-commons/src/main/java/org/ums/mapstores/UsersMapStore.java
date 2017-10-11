package org.ums.mapstores;

import com.hazelcast.core.MapStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ums.entities.Users;
import org.ums.repositories.UserRepositories;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UsersMapStore  implements MapStore<String, Users>{

    @Autowired
    UserRepositories userRepositories;

    @Override
    public void store(String key, Users value) {
        userRepositories.save(value);
    }

    @Override
    public void storeAll(Map<String, Users> map) {
        userRepositories.save(map.values());
    }

    @Override
    public void delete(String key) {
        Users user = load(key);
        userRepositories.delete(user);
    }

    @Override
    public void deleteAll(Collection<String> keys) {
        Iterable<Users> users = userRepositories.findAll(keys);
        userRepositories.delete(users);
    }

    @Override
    public Users load(String key) {
        return userRepositories.getOne(key);
    }

    @Override
    public Map<String, Users> loadAll(Collection<String> keys) {
        Iterable<Users> users = userRepositories.findAll(keys);
        return StreamSupport.stream(users.spliterator(),false)
                .collect(Collectors.toMap(Users::getUserId, Function.identity()));
    }

    @Override
    public Iterable<String> loadAllKeys() {
        Iterable<Users> users = userRepositories.findAll();
        return StreamSupport.stream(users.spliterator(),false)
                .map(Users::getUserId)
                .collect(Collectors.toList());
    }
}
