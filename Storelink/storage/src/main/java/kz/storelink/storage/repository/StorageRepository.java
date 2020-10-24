package kz.storelink.storage.repository;

import kz.storelink.storage.model.Storage;
import kz.storelink.storage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {

    Optional<Storage> getByUser(User user);

}
