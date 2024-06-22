let numbers = [2, 5, 12, 13, 15, 18, 22];

function isEven(num) {
    if (num % 2 === 0) {
        console.log(num + 'は偶数です');
    }
}

numbers.forEach(num => isEven(num));







class car{
    constructor(gas,number){
        this.gas = gas;
        this.number = number;
    }
    getNumGas(){
        console.log(`ガソリンは${this.gas}です。ナンバーは${this.number}です。`);
    }
}

let mycar =new car("満タン","う6990");

mycar.getNumGas();
