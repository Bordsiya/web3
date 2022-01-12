let clearButton = document.getElementById("main_form:clean_btn");
let mainSubmitButton = document.getElementById("main_form:submit_main_form");
let errorR = document.getElementById("err_r");

let ERROR_MSG_NO_R = "R не выбрано";
let ERROR_MSG_TOO_MUCH_R = "Нужно выбрать одно значение R";

let r1State = document.getElementById("main_form:r_state1");
let r2State = document.getElementById("main_form:r_state2");
let r3State = document.getElementById("main_form:r_state3");
let r4State = document.getElementById("main_form:r_state4");
let r5State = document.getElementById("main_form:r_state5");

let r1Val = 1;
let r2Val = 1.5;
let r3Val = 2;
let r4Val = 2.5;
let r5Val = 3;

document.addEventListener("DOMContentLoaded", function() {

    clearButton.onclick = function () {
        cleanErrors();
        cleanCanvas();
        drawGraph();
    }

    mainSubmitButton.onclick = function () {
        cleanErrors();

        let checkBoxStateRes = checkCheckboxState();
        if (checkBoxStateRes.counter === 0) {
            errorR.textContent = ERROR_MSG_NO_R;
        }
        console.log("Заапдейтили граф");
        updateGraph();
    }


});

    function checkCheckboxState() {
        let counter = 0;
        let value;
        if (r1State.checked) {
            counter++;
            value = r1Val;
        }
        if (r2State.checked) {
            counter++;
            value = r2Val;
        }
        if (r3State.checked) {
            counter++;
            value = r3Val;
        }
        if (r4State.checked) {
            counter++;
            value = r4Val;
        }
        if (r5State.checked) {
            counter++;
            value = r5Val;
        }
        return {
            counter: counter,
            value: value
        };
    }

    function cleanErrors() {
        errorR.textContent = "";
        return false;
    }

    function checkHit(x, y, r) {
        return (checkRectangle(x, y, r) || checkTriangle(x, y, r) || checkCircle(x, y, r));
    }

    function checkRectangle(x, y, r) {
        return (x <= 0 && x >= -r && y >= 0 && y <= r);
    }

    function checkTriangle(x, y, r) {
        return (x >= 0 && x <= r && y >= 0 && y <= -x / 2 + r / 2);
    }

    function checkCircle(x, y, r) {
        return (x <= 0 && x >= -r / 2 && y <= 0 && x * x + y * y <= (r / 2) * (r / 2));
    }

    function getCanvasR(){
        let DEFAULT_R = 3;
        let checkBoxStateRes = checkCheckboxState();
        if (checkBoxStateRes.counter === 0) {
            return DEFAULT_R;
        }
        else if(checkBoxStateRes.counter !== 1){
            return DEFAULT_R;
        }
        else return checkBoxStateRes.value;
    }

