import {FileHandler} from "./FileHandler";
import {TuringMachine} from "./TuringMachine";

interface NextStep {
    state: string;
    write: string;
    goTo: string;
}

const jsonObject = FileHandler.readFile('./turing-machine.json');
const turingMachine = TuringMachine.convertFromJson(jsonObject);

/*
*   Separa funcao de transicao em duas partes (antes e depois de ->)
*   @param {string} - Funcao de transicao da maquina de turing na forma de string. Exemplo:
*       (q0, 0) -> (q1, 1, R)
*
*   @return {string[]} - Array resultante do split da funcao de transicao. Exemplo:
*       [(q0, 0), (q1, 1, R)]
* */
export const separateByArrow = (transitionFunction: string): string[] => {
    return transitionFunction.split(" -> ");
}

/*
*   Formata a funcao de transicao no formato definido pela interface NextStep
*   @param {string] - o lado direito de uma funcao de transição na forma de uma string. Exemplo:
*       '(q1, 1, R)'
*
*   @return {NextStep} - lado direito da funcao de transicao formatado no tipo NextStep. Exemplo:
*       {state: 'q1', write: '1', goTo: 'R'}
* */
export const formatTransitionFunction = (separatedByArrowRightSide?: string): NextStep => {

    if (!separatedByArrowRightSide) {
        return {state: '', write: '', goTo: ''};
    }

    const cutParenthesesRight = separatedByArrowRightSide.substring(1, 9);
    const separateRightByComma = cutParenthesesRight.split(', ');

    return {state: separateRightByComma[0], write: separateRightByComma[1], goTo: separateRightByComma[2]}
}

/*
*   Constroi um map da funcao de transicao da maquina de turing
*   @transitionFunction {string[]} -  Funcao de transicao da maquina de turing. Exemplo:
*   ['(q0, 0) -> (q1, 1, R)', '(q1, 1) -> (q0, 0, R)']
*
*   @return {Map<string, string} - Retorna um map da funcao de transicao. Exemplo:
*       Map(2) {
*           key:'(q0, 0)' => value:'(q1, 1, R)',
*           key:'(q1, 1)' => value:'(q0, 0, R)'
*       }
*/
export const mapTransitionFunction = (transitionFunction: string[]): Map<string, string> => {
    const transitionFunctionMap: Map<string, string> = new Map<string, string>();

    for (let j = 0; j < transitionFunction.length; j++) {

        const separateByArrowResult = separateByArrow(transitionFunction[j]);
        transitionFunctionMap.set(separateByArrowResult[0], separateByArrowResult[1]);
    }

    return transitionFunctionMap;
}

export const runTuringMachine = (turingMachine: TuringMachine, word: string): void => {
    const transitionFunctionMap = mapTransitionFunction(turingMachine.transitionFunction);
    let acceptWord: boolean = true;
    let actualState = turingMachine.initialState;
    const wordArray = word.split('');
    wordArray.push('B');

    console.log(`Input: ${word}`);

    for (let i = 0; i < wordArray.length; i++) {
        const char = wordArray[i];


        const rightSide = transitionFunctionMap.get(`(${actualState}, ${char})`);

        if(rightSide === undefined){
            acceptWord = false;
            break;
        }

        const transitionFunctionFormatted = formatTransitionFunction(rightSide);

        const {state, write, goTo} = transitionFunctionFormatted!;

        actualState = state!;
        wordArray[i] = write!;

        if (goTo === 'L') i -= 2;
    }

    const formattedOutput = wordArray.toString()
        .replace(/,/g, '')          //Retira as virgulas da resposta
        .substring(0, wordArray.length - 1);               //Retira o caractere B da resposta

    console.log(`Result: ${acceptWord ? 'Accepted' : 'Rejected'}`);

    console.log(`Output: ${formattedOutput}`);
}

runTuringMachine(turingMachine, '010');