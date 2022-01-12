let scalePx = 80;
let canvas = document.getElementById("canvas");
let context = canvas.getContext("2d");
let size = 600;

document.addEventListener("DOMContentLoaded", function() {
    drawGraph();
});

    function drawGraph(){
        let r = getCanvasR() * scalePx;
        if (r === 0) return;
        console.log("r = " + r);
        drawRect(r);
        drawTriangle(r);
        drawCircle(r);
        drawXAxis(r);
        drawYAxis(r);
    }

    function drawXAxis(r){
        context.beginPath();

        context.strokeStyle = "black";

        context.moveTo(0, size/2);
        context.lineTo(size, size/2);

        context.lineTo(size - 9, (size/2) - 3);
        context.moveTo(size, size/2);
        context.lineTo(size - 9, (size/2) + 3);

        context.moveTo(size - ((size/2) - r), (size/2) + 3);
        context.lineTo(size - ((size/2) - r), (size/2) - 3);
        context.strokeText("R", size - ((size/2) - r), (size/2) - 6);

        context.moveTo(size - ((size/2) - (r/2)), (size/2) + 3);
        context.lineTo(size - ((size/2) - (r/2)), (size/2) - 3);
        context.strokeText("R/2", size - ((size/2) - (r/2)), (size/2) - 6);

        context.moveTo((size/2) - (r/2), (size/2) + 3);
        context.lineTo((size/2) - (r/2), (size/2) - 3);
        context.strokeText("-R/2", (size/2) - (r/2), (size/2) - 6);

        context.moveTo((size/2) - r, (size/2) + 3);
        context.lineTo((size/2) - r, (size/2) - 3);
        context.strokeText("-R", (size/2) - r, (size/2) - 6);

        context.stroke();

        context.strokeText("x", size - 9, (size/2) - 6);
    }

    function drawYAxis(r){
        context.beginPath();

        context.strokeStyle = "black";

        context.moveTo(size/2, size);
        context.lineTo(size/2, 0);

        context.lineTo(size/2 - 3, 9);
        context.moveTo(size/2, 0);
        context.lineTo(size/2 + 3, 9);

        context.moveTo(size/2 - 3, (size/2) - r);
        context.lineTo(size/2 + 3, (size/2) - r);
        context.strokeText("R", size/2 + 6, (size/2) - r);

        context.moveTo(size/2 - 3, (size/2) - (r/2));
        context.lineTo(size/2 + 3, (size/2) - (r/2));
        context.strokeText("R/2", size/2 + 6, (size/2) - (r/2));

        context.moveTo(size/2 - 3, size - ((size/2) - (r/2)));
        context.lineTo(size/2 + 3, size - ((size/2) - (r/2)));
        context.strokeText("-R/2", size/2 + 6, size - ((size/2) - (r/2)));

        context.moveTo(size/2 - 3, size - ((size/2) - r));
        context.lineTo(size/2 + 3, size - ((size/2) - r));
        context.strokeText("-R", size/2 + 6, size - ((size/2) - r));

        context.stroke();

        context.strokeText("y", size/2 + 6,9);
    }

    function drawRect(r){
        context.beginPath();

        context.fillStyle = "dodgerblue";
        context.strokeStyle = "dodgerblue";
        context.rect((size/2) - r, size/2 - r, r, r);

        context.fill();
        context.stroke();
    }

    function drawTriangle(r){
        context.beginPath();

        context.fillStyle = "dodgerblue";
        context.strokeStyle = "dodgerblue";
        context.moveTo(size/2, size/2);
        context.lineTo(size/2, size/2 - (r/2));
        context.lineTo(size - ((size/2) - r), size/2);
        context.closePath();

        context.fill();
        context.stroke();
    }

    function drawCircle(r){
        context.beginPath();

        context.fillStyle = "dodgerblue";
        context.strokeStyle = "dodgerblue";
        context.arc(size/2, size/2, r/2, 0.5 * Math.PI, Math.PI);
        context.lineTo(size/2, size/2);
        context.lineTo(size/2, size/2 + r/2);

        context.fill();
        context.stroke();
    }

    function cleanCanvas(){
        console.log("Мы в cleanCanvas");
        context.clearRect(0,0,canvas.width, canvas.height);
    }

    function drawPoints(points){
        let r = getCanvasR();
        console.log("Мы в drawPoints, r = " + r);
        points.forEach(point=>{
            if (point.r === r){
                drawPoint(point.x, point.y, point.isHit);
            }
        })
    }

    function drawPoint(x, y, isHit){
        console.log("Мы в drawPoint");
        let m = 1 / scalePx;
        let cx = (size / 2) + (x / m);
        let cy = (size / 2) - (y / m);
        if (cx > 500) cx = 500;
        else if (cx < 0) cx = 0;
        if (cy > 500) cy = 500;
        else if (cy < 0) cy = 0;

        let color = "green";
        if(!isHit) color = "red";

        context.beginPath();

        context.fillStyle = color;
        context.arc(cx, cy, 3, 0, 2 * Math.PI);
        context.fill();

        context.stroke();
    }


