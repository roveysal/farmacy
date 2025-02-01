package uz.pdp.farmacy.repository;

import uz.pdp.farmacy.data.Customers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CustomersRepository extends CrudRepository<Customers, Integer> {
    @Query("select c from Customers c order by c.name")
    List<Customers> findAllOrderByCategory();

}
