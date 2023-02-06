/*
Simplified version of Queue implemented in TypeScript 
Array is already dynamic
*/
// 
interface IQueable {
    enqeueue(value: string): string[];
    dequeue(): any;
    getQueue(): string[];
    size(): number;
}


export class Queue implements IQueable {
    arr: string[];
    // constructor initialization
    constructor() {
        this.arr = [];
    }

    // enqueueing elements into the array
    enqeueue(value: string): string[] {
        this.arr.push(value);
        return this.arr;
    }
    // Return type is any 
    // so it can return the dequeued element and also 
    // a string message if the array is empty
    dequeue(): any {
        
        return this.arr.length === 0 ? 'No tickets in the waiting queue' : this.arr.shift();
    }
    // get the array
    getQueue(): string[] {
        return this.arr;
    }
    // get the number of elements in array
    size(): number {
        return this.arr.length;
    }
}

