import {Parcour} from "./parcour";

export  interface User{
  id: number;
  username: string;
  password: string;
  email: string;
  role: string;
  parcours: Parcour[];
}
