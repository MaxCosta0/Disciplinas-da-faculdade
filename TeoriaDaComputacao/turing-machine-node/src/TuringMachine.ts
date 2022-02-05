export class TuringMachine {
    private states: string[] | undefined;
    private alphabet: string[] | undefined;
    private symbols: string[] | undefined;
    private transitionFunction: string[] | undefined;
    private initialState: string | undefined;
    private blankSymbol: string | undefined;
    private finalStates: string[] | undefined;


    public static convertFromJson(jsonEntries: any[]): TuringMachine[] {
        const turingMachines: TuringMachine[] = new Array<TuringMachine>();

        jsonEntries.forEach(jsonEntry => {
            const turingMachine: TuringMachine = new TuringMachine();

            turingMachine.states = jsonEntry.states;
            turingMachine.alphabet = jsonEntry.alphabet;
            turingMachine.symbols = jsonEntry.symbols;
            turingMachine.transitionFunction = jsonEntry.transitionFunction;
            turingMachine.initialState = jsonEntry.initialState;
            turingMachine.blankSymbol = jsonEntry.blankSymbol;
            turingMachine.finalStates = jsonEntry.finalStates;

            turingMachines.push(turingMachine);
        });

        return turingMachines;
    }
}