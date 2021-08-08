package tn.esprit.students.Models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends MongoRepository<Movement, String> {

}
