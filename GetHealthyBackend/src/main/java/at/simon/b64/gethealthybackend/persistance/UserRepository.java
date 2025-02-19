package at.simon.b64.gethealthybackend.persistance;

import at.simon.b64.gethealthybackend.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
