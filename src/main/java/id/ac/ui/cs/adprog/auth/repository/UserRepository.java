package id.ac.ui.cs.adprog.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import id.ac.ui.cs.adprog.auth.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
    // ini kosong karena inheritnya dari JpaRepository yang sudah ada method-methodnya
}