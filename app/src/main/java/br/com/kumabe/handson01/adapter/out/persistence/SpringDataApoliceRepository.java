package br.com.kumabe.handson01.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kumabe.handson01.adapter.out.persistence.entity.ApoliceEntity;

@Repository
public interface SpringDataApoliceRepository extends JpaRepository<ApoliceEntity, Integer> {
}
