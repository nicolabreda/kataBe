//STEP1
const binaryToDecimal = (binary) => {
    let arr = [...binary];
    let decimal = 0;

    for (let i = (arr.length - 1); i >= 0; i--) {
      decimal += parseInt(arr[i]) * Math.pow(2, arr.length - 1 - i)
    }
    return decimal;
}

//STEP2

const hexadecimalToBinary = (hexadecimal) => {

    const hexBins = {
        "0": '0000',
        "1": '0001',
        "2": '0010',
        "3": '0011',
        "4": '0100',
        "5": '0101',
        "6": '0110',
        "7": '0111',
        "8": '1000',
        "9": '1001',
        "A": '1010',
        "B": '1011',
        "C": '1100',
        "D": '1101',
        "E": '1110',
        "F": '1111',
    };
    let arr = [...hexadecimal]
    let binary = '';

    for( let i = 0; i <= arr.length; i++ ) {
        for( let x in hexBins) {
            if(x == arr[i])
                binary += hexBins[x];
        }
    }
    console.log(binary);
};



