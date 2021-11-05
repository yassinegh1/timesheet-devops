package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Mission;

import java.util.List;

@Repository
public interface MissionRepository extends CrudRepository<Mission, Integer> {
    Mission getMissionById(int id);
    List<Mission> getAllMissionById(int id);
    public void deleteMissionById(int id);
}
