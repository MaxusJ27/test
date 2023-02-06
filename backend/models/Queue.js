"use strict";
exports.__esModule = true;
exports.Queue = void 0;
var Queue = /** @class */ (function () {
    // constructor initialization
    function Queue() {
        this.arr = [];
    }
    // enqueueing elements into the array
    Queue.prototype.enqeueue = function (value) {
        this.arr.push(value);
        return this.arr;
    };
    // Return type is any 
    // so it can return the dequeued element and also 
    // a string message if the array is empty
    Queue.prototype.dequeue = function () {
        return this.arr.length === 0 ? 'No tickets in the waiting queue' : this.arr.shift();
    };
    // get the array
    Queue.prototype.getQueue = function () {
        return this.arr;
    };
    // get the number of elements in array
    Queue.prototype.size = function () {
        return this.arr.length;
    };
    return Queue;
}());
exports.Queue = Queue;
