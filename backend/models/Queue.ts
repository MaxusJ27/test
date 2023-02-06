// tsc index.ts 
// 
interface IQueable {
    enqeueue(value: String): String[];
    dequeue(): any;
    getQueue(): String[];
    size(): number;
}


export class Queue implements IQueable {
    arr: String[];

    constructor() {
        // constructor initialization 
        this.arr = [];
    }


    enqeueue(value: String): String[] {
        this.arr.push(value);
        return this.arr;
    }

    dequeue(): any {
        
        return this.arr.length === 0 ? 'No tickets in the waiting queue' : this.arr.shift();
    }

    getQueue(): String[] {
        return this.arr;
    }
    size(): number {
        return this.arr.length;
    }
}

// let newQueue = new Queue();
// newQueue.enqeueue('10');
// newQueue.enqeueue('10');
// newQueue.enqeueue('10');
// console.log(newQueue.getQueue());
// console.log(newQueue.dequeue());
// console.log(newQueue.dequeue());
// console.log(newQueue.getQueue());
// console.log(newQueue.size())


