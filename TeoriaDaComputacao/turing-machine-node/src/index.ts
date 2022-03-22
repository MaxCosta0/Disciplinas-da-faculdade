import {FileHandler} from "./FileHandler";
import {TuringMachine} from "./TuringMachine";

interface NextStep {
    state: string;
    write: string;
    goTo: string;
}

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
    let now: string = '';
    let index: number = 0;
    const wordArray = word.split('');

    console.log(turingMachine);

    console.log(`Input: ${word}`);

    for (index = 0; index < wordArray.length; index++) {

        let readChar: string;

        if(index < 0 ){
            readChar = 'B';
        }else {
            readChar = wordArray[index];
            wordArray[index] = `(${actualState})` + wordArray[index];       //  '0' -> '(q0)0'
        }

        // readChar = wordArray[index];

        now = wordArray.toString()                                      //  ['(q0)0', '1', '0'] -> (q0)010
            .replace(/,/g, '');

        process.stdout.write(now + " -| ");

        const rightSide = transitionFunctionMap.get(`(${actualState}, ${readChar})`);

        if(rightSide === undefined){            //Se nao existe esta funcao de transição
            wordArray[index] = readChar;
            index++;
            break;
        }

        const transitionFunctionFormatted = formatTransitionFunction(rightSide);
        const {state, write, goTo} = transitionFunctionFormatted!;

        actualState = state!;
        wordArray[index] = write!;

        if (goTo === 'L') index -= 2;
    }

    let formattedOutput: string;

    if(!turingMachine.finalStates.includes(actualState)){       //Se nao parou em um estado final
        acceptWord = false;

        formattedOutput = wordArray.toString()
            .replace(/,/g, '')          //Retira as virgulas da resposta

        console.log();
    }else{

        formattedOutput = wordArray.toString()
            .replace(/,/g, '')          //Retira as virgulas da resposta

        index--;
        const char = wordArray[index];
        wordArray[index] = wordArray[index] +  `(${actualState})`;

        console.log(wordArray.toString()
            .replace(/,/g, ''));        //Formata a ultima saida da maquina

    }

    console.log(`Result: ${acceptWord ? 'Accepted' : 'Rejected'}`);

    console.log(`Output: ${formattedOutput}`);
}

//Inicio do programa
const jsonObject = FileHandler.readFile('./turing-machine.json');
const turingMachine = TuringMachine.convertFromJson(jsonObject);

runTuringMachine(turingMachine, '11011011B');