var convertToDecimal = function (valore, index) {
    if (index === void 0) { index = 0; }
    if (valore.length > 1) {
        return (Number(valore.charAt(valore.length - 1)) * Math.pow(2, index) +
            convertToDecimal(valore.slice(0, -1), index + 1));
    }
    else {
        return Number(valore[0]) * Math.pow(2, index);
    }
};
console.log(convertToDecimal("11"));
console.log(convertToDecimal("100101100011"))
console.log(convertToDecimal("100101001001001100011"))
console.log(convertToDecimal("100101001001001010010010001000001000100010100011"))

