package fr.univparis8.iut.csid.holiday;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<HolidayEntity, Long> {
}
