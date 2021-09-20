package ar.com.fravega.fravegaChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.fravega.fravegaChallenge.entity.PickupPoint;

@Repository
public interface PickupPointRepository extends JpaRepository<PickupPoint, Long> {

}
