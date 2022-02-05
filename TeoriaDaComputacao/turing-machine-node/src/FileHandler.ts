import * as fs from "fs";

export class FileHandler {

    public static readFile(file: string): any[] {
        return JSON.parse( fs.readFileSync(file, 'utf-8'));
    }

}