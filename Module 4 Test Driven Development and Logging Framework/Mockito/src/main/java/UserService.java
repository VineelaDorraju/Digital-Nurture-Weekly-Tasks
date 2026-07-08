public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String fetchUser() {
        return repository.getName();
    }

    public void save(String name) {
        repository.saveUser(name);
    }
}
