package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> searchProducts(Integer ram, Integer hdd, Double cpuSpeed, String os) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        Root<Product> product = cq.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();

        if (ram != null) {
            predicates.add(cb.equal(product.get("ram"), ram));
        }
        if (hdd != null) {
            predicates.add(cb.equal(product.get("hdd"), hdd));
        }
        if (cpuSpeed != null) {
            predicates.add(cb.greaterThanOrEqualTo(product.get("cpuSpeed"), cpuSpeed));
        }
        if (os != null && !os.isEmpty()) {
            predicates.add(cb.equal(product.get("os"), os));
        }

        cq.select(product).where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }
}
