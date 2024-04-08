package ulster.cybersecurity.org.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ulster.cybersecurity.org.model.CryptoKey;

public interface CryptoKeyRepository extends MongoRepository<CryptoKey, String> {
}
