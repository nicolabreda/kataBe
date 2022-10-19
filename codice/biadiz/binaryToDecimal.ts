export const convertToDecimal = (str: string, index = 0): number => {
  if (str.length > 1) {
    return (
      Number(str.charAt(str.length - 1)) * Math.pow(2, index) +
      convertToDecimal(str.slice(0, -1), index + 1)
    );
  } else {
    return Number(str[0]) * Math.pow(2, index);
  }
};
