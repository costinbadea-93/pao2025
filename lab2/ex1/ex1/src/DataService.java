public class DataService {

    private DataService() {}

    private final class SINGLETON_HOLDER {
        private static final DataService INSTANCE = new DataService();
    }

    public static DataService getInstance() {
        return SINGLETON_HOLDER.INSTANCE;
    }

    /**
     * rest of code
     */
}
