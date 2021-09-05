export class EducationDegree implements IEducationDegree{

  educationDegreeId: number;
  educationDegreeName: string;

  constructor(educationDegreeId: number, educationDegreeName: string) {
    this.educationDegreeId = educationDegreeId;
    this.educationDegreeName = educationDegreeName;
  }
}

export interface IEducationDegree {
  educationDegreeId: number;
  educationDegreeName: string;
}
