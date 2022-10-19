binaryToDecimal(binary) {
    let arr = [...binary];
    let decimal = 0;

    for (let i = (arr.length - 1); i >= 0; i--) {
      decimal += parseInt(arr[i]) * Math.pow(2, arr.length - 1 - i)
    }
    return decimal
  }