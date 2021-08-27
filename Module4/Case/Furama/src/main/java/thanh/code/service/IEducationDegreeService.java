package thanh.code.service;

import thanh.code.models.EducationDegree;

public interface IEducationDegreeService extends ICRUDService<EducationDegree> {
    // for tag select option client
    Iterable<EducationDegree> educationDegreeIterable();
}
