import {User} from "./user";
import {Step} from "./step";



export interface Parcour {
  id: number;
  title: string;
  description: string;
  users: User[];
  steps: Step[];
}
