import {FileHandler} from "./FileHandler";
import {TuringMachine} from "./TuringMachine";

const jsonObject = FileHandler.readFile('./src/turing-machine.json');

const turingMachines = TuringMachine.convertFromJson(jsonObject);