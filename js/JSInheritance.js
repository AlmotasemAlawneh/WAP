/* jshint esversion: 6 */
/* jshint browser: true */

(() => {
    "use strict";
/*
1-Create a function expression named createBicyclePrototye which returns an object literal with one property speed set to value 0 and two methods
    -applyBrake that takes a parameter and decrement the current speed of the object by that given value.
    -speedup that takes a parameter increment current speed by given value.
*/
function createBicyclePrototye() {
    return {
        speed: 0,
        applyBrake: function (decrement) {
            this.speed -= decrement;
        },
        speedup: function (increment) {
            this.speed += increment;
        }
    };
}

/* 2-Create another function expression named createMountainBikeProtoype  
     that take a prototype parameter and returns an object created using Object.create (prototype)with one additional 
     property gear set to value 1 and one additional method setGear which takes a parameter and sets gear value for the object. */
     function createMountainBikeProtoype(prototype) {
        const obj = Object.create(prototype);
        obj.gear = 1;
        obj.setGear = function (currGear) {
            this.gear = currGear;
        };

        return obj;
    }

    /*3-Write third function expression named start that first make bicyclePrototype object using first function and then mountainBikePrototype object using second function,
     passing bicyclePrototype as argument and play with it (do some console.logs) to see if its working as intended.
      4-Now create some objects from both bicyclePrototype and mountainBikePrototype using Object.create() and play with it. (do some console.log)
    */
   function start() {
    var textArea = document.getElementById("textArea");

    let bicyclePrototype = createBicyclePrototye();
    let mountainBikePrototype = createMountainBikeProtoype(bicyclePrototype);
    let bikeList = [
        Object.create(bicyclePrototype),
        Object.create(bicyclePrototype),
        Object.create(mountainBikePrototype),
        Object.create(mountainBikePrototype)
    ];

    for (let i = 0; i < 5; i++) {
        textArea.value += `speed up \n`;
        for (let bike of bikeList) {
            bike.speedup(i);
            textArea.value += `${bike.speed} \n`;
        }
        textArea.value += `speed down \n`;
        for (let bike of bikeList) {
            if(bike.speed != 0)
            bike.applyBrake(i-1);
            textArea.value += `${bike.speed} \n`;
        };
        textArea.value += `change gear\n`;
        for (let bike of bikeList) {
            if (bike.__proto__ == mountainBikePrototype) {
                bike.setGear(i+1);
                textArea.value += `${bike.gear} \n`;
            }
        }
    }
}
window.onload = start;
})();