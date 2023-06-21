import { GeneroEnum } from "../enum/GeneroEnum";
import { Persona } from "./Persona";

export class Cliente extends Persona{
  clienteId?: number;
  contrasenia?: string;
  estado?: boolean;
}
