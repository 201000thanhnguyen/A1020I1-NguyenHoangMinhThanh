export class Student {
  id: number;
  name: string;
  age: number;
  avatar: string;
  scores: number;

  constructor(id: number, name: string, age: number, avatar: string, scores: number) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.avatar = avatar;
    this.scores = scores;
  }

}
