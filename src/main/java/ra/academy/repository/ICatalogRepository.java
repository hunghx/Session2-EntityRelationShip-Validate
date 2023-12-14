package ra.academy.repository;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.academy.entity.Catalog;
@Repository
public interface ICatalogRepository extends JpaRepository<Catalog,Long> {

}
