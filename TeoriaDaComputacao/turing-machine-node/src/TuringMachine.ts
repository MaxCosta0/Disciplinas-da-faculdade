export class TuringMachine {
    public states: string[];
    public alphabet: string[];
    public symbols: string[];
    public transitionFunction: string[];
    public initialState: string;
    public blankSymbol: string;
    public finalStates: string[];

    public static convertFromJson(jsonEntry: any): TuringMachine {
        const turingMachine = new TuringMachine();

        turingMachine.states = jsonEntry.states;
        turingMachine.alphabet = jsonEntry.alphabet;
        turingMachine.symbols = jsonEntry.symbols;
        turingMachine.transitionFunction = jsonEntry.transitionFunction;
        turingMachine.initialState = jsonEntry.initialState;
        turingMachine.blankSymbol = jsonEntry.blankSymbol;
        turingMachine.finalStates = jsonEntry.finalStates;

        return turingMachine
    }
}