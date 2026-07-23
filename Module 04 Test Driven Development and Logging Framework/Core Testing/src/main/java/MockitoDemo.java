public class MockitoDemo {

    private RepositoryMock repository;
    public MockitoDemo(RepositoryMock repository) {
        this.repository = repository;
    }
    public String displayUser() {
        return repository.getUserName();
    }

}