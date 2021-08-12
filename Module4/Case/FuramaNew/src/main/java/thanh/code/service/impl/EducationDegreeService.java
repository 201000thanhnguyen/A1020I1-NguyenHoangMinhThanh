package thanh.code.service.impl;

import org.springframework.stereotype.Service;
import thanh.code.models.EducationDegree;
import thanh.code.repository.IEducationDegreeRepository;
import thanh.code.service.IEducationDegreeService;

import java.util.List;

@Service
//@Component("EducationDegreeService")
public class EducationDegreeService implements IEducationDegreeService {

    final IEducationDegreeRepository educationDegreeRepository;

    public  EducationDegreeService(IEducationDegreeRepository educationDegreeRepository){
        this.educationDegreeRepository = educationDegreeRepository;
    }
    @Override
    public List<EducationDegree> listEntity() {
        return this.educationDegreeRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(EducationDegree educationDegree) {
        this.educationDegreeRepository.save(educationDegree);
    }

    @Override
    public void removeEntity(EducationDegree educationDegree) {
        this.educationDegreeRepository.delete(educationDegree);
    }

    @Override
    public EducationDegree findByIdInt(int id) {
        return this.educationDegreeRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<EducationDegree> educationDegreeIterable() {
        return this.educationDegreeRepository.findAll();
    }
}
