"use strict";
exports.__esModule = true;
exports.Queue = void 0;
var Queue = /** @class */ (function () {
    function Queue() {
        // constructor initialization 
        this.arr = [];
    }
    Queue.prototype.enqeueue = function (value) {
        this.arr.push(value);
        return this.arr;
    };
    Queue.prototype.dequeue = function () {
        return this.arr.shift();
    };
    Queue.prototype.getQueue = function () {
        return this.arr;
    };
    Queue.prototype.size = function () {
        return this.arr.length;
    };
    return Queue;
}());
exports.Queue = Queue;
// let newQueue = new Queue();
// newQueue.enqeueue('10');
// newQueue.enqeueue('10');
// newQueue.enqeueue('10');
// console.log(newQueue.getQueue());
// console.log(newQueue.dequeue());
// console.log(newQueue.dequeue());
// console.log(newQueue.getQueue());
// console.log(newQueue.size())
