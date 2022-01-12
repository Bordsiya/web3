let xARR = [-2, -1, 0, 1, 2]

let canvasX = document.getElementById("canvas_form:canvas_x_val");
let canvasY = document.getElementById("canvas_form:canvas_y_val");
let canvasR = document.getElementById("canvas_form:canvas_r_val");
let canvasSubmitButton = document.getElementById("canvas_form:canvas_submit");


document.addEventListener("DOMContentLoaded", function() {

    updateGraph();

    canvas.addEventListener("click", function (event){
        cleanErrors();

        console.log("Мы отсылаем точку");

        // убеждаемся, что выбрано одно R
        let checkBoxStateRes = checkCheckboxState();
        if (checkBoxStateRes.counter === 0) {
            errorR.textContent = ERROR_MSG_NO_R;
            return;
        } else if (checkBoxStateRes.counter !== 1) {
            errorR.textContent = ERROR_MSG_TOO_MUCH_R;
            return;
        }
        let rValue = checkBoxStateRes.value;
        console.log(rValue);

        let xPx = -(size / 2 - event.offsetX)
        let yPx = size / 2 - event.offsetY;

        let m = 1 / scalePx;
        let x = xPx * m;
        let y = yPx * m;

        let diff = Infinity;
        let closestX, closestY;
        for (let i = 0; i < xARR.length; i++) {
            if (Math.abs(xARR[i] - x) < diff) {
                diff = Math.abs(xARR[i] - x);
                closestX = xARR[i];
            }
        }
        if (y > 5) y = 4.999999;
        if (y < -3) y = -2.99999;
        let yString = String(y);
        if (yString.length > 8) yString = yString.substring(0, 8);
        closestY = Number(yString);

        canvasX.value = closestX;
        canvasY.value = closestY;
        canvasR.value = rValue;

        canvasSubmitButton.click();

        drawPoint(closestX, closestY, checkHit(closestX, closestY, rValue));
    });

});

    function updateGraph() {
        console.log("Мы в updateGraph");
        let rows = document.querySelectorAll("#table tbody tr");
        let points = [];

        for (let i = 0; i < rows.length; i++){
            let cells = rows[i].children;
            let point = new Point(parseFloat(cells[0].innerHTML),parseFloat(cells[1].innerHTML),parseFloat(cells[2].innerHTML),cells[3].innerHTML == "true");
            points.push(point);
        }
        drawPoints(points);
    }
