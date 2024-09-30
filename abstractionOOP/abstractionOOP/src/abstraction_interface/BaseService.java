package abstraction_interface;

import java.util.UUID;

public interface BaseService {
    boolean add(Object object);
    void deleteById(UUID id);
}
